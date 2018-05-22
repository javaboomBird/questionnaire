/**
 * Copyright ${license.git.copyrightYears} the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.create80.rd.common.mybaties.plugins;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import com.create80.rd.common.mybaties.TableConfigurationExtend;
import com.create80.rd.common.mybaties.config.OneToOne;
import com.create80.rd.common.utils.StringUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.db.DatabaseIntrospector;
import org.mybatis.generator.internal.util.StringUtility;

public class OneToOnePlugin extends PluginAdapter {

  /**
   * 修改model
   */
  @Override
  public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {
    TableConfigurationExtend tableConfigurationExtend = (TableConfigurationExtend) introspectedTable
        .getTableConfiguration();

    System.out.println("modelBaseRecordClassGenerated");

    //存储已经创建的fieldName
    List<String> createFieldNameList = new ArrayList<>();

    for (OneToOne oto : tableConfigurationExtend.getOneToOneList()) {
      String tableName = oto.getMappingTable();
      TableConfiguration tc = PluginCommon.getMapTc(tableName, context);
      if (tc != null) {
        String pakkage = PluginCommon.getModelPackage(introspectedTable, context);
        String domainName = tc.getDomainObjectName();
        String type = pakkage + "." + domainName;
        String fieldName = toLowerCase(domainName);
        org.mybatis.generator.api.dom.java.Field field = new org.mybatis.generator.api.dom.java.Field();

        //如果fieldName已经存在，则加上columnName来区别
        if (createFieldNameList.contains(fieldName)) {
          field.setName(StringUtils.toCamelCase(oto.getColumn()) + domainName);
        } else {
          field.setName(fieldName);
        }

        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(type);
        field.setType(fqjt);
        field.setVisibility(JavaVisibility.PRIVATE);
        topLevelClass.addImportedType(new FullyQualifiedJavaType(type));
        topLevelClass.addField(field);

        // get
        Method getMethod = new Method();
        getMethod.setVisibility(JavaVisibility.PUBLIC);
        getMethod.setReturnType(fqjt);
        //如果fieldName已经存在，则加上columnName来区别
        if (createFieldNameList.contains(fieldName)) {
          String tmp = StringUtils.toCamelCase(oto.getColumn()) + domainName;
          getMethod.setName("get" + toUpperCase(tmp));
          getMethod.addBodyLine("return " + tmp + ";");
        } else {
          getMethod.setName("get" + domainName);
          getMethod.addBodyLine("return " + fieldName + ";");
        }

        topLevelClass.addMethod(getMethod);
        // set
        Method setMethod = new Method();
        setMethod.setVisibility(JavaVisibility.PUBLIC);
        if (createFieldNameList.contains(fieldName)) {
          String tmp = StringUtils.toCamelCase(oto.getColumn()) + domainName;
          setMethod.setName("set" + toUpperCase(tmp));
          setMethod.addParameter(new Parameter(new FullyQualifiedJavaType(type), tmp));
          setMethod.addBodyLine("this." + tmp + "=" + tmp + ";");
        } else {
          setMethod.setName("set" + domainName);
          setMethod.addParameter(new Parameter(new FullyQualifiedJavaType(type), fieldName));
          setMethod.addBodyLine("this." + fieldName + "=" + fieldName + ";");
        }
        topLevelClass.addMethod(setMethod);

        //添加fieldName
        createFieldNameList.add(fieldName);
      }
    }
    return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
  }

  public String toLowerCase(String toLower) {
    return toLower.replaceFirst(new String(new char[]{toLower.charAt(0)}),
        new String(new char[]{toLower.charAt(0)}).toLowerCase());
  }

  public String toUpperCase(String toUpper) {
    return toUpper.replaceFirst(new String(new char[]{toUpper.charAt(0)}),
        new String(new char[]{toUpper.charAt(0)}).toUpperCase());
  }

  /**
   * 修改mapper.xml
   */
  @Override
  public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
//    //获取
    TableConfigurationExtend tableConfigurationExtend = (TableConfigurationExtend) introspectedTable
        .getTableConfiguration();
    System.out.println("sqlMapDocumentGenerated");

    List<String> warnings = new ArrayList<String>();
    List<String> createFieldNameList = new ArrayList<>();

    for (OneToOne oto : tableConfigurationExtend.getOneToOneList()) {
      String tableName = oto.getMappingTable();
      TableConfiguration tc = PluginCommon.getMapTc(tableName, context);
      List<IntrospectedTable> tables = null;
      try {
        DatabaseIntrospector databaseIntrospector = new DatabaseIntrospector(
            context, PluginCommon.getConnection(context, context.getJdbcConnectionConfiguration())
            .getMetaData(),
            PluginCommon.getJdbcTypes(context, warnings),
            warnings);
        tables = databaseIntrospector.introspectTables(tc);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      IntrospectedTable it = PluginCommon.getIt(tableName, tables);
      if (tc != null) {
        String domainName = tc.getDomainObjectName();
        String fieldName = toLowerCase(domainName);

        // 添加<association property="teacher" column="teacher_id" select="getTeacher"/>
        XmlElement assEle = new XmlElement("association");
        //如果fieldName已经存在，则加上columnName来区别
        if (createFieldNameList.contains(fieldName)) {

          assEle.addAttribute(
              new Attribute("property", StringUtils.toCamelCase(oto.getColumn()) + domainName));
        } else {
          assEle.addAttribute(new Attribute("property", fieldName));
        }

        assEle.addAttribute(new Attribute("column", oto.getColumn()));
        assEle.addAttribute(new Attribute("select", "get" + domainName));
        for (Element ele : document.getRootElement().getElements()) {
          XmlElement xe = (XmlElement) ele;
          for (Attribute a : xe.getAttributes()) {
            if (a.getName().equalsIgnoreCase("id") && "BaseResultMap".equals(a.getValue())) {
              xe.addElement(assEle);
            }
          }
        }
        String tuofengColum = StringUtils.toCamelCase(oto.getColumn());
        //
        String namespace =
            context.getJavaClientGeneratorConfiguration().getTargetPackage() + "." + domainName
                + "Mapper";
        String selectId = "get" + domainName;
        boolean has = hasElement(document, selectId);
        //添加查询方法<select id="testOutMapper" resultMap="soc.dao.ScanDao.BaseResultMap"><include refid="soc.dao.ScanDao.Base_Column_List" />
        if (!has) {
          XmlElement selectEle = new XmlElement("select");
          selectEle.addAttribute(new Attribute("id", selectId));
          selectEle.addAttribute(
              new Attribute("resultMap", namespace + "." + "BaseResultMap"));
          String sql = "select ";
          for (IntrospectedColumn c : it.getAllColumns()) {
            sql += c.getActualColumnName() + ",";
          }
          sql = sql.substring(0, sql.length() - 1);
          sql +=
              " from " + tableName + " where " + oto.getJoinColumn() + "=#{" + tuofengColum + "}";
          if (StringUtility.stringHasValue(oto.getWhere())) {
            sql += " and " + oto.getWhere();
          }
          selectEle.addElement(new TextElement(sql));
          document.getRootElement().addElement(selectEle);
        }

        //添加
        createFieldNameList.add(fieldName);
      }

    }
    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }



  /**
   * 元素是否存在
   */
  public boolean hasElement(Document document, String elementId) {
    boolean result = false;
    for (Element element : document.getRootElement().getElements()) {
      XmlElement xmlElement = (XmlElement) element;
      for (Attribute attribute : xmlElement.getAttributes()) {
        if (attribute.getValue().equals(elementId)) {
          result = true;
          break;
        }
      }
    }
    return result;
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

}
