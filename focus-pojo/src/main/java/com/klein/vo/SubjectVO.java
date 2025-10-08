package com.klein.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class SubjectVO implements Serializable {
    private String subject;

    private Integer subjectId;
}
