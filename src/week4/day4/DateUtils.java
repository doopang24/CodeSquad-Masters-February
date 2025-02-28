package week4.day4;

public class DateUtils {

    private final int EARTH_NORMAL_YEAR_DAYS = 365;
    private final int EARTH_LEAP_YEAR_DAYS = 366;
    private final int MARS_NORMAL_YEAR_DAYS = 668;
    private final int MARS_LEAP_YEAR_DAYS = 669;
    private final int[] EARTH_DAY_OF_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int MARS_DAYS_OF_MONTH = 28;

    public long countDays(int[] inputDate) {
        long days = 0;
        int year = inputDate[0], month = inputDate[1], day = inputDate[2];
        for (int i = 1; i < year; i++) {
            days += isLeapYear(i) ? EARTH_LEAP_YEAR_DAYS : EARTH_NORMAL_YEAR_DAYS;
        }
        for (int i = 0; i < month - 1; i++) {
            days += EARTH_DAY_OF_MONTHS[i];
        }
        if (month > 2 && isLeapYear(year)) {
            days++;
        }
        days += day;
        return days;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0);
//        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public int[] convertMartian(long earthDays) {
        int year = 1;   // 화성년 1년부터 시작

        while (earthDays > 0) {
            if (year % 2 == 0) { // 화성 윤년
                if (earthDays > MARS_LEAP_YEAR_DAYS) {
                    earthDays -= MARS_LEAP_YEAR_DAYS;
                    year++;
                } else {
                    break;
                }
            } else {
                if (earthDays > MARS_NORMAL_YEAR_DAYS) {
                    earthDays -= MARS_NORMAL_YEAR_DAYS;
                    year++;
                } else {
                    break;
                }
            }
        }
        int month = 1;
        while (earthDays > 28) {
            month++;
            earthDays -= MARS_DAYS_OF_MONTH;
            if (month % 6 == 0) {
                if (year % 2 == 0 && month % 24 == 0) { // 윤년
                    continue;
                } else {
                    earthDays++;
                }
            }
        }
        int day = (int) earthDays;
        return new int[]{year, month, day};
    }
}
