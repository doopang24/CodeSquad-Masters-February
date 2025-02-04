package week1.day2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Darts darts = new Darts();

        String input = main.getInput();
        int[] scoreLine = main.StringToIntArray(input);

        System.out.println(darts.solution(scoreLine));
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("점수를 쉼표와 띄어쓰기로 구분해서 입력하세요.");
        return scanner.nextLine();
    }

    private int[] StringToIntArray(String input) {
        String[] inputSplit = input.split(", ");
        int[] answer = new int[inputSplit.length];
        for (int i = 0; i < inputSplit.length; i++) {
            answer[i] = Integer.parseInt(inputSplit[i]);
        }
        return answer;
    }
}

