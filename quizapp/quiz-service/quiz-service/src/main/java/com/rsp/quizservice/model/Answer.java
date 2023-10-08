package com.rsp.quizapp.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Answer {
    private Integer id;
    private String response;
}
