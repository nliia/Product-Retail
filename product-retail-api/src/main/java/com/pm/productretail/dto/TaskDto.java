package com.pm.productretail.dto;

import com.pm.productretail.util.TaskStatus;

/**
 * @author lnurullina
 */
public class TaskDto {
    private Long task_creator_id;
    private Long task_maker_id;
    private String description;
    private TaskStatus taskStatus;

    public Long getTaskCreatorId() {
        return task_creator_id;
    }

    public void setTaskCreatorId(Long taskCreatorId) {
        this.task_creator_id = taskCreatorId;
    }

    public Long getTaskMakerId() {
        return task_maker_id;
    }

    public void setTaskMakerId(Long taskMakerId) {
        this.task_maker_id = taskMakerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
