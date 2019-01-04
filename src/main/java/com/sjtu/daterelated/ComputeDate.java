package com.sjtu.daterelated;

import org.apache.commons.lang3.StringUtils;
import org.easymock.EasyMock;

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

		ComputeDate computeDateMock = EasyMock.createMock(ComputeDate.class);

		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,15)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,16)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,17)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,18)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,19)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,20)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,21)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,22)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,23)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,24)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,25)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,26)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,27)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,28)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,29)).andReturn(2004);

		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 15)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 16)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 17)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 18)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 19)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 20)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 21)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 22)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 23)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 24)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 25)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 26)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 27)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 28)).andReturn(2005);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2005, 1, 29)).andReturn(2005);


		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,1,31)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 1)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 2)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 3)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 4)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 5)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 6)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 7)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 8)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 9)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 10)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 11)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 12)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 13)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 14)).andReturn(2004);


		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,4,30)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 1)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 2)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 3)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 4)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 5)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 6)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 7)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 8)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 9)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 10)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 11)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 12)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 13)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 5, 14)).andReturn(2004);


		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,1,29)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,1,30)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004,1,31)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 1)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 2)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 3)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 4)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 5)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 6)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 7)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 8)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 9)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 10)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 11)).andReturn(2004);
		EasyMock.expect(computeDateMock.getYearOfNextDay(2004, 2, 12)).andReturn(2004);


		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004,4,15)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 16)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 17)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 18)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 19)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 20)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 21)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 22)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 23)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 24)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 25)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 26)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 27)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 28)).andReturn(4);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 4, 29)).andReturn(4);


		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005,1,15)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 16)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 17)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 18)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 19)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 20)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 21)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 22)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 23)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 24)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 25)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 26)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 27)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 28)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2005, 1, 29)).andReturn(1);

		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004,1,31)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 1)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 2)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 3)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 4)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 5)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 6)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 7)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 8)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 9)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 10)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 11)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 12)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 13)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 14)).andReturn(2);

		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004,4,30)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 1)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 2)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 3)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 4)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 5)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 6)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 7)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 8)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 9)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 10)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 11)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 12)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 13)).andReturn(5);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 5, 14)).andReturn(5);

		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004,1,29)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004,1,30)).andReturn(1);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004,1,31)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 1)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 2)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 3)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 4)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 5)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 6)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 7)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 8)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 9)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 10)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 11)).andReturn(2);
		EasyMock.expect(computeDateMock.getMonthOfNextDay(2004, 2, 12)).andReturn(2);

		EasyMock.expect(computeDateMock.getDateOfNextDay(2004,4,15)).andReturn(16);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 16)).andReturn(17);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 17)).andReturn(18);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 18)).andReturn(19);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 19)).andReturn(20);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 20)).andReturn(21);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 21)).andReturn(22);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 22)).andReturn(23);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 23)).andReturn(24);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 24)).andReturn(25);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 25)).andReturn(26);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 26)).andReturn(27);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 27)).andReturn(28);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 28)).andReturn(29);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 4, 29)).andReturn(30);

		EasyMock.expect(computeDateMock.getDateOfNextDay(2005,1,15)).andReturn(16);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 16)).andReturn(17);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 17)).andReturn(18);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 18)).andReturn(19);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 19)).andReturn(20);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 20)).andReturn(21);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 21)).andReturn(22);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 22)).andReturn(23);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 23)).andReturn(24);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 24)).andReturn(25);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 25)).andReturn(26);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 26)).andReturn(27);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 27)).andReturn(28);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 28)).andReturn(29);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2005, 1, 29)).andReturn(30);

		EasyMock.expect(computeDateMock.getDateOfNextDay(2004,1,31)).andReturn(1);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 1)).andReturn(2);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 2)).andReturn(3);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 3)).andReturn(4);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 4)).andReturn(5);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 5)).andReturn(6);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 6)).andReturn(7);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 7)).andReturn(8);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 8)).andReturn(9);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 9)).andReturn(10);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 10)).andReturn(11);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 11)).andReturn(12);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 12)).andReturn(13);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 13)).andReturn(14);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 14)).andReturn(15);

		EasyMock.expect(computeDateMock.getDateOfNextDay(2004,4,30)).andReturn(1);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 1)).andReturn(2);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 2)).andReturn(3);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 3)).andReturn(4);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 4)).andReturn(5);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 5)).andReturn(6);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 6)).andReturn(7);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 7)).andReturn(8);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 8)).andReturn(9);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 9)).andReturn(10);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 10)).andReturn(11);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 11)).andReturn(12);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 12)).andReturn(13);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 13)).andReturn(14);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 5, 14)).andReturn(15);

		EasyMock.expect(computeDateMock.getDateOfNextDay(2004,1,29)).andReturn(30);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004,1,30)).andReturn(31);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004,1,31)).andReturn(1);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 1)).andReturn(2);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 2)).andReturn(3);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 3)).andReturn(4);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 4)).andReturn(5);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 5)).andReturn(6);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 6)).andReturn(7);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 7)).andReturn(8);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 8)).andReturn(9);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 9)).andReturn(10);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 10)).andReturn(11);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 11)).andReturn(12);
		EasyMock.expect(computeDateMock.getDateOfNextDay(2004, 2, 12)).andReturn(13);


		EasyMock.replay(computeDateMock);
		
		if (!val.isValidDate(start_year, start_month, start_day)) {
			return "0";
		}
		
		if(num < 0)
			return "0";

		int year;
		int month;
		int day;
		
		while(num > 0) {
			num --;
			year = start_year;
			month = start_month;
			day = start_day;
//			start_year = computeDateMock.getYearOfNextDay(year, month, day);
//			start_month = computeDateMock.getMonthOfNextDay(year, month, day);
//			start_day = computeDateMock.getDateOfNextDay(year, month, day);
			start_year = getYearOfNextDay(year, month, day);
			start_month = getMonthOfNextDay(year, month, day);
			start_day = getDateOfNextDay(year, month, day);
		}
		
		int[] date = {start_year, start_month, start_day};
		String end_date = StringUtils.join(date, '-');

		return end_date;
	}
}
