package week1.day2;

public class Darts {

    static final int[] SCORE_BOARD = new int[]{20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5, 20, 1};
    static final int SINGLE_ROUND = 7;
    private int getRoundCount(int[] scoreLine) { // 게임 라운드 반환
        return scoreLine.length / 7;
    }
    private int[] getValidRange(int startIndex) {   // 점수표에서 유효한 범위를 반환
        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = SCORE_BOARD[startIndex + i];
        }
        return answer;
    }
    private int scoreOfPlayerA(int[] eachRoundIndex) {
        int AIndexStart = 1;
        return calculator(AIndexStart, eachRoundIndex);
    }

    private int scoreOfPlayerB(int[] eachRoundIndex) {
        int BIndexStart = 4;
        return calculator(BIndexStart, eachRoundIndex);
    }
}
