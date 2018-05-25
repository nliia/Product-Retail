package com.pm.productretail.entity;


import com.pm.productretail.util.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "taskSeq", sequenceName = "taskSeq", initialValue = 10)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSeq")
    private Long id;
    @ManyToOne
    @JoinColumn
    private AppUser taskCreator;
    @ManyToOne
    @JoinColumn
    private AppUser taskMaker;
    private String description;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
