package com.rsp.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NewContactMailRequest {
    private String name;
    private String email;
    private String subject;
    private String message;
}
