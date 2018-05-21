package com.knt.rd.common.mybaties.plugins;

import com.knt.rd.common.mybaties.TableConfigurationExtend;
import java.util.List;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class StopGeneratorPlugin extends PluginAdapter {

  @Override
  public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
    TableConfigurationExtend tableConfigurationExtend = getTableConfigurationExtend(
        introspectedTable);

    return tableConfigurationExtend.isStopGenerator() ? false : true;
  }

  @Override
  public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {
    TableConfigurationExtend tableConfigurationExtend = getTableConfigurationExtend(
        introspectedTable);
    return tableConfigurationExtend.isStopGenerator() ? false : true;
  }

  @Override
  public boolean clientGenerated(Interface interfaze,
      TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {
    TableConfigurationExtend tableConfigurationExtend = getTableConfigurationExtend(
        introspectedTable);

    return tableConfigurationExtend.isStopGenerator() ? false : true;
  }

  @Override
  public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {
    TableConfigurationExtend tableConfigurationExtend = getTableConfigurationExtend(
        introspectedTable);
     return tableConfigurationExtend.isStopGenerator() ? false : true;
  }

  private TableConfigurationExtend getTableConfigurationExtend(
      IntrospectedTable introspectedTable) {
    return (TableConfigurationExtend) introspectedTable
        .getTableConfiguration();
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }
}
