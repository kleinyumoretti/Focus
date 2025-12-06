package com.klein.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Question implements Serializable {
    private Integer id;          // 题目ID
    private String topic;        // 题干
    private Character answer;    // 正确答案
    private String options;      // 选项（逗号分隔）
    private Integer repositoryId;// 所属题库ID
}
