package com.create80.rd.common.utils;

import com.create80.rd.common.config.ModuleLinkUtils;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteDataUtils {

  private static RestTemplate restTemplate = new RestTemplate();

  public static List<Map<String, Object>> getDataList(String url, String valueProperty,
      String textProperty) {
    if (StringUtils.isEmpty(url)) {
      return new ArrayList<>();
    }
    if (StringUtils.isEmpty(valueProperty)) {
      valueProperty = "value";
    }
    if (StringUtils.isEmpty(textProperty)) {
      textProperty = "text";
    }

    //如果url中有{moduleName},则根据moduleName去获取远程url
    url = rewritingUrl(url);

    ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
    List<Map> mapList = JsonUtils.toListObject(responseEntity.getBody(), Map.class);

    //transfer data to Map
    List<Map<String, Object>> result = new ArrayList<>();
    for (Map data : mapList) {
      Map<String, Object> valueMap = new HashMap<>();
      valueMap.put("value", data.get(valueProperty));
      valueMap.put("text", data.get(textProperty));
      result.add(valueMap);
    }
    return result;
  }

  /**
   * 重写组装url
   * @param url 请求url
   */
  private static String rewritingUrl(String url) {
    String moduleName = getModuleName(url);
    if (StringUtils.isNotEmpty(moduleName)) {
      String remoteUrl = ModuleLinkUtils.getModuleLink(moduleName);
      url = StringUtils.replaceOnce(url, "{" + moduleName + "}", remoteUrl);
    }
    return url;
  }

  /**
   * 截取url中的moduleName值
   */
  private static String getModuleName(String url) {

    if (StringUtils.isEmpty(url)) {
      return null;
    }
    int pre = url.indexOf("{");
    int suffix = url.indexOf("}");
    if (pre >= 0 && suffix > pre) {
      return url.substring(pre + 1, suffix);
    }
    return null;
  }

}
