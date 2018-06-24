package com.create80.rd.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.create80.rd.common.utils.page.PageInfo;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class JsonUtils {

  private static ObjectMapper mapper = new ObjectMapper();

  protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss");


  static {
    mapper.configure(
        DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
        true);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.setDateFormat(DATE_FORMAT);
  }

  /**
   * 对象转Json字符串
   */
  public static String toJson(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return "{}";
  }

  /**
   * 字符串转简单对象
   */
  public static <T> T toSimpleObject(String json, Class<T> clazz) {

    T obj = null;
    try {
      obj = mapper.readValue(json, clazz);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return obj;
  }


  /**
   * Json转List<bean>对象
   */
  public static <T> List<T> toListObject(String json, Class<T> clazz) {

    try {
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      mapper.setDateFormat(DATE_FORMAT);
      return (List<T>) mapper.readValue(json, getCollectionType(List.class, clazz));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取collection子集对象
   */
  private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
    return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
  }

  /**
   * 如果JSON字符串为Null或"null"字符串, 返回Null.
   * 如果JSON字符串为"[]", 返回空集合.
   *
   * 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型.
   *
   * @see #constructParametricType(Class, Class...)
   */
  public static <T> T fromJson(String jsonString, Class<T> clazz) {
    if (StringUtils.isEmpty(jsonString)) {
      return null;
    }

    try {
      return mapper.readValue(jsonString, clazz);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 如果JSON字符串为Null或"null"字符串, 返回Null.
   * 如果JSON字符串为"[]", 返回空集合.
   *
   * 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型.
   *
   * @see #constructParametricType(Class, Class...)
   */
  @SuppressWarnings("unchecked")
  public static <T> T fromJson(String jsonString, JavaType javaType) {
    if (StringUtils.isEmpty(jsonString)) {
      return null;
    }
    try {
      return (T) mapper.readValue(jsonString, javaType);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public static <T> T fromJson(String jsonString, Class<?> parametrized,
      Class<?>... parameterClasses) {
    return (T) fromJson(jsonString, constructParametricType(parametrized, parameterClasses));
  }

  @SuppressWarnings("unchecked")
  public <T> List<T> fromJsonToList(String jsonString, Class<T> classMeta) {
    return (List<T>) fromJson(jsonString, constructParametricType(List.class, classMeta));
  }


  /**
   * 構造泛型的Type如List<MyBean>, 则调用constructParametricType(ArrayList.class,MyBean.class)
   * Map<String,MyBean>则调用(HashMap.class,String.class, MyBean.class)
   */
  public static JavaType constructParametricType(Class<?> parametrized,
      Class<?>... parameterClasses) {
    return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
  }

  public static void main(String[] args) {


  }

}
