package com.create80.questionnaire.entity;

import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author huangzh
 * @Date 2019/2/28
 * @description 问卷实体类
 */
@Data
@Accessors(chain = true)
@Table(name="questionnaire")
public class Questionnaire {

  private String id;
  private String title;
  private String description;
}
