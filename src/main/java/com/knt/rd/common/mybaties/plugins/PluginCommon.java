package com.knt.rd.common.mybaties.plugins;

import com.knt.rd.common.utils.StringUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.ConnectionFactory;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.JDBCConnectionFactory;
import org.mybatis.generator.internal.ObjectFactory;
import org.mybatis.generator.internal.util.StringUtility;

public class PluginCommon {

  public static IntrospectedTable getIt(String tableName, List<IntrospectedTable> tableList) {
    if (tableList == null) {
      return null;
    }
    for (IntrospectedTable i : tableList) {
      if (i.getTableConfiguration().getTableName().equalsIgnoreCase(tableName)) {
        return i;
      }
    }
    return null;
  }

  public static TableConfiguration getMapTc(String tableName, Context context) {
    TableConfiguration tc = null;
    for (TableConfiguration t : context.getTableConfigurations()) {
      if (t.getTableName().equalsIgnoreCase(tableName)) {
        tc = t;
      }
    }
    return tc;
  }

  public static String getModelPackage(IntrospectedTable introspectedTable, Context context) {
    StringBuilder sb = new StringBuilder();
    sb.append(context.getJavaModelGeneratorConfiguration().getTargetPackage());
    sb.append(introspectedTable.getFullyQualifiedTable().getSubPackageForModel(StringUtility
        .isTrue(context.getJavaModelGeneratorConfiguration()
            .getProperty(PropertyRegistry.ANY_ENABLE_SUB_PACKAGES))));
    String pakkage = sb.toString();
    return pakkage;
  }

  public static JavaTypeResolver getJdbcTypes(Context context, List<String> warnings) {
    JavaTypeResolver javaTypeResolver = ObjectFactory
        .createJavaTypeResolver(context, warnings);
    return javaTypeResolver;
  }


  public static Connection getConnection(Context context,
      JDBCConnectionConfiguration jdbcConnectionConfiguration) throws SQLException {
    ConnectionFactory connectionFactory;
    if (jdbcConnectionConfiguration != null) {
      connectionFactory = new JDBCConnectionFactory(jdbcConnectionConfiguration);
    } else {
      connectionFactory = ObjectFactory.createConnectionFactory(context);
    }
    return connectionFactory.getConnection();
  }

  /**
   * 判断xml是否已经创建了方法
   * @param document
   * @param methodName
   * @return
   */
  public static boolean xmlHasCreateMethod(Document document, String methodName) {

    if (StringUtils.isEmpty(methodName)) {
      return false;
    }
    List<String> result = new ArrayList<>();
    document.getRootElement().getElements().stream().forEach(element -> {
      XmlElement xmlElement = (XmlElement) element;
      if ("insert".equalsIgnoreCase(xmlElement.getName())) {
        xmlElement.getAttributes().stream().forEach(attribute -> {
          if (methodName.equalsIgnoreCase(attribute.getName())) {
            result.add("xx");
          }
        });
      }
    });
    return result.size() > 0;
  }

  /**
   * 代码中是否创建了方法
   * @param interfaze
   * @param methodName
   * @return
   */
  public static boolean codeHasCreateMethod(Interface interfaze, String methodName) {
    if (StringUtils.isEmpty(methodName)) {
      return false;
    }
    List<String> result = new ArrayList<>();
    interfaze.getMethods().stream().forEach(method -> {
      if (methodName.equalsIgnoreCase(method.getName())) {
        result.add("xx");
      }
    });
    return result.size() > 0;
  }

}
