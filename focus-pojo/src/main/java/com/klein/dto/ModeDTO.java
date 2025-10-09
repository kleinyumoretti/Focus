package com.klein.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ModeDTO implements Serializable {
    private Integer subjectId;

    private Integer mode;
}
