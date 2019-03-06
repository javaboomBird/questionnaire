package com.create80.questionnaire.service;

import com.create80.questionnaire.entity.Answer;
import com.create80.questionnaire.entity.Question;
import com.create80.questionnaire.entity.Questionnaire;
import com.create80.questionnaire.entity.vo.QuestionnaireVo;
import com.create80.questionnaire.repository.AnswerRepository;
import com.create80.questionnaire.repository.QuestionRepository;
import com.create80.questionnaire.repository.QuestionnaireRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

/**
 * @author huangzh
 * @Date 2019/3/1
 * @description
 */
@Service
public class QuestionnaireService {

  @Autowired
  private QuestionnaireRepository questionnaireRepository;
  @Autowired
  private QuestionRepository questionRepository;
  @Autowired
  private AnswerRepository answerRepository;

  /**
   * @Description: 生产uuid
   * @Author: huangzh
   * @Date: 2019/3/1
   */
  private static String getUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  @Transactional(rollbackFor = Exception.class)
  public int save(QuestionnaireVo questionnaireVo) {
    //默认为失败
    int code=0;
    if (questionnaireVo.getPaper().getId() == null) {
      String questionnaireId = getUUID();
      questionnaireVo.getPaper().setId(questionnaireId);
    }
    //存储问卷
    questionnaireRepository.insertSelective(questionnaireVo.getPaper());
    //存储问卷下的问题
    //存储每一个问卷问题
    if(!questionnaireVo.getPsqList().isEmpty()) {
      questionnaireVo.getPsqList().stream().forEach(question -> {
        //存储每个问卷问题的多个答案选项
        question.setId(getUUID());
        question.setQuestionnaireId(questionnaireVo.getPaper().getId());
        questionRepository.insertSelective(question);
        if(question.getAnswersList()!=null && !question.getAnswersList().isEmpty()) {
          question.getAnswersList().stream().forEach(answer -> {
            answer.setQuestionId(question.getId());
            answer.setId(getUUID());
            answerRepository.insertSelective(answer);
          });
        }
      });
      code=1;
    }
    return code;
  }

  /**
  * @Description: 返回所有的问卷Vo
  * @Author: huangzh
  * @Date: 2019/3/5
  */
  public List<QuestionnaireVo> getAllVo() {

    List<QuestionnaireVo> questionnaireVoList=new ArrayList<>();
    //查询所有的问卷
    List<Questionnaire> questionnaireList=questionnaireRepository.selectAll();
    //查询每一个问卷下的问题列表

    if(questionnaireList!=null && !questionnaireList.isEmpty()){
      questionnaireList.forEach(questionnaire -> {
        Example example= Example.builder(Question.class).where(Sqls.custom().andEqualTo("questionnaireId",questionnaire.getId())).build();
        List<Question> questionList=questionRepository.selectByExample(example);
        QuestionnaireVo questionnaireVo=new QuestionnaireVo();
        questionnaireVo.setPaper(questionnaire);
        questionnaireVo.setPsqList(questionList);
        questionnaireVoList.add(questionnaireVo);
      });
    }
    return null;
  }

  public List<Questionnaire> getAll() {
    return questionnaireRepository.selectAll();
  }

  @Transactional(rollbackFor = Exception.class)
  public void deleteQuestionnaireById(String id){
    //删除问卷
    questionnaireRepository.delete(new Questionnaire().setId(id));
    //删除该问卷下的问题
    Example example= Example.builder(Question.class).where(Sqls.custom().andEqualTo("questionnaireId",id)).build();
    List<Question> questionList=questionRepository.selectByExample(example);
    //删除问题列表时遍历删除每个问题下的选项
    if(questionList!=null && !questionList.isEmpty()){
      questionList.stream().forEach(question -> {
        Example exampleAnswer= Example.builder(Answer.class).where(Sqls.custom().andEqualTo("questionId",question.getId())).build();
        answerRepository.deleteByExample(exampleAnswer);
        //最后删除问题列表
        questionRepository.delete(question);
      });
    }
  }

  public List<Question> findByQuestionnaireId(String id){
    //根据id查询问卷
    Question question=new Question();
    question.setQuestionnaireId(id);
    return questionRepository.select(question);
  }
}
