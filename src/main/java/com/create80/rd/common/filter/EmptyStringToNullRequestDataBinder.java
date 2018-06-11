package com.create80.rd.common.filter;

import javax.servlet.ServletRequest;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

/**
 * 继承自ExtendedServletRequestDataBinder，主要用来自定义数据绑定处理
 *
 * @author yzx
 */
public class EmptyStringToNullRequestDataBinder extends ServletRequestDataBinder {

  public EmptyStringToNullRequestDataBinder(Object target, String objectName) {
    super(target, objectName);
  }

  @Override
  protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {

    for (PropertyValue propertyValue : mpvs.getPropertyValueList()) {
      if ("".equals(propertyValue.getValue())) {
        propertyValue.setConvertedValue(null);
      }
    }
    super.addBindValues(mpvs, request);
  }
}
