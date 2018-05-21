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
package com.knt.rd.common.mybaties.plugins;

import com.knt.rd.common.mybaties.TableConfigurationExtend;
import com.knt.rd.common.mybaties.config.OneToMany;
import com.knt.rd.common.utils.StringUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.db.DatabaseIntrospector;
import org.mybatis.generator.internal.util.StringUtility;

public class OneToManyPlugin extends PluginAdapter {

  /**
   * 修改model
   */
  @Override
  public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {
    TableConfigurationExtend tableConfigurationExtend = (TableConfigurationExtend) introspectedTable
        .getTableConfiguration();
    for (OneToMany otm : tableConfigurationExtend.getOneToManyList()) {
      String tableName = otm.getMappingTable();
      TableConfiguration tc = PluginCommon.getMapTc(tableName, context);
      if (tc != null) {
        String pakkage = PluginCommon.getModelPackage(introspectedTable, context);
        String domainName = tc.getDomainObjectName();
        String type = pakkage + "." + domainName;
        String fieldName = domainName.replaceFirst(new String(new char[]{domainName.charAt(0)}),
            new String(new char[]{domainName.charAt(0)}).toLowerCase()) + "List";
        org.mybatis.generator.api.dom.java.Field field = new org.mybatis.generator.api.dom.java.Field();

        field.setName(fieldName);
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("java.util.List<" + type + ">");
        field.setType(fqjt);
        field.setVisibility(JavaVisibility.PRIVATE);
        topLevelClass.addImportedType(new FullyQualifiedJavaType(type));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("java.util.List"));
        topLevelClass.addField(field);

        // get
        Method getMethod = new Method();
        getMethod.setVisibility(JavaVisibility.PUBLIC);
        getMethod.setReturnType(fqjt);
        getMethod.setName("get" + tc.getDomainObjectName() + "List");
        getMethod.addBodyLine("return " + fieldName + ";");
        topLevelClass.addMethod(getMethod);
        // set
        Method setMethod = new Method();
        setMethod.setVisibility(JavaVisibility.PUBLIC);
        setMethod.setName("set" + tc.getDomainObjectName() + "List");
        setMethod.addParameter(new Parameter(fqjt, fieldName));
        setMethod.addBodyLine("this." + fieldName + "=" + fieldName + ";");
        topLevelClass.addMethod(setMethod);
      }
    }
    return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
  }

  /**
   * 修改mapper.xml
   */
  @Override
  public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
    //获取
    TableConfigurationExtend tableConfigurationExtend = (TableConfigurationExtend) introspectedTable
        .getTableConfiguration();
    List<String> warnings = new ArrayList<String>();
    for (OneToMany otm : tableConfigurationExtend.getOneToManyList()) {
      String tableName = otm.getMappingTable();
      TableConfiguration tc = PluginCommon.getMapTc(tableName, context);
      List<IntrospectedTable> tables = null;
      try {
        DatabaseIntrospector databaseIntrospector = new DatabaseIntrospector(
            context, PluginCommon.getConnection(context, context.getJdbcConnectionConfiguration())
            .getMetaData(),
            PluginCommon.getJdbcTypes(context, warnings),
            warnings);
        tables = databaseIntrospector
            .introspectTables(tc);

      } catch (SQLException e) {
        e.printStackTrace();
      }
      IntrospectedTable it = PluginCommon.getIt(tableName, tables);
      if (tc != null) {
        String domainName = tc.getDomainObjectName() + "List";
        String fieldName = domainName.replaceFirst(new String(new char[]{domainName.charAt(0)}),
            new String(new char[]{domainName.charAt(0)}).toLowerCase());
        // 添加<collection property="tags" column="tag_id" select="getParentElement" />
        XmlElement assEle = new XmlElement("collection");
        assEle.addAttribute(new Attribute("property", fieldName));
        assEle.addAttribute(new Attribute("column", otm.getColumn()));
        assEle.addAttribute(new Attribute("select", "get" + domainName));
        for (Element ele : document.getRootElement().getElements()) {
          XmlElement xe = (XmlElement) ele;
          for (Attribute a : xe.getAttributes()) {
            if (a.getName().equalsIgnoreCase("id") && "BaseResultMap".equals(a.getValue())) {
              xe.addElement(assEle);
            }
          }
        }
        String tuofengColum = StringUtils.toCamelCase(otm.getColumn());
        String namespace =
            context.getJavaClientGeneratorConfiguration().getTargetPackage() + "." + tc
                .getDomainObjectName()
                + "Mapper";

        //添加查询方法<select id="testOutMapper" resultMap="soc.dao.ScanDao.BaseResultMap"><include refid="soc.dao.ScanDao.Base_Column_List" />
        XmlElement selectEle = new XmlElement("select");
        selectEle.addAttribute(new Attribute("id", "get" + domainName));
        selectEle.addAttribute(
            new Attribute("resultMap", namespace + "." + "BaseResultMap"));
        String sql = "select ";
        for (IntrospectedColumn c : it.getAllColumns()) {
          sql += c.getActualColumnName() + ",";
        }
        sql = sql.substring(0, sql.length() - 1);
        sql += " from " + tableName + " where " + otm.getJoinColumn() + "=#{" + tuofengColum + "} ";
        if (StringUtility.stringHasValue(otm.getWhere())) {
          sql += " and " + otm.getWhere();
        }
        selectEle.addElement(new TextElement(sql));
        document.getRootElement().addElement(selectEle);
      }
    }
    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

}
