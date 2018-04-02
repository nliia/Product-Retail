package com.pm.productretail.dto.response;

import com.pm.productretail.util.TaskStatus;

/**
 * @author lnurullina
 */
public class TaskResponseDto {
    private String creator_name;
    private String creator_surname;
    private String maker_name;
    private String maker_surname;
    private String description;
    private TaskStatus task_status;

    public String getCreatorName() {
        return creator_name;
    }

    public void setCreatorName(String creatorName) {
        this.creator_name = creatorName;
    }

    public String getCreatorSurname() {
        return creator_surname;
    }

    public void setCreatorSurname(String creatorSurname) {
        this.creator_surname = creatorSurname;
    }

    public String getMakerName() {
        return maker_name;
    }

    public void setMakerName(String makerName) {
        this.maker_name = makerName;
    }

    public String getMakerSurname() {
        return maker_surname;
    }

    public void setMakerSurname(String makerSurname) {
        this.maker_surname = makerSurname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return task_status;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.task_status = taskStatus;
    }
}
