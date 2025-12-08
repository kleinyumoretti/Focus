package com.klein.vo;

import lombok.Builder;
import lombok.Data;

import javax.crypto.SecretKey;
import java.io.Serializable;
@Data
@Builder
public class DataVO implements Serializable {

    private String nameList;

    private String valueList;
}
