package com.create80.rd.common.config;

import com.create80.rd.common.utils.SpringContextHolder;
import com.create80.rd.common.utils.StringUtils;

public class ModuleLinkUtils {

  private static ModuleLinkConfiguration moduleLinkConfiguration = SpringContextHolder
      .getBean(ModuleLinkConfiguration.class);

  /**
   * 根据模块返回模块请求连接
   */
  public static String getModuleLink(String moduleName) {
    if (StringUtils.isEmpty(moduleName)) {
      return "";
    }
    return moduleLinkConfiguration.getLink(moduleName) == null ? ""
        : moduleLinkConfiguration.getLink(moduleName);
  }

}
