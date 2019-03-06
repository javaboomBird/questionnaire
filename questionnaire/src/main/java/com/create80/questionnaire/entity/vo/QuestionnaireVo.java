package com.create80.questionnaire.entity.vo;

import com.create80.questionnaire.entity.Question;
import com.create80.questionnaire.entity.Questionnaire;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

/**
 * @author huangzh
 * @Date 2019/3/1
 * @description
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionnaireVo {

  private Questionnaire paper;
  private List<Question> psqList;

}
