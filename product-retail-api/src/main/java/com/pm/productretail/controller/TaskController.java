package com.pm.productretail.controller;

import com.pm.productretail.dto.TaskDto;
import com.pm.productretail.dto.response.TaskResponseDto;
import com.pm.productretail.service.TaskService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lnurullina
 */
@RestController

public class TaskController extends ResponseCreator {
    @Autowired
    TaskService taskService;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> createTask(@RequestBody TaskDto taskDto) {
        taskService.createNewTask(taskDto);
        return createGoodResponse();
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/tasks{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<TaskResponseDto>>> getWorkerTasks(@PathVariable Long id) {
        return createGoodResponse(taskService.findAllByTaskMaker(id));
    }
}
