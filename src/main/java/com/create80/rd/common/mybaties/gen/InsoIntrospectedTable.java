package com.create80.rd.common.mybaties.gen;

import java.util.List;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

/**
 *
 */
public class InsoIntrospectedTable extends IntrospectedTableMyBatis3Impl {

  @Override
  protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator,
      List<String> warnings, ProgressCallback progressCallback) {

    if (context.getSqlMapGeneratorConfiguration() != null) {
      xmlMapperGenerator = new InsertXmlMapperGenerator();
    } else {
      xmlMapperGenerator = javaClientGenerator.getMatchedXMLGenerator();
    }
    initializeAbstractGenerator(xmlMapperGenerator, warnings,
        progressCallback);
  }
}
