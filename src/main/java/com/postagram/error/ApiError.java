package com.postagram.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.postagram.security.BasicGrantedAuthority;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiError {

    BasicGrantedAuthority authority;

    private long timestamp = new Date().getTime();

    private int status;

    private String message;

    private String url;

    private Map<String, String> validationErrors = new HashMap<>();

   public ApiError(int status, String message, String url) {
        this.status = status;
        this.message = message;
        this.url = url;
    }

}
