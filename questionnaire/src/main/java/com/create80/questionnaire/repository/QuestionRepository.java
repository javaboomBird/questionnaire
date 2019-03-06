package com.create80.questionnaire.repository;

import com.create80.questionnaire.entity.Question;
import java.util.List;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author huangzh
 * @Date 2019/2/28
 * @description
 */
@Repository
public interface QuestionRepository extends Mapper<Question> {

   List<Question> getAll();
}
