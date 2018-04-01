package com.pm.productretail.service.impl;

import com.pm.productretail.dto.TaskDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Task;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.repository.TaskRepository;
import com.pm.productretail.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lnurullina
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public void createNewTask(TaskDto taskDto) {
        AppUser creator = appUserRepository.findOneById(taskDto.getTaskCreatorId());
        AppUser maker = appUserRepository.findOneById(taskDto.getTaskMakerId());
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setTaskCreator(creator);
        task.setTaskMaker(maker);
        task.setStatus(taskDto.getTaskStatus());
        taskRepository.save(task);
    }
}
