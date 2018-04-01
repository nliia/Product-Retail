package com.pm.productretail.dto;

import com.pm.productretail.util.TaskStatus;

/**
 * @author lnurullina
 */
public class TaskDto {
    private Long taskCreatorId;
    private Long taskMakerId;
    private String description;
    private TaskStatus taskStatus;

    public Long getTaskCreatorId() {
        return taskCreatorId;
    }

    public void setTaskCreatorId(Long taskCreatorId) {
        this.taskCreatorId = taskCreatorId;
    }

    public Long getTaskMakerId() {
        return taskMakerId;
    }

    public void setTaskMakerId(Long taskMakerId) {
        this.taskMakerId = taskMakerId;
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
