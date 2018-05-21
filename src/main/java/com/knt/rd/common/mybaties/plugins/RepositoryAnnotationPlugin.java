package com.knt.rd.common.mybaties.plugins;

import java.util.List;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;


public class RepositoryAnnotationPlugin extends PluginAdapter {

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  @Override
  public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {

    interfaze.addImportedType(
        new FullyQualifiedJavaType("org.springframework.stereotype.Repository")); //$NON-NLS-1$
    interfaze.addAnnotation("@Repository");
    return true;
  }
}
