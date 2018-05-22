package com.create80.rd.common.mybaties;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * mybatis代码生成工具 (用来兼容jeesite代码生成工具)
 * 支持单表和1对多表关系代码生成
 *
 * @author yzx
 */
public class CodeGenerator {

  //插件
  public static final List<String> PLUGINS = Arrays
      .asList("com.create80.rd.common.mybaties.plugins.OneToOnePlugin",
          "com.create80.rd.common.mybaties.plugins.OneToManyPlugin",
          "com.create80.rd.common.mybaties.plugins.StopGeneratorPlugin",
          "com.create80.rd.common.mybaties.plugins.BatchInsertPlugin",
          "com.create80.rd.common.mybaties.plugins.BatchUpdatePlugin",
          "com.create80.rd.common.mybaties.plugins.RepositoryAnnotationPlugin",
          "org.mybatis.generator.plugins.SerializablePlugin",
          "org.mybatis.generator.plugins.ToStringPlugin",
          "com.create80.rd.common.mybaties.plugins.QueryObjectPlugin"
      );

  /**
   * 自定义注释生成
   */
  public static final String COMMENT_GENERATOR = "com.create80.rd.common.mybaties.CommentGenerator";

  private Configuration configuration = new Configuration();
  private Context context = null;

  /**
   * table configure List
   */
  private List<TableConfigurationExtend> tableConfigurationExtendList = new ArrayList<>();

  public CodeGenerator(String driver, String username, String password, String url,
      String codeTargetPackage, String codeTargetProject, String sqlMapTargetPackage,
      String sqlMapTargetProject) {


    context = new Context(ModelType.CONDITIONAL);
//    context.addProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING, "UTF-8");
    context.setId("gen-mybatis");
    context.setTargetRuntime("com.create80.rd.common.mybaties.gen.InsoIntrospectedTable");

    initPlugins(context);
//    initCommentGenerator(context);
    initJdbcConnection(driver, username, password, url, context);
    initJavaModelGenerator(codeTargetPackage, codeTargetProject, context);
    initSqlMapGenerator(sqlMapTargetPackage, sqlMapTargetProject, context);
    initJavaClientGenerator(codeTargetPackage, codeTargetProject, context);
  }


  /**
   * 代码生成
   */
  public void gen() {

    addTableConfiguration();
    configuration.addContext(context);
    DefaultShellCallback callback = new DefaultShellCallback(true);
    List<String> warnings = new ArrayList<String>();
    MyBatisGenerator myBatisGenerator = null;
    try {
      myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
    try {
      myBatisGenerator.generate(null);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  /**
   * 添加配置信息
   */
  public void addTableConfiguration(TableConfigurationExtend tableConfigurationExtend) {

    if (tableConfigurationExtend != null) {

      if (!hasTableConfiguration(tableConfigurationExtend)) {
        tableConfigurationExtendList.add(tableConfigurationExtend);
      }
    }
  }

  /**
   * 表配置是否已经定义,如果添加则忽略
   * @param tableConfigurationExtend
   * @return
   */
  public boolean hasTableConfiguration(TableConfigurationExtend tableConfigurationExtend) {
    List<String> result = new ArrayList<>();
    tableConfigurationExtendList.stream().forEach(table -> {
      if (table.getTableName().equals(tableConfigurationExtend.getTableName())) {
        result.add("xxx");
      }
    });
    return result.size() > 0;
  }

  /**
   * 批量添加table配置信息
   */
  public void addAllTableConfiguration(
      List<TableConfigurationExtend> tableConfigurationExtendList) {
    if (tableConfigurationExtendList != null) {
      tableConfigurationExtendList.addAll(tableConfigurationExtendList);
    }
  }

  public TableConfigurationExtend createTableConfiguration(String tableName,
      String domainObjectName, boolean stopGen) {
    return new TableConfigurationExtend(tableName, domainObjectName, stopGen, context);
  }


  /**
   * 添加table配置信息到context中
   */
  protected void addTableConfiguration() {
    if (context == null) {
      return;
    }
    tableConfigurationExtendList.stream().forEach(t -> {
      context.addTableConfiguration(t);
    });

  }

  public static void main(String[] args) {
//
//    try {
//      Configuration configuration = new Configuration();
//      Context context = new Context(ModelType.CONDITIONAL);
//      context.setId("gen-mybatis");
//      //plugins
//      initPlugins(context);
//      //commentGenerator
//      initCommentGenerator(context);
//      //JDBCConnectionConfiguration
//      initJdbcConnection(driver, username, password, url, context);
//      //JavaModelGeneratorConfiguration
//      initJavaModelGenerator(targetPackage, targetProject, context);
//      //SqlMapGeneratorConfiguration
//      initSqlMapGenerator(targetPackage, targetProject, context);
//      //JavaClientGeneratorConfiguration
//      initJavaClientGenerator(targetPackage, targetProject, context);
//
//      //test_data_child
//      TableConfigurationExtend test_data_childConfiguration = new TableConfigurationExtend(context);
//      test_data_childConfiguration.setTableName("test_data_child");
//      test_data_childConfiguration.setDomainObjectName("test_data_child");
//      OneToMany test_data_child_oneToOne = new OneToMany("test_data_main", "test_data_main_id",
//          "id");
//      test_data_childConfiguration.setOneToManyList(Arrays.asList(test_data_child_oneToOne));
//      //
//      TableConfigurationExtend test_data_mainConfiguration = new TableConfigurationExtend(context);
//      test_data_mainConfiguration.setTableName("test_data_main");
//      test_data_mainConfiguration.setDomainObjectName("test_data_main");
//      test_data_mainConfiguration.setStopGenerator(true);
//
//      context.addTableConfiguration(test_data_childConfiguration);
//      context.addTableConfiguration(test_data_mainConfiguration);
//      //
//      configuration.addContext(context);
//      DefaultShellCallback callback = new DefaultShellCallback(true);
//      List<String> warnings = new ArrayList<String>();
//
//      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
//      myBatisGenerator.generate(null);
//
//      System.out.println("生成代码完成..");
//    } catch (InvalidConfigurationException e) {
//      e.printStackTrace();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }

  }

  private static void initJavaClientGenerator(String targetPackage, String targetProject,
      Context context) {
    JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
    javaClientGeneratorConfiguration.setTargetPackage(targetPackage + ".client");
    javaClientGeneratorConfiguration.setTargetProject(targetProject);
    javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
    context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
  }

  private static void initSqlMapGenerator(String targetPackage, String targetProject,
      Context context) {
    SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
    sqlMapGeneratorConfiguration.setTargetPackage(targetPackage);
    sqlMapGeneratorConfiguration.setTargetProject(targetProject);
    context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
  }

  private static void initJavaModelGenerator(String targetPackage, String targetProject,
      Context context) {
    JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
    javaModelGeneratorConfiguration.setTargetPackage(targetPackage + ".model");
    javaModelGeneratorConfiguration.setTargetProject(targetProject);
    context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
  }

  private static void initJdbcConnection(String driver, String username, String password,
      String url, Context context) {
    JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
    jdbcConnectionConfiguration.setDriverClass(driver);
    jdbcConnectionConfiguration.setUserId(username);
    jdbcConnectionConfiguration.setPassword(password);
    jdbcConnectionConfiguration.setConnectionURL(url);
    context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
  }

  private static void initCommentGenerator(Context context) {
    CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
    commentGeneratorConfiguration
        .setConfigurationType(COMMENT_GENERATOR);
    commentGeneratorConfiguration.addProperty("suppressAllComments", "true");

    context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
  }

  private static void initPlugins(Context context) {
    //plugins
    for (String plugin : PLUGINS) {
      PluginConfiguration pluginConfiguration = new PluginConfiguration();
      pluginConfiguration.setConfigurationType(plugin);
      context.addPluginConfiguration(pluginConfiguration);
    }
  }

}
