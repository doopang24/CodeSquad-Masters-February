package week4.day4;

import java.util.Scanner;

public class DateReceiver {

    Scanner scanner = new Scanner(System.in);

    public int[] getInput() {
        int[] answer = new int[3];
        System.out.print("> 지구날짜는? ");
        String inputDate = scanner.nextLine();
        String[] dividedDate = inputDate.split("-");
        for (int i = 0; i < dividedDate.length; i++) {
            answer[i] = Integer.parseInt(dividedDate[i].trim());
        }
        if (!(isValidYear(answer[0]) && isValidMonth(answer[1]) && isValidDay(answer[0], answer[1], answer[2]))) {
            throw new IllegalArgumentException("올바른 날짜 입력이 아닙니다.");
        }
        return answer;
    }

    private boolean isValidYear(int inputYear) {
        return inputYear >= 1;
    }

    private boolean isValidMonth(int inputMonth) {
        return inputMonth >= 1 && inputMonth <= 12;
    }

    private boolean isValidDay(int inputYear, int inputMonth, int inputDay) {
        if (inputMonth == 1 || inputMonth == 3 || inputMonth == 5 || inputMonth == 7 || inputMonth == 8 || inputMonth == 10 || inputMonth == 12) {
            if (inputDay >= 1 && inputDay <= 31) return true;
        } else if (inputMonth == 4 || inputMonth == 6 || inputMonth == 9 || inputMonth == 11) {
            if (inputDay >= 1 && inputDay <= 30) return true;
        } else {    // 2월
            if (inputYear % 4 == 0) {
                if (inputDay >= 1 && inputDay <= 29) return true;
            } else {
                if (inputDay >= 1 && inputDay <= 28) return true;
            }
        }
        return false;
    }
}
