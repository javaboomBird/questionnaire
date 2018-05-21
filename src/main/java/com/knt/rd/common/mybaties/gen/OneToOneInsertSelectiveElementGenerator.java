package com.knt.rd.common.mybaties.gen;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import com.knt.rd.common.mybaties.TableConfigurationExtend;
import com.knt.rd.common.mybaties.config.OneToOne;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.InsertSelectiveElementGenerator;
import org.mybatis.generator.config.GeneratedKey;

public class OneToOneInsertSelectiveElementGenerator extends InsertSelectiveElementGenerator {


  public OneToOneInsertSelectiveElementGenerator() {
    super();
  }

  @Override
  public void addElements(XmlElement parentElement) {

    TableConfigurationExtend tableConfigurationExtend = (TableConfigurationExtend) introspectedTable
        .getTableConfiguration();

    //判断是否存在oneToOne关系
    if (tableConfigurationExtend.getOneToOneList().size() > 0) {

      List<OneToOne> oneToOneList = tableConfigurationExtend.getOneToOneList();

      XmlElement answer = new XmlElement("insert"); //$NON-NLS-1$

      answer.addAttribute(new Attribute(
          "id", introspectedTable.getInsertSelectiveStatementId())); //$NON-NLS-1$

      FullyQualifiedJavaType parameterType = introspectedTable.getRules()
          .calculateAllFieldsClass();

      answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
          parameterType.getFullyQualifiedName()));

      context.getCommentGenerator().addComment(answer);

      GeneratedKey gk = introspectedTable.getGeneratedKey();
      if (gk != null) {
        IntrospectedColumn introspectedColumn = introspectedTable
            .getColumn(gk.getColumn());
        // if the column is null, then it's a configuration error. The
        // warning has already been reported
        if (introspectedColumn != null) {
          if (gk.isJdbcStandard()) {
            answer.addAttribute(
                new Attribute("useGeneratedKeys", "true")); //$NON-NLS-1$ //$NON-NLS-2$
            answer.addAttribute(
                new Attribute("keyProperty", introspectedColumn.getJavaProperty())); //$NON-NLS-1$
            answer.addAttribute(
                new Attribute("keyColumn", introspectedColumn.getActualColumnName())); //$NON-NLS-1$
          } else {
            answer.addElement(getSelectKey(introspectedColumn, gk));
          }
        }
      }

      StringBuilder sb = new StringBuilder();

      sb.append("insert into "); //$NON-NLS-1$
      sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
      answer.addElement(new TextElement(sb.toString()));

      XmlElement insertTrimElement = new XmlElement("trim"); //$NON-NLS-1$
      insertTrimElement.addAttribute(new Attribute("prefix", "(")); //$NON-NLS-1$ //$NON-NLS-2$
      insertTrimElement.addAttribute(new Attribute("suffix", ")")); //$NON-NLS-1$ //$NON-NLS-2$
      insertTrimElement
          .addAttribute(new Attribute("suffixOverrides", ",")); //$NON-NLS-1$ //$NON-NLS-2$
      answer.addElement(insertTrimElement);

      XmlElement valuesTrimElement = new XmlElement("trim"); //$NON-NLS-1$
      valuesTrimElement
          .addAttribute(new Attribute("prefix", "values (")); //$NON-NLS-1$ //$NON-NLS-2$
      valuesTrimElement.addAttribute(new Attribute("suffix", ")")); //$NON-NLS-1$ //$NON-NLS-2$
      valuesTrimElement
          .addAttribute(new Attribute("suffixOverrides", ",")); //$NON-NLS-1$ //$NON-NLS-2$
      answer.addElement(valuesTrimElement);

      for (IntrospectedColumn introspectedColumn : ListUtilities
          .removeIdentityAndGeneratedAlwaysColumns(introspectedTable
              .getAllColumns())) {

        if (introspectedColumn.isSequenceColumn()
            || introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
          // if it is a sequence column, it is not optional
          // This is required for MyBatis3 because MyBatis3 parses
          // and calculates the SQL before executing the selectKey

          // if it is primitive, we cannot do a null check
          sb.setLength(0);
          sb.append(MyBatis3FormattingUtilities
              .getEscapedColumnName(introspectedColumn));
          sb.append(',');
          insertTrimElement.addElement(new TextElement(sb.toString()));

          sb.setLength(0);
          sb.append(MyBatis3FormattingUtilities
              .getParameterClause(introspectedColumn));
          sb.append(',');
          valuesTrimElement.addElement(new TextElement(sb.toString()));

          continue;
        }
        //是否0netoOne属性
        OneToOne oneToOne = isOneToOneColumn(oneToOneList, introspectedColumn);

        if (oneToOne != null && !oneToOne.isNoJoinField()) {

          sb.setLength(0);
          sb.append(oneToOne.getJavaField());
          sb.append(" != null"); //$NON-NLS-1$
          XmlElement insertNotNullElement = new XmlElement("if"); //$NON-NLS-1$
          insertNotNullElement.addAttribute(new Attribute(
              "test", sb.toString())); //$NON-NLS-1$

          sb.setLength(0);
          sb.append(MyBatis3FormattingUtilities
              .getEscapedColumnName(introspectedColumn));
          sb.append(',');
          insertNotNullElement.addElement(new TextElement(sb.toString()));
          insertTrimElement.addElement(insertNotNullElement);

          sb.setLength(0);
          sb.append(oneToOne.getJavaField());
          sb.append(" != null"); //$NON-NLS-1$
          XmlElement valuesNotNullElement = new XmlElement("if"); //$NON-NLS-1$
          valuesNotNullElement.addAttribute(new Attribute(
              "test", sb.toString())); //$NON-NLS-1$

          sb.setLength(0);
          sb.append(getParameterClause(introspectedColumn, oneToOne.getJavaField() + ".id"));
          sb.append(',');
          valuesNotNullElement.addElement(new TextElement(sb.toString()));
          valuesTrimElement.addElement(valuesNotNullElement);
        } else {
          sb.setLength(0);
          sb.append(introspectedColumn.getJavaProperty());
          sb.append(" != null"); //$NON-NLS-1$
          XmlElement insertNotNullElement = new XmlElement("if"); //$NON-NLS-1$
          insertNotNullElement.addAttribute(new Attribute(
              "test", sb.toString())); //$NON-NLS-1$

          sb.setLength(0);
          sb.append(MyBatis3FormattingUtilities
              .getEscapedColumnName(introspectedColumn));
          sb.append(',');
          insertNotNullElement.addElement(new TextElement(sb.toString()));
          insertTrimElement.addElement(insertNotNullElement);

          sb.setLength(0);
          sb.append(introspectedColumn.getJavaProperty());
          sb.append(" != null"); //$NON-NLS-1$
          XmlElement valuesNotNullElement = new XmlElement("if"); //$NON-NLS-1$
          valuesNotNullElement.addAttribute(new Attribute(
              "test", sb.toString())); //$NON-NLS-1$

          sb.setLength(0);
          sb.append(MyBatis3FormattingUtilities
              .getParameterClause(introspectedColumn));
          sb.append(',');
          valuesNotNullElement.addElement(new TextElement(sb.toString()));
          valuesTrimElement.addElement(valuesNotNullElement);
        }

      }

      if (context.getPlugins().sqlMapInsertSelectiveElementGenerated(
          answer, introspectedTable)) {
        parentElement.addElement(answer);
      }

    } else {
      super.addElements(parentElement);
    }
  }

  /**
   * Gets the parameter clause.
   *
   * @param introspectedColumn the introspected column
   * @return the parameter clause
   */
  public static String getParameterClause(
      IntrospectedColumn introspectedColumn, String property) {
    StringBuilder sb = new StringBuilder();

    sb.append("#{"); //$NON-NLS-1$
    sb.append(property);
    sb.append(",jdbcType="); //$NON-NLS-1$
    sb.append(introspectedColumn.getJdbcTypeName());

    if (stringHasValue(introspectedColumn.getTypeHandler())) {
      sb.append(",typeHandler="); //$NON-NLS-1$
      sb.append(introspectedColumn.getTypeHandler());
    }

    sb.append('}');

    return sb.toString();
  }

  /**
   *
   * @param oneToOneList
   * @param introspectedColumn
   * @return
   */
  private OneToOne isOneToOneColumn(List<OneToOne> oneToOneList,
      IntrospectedColumn introspectedColumn) {
    List<OneToOne> result = new ArrayList<>();

    oneToOneList.stream().forEach(oneToOne -> {
      String actualColumnName = introspectedColumn.getActualColumnName();
      if (actualColumnName.equals(oneToOne.getColumn())) {
        result.add(oneToOne);
      }
    });
    return result.size() > 0 ? result.get(0) : null;
  }

}
