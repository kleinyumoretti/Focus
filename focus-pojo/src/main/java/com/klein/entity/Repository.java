package com.klein.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Repository implements Serializable {
    private Integer subjectId;

    private String repositoryName;

    private String description;

    private Integer userId;
}
