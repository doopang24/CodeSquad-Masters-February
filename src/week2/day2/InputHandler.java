package week2.day2;

import java.util.Scanner;

public class InputHandler {

    public String[] getCommands() {
        System.out.println("명령을 입력하세요.");
        String input = getInput();
        return parseInput(input);
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String[] parseInput(String input) {
        String[] dividedInput = input.replaceAll("\"", "").split(", ");     // (", ") , ("), (,)
        // (실패) String[] dividedInput = input.split("\", \" | \" | ,");
        for (int i = 0; i < dividedInput.length; i++) dividedInput[i] = dividedInput[i].trim();     // 공백 제거
        return dividedInput;
    }
}
