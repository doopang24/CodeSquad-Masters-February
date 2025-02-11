package week2.day1;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        SudokuGenerator generator = new SudokuGenerator();
        OutputHandler outputHandler = new OutputHandler();

        outputHandler.printEasySudoku(generator.getGameBoard());
        int[] attempt = inputHandler.startGame();
        if (generator.canPlaceNumber(attempt)) {
            /*
            TODO
            - 사용자가 입력(위치, 숫자)하면 현재 스도쿠 판에 들어갈 수 있는지 검증한 후, 해당 위치를 해당 숫자로 바꿔서 출력
            - 사용자가 이미 채워진 위치에 있는 숫자를 바꾸고 싶으면 동일한 방식으로 검증하고 바꿔서 출력
            - 그러다가 사용자가 정답(프로그램이 생성한 스도쿠 판)을 완성하면 완성했다는 안내 문구화 함께 프로그램 종료.
             */
        }
    }
}
