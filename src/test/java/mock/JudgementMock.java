package mock;

import org.easymock.EasyMock;

import daterelated.Judgement;




public class JudgementMock extends Judgement{
	public JudgementMock() {
		Judgement judgementMock = EasyMock.createMock(Judgement.class);
		EasyMock.expect(judgementMock.isLunarMonth(4)).andReturn(true);
		EasyMock.expect(judgementMock.isLunarMonth(6)).andReturn(true);
		EasyMock.expect(judgementMock.isLunarMonth(9)).andReturn(true);
		EasyMock.expect(judgementMock.isLunarMonth(11)).andReturn(true);
		EasyMock.expect(judgementMock.isLunarMonth(1)).andReturn(false);
		EasyMock.expect(judgementMock.isLunarMonth(2)).andReturn(false);
		EasyMock.expect(judgementMock.isLunarMonth(3)).andReturn(false);
		EasyMock.expect(judgementMock.isLunarMonth(5)).andReturn(false);
		EasyMock.expect(judgementMock.isLunarMonth(7)).andReturn(false);
		EasyMock.expect(judgementMock.isLunarMonth(8)).andReturn(false);
		EasyMock.expect(judgementMock.isLunarMonth(10)).andReturn(false);
		EasyMock.expect(judgementMock.isLunarMonth(12)).andReturn(false);
		EasyMock.expect(judgementMock.isLeapYear(2004)).andReturn(true);
		EasyMock.expect(judgementMock.isLeapYear(2005)).andReturn(false);
		EasyMock.replay(judgementMock);
	}

	public boolean isLunarMonth(int month) {
		if (month == 4 | month == 6 | month == 9 | month == 11) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
