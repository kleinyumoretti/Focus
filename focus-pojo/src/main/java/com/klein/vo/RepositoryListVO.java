package com.klein.vo;

import com.klein.entity.Repository;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RepositoryListVO implements Serializable {
    private List repositoryList;
}
