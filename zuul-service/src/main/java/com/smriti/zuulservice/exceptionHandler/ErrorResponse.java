package com.smriti.interceptorservice.exceptionHandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {

    private HttpStatus status;
    private String errorMsg;
    private String developerMsg;

    public ErrorResponse() {

    }

    public ErrorResponse(HttpStatus status, String errorMsg, String developerMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
        this.developerMsg = developerMsg;
    }
}



