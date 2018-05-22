package com.create80.rd.common.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.create80.rd.common.utils.JsonUtils;
import com.create80.rd.common.utils.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class ModelLinkConfiguration {

  protected Logger logger = LoggerFactory.getLogger(getClass());

  @Value("classpath:modelLinks.json")
  Resource modelLinkResource;
  private Map<String, String> modelLinkMap = new HashMap<String, String>();


  /**
   * 返回model 链接
   */
  public String getLink(String modelName) {
    Assert.notNull(modelName, "model name must not be null .");
    if (!modelLinkMap.containsKey(modelName)) {
      logger.warn("model name :" + modelName
          + " link url no found in config directory modelLinks.json file ");
      return null;
    }
    return modelLinkMap.get(modelName);
  }

  @PostConstruct
  public void init() {
    String modelLinkJson = readModelLinkJson();
    if (StringUtils.isEmpty(modelLinkJson)) {
      logger.warn("warn: read modelLink config is null");
      return;
    }
    Map<String, String> result = JsonUtils.toSimpleObject(modelLinkJson, Map.class);
    modelLinkMap.putAll(result);
  }


  /**
   * 读取model Link配置
   */
  private String readModelLinkJson() {
    String modelLinkJson = null;
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(
          new InputStreamReader(modelLinkResource.getInputStream()));
      StringBuffer fileBuffer = new StringBuffer();
      while (reader.ready()) {
        fileBuffer.append(reader.readLine());
      }
      modelLinkJson = fileBuffer.toString();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return modelLinkJson;
  }
}
