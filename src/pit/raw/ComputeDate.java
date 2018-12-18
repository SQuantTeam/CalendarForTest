package pit.raw;

import util.Const;

/**
 * Created by Angel on 16/3/18.
 */
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


	/*
	 * public static int getNextMonth(int currYear, int currMonth, int currDay){
	 * 
	 * if (!Validate.isValidDate(currYear, currMonth, currDay)) { return 0; }
	 * 
	 * Validate.setMaxDay(currYear, currMonth); int nextMonth = currMonth;
	 * 
	 * if(Const.maxDay == currDay){ nextMonth = currMonth%Const.maxMonth + 1; }
	 * return nextMonth; }
	 */
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
	

	
}
