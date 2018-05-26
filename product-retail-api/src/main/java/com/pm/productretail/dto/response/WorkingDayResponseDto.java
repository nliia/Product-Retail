package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Shift;

import java.util.List;

/**
 * @author lnurullina
 */
public class WorkingDayResponseDto {

    String date;
    List<AppUser> workers;

    public WorkingDayResponseDto(Shift shift) {
        this.date = String.valueOf(shift.getShiftDate()).substring(8, 10);
        this.workers = shift.getUsers();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<AppUser> getWorkers() {
        return workers;
    }

    public void setWorkers(List<AppUser> workers) {
        this.workers = workers;
    }
}
