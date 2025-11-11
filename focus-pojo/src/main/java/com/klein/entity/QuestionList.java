package com.klein.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionList implements Serializable {
    Integer questionId;
    String question;
    String answer;
    String options;
    String[] optionList;
}
