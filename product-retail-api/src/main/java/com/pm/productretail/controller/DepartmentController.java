package com.pm.productretail.controller;

import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.DepartmentItemDto;
import com.pm.productretail.dto.response.AppUserResponseDto;
import com.pm.productretail.dto.response.ItemResponseDto;
import com.pm.productretail.dto.response.TaskResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.service.DepartmentService;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.service.TaskService;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    TaskService taskService;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<DepartmentDto>>> getUserDepartments() {
        AppUser currentUser = securityService.getCurrentUser();
        return createGoodResponse(userService.findUserDepartments(currentUser));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/department/{id}/tasks", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<TaskResponseDto>>> getDepartmentTasks(@PathVariable Long id) {
        return createGoodResponse(taskService.findAllByDepartment(id));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/department/{id}/workers", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<AppUserResponseDto>>> getDepartmentWorkers(@PathVariable Long id) {
        return createGoodResponse(userService.findAllByDepartment(id));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/department/{id}/items", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<ItemResponseDto>>> getItemsByDepartment(@PathVariable Long id) {
        return createGoodResponse(departmentService.getItemsByDepartment((id)));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/department/{depId}/item/{itemId}", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> addItemToDepartment(@RequestBody DepartmentItemDto departmentItem) {
        departmentService.addItemToDepartment(departmentItem);
        return createGoodResponse();
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/department/all", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<DepartmentDto>>> showAllDeps() {
        return createGoodResponse(departmentService.findAllDepartments());
    }
}
