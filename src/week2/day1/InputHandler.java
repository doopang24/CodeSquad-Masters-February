package week2.day1;

import java.util.Scanner;

public class InputHandler {

    public int[] startGame() {
        System.out.println("시도할 행, 렬, 숫자를 쉼표로 구분해서 입력하세요.");
        String input = getInput();
        int[] attempt = parseInput(input);
        return attempt;
    }

    private int[] parseInput(String input) {
        int[] attempt = new int[3];
        String[] numbers = input.split(",");
        for (int i = 0; i < numbers.length; i++) {
            attempt[i] = Integer.parseInt(numbers[i].trim());
        }
        return attempt;
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
