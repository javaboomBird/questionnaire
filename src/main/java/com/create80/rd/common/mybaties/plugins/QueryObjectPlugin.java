package com.create80.rd.common.mybaties.plugins;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 生成查询对象
 * select * from xxx a where a.column=xxx
 */
public class QueryObjectPlugin extends PluginAdapter {

  public final static String METHOD_NAME = "selectBySelective";

  @Override
  public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {

    if (!PluginCommon.codeHasCreateMethod(interfaze, METHOD_NAME)) {
      addSelectMethod(interfaze, introspectedTable);
    }
    return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
  }

  /**
   *
   * @param interfaze
   * @param introspectedTable
   */
  private void addSelectMethod(Interface interfaze, IntrospectedTable introspectedTable) {

    // 设置需要导入的类
    Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
    importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
    importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));

    Method ibsmethod = new Method();
    // 1.设置方法可见性
    ibsmethod.setVisibility(JavaVisibility.PUBLIC);
    // 2.设置返回值类型
    FullyQualifiedJavaType ibsreturnType = FullyQualifiedJavaType.getNewListInstance();
    ibsreturnType
        .addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
    // 3.设置方法名
    ibsmethod.setName(METHOD_NAME);
    ibsmethod.setReturnType(ibsreturnType);
    // 4.设置参数列表
    FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(
        introspectedTable.getBaseRecordType());
    ibsmethod.addParameter(new Parameter(fullyQualifiedJavaType, "records"));

    interfaze.addImportedTypes(importedTypes);
    interfaze.addMethod(ibsmethod);
  }


  /**
   * 修改Mapper.xml
   */
  @Override
  public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
    if (!PluginCommon.xmlHasCreateMethod(document, METHOD_NAME)) {
        addSelectMethodInXml(document, introspectedTable);
    }
    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  /**
   *
   * @param document
   * @param introspectedTable
   */
  private void addSelectMethodInXml(Document document, IntrospectedTable introspectedTable) {

    List<IntrospectedColumn> columns = introspectedTable.getAllColumns();

    XmlElement selectElement = new XmlElement("select");
    selectElement.addAttribute(new Attribute("id", METHOD_NAME));
    selectElement
        .addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
    selectElement
        .addAttribute(new Attribute("resultMap", "BaseResultMap"));
    //
    selectElement.addElement(new TextElement("select "));
    //include
    XmlElement include = new XmlElement("include");
    include.addAttribute(new Attribute("refid", "Base_Column_List"));
    selectElement.addElement(include);
    //
    selectElement.addElement(
        new TextElement(" from " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));

    XmlElement _parameterElement = new XmlElement("if ");
    _parameterElement.addAttribute(new Attribute("test", "_parameter!=null"));

    XmlElement whereElement = new XmlElement("where");
    _parameterElement.addElement(whereElement);

    XmlElement trim1Element = new XmlElement("trim");
    trim1Element.addAttribute(new Attribute("prefixOverrides", "and"));
    whereElement.addElement(trim1Element);

    for (IntrospectedColumn introspectedColumn : columns) {
      String columnName = introspectedColumn.getActualColumnName();
      XmlElement ifxml = new XmlElement("if");
      ifxml.addAttribute(
          new Attribute("test", introspectedColumn.getJavaProperty() + "!=null"));
      ifxml.addElement(new TextElement(
          "and " + columnName + "=#{" + introspectedColumn.getJavaProperty() + ",jdbcType="
              + introspectedColumn.getJdbcTypeName() + "}"));
      trim1Element.addElement(ifxml);
    }

    selectElement.addElement(_parameterElement);
    document.getRootElement().addElement(selectElement);
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }
}
