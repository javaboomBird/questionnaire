package com.create80.questionnaire.entity;

import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

/**
* @Description: 用户选项类
* @Author: huangzh
* @Date: 2019/3/4
*/
@Data
@Accessors(chain = true)
@Table(name="option")
public class Option {

  private long id;
  private String questionId;
  private String answerId;
  private String optionContent;
}
