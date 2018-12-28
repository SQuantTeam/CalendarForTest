package entry;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import daterelated.ComputeDate;
import daterelated.Validate;

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


    @ApiOperation(value = "获取第二天的年份")
    @GetMapping("/yearOfNextDay")
    public int getYearOfNextDay(@ApiParam("年份")
                                @RequestParam("year") int year,
                                @ApiParam("月份")
                                @RequestParam("month") int month,
                                @ApiParam("天")
                                @RequestParam("day") int day) {
        return computeDate.getYearOfNextDay(year, month, day);
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