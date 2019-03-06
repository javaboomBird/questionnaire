package com.create80.questionnaire.entity;

import java.util.List;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author huangzh
 * @Date 2019/3/1
 * @description 问题实体类
 */
@Data
@Accessors(chain = true)
@Table(name="question")
public class Question {

  private String id;
  private String isMust;
  private String type;
  private String questionContent;
  private String questionnaireId;
  private Integer questionNo;
  private List<Answer> answersList;
}
