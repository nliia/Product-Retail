package com.pm.productretail.service;

import com.pm.productretail.dto.TaskDto;
import com.pm.productretail.dto.response.TaskResponseDto;

import java.util.List;

/**
 * @author lnurullina
 */
public interface TaskService {
    void createNewTask(TaskDto taskDto);

    List<TaskResponseDto> findAllByTaskMaker(Long taskMakerId);

    List<TaskResponseDto> findAllByDepartment(Long departmentId);
}
