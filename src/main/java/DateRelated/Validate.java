package DateRelated;


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
}