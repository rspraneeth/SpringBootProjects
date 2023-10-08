package com.rsp.questionservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Answer {
    private Integer id;
    private String response;
}
