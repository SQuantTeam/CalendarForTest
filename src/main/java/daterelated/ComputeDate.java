package daterelated;

import org.apache.commons.lang3.StringUtils;

public class ComputeDate {

	private Validate val;

	public ComputeDate(Validate val) {
		setVal(val);
	}

	public void setVal(Validate val) {
		this.val = val;
	}

	public int getDateOfNextDay(int year, int month, int day) {

		if (!val.isValidDate(year, month, day)) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextDay = day + 1;
		nextDay = (nextDay - 1) % Const.maxDay + 1;
		return nextDay;
	}

	public int getMonthOfNextDay(int year, int month, int day) {

		if (!val.isValidDate(year, month, day)) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextMonth = month;

		if (Const.maxDay == day) {
			nextMonth = month % Const.maxMonth + 1;
		}
		return nextMonth;
	}

	public int getYearOfNextDay(int year, int month, int day) {

		if (!val.isValidDate(year, month, day)) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextMonth = month;

		if (Const.maxDay == day) {
			nextMonth = month % Const.maxMonth + 1;
		}

		int nextYear = year;

		if (month != nextMonth && nextMonth == 1) {
			nextYear++;
		}
		return nextYear;
	}
	
	public int getNumOfDaysBetweenTwoDates(int start_year, int start_month, int start_day, int end_year, int end_month, int end_day) {
		
		if (!val.isValidDate(start_year, start_month, start_day)) {
			return -1;
		}
		
		if (!val.isValidDate(end_year, end_month, end_day)) {
			return -1;
		}
		
		if (!val.isValidDuration(start_year, start_month, start_day, end_year, end_month, end_day)) {
			return -1;
		}
		
		int num = 0;
		
		while(!(start_year==end_year && start_month==end_month && start_day==end_day)) {
			int year = start_year;
			int month = start_month;
			int day = start_day;
			start_year = getYearOfNextDay(year, month, day);
			start_month = getMonthOfNextDay(year, month, day);
			start_day = getDateOfNextDay(year, month, day);
			num++;
		}
		return num;
	}

	public String getTheDateAfterAFewDays(int start_year, int start_month, int start_day, int num) {
		
		if (!val.isValidDate(start_year, start_month, start_day)) {
			return "0";
		}
		
		while(num > 0) {
			num --;
			int year = start_year;
			int month = start_month;
			int day = start_day;
			start_year = getYearOfNextDay(year, month, day);
			start_month = getMonthOfNextDay(year, month, day);
			start_day = getDateOfNextDay(year, month, day);
		}
		
		int[] date = {start_year, start_month, start_day};
		String end_date = StringUtils.join(date, '-');

		return end_date;
	}
}
