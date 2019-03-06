package com.create80.questionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.create80.questionnaire.repository")
@EnableTransactionManagement
public class QuestionnaireApplication {

  public static void main(String[] args) {
    SpringApplication.run(QuestionnaireApplication.class, args);
  }

}
