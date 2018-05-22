package com.create80.rd.common.utils;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.util.List;

public class FreeMarkerTag implements TemplateMethodModelEx {

  @Override
  public Object exec(List arguments) throws TemplateModelException {
    String string = String.valueOf(arguments.get(0));

    return StringUtils.toCapitalizeCamelCase(string);
  }
}
