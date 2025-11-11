package com.klein.vo;

import com.klein.entity.QuestionList;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionsVO implements Serializable {
    Integer total;
     List<QuestionList> questionList;
}
