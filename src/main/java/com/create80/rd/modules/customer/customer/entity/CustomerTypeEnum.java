package com.create80.rd.modules.customer.customer.entity;

public enum CustomerTypeEnum {

  ENTERPRISE_TYPE("ET"), GOVENMENT_TYPE("GT");

  private String value;

  CustomerTypeEnum(String value) {
    this.value=value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
