package com.sjtu.entry;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjtu.daterelated.ComputeDate;
import com.sjtu.daterelated.Validate;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    private ComputeDate computeDate;
    private Validate validate;

    public CalendarController() {
        this.computeDate = new ComputeDate(new Validate());
        this.validate = new Validate();
    }

    @ApiOperation(value = "获取月份最大值，并设置")
    @GetMapping("/getMaxDay")
    public int setMaxDay(@ApiParam("年份")
                         @RequestParam("year") int year,
                         @ApiParam("月份")
                         @RequestParam("month") int month) {
        return validate.setMaxDay(year, month);
    }


    @ApiOperation(value = "判断日期是否有效")
    @GetMapping("/validDate")
    public boolean isValidDate(@ApiParam("年份")
                               @RequestParam("year") int year,
                               @ApiParam("月份")
                               @RequestParam("month") int month,
                               @ApiParam("天")
                               @RequestParam("day") int day) {
        return validate.isValidDate(year, month, day);
    }

    @ApiOperation(value = "获取第二天日期(天）")
    @GetMapping("/dateOfNextDay")
    public int getDateOfNextDay(@ApiParam("年份")
                                @RequestParam("year") int year,
                                @ApiParam("月份")
                                @RequestParam("month") int month,
                                @ApiParam("天")
                                @RequestParam("day") int day) {
        return computeDate.getDateOfNextDay(year, month, day);
    }
    
    @ApiOperation(value = "获取第二天日期(月）")
    @GetMapping("/monthOfNextDay")
    public int getMonthOfNextDay(@ApiParam("年份")
                                @RequestParam("year") int year,
                                @ApiParam("月份")
                                @RequestParam("month") int month,
                                @ApiParam("天")
                                @RequestParam("day") int day) {
        return computeDate.getMonthOfNextDay(year, month, day);
    }


    @ApiOperation(value = "获取第二天日期(年）")
    @GetMapping("/yearOfNextDay")
    public int getYearOfNextDay(@ApiParam("年份")
                                @RequestParam("year") int year,
                                @ApiParam("月份")
                                @RequestParam("month") int month,
                                @ApiParam("天")
                                @RequestParam("day") int day) {
        return computeDate.getYearOfNextDay(year, month, day);
    }
    
    @ApiOperation(value = "获取两日期相差的天数")
    @GetMapping("/numOfDaysBetweenTwoDates")
    public int getYeaOfNextDay(@ApiParam("起始天")
                                @RequestParam("start_year") int start_year,
                                @ApiParam("起始天")
                                @RequestParam("start_month") int start_month,
                                @ApiParam("起始天")
                                @RequestParam("start_day") int start_day,
                                @ApiParam("起始天")
                                @RequestParam("end_year") int end_year,
                                @ApiParam("起始天")
                                @RequestParam("end_month") int end_month,
                                @ApiParam("结束天")
                                @RequestParam("end_day") int end_day) {
        return computeDate.getNumOfDaysBetweenTwoDates(start_year, start_month, start_day, end_year, end_month, end_day);
    }

    @ApiOperation(value = "推算几天后的日期")
    @GetMapping("/dateAfterAFewDays")
    public String getTheDateAfterAFewDays(@ApiParam("年份")
    							@RequestParam("year") int year,
    							@ApiParam("月份")
    							@RequestParam("month") int month,
    							@ApiParam("天")
    							@RequestParam("day") int day,
    							@ApiParam("天数")
								@RequestParam("num") int num) {
        return computeDate.getTheDateAfterAFewDays(year, month, day, num);
    }
    
//    @ApiOperation(value = "获取日期在当年的第几周")
//    @GetMapping("/weekNum")
//    public int getWeekNum(@ApiParam("年份")
//                          @RequestParam("year") int year,
//                          @ApiParam("月份")
//                          @RequestParam("month") int month,
//                          @ApiParam("天")
//                          @RequestParam("day") int day) {
//        return -1;
//    }
}