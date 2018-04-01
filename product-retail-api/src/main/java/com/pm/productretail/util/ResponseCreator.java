package com.pm.productretail.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author lnurullina
 */
public abstract class ResponseCreator {
    private final static String SUCCES_RESUL = "Success";
    private final static String FAIL_RESUL = "Fail";

    protected <T> ResponseEntity<ApiResponse<T>> createGoodResponse(T body) {
        return createResponse(body, null, HttpStatus.OK);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createGoodResponse() {
        return createGoodResponse((T) SUCCES_RESUL);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createBadResponse(String error) {
        return createResponse((T) FAIL_RESUL, error, HttpStatus.OK);
    }

    private <T> ResponseEntity<ApiResponse<T>> createResponse(T body, String error, HttpStatus status) {
        return new ResponseEntity<>(new ApiResponse<>(body, error), status);
    }

}
