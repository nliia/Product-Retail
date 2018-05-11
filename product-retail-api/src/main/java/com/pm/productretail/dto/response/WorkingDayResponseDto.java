package com.pm.productretail.dto.response;

import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Shift;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author lnurullina
 */
public class WorkingDayResponseDto {

    String date;
    List<AppUser> workers;

    public WorkingDayResponseDto(Shift shift) {
        this.date = shift.getShiftDate().toString().substring(0, 10);
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
