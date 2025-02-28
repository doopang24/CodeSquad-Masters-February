package week4.day4;

import java.text.DecimalFormat;

public class MartianCalendar {

    private final int MARS_NORMAL_MONTH_SIZE = 28;
    private final int MARS_SIXFOLD_MONTH_SIZE = 27;

    public void startConvert(int[] presentDay) {
        DateUtils utils = new DateUtils();

        long totalDays = utils.countDays(presentDay);   // 총 일수
        int[] martianDate = utils.convertMartian(totalDays);    // 화성 날짜
        printConversionResult(totalDays, martianDate);
        decideCalendar(martianDate);
    }

    private void printConversionResult(long totalDays, int[] martianDate) {
        DecimalFormat pattern = new DecimalFormat("#,###");
        String formatedDays = pattern.format(totalDays);
        System.out.println("\n지구날은 " + formatedDays + " => " + martianDate[0] + " 화성년 " + martianDate[1] + "월 " + martianDate[2] + "일");
        System.out.println();
    }

    private void decideCalendar(int[] martianDate) {
        int year = martianDate[0], month = martianDate[1], day = martianDate[2];
        if (month % 6 == 0) {
            if (year % 2 == 0 && month % 24 == 0) {
                printCalendar(MARS_NORMAL_MONTH_SIZE, year, month);
            } else {
                printCalendar(MARS_SIXFOLD_MONTH_SIZE, year, month);
            }
        } else {
            printCalendar(MARS_NORMAL_MONTH_SIZE, year, month);
        }
    }

    private void printCalendar(int lastDay, int year, int month) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= lastDay; i++) {
            if (i < 10) {
                builder.append("  ").append(i);
                if (i % 7 == 0) builder.append("\n");
            } else {
                builder.append(" ").append(i);
                if (i % 7 == 0) builder.append("\n");
            }
        }
        System.out.println("      " + year + "년 " + month + "월" + "     ");
        System.out.println(" Su Lu Ma Me Jo Ve Sa");
        System.out.println(builder.toString());
    }
}
