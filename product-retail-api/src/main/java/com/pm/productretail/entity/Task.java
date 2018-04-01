package com.pm.productretail.entity;


import com.pm.productretail.util.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private AppUser taskCreator;
    @ManyToOne
    @JoinColumn
    private AppUser taskMaker;
    private String description;
    private TaskStatus status;

    public AppUser getTaskCreator() {
        return taskCreator;
    }

    public void setTaskCreator(AppUser taskCreator) {
        this.taskCreator = taskCreator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public AppUser getTaskMaker() {
        return taskMaker;
    }

    public void setTaskMaker(AppUser taskMaker) {
        this.taskMaker = taskMaker;
    }
}
