package com.create80.questionnaire.controller;

import com.create80.questionnaire.entity.Question;
import com.create80.questionnaire.entity.Questionnaire;
import com.create80.questionnaire.entity.vo.QuestionnaireVo;
import com.create80.questionnaire.service.QuestionnaireService;
import java.security.PublicKey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzh
 * @Date 2019/2/28
 * @description
 */
@RestController
@RequestMapping("questionnaire")
public class QuestionnaireController {

  @Autowired
  private QuestionnaireService questionnaireService;


  /**
  * @Description: 返回所有问卷的vo类
  * @Author: huangzh
  * @Date: 2019/3/5
  */
  @GetMapping("listVo")
  public List<QuestionnaireVo> getAllVo() {
    return questionnaireService.getAllVo();
  }

  /**
  * @Description: 返回问卷列表
  * @Author: huangzh
  * @Date: 2019/3/5
  */
  @GetMapping("list")
  public List<Questionnaire> getAll() {
    return questionnaireService.getAll();
  }

  @PostMapping("save")
  public int save(@RequestBody QuestionnaireVo question) {
    int code = questionnaireService.save(question);
    return code;
  }

  @DeleteMapping("delete/{questionnaireId}")
  public void deleteQuestionnaireById(@PathVariable("questionnaireId") String id){
    questionnaireService.deleteQuestionnaireById(id);
  }

  /**
  * @Description:  根据问卷id查询该问卷下的问题列表
  * @Param: [id]
  * @Date: 2019/3/6
  */
  @GetMapping("question/{questionnaireId}")
    public List<Question> findByQuestionnaireId(@PathVariable("questionnaireId") String id){
    return questionnaireService.findByQuestionnaireId(id);
    }
}
