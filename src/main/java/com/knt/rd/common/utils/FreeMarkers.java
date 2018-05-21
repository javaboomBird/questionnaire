/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.knt.rd.common.utils;

import com.google.common.collect.Maps;
import com.knt.rd.modules.gen.entity.GenTable;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Map;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarkers工具类
 *
 * @author ThinkGem
 * @version 2013-01-15
 */
public class FreeMarkers {

  public static String renderString(String templateString, Map<String, Object> model) {
    try {
      StringWriter result = new StringWriter();
      model.put("tuofeng",new FreeMarkerTag());
      Template t = new Template("name", new StringReader(templateString), new Configuration());
      t.process(model, result);
      return result.toString();
    } catch (Exception e) {
      throw Exceptions.unchecked(e);
    }
  }

  public static String renderTemplate(Template template, Object model) {
    try {
      StringWriter result = new StringWriter();
      template.process(model, result);
      return result.toString();
    } catch (Exception e) {
      throw Exceptions.unchecked(e);
    }
  }

  public static Configuration buildConfiguration(String directory) throws IOException {
    Configuration cfg = new Configuration();
    Resource path = new DefaultResourceLoader().getResource(directory);
    cfg.setDirectoryForTemplateLoading(path.getFile());
    return cfg;
  }



  public static void main(String[] args) throws IOException {
//		// renderString
    Map<String, Object> model = Maps.newHashMap();
    GenTable child = new GenTable();
    child.setClassName("contact");
    child.setName("contact_cd");
    child.setParentTableFk("CustomerId");

    model.put("ClassName", "Government");
    model.put("className", "government");
    model.put("contactPFK", "CustomerId");
    model.put("tuofeng",new FreeMarkerTag());
    GenTable parent = new GenTable();
    parent.setChildList(Arrays.asList(child));
    model.put("table", parent);

    String result = FreeMarkers.renderString(Template, model);
    System.out.println(result);
//		// renderTemplate
//		Configuration cfg = FreeMarkers.buildConfiguration("classpath:/");
//		Template template = cfg.getTemplate("testTemplate.ftl");
//		String result2 = FreeMarkers.renderTemplate(template, model);
//		System.out.println(result2);

//		Map<String, String> model = com.google.common.collect.Maps.newHashMap();
//		model.put("userName", "calvin");
//		String result = FreeMarkers.renderString("hello ${userName} ${r'${userName}'}", model);
//		System.out.println(result);
  }

  public static final String Template = "  \n\t@Transactional(readOnly = false)\n"
      + "\tpublic void save(${ClassName} ${className}) {\n"
      + "\n"
      + "     if (StringUtils.isNotEmpty(${className}.getId())) {\n"
      + "      ${className}Mapper.updateByPrimaryKeySelective(${className});\n"
      + "     <#list table.childList as c>\n"
      + "      if (StringUtils.isNotEmpty(${className}.getId())) {\n"
      + "        delete${ClassName}${c.className?cap_first}ById(${className}.getId());\n"
      + "      }\n"
      + "      List<${c.className?cap_first}> ${c.className?uncap_first}List = ${className}.get${c.className?cap_first}List();\n"
      + "      if (${c.className?uncap_first}List.size() > 0 && ${c.className?uncap_first}List != null) {\n"
      + "        List<${c.className?cap_first}> insertOrUpdate${c.className?cap_first} = new ArrayList<>();\n"
      + "        ${c.className?uncap_first}List.stream().forEach(${c.className?uncap_first} -> {\n"
      + "          String delFlag = ${c.className?uncap_first}.getDelFlag();\n"
      + "          if (\"0\".equals(delFlag)) {\n"
      + "            ${c.className?uncap_first}.setId(uuid());\n"
      + "            ${c.className?uncap_first}.set${tuofeng(c.name)}(${className}.getId());\n"
      + "            insertOrUpdate${c.className?cap_first}.add(${c.className?uncap_first});\n"
      + "          }\n"
      + "        });\n"
      + "        if (insertOrUpdate${c.className?cap_first}.size() > 0) {\n"
      + "          ${c.className?uncap_first}Mapper.insertBatchSelective(insertOrUpdate${c.className?cap_first});\n"
      + "        }\n"
      + "      }\n"
      + "      </#list>\n"
      + "    } else {\n"
      + "      ${className}.setId(uuid());\n"
      + "      <#list table.childList as c>\n"
      + "      List<${c.className?cap_first}> ${c.className?uncap_first}List = ${className}.get${c.className?cap_first}List();\n"
      + "      if (${c.className?uncap_first}List != null && ${c.className?uncap_first}List.size() > 0) {\n"
      + "        ${c.className?uncap_first}List.stream().forEach(${c.className?uncap_first} -> {\n"
      + "          ${c.className?uncap_first}.setId(uuid());\n"
      + "          ${c.className?uncap_first}.set${c.parentTableFk}(${className}.getId());\n"
      + "        });\n"
      + "        ${c.className?uncap_first}Mapper.insertBatchSelective(${c.className?uncap_first}List);\n"
      + "      }\n"
      + "      ${className}Mapper.insertSelective(${className});\n"
      + "      </#list>\n"
      + "    }\n"
      + "\n"
      + "\t}";

}
