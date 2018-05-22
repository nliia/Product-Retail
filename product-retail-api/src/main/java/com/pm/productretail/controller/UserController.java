package com.pm.productretail.controller;

import com.pm.productretail.dto.AppUserDto;
import com.pm.productretail.dto.response.AppUserResponseDto;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController extends ResponseCreator {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> createUser(@RequestBody AppUserDto appUserDto) {
        try {
            userService.createUser(appUserDto);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/search_users/{name}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<AppUserResponseDto>>> searchUsersByName(@PathVariable String name) {
        return createGoodResponse(userService.findAllByName(name));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/users/{page}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<AppUserResponseDto>>> getWorkersPage(@PathVariable int page) {
        return createGoodResponse(userService.getPage(page));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/can-write/{userId}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<AppUserResponseDto>>> getUsersICanWrite(@PathVariable Long userId) {
        return createGoodResponse(userService.getCanWrite(userId));
    }
}
