package com.knt.rd.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteDataUtils {

  private static RestTemplate restTemplate = new RestTemplate();

  public  static List<Map<String, Object>> getDataList(String url, String valueProperty,
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

}
