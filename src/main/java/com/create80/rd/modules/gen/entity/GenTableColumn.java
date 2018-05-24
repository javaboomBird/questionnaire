/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.modules.gen.entity;

import com.create80.rd.modules.gen.util.GenUtils;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.create80.rd.common.persistence.DataEntity;
import com.create80.rd.common.utils.StringUtils;

/**
 * 业务表字段Entity
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
public class GenTableColumn extends DataEntity<GenTableColumn> {

  private static final long serialVersionUID = 1L;
  private GenTable genTable;  // 归属表
  private String name;    // 列名
  private String comments;  // 描述
  private String jdbcType;  // JDBC类型
  private String javaType;  // JAVA类型
  private String javaField;  // JAVA字段名
  private String javaTypeTable;//java 类型对应的表名称
  private String isPk;    // 是否主键（1：主键）
  private String isNull;    // 是否可为空（1：可为空；0：不为空）
  private String isInsert;  // 是否为插入字段（1：插入字段）
  private String isEdit;    // 是否编辑字段（1：编辑字段）
  private String isList;    // 是否列表字段（1：列表字段）
  private String isQuery;    // 是否查询字段（1：查询字段）
  private String queryType;  // 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
  private String showType;  // 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
  private String dictType;  // 字典类型
  private String url;   //动态下拉框数据获取地址
  private String textValue; //动态下拉选框Text指定字段名称
  private Integer sort;    // 排序（升序）


  public GenTableColumn() {
    super();
  }

  public GenTableColumn(String id) {
    super(id);
  }

  public GenTableColumn(GenTable genTable) {
    this.genTable = genTable;
  }

  public GenTable getGenTable() {
    return genTable;
  }

  public void setGenTable(GenTable genTable) {
    this.genTable = genTable;
  }

  @Length(min = 1, max = 200)
  public String getName() {
    return StringUtils.lowerCase(name);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getJdbcType() {
    return StringUtils.lowerCase(jdbcType);
  }

  public void setJdbcType(String jdbcType) {
    this.jdbcType = jdbcType;
  }

  public String getJavaType() {
    return javaType;
  }

  public void setJavaType(String javaType) {
    this.javaType = javaType;
  }

  public String getJavaField() {
    return javaField;
  }

  public void setJavaField(String javaField) {
    this.javaField = javaField;
  }

  public String getIsPk() {
    return isPk;
  }

  public void setIsPk(String isPk) {
    this.isPk = isPk;
  }

  public String getIsNull() {
    return isNull;
  }

  public void setIsNull(String isNull) {
    this.isNull = isNull;
  }

  public String getIsInsert() {
    return isInsert;
  }

  public void setIsInsert(String isInsert) {
    this.isInsert = isInsert;
  }

  public String getIsEdit() {
    return isEdit;
  }

  public void setIsEdit(String isEdit) {
    this.isEdit = isEdit;
  }

  public String getIsList() {
    return isList;
  }

  public void setIsList(String isList) {
    this.isList = isList;
  }

  public String getIsQuery() {
    return isQuery;
  }

  public void setIsQuery(String isQuery) {
    this.isQuery = isQuery;
  }

  public String getQueryType() {
    return queryType;
  }

  public void setQueryType(String queryType) {
    this.queryType = queryType;
  }

  public String getShowType() {
    return showType;
  }

  public void setShowType(String showType) {
    this.showType = showType;
  }

  public String getDictType() {
    return dictType == null ? "" : dictType;
  }

  public void setDictType(String dictType) {
    this.dictType = dictType;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public String getJavaTypeTable() {
    return javaTypeTable;
  }

  public void setJavaTypeTable(String javaTypeTable) {
    this.javaTypeTable = javaTypeTable;
  }

  public String getTextValue() {
    return textValue;
  }

  public void setTextValue(String textValue) {
    this.textValue = textValue;
  }

  /**
   * 获取列名和说明
   */
  public String getNameAndComments() {
    return getName() + (comments == null ? "" : "  :  " + comments);
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * 获取字符串长度
   */
  public String getDataLength() {
    String[] ss = StringUtils.split(StringUtils.substringBetween(getJdbcType(), "(", ")"), ",");
    if (ss != null && ss.length == 1) {// && "String".equals(getJavaType())){
      return ss[0];
    }
    return "0";
  }

  /**
   * 获取简写Java类型
   */
  public String getSimpleJavaType() {
    if ("This".equals(getJavaType())) {
      return StringUtils.capitalize(genTable.getClassName());
    }
    return StringUtils.indexOf(getJavaType(), ".") != -1
        ? StringUtils.substringAfterLast(getJavaType(), ".")
        : getJavaType();
  }

  /**
   * 获取简写Java字段
   */
  public String getSimpleJavaField() {
    return StringUtils.substringBefore(getJavaField(), ".");
  }

  /**
   * 获取Java字段，如果是对象，则获取对象.附加属性1
   */
  public String getJavaFieldId() {
    return StringUtils.substringBefore(getJavaField(), "|");
  }

  /**
   * 获取Java字段，如果是对象，则获取对象.附加属性2
   */
  public String getJavaFieldName() {
    String[][] ss = getJavaFieldAttrs();
    return ss.length > 0 ? getSimpleJavaField() + "." + ss[0][0] : "";
  }

  /**
   * 获取Java字段，所有属性名
   */
  public String[][] getJavaFieldAttrs() {
    String[] ss = StringUtils.split(StringUtils.substringAfter(getJavaField(), "|"), "|");
    String[][] sss = new String[ss.length][2];
    if (ss != null) {
      for (int i = 0; i < ss.length; i++) {
        sss[i][0] = ss[i];
        sss[i][1] = StringUtils.toUnderScoreCase(ss[i]);
      }
    }
    return sss;
  }

  /**
   * 获取列注解列表
   */
  public List<String> getAnnotationList() {
    List<String> list = Lists.newArrayList();
    // 导入Jackson注解
    if ("This".equals(getJavaType())) {
      list.add("com.fasterxml.jackson.annotation.JsonBackReference");
    }
    if ("java.util.Date".equals(getJavaType())) {
      list.add("com.fasterxml.jackson.annotation.JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
    }
    // 导入JSR303验证依赖包
    if (!"1".equals(getIsNull()) && !"String".equals(getJavaType())) {
      list.add("javax.validation.constraints.NotNull(message=\"" + getComments() + "不能为空\")");
    } else if (!"1".equals(getIsNull()) && "String".equals(getJavaType()) && !"0"
        .equals(getDataLength())) {
      list.add("org.hibernate.validator.constraints.Length(min=1, max=" + getDataLength()
          + ", message=\"" + getComments() + "长度必须介于 1 和 " + getDataLength() + " 之间\")");
    } else if ("String".equals(getJavaType()) && !"0".equals(getDataLength())) {
      list.add("org.hibernate.validator.constraints.Length(min=0, max=" + getDataLength()
          + ", message=\"" + getComments() + "长度必须介于 0 和 " + getDataLength() + " 之间\")");
    }
    return list;
  }

  /**
   * 获取简写列注解列表
   */
  public List<String> getSimpleAnnotationList() {
    List<String> list = Lists.newArrayList();
    for (String ann : getAnnotationList()) {
      list.add(StringUtils.substringAfterLast(ann, "."));
    }
    return list;
  }

  /**
   * 是否是基类字段
   */
  public Boolean getIsNotBaseField() {
    return !StringUtils.equals(getSimpleJavaField(), "id")
        && !StringUtils.equals(getSimpleJavaField(), "remarks")
        && !StringUtils.equals(getSimpleJavaField(), "createBy")
        && !StringUtils.equals(getSimpleJavaField(), "createDate")
        && !StringUtils.equals(getSimpleJavaField(), "updateBy")
        && !StringUtils.equals(getSimpleJavaField(), "updateDate")
        && !StringUtils.equals(getSimpleJavaField(), "delFlag");
  }

  public Boolean getIsNeedCreateBaseField() {
    if (!getIsNotBaseField()) {
      return false;
    }
    GenConfig genConfig = GenUtils.getConfig();
    return genConfig.getJavaTypeList().stream()
        .filter(e -> StringUtils.isNotEmpty(e.getType()) && e.getType().equals(getJavaTypeTable()))
        .count() > 0;
  }

  public String getCreateBaseFieldId() {
    return StringUtils.toCamelCase(getName());
  }

}


