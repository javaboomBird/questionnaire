package com.create80.rd.common.filter;

import com.create80.rd.common.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.ServletRequest;
import org.springframework.beans.BeansException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

/**
 * 使用过滤器/拦截器把空字符串设置成null
 *
 * @author yzx
 */
public class EmptyStringToNullArgumentResolver extends
    ServletModelAttributeMethodProcessor {


  /**
   * @param annotationNotRequired if "true", non-simple method arguments and
   * return values are considered model attributes with or without a
   * {@code @ModelAttribute} annotation
   */
  public EmptyStringToNullArgumentResolver(boolean annotationNotRequired) {
    super(annotationNotRequired);
  }

  @Override
  protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
    EmptyStringToNullRequestDataBinder toNullRequestDataBinderBinder = new EmptyStringToNullRequestDataBinder(
        binder.getTarget(), binder.getObjectName());

    SimpleDateFormat timeDateFormat = new SimpleDateFormat(DateUtils.DEFAULT_DATE_TIME_PATTERN);
    timeDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    toNullRequestDataBinderBinder
        .registerCustomEditor(Date.class, new CustomDateEditor(timeDateFormat, true));

    SimpleDateFormat dayDateFormat = new SimpleDateFormat(DateUtils.DEFAULT_DATE_PATTERN);
    dayDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    toNullRequestDataBinderBinder
        .registerCustomEditor(Date.class, new CustomDateEditor(dayDateFormat, true));

    SimpleDateFormat monthDateFormat = new SimpleDateFormat(DateUtils.DEFAULT_MONTH_PATTERN);
    monthDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    toNullRequestDataBinderBinder
        .registerCustomEditor(Date.class, new CustomDateEditor(monthDateFormat, true));

    ServletRequest servletRequest = request.getNativeRequest(ServletRequest.class);
    toNullRequestDataBinderBinder.bind(servletRequest);
  }

}
