package com.pm.productretail.controller;

import com.pm.productretail.dto.response.WorkingDayResponseDto;
import com.pm.productretail.service.ShiftService;
import com.pm.productretail.util.ApiResponse;
import com.pm.productretail.util.ResponseCreator;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.List;

/**
 * @author lnurullina
 */
@Controller
public class ScheduleController extends ResponseCreator {

    @Autowired
    ShiftService shiftService;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<WorkingDayResponseDto>>> getSchedule() throws ParseException {
        return createGoodResponse(shiftService.getMonthSchedule());
    }
}
