/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.gen.service;

import com.create80.rd.common.config.Global;
import com.create80.rd.common.mybaties.CodeGenerator;
import com.create80.rd.common.mybaties.TableConfigurationExtend;
import com.create80.rd.common.mybaties.config.OneToMany;
import com.create80.rd.common.mybaties.config.OneToOne;
import com.create80.rd.common.utils.FileUtils;
import com.create80.rd.common.utils.FreeMarkers;
import com.create80.rd.modules.gen.dao.GenSchemeDao;
import com.create80.rd.modules.gen.dao.GenTableColumnDao;
import com.create80.rd.modules.gen.dao.GenTableDao;
import com.create80.rd.modules.gen.entity.GenConfig;
import com.create80.rd.modules.gen.entity.GenScheme;
import com.create80.rd.modules.gen.entity.GenTable;
import com.create80.rd.modules.gen.entity.GenTableColumn;
import com.create80.rd.modules.gen.entity.GenTemplate;
import com.create80.rd.modules.gen.util.GenUtils;
import com.create80.rd.modules.sys.entity.Dict;
import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.create80.rd.common.persistence.Page;
import com.create80.rd.common.service.BaseService;
import com.create80.rd.common.utils.StringUtils;
import com.create80.rd.modules.gen.dao.GenSchemeDao;
import com.create80.rd.modules.gen.dao.GenTableColumnDao;
import com.create80.rd.modules.gen.dao.GenTableDao;
import com.create80.rd.modules.gen.entity.GenConfig;
import com.create80.rd.modules.gen.entity.GenScheme;
import com.create80.rd.modules.gen.entity.GenTable;
import com.create80.rd.modules.gen.entity.GenTableColumn;
import com.create80.rd.modules.gen.entity.GenTemplate;
import com.create80.rd.modules.gen.util.GenUtils;

/**
 * 生成方案Service
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
@Service
@Transactional(readOnly = true)
public class GenSchemeService extends BaseService {

  @Autowired
  private GenSchemeDao genSchemeDao;
  //	@Autowired
//	private GenTemplateDao genTemplateDao;
  @Autowired
  private GenTableDao genTableDao;
  @Autowired
  private GenTableColumnDao genTableColumnDao;

  public GenScheme get(String id) {
    return genSchemeDao.get(id);
  }

  public Page<GenScheme> find(Page<GenScheme> page, GenScheme genScheme) {
    GenUtils.getTemplatePath();
    genScheme.setPage(page);
    page.setList(genSchemeDao.findList(genScheme));
    return page;
  }

  @Transactional(readOnly = false)
  public String save(GenScheme genScheme) {
    if (StringUtils.isBlank(genScheme.getId())) {
      genScheme.preInsert();
      genSchemeDao.insert(genScheme);
    } else {
      genScheme.preUpdate();
      genSchemeDao.update(genScheme);
    }
    // 生成代码
    if ("1".equals(genScheme.getFlag())) {
      return generateCode(genScheme);
    }
    return "";
  }

  @Transactional(readOnly = false)
  public void delete(GenScheme genScheme) {
    genSchemeDao.delete(genScheme);
  }

  private String generateCode(GenScheme genScheme) {

    StringBuilder result = new StringBuilder();

    // 查询主表及字段列
    GenTable genTable = genTableDao.get(genScheme.getGenTable().getId());
    genTable.setColumnList(
        genTableColumnDao.findList(new GenTableColumn(new GenTable(genTable.getId()))));

    // 获取所有代码模板
    GenConfig config = GenUtils.getConfig();

    // 获取模板列表
    List<GenTemplate> templateList = GenUtils
        .getTemplateList(config, genScheme.getCategory(), false);
    List<GenTemplate> childTableTemplateList = GenUtils
        .getTemplateList(config, genScheme.getCategory(), true);

    // 如果有子表模板，则需要获取子表列表
    if (childTableTemplateList.size() > 0) {
      GenTable parentTable = new GenTable();
      parentTable.setParentTable(genTable.getName());
      List<GenTable> genTableList = genTableDao.findList(parentTable);
      genTable.setChildList(genTableList);
    }

    // 生成子表模板代码
    for (GenTable childTable : genTable.getChildList()) {
      childTable.setParent(genTable);
      childTable.setColumnList(
          genTableColumnDao.findList(new GenTableColumn(new GenTable(childTable.getId()))));
      genScheme.setGenTable(childTable);
      Map<String, Object> childTableModel = GenUtils.getDataModel(genScheme);
      for (GenTemplate tpl : childTableTemplateList) {
        result.append(GenUtils.generateToFile(tpl, childTableModel, genScheme.getReplaceFile()));
      }
    }

    // 生成主表模板代码
    genScheme.setGenTable(genTable);
    Map<String, Object> model = GenUtils.getDataModel(genScheme);

    for (GenTemplate tpl : templateList) {
      result.append(GenUtils.generateToFile(tpl, model, genScheme.getReplaceFile()));
    }

    //目前代码分离支持单表和1对多类型代码生成，其他代码生成走jeesite框架原生的方式
    if ("curd".equals(genScheme.getCategory()) || "curd_many".equals(genScheme.getCategory())) {
      //mybatis code generator
      CodeGenerator codeGenerator = getCodeGenerator(genScheme, model);

      TableConfigurationExtend myTableConfiguration = codeGenerator
          .createTableConfiguration(genTable.getName(), genTable.getClassName(), false);

      if ("curd_many".equals(genScheme.getCategory())) {

        //添加需要生成的表
        List<GenTableColumn> oneToOneTableColumnList = getOneToOneNoGenColumn(
            genTable.getColumnList());
        //获取子列表
        List<GenTable> childGenTableList = genTable.getChildList();
        //
        List<String> noGenTables = getFilterTables();
        //创建1对1表配置
        oneToOneTableColumnList.stream().forEach(genTableColumn -> {
          if (!noGenTables.contains(genTableColumn.getJavaTypeTable())) {
            codeGenerator.addTableConfiguration(
                codeGenerator.createTableConfiguration(genTableColumn.getJavaTypeTable()
                    , StringUtils.substringAfterLast(genTableColumn.getJavaType(), "."), false));
          }
        });
        //创建子表配置
        childGenTableList.stream().forEach(table -> {
          if (!noGenTables.contains(table.getName())) {
            codeGenerator.addTableConfiguration(codeGenerator
                .createTableConfiguration(table.getName(), table.getClassName(), false));
          }
        });

        //获取1对1的字段定义
        List<OneToOne> oneToOneList = getTableOneToOneByColumn(oneToOneTableColumnList);
        List<OneToMany> oneToManyList = getTableOneToManyByColumn(childGenTableList);

        myTableConfiguration.setOneToOneList(oneToOneList);
        myTableConfiguration.setOneToManyList(oneToManyList);

      }
      codeGenerator.addTableConfiguration(myTableConfiguration);
      codeGenerator.gen();
    }
    return result.toString();
  }


  private CodeGenerator getCodeGenerator(GenScheme genScheme, Map<String, Object> model) {
    String codeTargetProjectTemplate = "src/main/java/";
    String sqlMapTargetProjectTemplate = "src/main/resources/mappings/modules/${lastPackageName}";

    //代码生成保存路径
    String codeTargetProject = getTargetProject(model, codeTargetProjectTemplate);
    String sqlMapTargetProject = getTargetProject(model, sqlMapTargetProjectTemplate);

    //创建sqlMap保存目录
    FileUtils.createDirectory(sqlMapTargetProject);

    //创建mybatis代码生成器
    CodeGenerator codeGenerator = new CodeGenerator(Global.getConfig("jdbc.driver"),
        Global.getConfig("jdbc.username"), Global.getConfig("jdbc.password"),
        Global.getConfig("jdbc.url"),
        genScheme.getPackageName() + "." + genScheme.getModuleName() + ".api",
        codeTargetProject, genScheme.getModuleName(), sqlMapTargetProject);

    logger.info("<<<API代码保存路径：" + codeTargetProject);
    logger.info("<<<API SQL MAP XML 保存路径：" + sqlMapTargetProject);

    return codeGenerator;
  }

  private List<GenTableColumn> getOneToOneNoGenColumn(List<GenTableColumn> genTableColumnList) {
    return genTableColumnList.stream().filter(e -> StringUtils.isNotEmpty(e.getJavaTypeTable()))
        .collect(Collectors.toList());
  }

  private List<OneToOne> getTableOneToOneByColumn(List<GenTableColumn> genTableColumnList) {
    List<OneToOne> result = new ArrayList<>();
    //
    List<String> filterList = new ArrayList<>();
    List<String> noJoinFieldList = getFilterTables();

    genTableColumnList.stream().forEach(column -> {
      String javaTypeTable = column.getJavaTypeTable();
      String javaField = StringUtils.substringBefore(column.getJavaField(), ".");
      OneToOne oneToOne = new OneToOne(javaTypeTable, column.getName(), "id",
          javaField);
      if (filterList.contains(javaTypeTable)) {
        noJoinFieldList.add(javaTypeTable);
      }
      oneToOne.setWhere("del_flag='0'");
      result.add(oneToOne);
      filterList.add(javaTypeTable);
    });
    //TODO 目前是如果一个vo对象中出现两个相同其他关系对象,
    // TODO 生成插入insertSelect方法时候按原生的生成插入sql不生成对象关联sql；后期再改
    result.stream().forEach(oneToOne -> {
      if (noJoinFieldList.contains(oneToOne.getMappingTable())) {
        oneToOne.setNoJoinField(true);
      }
    });

    return result;
  }

  /**
   * 获取生成代码不关联的表
   */
  private List<String> getFilterTables() {

    List<String> result = new ArrayList<>();
    GenUtils.getConfig().getJavaTypeList().stream().filter(e -> StringUtils.isNotEmpty(e.getType()))
        .forEach(dict -> {
          result.add(dict.getType());
        });

    return result;
  }


  private List<OneToMany> getTableOneToManyByColumn(List<GenTable> childList) {
    List<OneToMany> oneToManyList = new ArrayList<>();

    childList.stream().forEach(table -> {
      OneToMany oneToMany = new OneToMany(table.getName(), "id", table.getParentTableFk());
      oneToMany.setWhere("del_flag='0'");
      oneToManyList.add(oneToMany);
    });
    return oneToManyList;
  }

  private String getTargetProject(Map<String, Object> model, String sqlMapTargetProjectTemplate) {
    return Global.getProjectPath() + File.separator
        + StringUtils
        .replaceEach(FreeMarkers.renderString(sqlMapTargetProjectTemplate + "/", model),
            new String[]{"//", "/", "."},
            new String[]{File.separator, File.separator, File.separator});
  }
}
