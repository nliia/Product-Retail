package com.pm.productretail.service.impl;

import com.pm.productretail.dto.TaskDto;
import com.pm.productretail.dto.response.TaskResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Task;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.repository.DepartmentRepository;
import com.pm.productretail.repository.TaskRepository;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.service.TaskService;
import com.pm.productretail.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lnurullina
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    SecurityService securityService;

    @Override
    public void createNewTask(TaskDto taskDto) {
        AppUser creator = appUserRepository.getOne(taskDto.getTaskCreatorId());
        AppUser maker = appUserRepository.getOne(taskDto.getTaskMakerId());
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setTaskCreator(creator);
        task.setTaskMaker(maker);
        task.setStatus(taskDto.getTaskStatus());
        taskRepository.save(task);
    }

    @Override
    public List<TaskResponseDto> findAllByTaskMaker(Long taskMakerId) {
        return taskRepository.findAllByTaskMaker(appUserRepository
                .getOne(taskMakerId))
                .stream()
                .map(TaskResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskResponseDto> findAllByDepartment(Long departmentId) {
        if (securityService.getCurrentUser().getRole().equals(Role.SELLER) || securityService.getCurrentUser().getRole().equals(Role.WAREHOUSE_WORKER)) {
            return taskRepository.findAllByTaskMaker(securityService.getCurrentUser())
                    .stream()
                    .map(TaskResponseDto::new)
                    .collect(Collectors.toList());
        }
        return taskRepository.findAllByDepartment(departmentRepository
                .getOne(departmentId))
                .stream()
                .map(TaskResponseDto::new)
                .collect(Collectors.toList());
    }

}
