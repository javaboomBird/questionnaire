package com.create80.rd.common.mybaties.gen;

import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.InsertSelectiveElementGenerator;

public class InsertXmlMapperGenerator extends XMLMapperGenerator {


  /**
   * 覆盖xml生成器
   * 重写插入insertSelective方法
   */
  @Override
  protected void addInsertSelectiveElement(XmlElement parentElement) {
    if (introspectedTable.getRules().generateInsertSelective()) {
      AbstractXmlElementGenerator elementGenerator = new OneToOneInsertSelectiveElementGenerator();
      initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
  }

}
