package DateRelated;

public class Judgement {

	public boolean isLunarMonth(int month) {
    	if (month==4 | month==6 | month==9 | month==11) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
