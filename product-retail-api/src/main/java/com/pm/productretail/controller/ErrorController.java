package com.pm.productretail.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lnurullina
 */
@RestController
public class ErrorController {

    @RequestMapping(value="/500")
    public String handleException(HttpServletRequest req) {
        // you can get the exception thrown
        Throwable t = (Throwable)req.getAttribute("javax.servlet.error.exception");

        // customize response to what you want
        return "Internal server error.";
    }
}
