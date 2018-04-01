package com.pm.productretail.controller;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.service.DepartmentService;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController extends ResponseCreator {

    @Autowired
    SecurityService securityService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;


    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<DepartmentDto>>> getUserDepartments(){
        AppUser currentUser = securityService.getCurrentUser();
        return createGoodResponse(userService.findUserDepartments(currentUser));
    }
}
