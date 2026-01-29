package com.klein.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String token;
    private String password;
    private String name;
    private Integer selectId;
    private LocalDateTime createTime;
    private String access;
}
