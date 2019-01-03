package com.sjtu.daterelated;

public class Validate {

	public int setMaxDay(int year, int month) {
		int maxDay = 0;
		if (month < 1 || month > 12) {
			return 0;
		}
		Judgement judgement = new Judgement();
		if (judgement.isLunarMonth(month)) {
			maxDay = 30;
		} else if (month == 2) {
			if (judgement.isLeapYear(year)) {
				maxDay = 29;
			} else {
				maxDay = 28;
			}
		} else {
			maxDay = 31;
		}

		return maxDay;
	}

	public boolean isValidDate(int year, int month, int day) {
		Const.maxDay = setMaxDay(year, month);
		if (Const.maxDay == 0) {
			return false;
		}
		if (year != 0 && month >= 1 && month <= Const.maxMonth && day >= 1 && day <= Const.maxDay) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isValidDuration(int start_year, int start_month, int start_day, int end_year, int end_month,
			int end_day) {
		if (start_year < end_year) {
			return true;
		} else if (start_year > end_year) {
			return false;
		} else if (start_month < end_month) {
			return true;
		} else if (start_month > end_month) {
			return false;
		} else if (start_day <= end_day) {
			return true;
		}
		return false;
	}
}