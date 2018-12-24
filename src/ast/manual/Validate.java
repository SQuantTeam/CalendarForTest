package ast.manual;

import ast.mock.JudgementMock;
import ast.util.Const;

public class Validate {

	public int setMaxDay(int year, int month) {
		int maxDay = 0;

		if (month < 1 || month > 12) {
			return 0;
		}
		JudgementMock judgement = new JudgementMock();
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

	/**
	 * setMaxDay mute ast.pit.test 1
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public int setMaxDay1(int year, int month) {
		int maxDay = 0;
		/* FAULT## FAILURE INDUCING CODE */
//		change || to &&
		if (month < 1 && month > 12) {
			return 0;
		}
		JudgementMock judgement = new JudgementMock();
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
		/* FAULT## FAILURE INDUCING CODE */
//		change maxDay to maxDay+1
		return maxDay + 1;
	}

	/**
	 * setMaxDay mute ast.pit.test 2
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public int setMaxDay2(int year, int month) {
		int maxDay = 0;
		if (month < 1 || month > 12) {
			/* FAULT## FAILURE INDUCING CODE */
//		change 0 to 1 
			return 1;
		}
		JudgementMock judgement = new JudgementMock();
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
		/* FAULT## FAILURE INDUCING CODE */
//		change maxDay to 0
		return 0;
	}

	/**
	 * setMaxDay mute ast.pit.test 3
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public int setMaxDay3(int year, int month) {
		int maxDay = 0;
		/* FAULT## FAILURE INDUCING CODE */
//		add !(  )
		if (!(month < 1 || month > 12)) {
			return 0;
		}
		JudgementMock judgement = new JudgementMock();
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

	/**
	 * setMaxDay mute ast.pit.test 4
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public int setMaxDay4(int year, int month) {
		int maxDay = 0;
		/* FAULT## FAILURE INDUCING CODE */
//		add (  )==false
		if ((month < 1 || month > 12) == false) {
			return 0;
		}
		JudgementMock judgement = new JudgementMock();
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

	/**
	 * setMaxDay mute ast.pit.test 5
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public int setMaxDay5(int year, int month) {
		int maxDay = 0;
		/* FAULT## FAILURE INDUCING CODE */
//		add (  )!=true
		if ((month < 1 || month > 12) != true) {
			return 0;
		}
		JudgementMock judgement = new JudgementMock();
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

//		 Const.maxDay = setMaxDay(year, month);
		if (Const.maxDay == 0) {
			return false;
		}

		if (year != 0 && month >= 1 && month <= Const.maxMonth && day >= 1 && day <= Const.maxDay) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * isValidDate mute ast.pit.test 1
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public boolean isValidDate1(int year, int month, int day) {
		Const.maxDay = setMaxDay(year, month);
		if (Const.maxDay == 0) {
			/* FAULT## FAILURE INDUCING CODE */
//			change false to true
			return true;
		}
		if (year != 0 && month >= 1 && month <= Const.maxMonth && day >= 1 && day <= Const.maxDay) {
			/* FAULT## FAILURE INDUCING CODE */
//		change true to false
			return false;
		} else {
			/* FAULT## FAILURE INDUCING CODE */
//			change false to true
			return true;
		}

	}

	/**
	 * isValidDate mute ast.pit.test 2
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public boolean isValidDate2(int year, int month, int day) {
		Const.maxDay = setMaxDay(year, month);
		/* FAULT## FAILURE INDUCING CODE */
//		change 0 to -1
		if (Const.maxDay == -1) {
			return false;
		}
		/* FAULT## FAILURE INDUCING CODE */
//		add !( )
		if (!(year != 0 && month >= 1 && month <= Const.maxMonth && day >= 1 && day <= Const.maxDay)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * isValidDate mute ast.pit.test 3
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public boolean isValidDate3(int year, int month, int day) {
		Const.maxDay = setMaxDay(year, month);
		/* FAULT## FAILURE INDUCING CODE */
//		change == to <
		if (Const.maxDay < 0) {
			return false;
		}
		/* FAULT## FAILURE INDUCING CODE */
//		add ( )==false
		if ((year != 0 && month >= 1 && month <= Const.maxMonth && day >= 1 && day <= Const.maxDay) == false) {
			return true;
		} else {
			return false;
		}

	}
	/**
	 * isValidDate mute ast.pit.test 4
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public boolean isValidDate4(int year, int month, int day) {
		/*FAULT## FAILURE INDUCING CODE */
//		change setMaxDay(year,month) to -setMaxDay(year,month)
		Const.maxDay = -setMaxDay(year, month);
		/*FAULT## FAILURE INDUCING CODE */
//		change ==0 to <-1
		if (Const.maxDay < -1) {
			return false;
		}
		/*FAULT## FAILURE INDUCING CODE */
//		add ( )!=true
		if ((year != 0 && month >= 1 && month <= Const.maxMonth && day >= 1 && day <= Const.maxDay)!=true) {
			return true;
		} else {
			return false;
		}

	}
	/**
	 * isValidDate mute ast.pit.test 5
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public boolean isValidDate5(int year, int month, int day) {
		Const.maxDay = setMaxDay(year, month);
		/*FAULT## FAILURE INDUCING CODE */
//		change 0 to -1
		if (Const.maxDay == -1) {
			return false;
		}
		/*FAULT## FAILURE INDUCING CODE */
//		add !( )
		if (!(year != 0 && month >= 1 && month <= Const.maxMonth && day >= 1 && day <= Const.maxDay)) {
			return true;
		} else {
			return false;
		}

	}

}