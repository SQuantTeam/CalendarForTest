package ast.manual;

import ast.util.Const;

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

	/**
	 * mutant ast.pit.test 1
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */

	public int getDateOfNextDay1(int year, int month, int day) {
		/* FAULT## FAILURE INDUCING CODE */
//		! missing
		if (val.isValidDate(year, month, day)) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextDay = day + 1;
		nextDay = (nextDay - 1) % Const.maxDay + 1;
		return nextDay;
	}

	/**
	 * mutant ast.pit.test 2
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getDateOfNextDay2(int year, int month, int day) {
		/* FAULT## FAILURE INDUCING CODE */
//		two ! operator
		if (!!val.isValidDate(year, month, day)) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextDay = day + 1;
		nextDay = (nextDay - 1) % Const.maxDay + 1;
		return nextDay;
	}

	/**
	 * mutant ast.pit.test 3
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getDateOfNextDay3(int year, int month, int day) {

		/* FAULT## FAILURE INDUCING CODE */
//		add "==false"
		if (!val.isValidDate(year, month, day) == false) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextDay = day + 1;
		nextDay = (nextDay - 1) % Const.maxDay + 1;
		return nextDay;
	}

	/**
	 * mutant ast.pit.test 4
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */

	public int getDateOfNextDay4(int year, int month, int day) {
		/* FAULT## FAILURE INDUCING CODE */
//		add "!=true"
		if (!val.isValidDate(year, month, day) != true) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextDay = day + 1;
		nextDay = (nextDay - 1) % Const.maxDay + 1;
		return nextDay;
	}
	/**
	 * mutant ast.pit.test 5
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	
	public int getDateOfNextDay5(int year, int month, int day) {
		/*FAULT## FAILURE INDUCING CODE */
//		add (  ==false)
		if (!(val.isValidDate(year, month, day)==false)) {
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
	
	/**
	 * getYearOfNextDay mute ast.pit.test 1
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getYearOfNextDay1(int year, int month, int day) {
		/*FAULT## FAILURE INDUCING CODE */
//		add one ! operator
		if (!!val.isValidDate(year, month, day)) {
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
		/*FAULT## FAILURE INDUCING CODE */
//		nextYear change to nextYear+1
		return nextYear+1;
	}
	
	/**
	 * getYearOfNextDay mute ast.pit.test 2
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getYearOfNextDay2(int year, int month, int day) {
		if (!val.isValidDate(year, month, day)) {
			/*FAULT## FAILURE INDUCING CODE */
//		change 0 to 1
			return 1;
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
		/*FAULT## FAILURE INDUCING CODE */
//		nextYear change to nextYear+1
		return nextYear+1;
	}
	/**
	 * getYearOfNextDay mute ast.pit.test 3
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getYearOfNextDay3(int year, int month, int day) {
		/*FAULT## FAILURE INDUCING CODE */
//		missing ! operator
		if (val.isValidDate(year, month, day)) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextMonth = month;

		if (Const.maxDay == day) {
			nextMonth = month % Const.maxMonth + 1;
		}

		/*FAULT## FAILURE INDUCING CODE */
//		year change to year+1
		int nextYear = year+1;

		if (month != nextMonth && nextMonth == 1) {
			nextYear++;
		}
		return nextYear;
	}
	
	/**
	 * getYearOfNextDay mute ast.pit.test 4
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getYearOfNextDay4(int year, int month, int day) {
		/*FAULT## FAILURE INDUCING CODE */
//		add ==false
		if (!val.isValidDate(year, month, day)==false) {
			return 0;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextMonth = month;

		if (Const.maxDay == day) {
			nextMonth = month % Const.maxMonth + 1;
		}

		/*FAULT## FAILURE INDUCING CODE */
//		change year to year+2
		int nextYear =year+2;

		if (month != nextMonth && nextMonth == 1) {
			nextYear++;
		}
		return nextYear;
	}
	/**
	 * getYearOfNextDay mute ast.pit.test 5
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getYearOfNextDay5(int year, int month, int day) {
		/*FAULT## FAILURE INDUCING CODE */
//		change 0 to -1
		if (!val.isValidDate(year, month, day)) {
			return -1;
		}

		Const.maxDay = val.setMaxDay(year, month);
		int nextMonth = month;

		if (Const.maxDay == day) {
			nextMonth = month % Const.maxMonth + 1;
		}

		int nextYear =year;

		if (month != nextMonth && nextMonth == 1) {
			nextYear++;
		}
		/*FAULT## FAILURE INDUCING CODE */
//		change year to nextYear+2
		return nextYear+2;
	}
	
	
}
