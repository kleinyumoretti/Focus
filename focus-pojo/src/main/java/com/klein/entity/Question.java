package com.klein.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Question implements Serializable {
    private Integer id;
    private Integer questionId;
    private String question;
    private String answer;
    private Integer userId;
    private Integer subjectId;
}
