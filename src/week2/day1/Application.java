package week2.day1;

import java.util.Scanner;

public class Application {

    public int[] parseInput(String input) {
        int[] attempt = new int[3];
        String[] numbers = input.split(",");
        for (int i = 0; i < numbers.length; i++) {
            attempt[i] = Integer.parseInt(numbers[i].trim());
        }
        return attempt;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static void main(String[] args) {
        Application application = new Application();
        SudokuGenerator sudoku = new SudokuGenerator();
        OutputHandler handler = new OutputHandler();

        String input = application.getInput();
        int[] attempt = application.parseInput(input);  // input 으로 사용자의 추축을 받음

        int[][] gameBoard = sudoku.getGameBoard();
        handler.printSudokuBoard(gameBoard);
        System.out.println();
        handler.printEasySudoku(gameBoard);
        System.out.println();
        handler.printHardSudoku(gameBoard);
    }
}

