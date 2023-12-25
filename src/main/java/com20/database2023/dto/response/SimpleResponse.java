package com20.database2023.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Setter
@Getter
public class SimpleResponse {
    private HttpStatus httpStatus;
    private String message;

    public SimpleResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}