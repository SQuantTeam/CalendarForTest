package mock;
import org.easymock.EasyMock;

import util.Const;
import util.Judgement;

/**
 * Created by Angel on 16/3/18.
 */
public class ValidateMock {
	
	//public Judgement judgement = new Judgement();
    
    public int setMaxDay(int year, int month){
    	
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
    	
    	int maxDay = 0;
    	
    	if(month < 1 || month > 12) {
    		return 0;
    	}
    	
        if(judgementMock.isLunarMonth(month)){
            maxDay=30;
        }
        else if(month==2){
            if(judgementMock.isLeapYear(year)){
                maxDay=29;
            }
            else{
                maxDay=28;
            }
        }else{
            maxDay=31;
        }
        
        return maxDay; 
    }

    public boolean isValidDate(int year, int month, int day) {
    	
    	
    	ValidateMock valMock = EasyMock.createMock(ValidateMock.class);
    	
    	EasyMock.expect(valMock.setMaxDay(2004, 4)).andReturn(30);
		EasyMock.expect(valMock.setMaxDay(2004, 1)).andReturn(31);
		EasyMock.expect(valMock.setMaxDay(2004, 2)).andReturn(29);
		EasyMock.expect(valMock.setMaxDay(2004, 0)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(2004, 13)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(2005, 4)).andReturn(30);
		EasyMock.expect(valMock.setMaxDay(2005, 1)).andReturn(31);
		EasyMock.expect(valMock.setMaxDay(2005, 2)).andReturn(28);
		EasyMock.expect(valMock.setMaxDay(2005, 0)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(2005, 13)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 4)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 1)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 2)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 0)).andReturn(0);
		EasyMock.expect(valMock.setMaxDay(0, 13)).andReturn(0);
		EasyMock.replay(valMock);
    	
    	Const.maxDay = valMock.setMaxDay(year, month);
    	
    	//Const.maxDay = setMaxDay(year, month);
    	if(Const.maxDay == 0) {
    		return false;
    	}
    	
    	if(year != 0 &&
    	   month >= 1 && month <= Const.maxMonth && 
    	   day >= 1 && day <= Const.maxDay){
            return true;
        }
        else{
            return false;
        }
    	
    }

}
