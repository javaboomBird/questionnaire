package com.create80.questionnaire.repository;

import com.create80.questionnaire.entity.Questionnaire;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author huangzh
 * @Date 2019/2/28
 * @description
 */
@Repository
public interface QuestionnaireRepository extends Mapper<Questionnaire> {

}
