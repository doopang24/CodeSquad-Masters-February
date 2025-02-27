package week4.day4;

public class MartianCalendar {

    // 연, 월을 주면 full 달력인지 아닌지 판단할 수 있게 만들기
    public void fullCalendar(int year, int month) {
        int lastDay = 28;
        printCalendar(lastDay, year, month);
    }

    public void sixfoldCalendar(int year, int month) {
        int lastDay = 27;
        printCalendar(lastDay, year, month);
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
        System.out.println("     " + year + "년 " + month + "월" + "     ");
        System.out.println(" Su Lu Ma Me Jo Ve Sa");
        System.out.println(builder.toString());
    }
}
