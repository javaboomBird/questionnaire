package com.create80.questionnaire.entity;


import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;


/**
* @Description: 问卷选项实体类
* @Author: huangzh
* @Date: 2019/3/1
*/
@Data
@Accessors(chain = true)
@Table(name="answer")
public class Answer {

  private String id;
  private String questionId;
  private String answerContent;
  private Integer answerNo;
  private Question question;


}
