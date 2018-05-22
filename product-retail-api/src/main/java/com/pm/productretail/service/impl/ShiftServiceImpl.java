package com.pm.productretail.service.impl;

import com.pm.productretail.dto.response.WorkingDayResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Shift;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.repository.ShiftRepository;
import com.pm.productretail.service.ShiftService;
import com.pm.productretail.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lnurullina
 */
@Service
public class ShiftServiceImpl implements ShiftService {
    private static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    ShiftRepository shiftRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Transactional
    @Override
    public List<WorkingDayResponseDto> getMonthSchedule() throws ParseException {
        Date today = new Date();

        List<Shift> monthSchedule = shiftRepository.findAllByShiftDateGreaterThanEqual(today);
        int daysCount = monthSchedule.size();

        List<AppUser> warehouseWorkers = appUserRepository.findAllByRole(Role.WAREHOUSE_WORKER);
        List<AppUser> sellers = appUserRepository.findAllByRole(Role.SELLER);

        if (daysCount < 30) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);
            cal.add(Calendar.DATE, daysCount - 1);
            for (int i = daysCount; i <= 30; i = i + 4) {
                //day1
                cal.add(Calendar.DATE, 1);
                List<AppUser> workers = new ArrayList<>();
                workers.add(warehouseWorkers.get(0));
                workers.add(warehouseWorkers.get(1));
                workers.add(sellers.get(0));
                Date currentDay = cal.getTime();
                shiftRepository.save(new Shift(formatter.parse(formatter.format(currentDay)), workers));
                //day2
                cal.add(Calendar.DATE, 1);
                currentDay = cal.getTime();
                shiftRepository.save(new Shift(formatter.parse(formatter.format(currentDay)), workers));
                //day3
                workers = new ArrayList<>();
                workers.add(warehouseWorkers.get(2));
                workers.add(sellers.get(1));
                workers.add(sellers.get(2));
                cal.add(Calendar.DATE, 1);
                currentDay = cal.getTime();
                shiftRepository.save(new Shift(formatter.parse(formatter.format(currentDay)), workers));
                //day4
                cal.add(Calendar.DATE, 1);
                currentDay = cal.getTime();
                shiftRepository.save(new Shift(formatter.parse(formatter.format(currentDay)), workers));
            }
            monthSchedule = shiftRepository.findAllByShiftDateGreaterThanEqual(today);
        }
        return monthSchedule.stream().map(WorkingDayResponseDto::new).collect(Collectors.toList());

    }
}
