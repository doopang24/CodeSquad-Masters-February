package week1.day3;

import java.util.Scanner;

public class OXQuiz {

    public int calculator(String testCase) {
        int oxLength = testCase.length();
        int score = 0, count = 0;
        for (int i = 0; i < oxLength; i++) {
            if (testCase.charAt(i) == 'O') {
                count++;
                score += count;
            } else {
                count = 0;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        OXQuiz main = new OXQuiz();
        Scanner scanner = new Scanner(System.in);

        int testCaseSize = Integer.parseInt(scanner.nextLine());
        String[] testCases = new String[testCaseSize];
        for (int i = 0; i < testCaseSize; i++) {
            testCases[i] = scanner.nextLine().trim();
        }
        for (String singleTestCase : testCases) {
            System.out.println(main.calculator(singleTestCase));
        }
    }
}
