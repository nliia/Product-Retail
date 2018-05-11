package com.pm.productretail.service;

import com.pm.productretail.dto.response.WorkingDayResponseDto;

import java.text.ParseException;
import java.util.List;

/**
 * @author lnurullina
 */
public interface ShiftService {
    List<WorkingDayResponseDto> getMonthSchedule() throws ParseException;
}
