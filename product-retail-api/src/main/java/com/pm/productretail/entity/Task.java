package com.pm.productretail.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private AppUser taskCreator;
    private String description;

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
}
