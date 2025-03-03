package week4.day5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HangulClock extends Application {

    private final String[][] WORDS = {
            {"오", "전", "후", "영"},
            {"열", "한", "두", "세"},
            {"네", "다", "여", "섯"},
            {"일", "곱", "여", "덟"},
            {"아", "홉", "시", ""},
            {"이", "삼", "사", "오"},
            {"십", "일", "이", "삼"},
            {"사", "오", "육", "칠"},
            {"팔", "구", "분", ""}
    };

    // 12시간제, 분 단위, 초 단위의 형태
    private final DateTimeFormatter HOUR_FORMAT = DateTimeFormatter.ofPattern("HH");
    private final DateTimeFormatter MINUTE_FORMAT = DateTimeFormatter.ofPattern("m");
    private final DateTimeFormatter SECOND_FORMAT = DateTimeFormatter.ofPattern("s");

    // UI에 표시된 Text 객체들에 접근해서 색을 변경하기 위해 필요하다
    private Text[][] textGrid = new Text[WORDS.length][WORDS[0].length];

    // 초 표시용 HBox
    private VBox secondDisplay = new VBox();        // 수직 구조물
    private Text tenSecondText = new Text(" "); // 십의 자리 초
    private Text oneSecondText = new Text("초"); // 일의 자리 초

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        // 글자들 회색으로 초기화
        for (int i = 0; i < WORDS.length; i++) {
            for (int j = 0; j < WORDS[i].length; j++) {
                Text text = new Text(WORDS[i][j]);
                text.setFont(Font.font(30));    // 글자크기
                text.setFill(Color.GRAY);   // 기본 색을 회색으로
                grid.add(text, j, i);
                textGrid[i][j] = text;
            }
        }

        // 초 텍스트 크기, 색 설정
        tenSecondText.setFont(Font.font(15));
        oneSecondText.setFont(Font.font(15));
        tenSecondText.setFill(Color.GRAY);
        oneSecondText.setFill(Color.GRAY);

        // VBox 에 초 텍스트 세로로 추기
        secondDisplay.getChildren().addAll(tenSecondText, oneSecondText);
        // 초 VBox 그리드에 더해준다
        grid.add(secondDisplay, 3, 8);

        // new Timeline : javafx 에서 시간 기반 애니메이션 실행
        // 1초마다 updateClock() 실행하도록 KeyFrame 설정
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateClock())
        );
        // 무한 반복
        timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline 실행
        timeline.play();

        // UI 화면 생성
        Scene scene = new Scene(grid, 120, 270);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("한글 시계");
        // 현재 Stage 에 Scene 을 연결해서 UI 표시
        primaryStage.setScene(scene);
        // 창을 화면에 표시
        primaryStage.show();
    }

    private void updateClock() {
        LocalTime now = LocalTime.now();
        int hour = Integer.parseInt(now.format(HOUR_FORMAT));
        int minute = Integer.parseInt(now.format(MINUTE_FORMAT));
        int second = Integer.parseInt(now.format(SECOND_FORMAT));

        // 모든 글자 회색으로 초기화
        for (int i = 0; i < WORDS.length; i++) {
            for (int j = 0; j < WORDS[i].length; j++) {
                textGrid[i][j].setFill(Color.GRAY);
            }
        }
        highlightTime(hour, minute, second);
    }

    // 해당하는 시간을 밝게 표시
    private void highlightTime(int hour, int minute, int second) {
        switch (hour) {
            case 1:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[1][1].setFill(Color.WHITE);
                break;
            case 2:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[1][2].setFill(Color.WHITE);
                break;
            case 3:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[1][3].setFill(Color.WHITE);
                break;
            case 4:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[2][0].setFill(Color.WHITE);
                break;
            case 5:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[2][1].setFill(Color.WHITE);
                break;
            case 6:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[2][2].setFill(Color.WHITE);
                textGrid[2][3].setFill(Color.WHITE);
                break;
            case 7:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[3][0].setFill(Color.WHITE);
                textGrid[3][1].setFill(Color.WHITE);
                break;
            case 8:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[3][2].setFill(Color.WHITE);
                textGrid[3][3].setFill(Color.WHITE);
                break;
            case 9:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[4][0].setFill(Color.WHITE);
                textGrid[4][1].setFill(Color.WHITE);
                break;
            case 10:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[1][0].setFill(Color.WHITE);
                break;
            case 11:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[1][0].setFill(Color.WHITE);
                textGrid[1][1].setFill(Color.WHITE);
                break;
            case 12:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][1].setFill(Color.WHITE);
                textGrid[1][0].setFill(Color.WHITE);
                textGrid[1][2].setFill(Color.WHITE);
                break;
            case 13:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[1][1].setFill(Color.WHITE);
                break;
            case 14:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[1][2].setFill(Color.WHITE);
                break;
            case 15:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[1][3].setFill(Color.WHITE);
                break;
            case 16:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[2][0].setFill(Color.WHITE);
                break;
            case 17:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[2][1].setFill(Color.WHITE);
                break;
            case 18:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[2][2].setFill(Color.WHITE);
                textGrid[2][3].setFill(Color.WHITE);
                break;
            case 19:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[3][0].setFill(Color.WHITE);
                textGrid[3][1].setFill(Color.WHITE);
                break;
            case 20:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[3][2].setFill(Color.WHITE);
                textGrid[3][3].setFill(Color.WHITE);
                break;
            case 21:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[4][0].setFill(Color.WHITE);
                textGrid[4][1].setFill(Color.WHITE);
                break;
            case 22:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[1][0].setFill(Color.WHITE);
                break;
            case 23:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[1][0].setFill(Color.WHITE);
                textGrid[1][1].setFill(Color.WHITE);
                break;
            case 24:
                textGrid[0][0].setFill(Color.WHITE);
                textGrid[0][2].setFill(Color.WHITE);
                textGrid[1][0].setFill(Color.WHITE);
                textGrid[1][2].setFill(Color.WHITE);
                break;
        }
        textGrid[4][2].setFill(Color.WHITE);

        switch (minute) {
            case 0:
                textGrid[0][3].setFill(Color.WHITE);
                break;
            case 1:
                textGrid[6][1].setFill(Color.WHITE);
                break;
            case 2:
                textGrid[6][2].setFill(Color.WHITE);
                break;
            case 3:
                textGrid[6][3].setFill(Color.WHITE);
                break;
            case 4:
                textGrid[7][0].setFill(Color.WHITE);
                break;
            case 5:
                textGrid[7][1].setFill(Color.WHITE);
                break;
            case 6:
                textGrid[7][2].setFill(Color.WHITE);
                break;
            case 7:
                textGrid[7][3].setFill(Color.WHITE);
                break;
            case 8:
                textGrid[8][0].setFill(Color.WHITE);
                break;
            case 9:
                textGrid[8][1].setFill(Color.WHITE);
                break;
            case 10:
                textGrid[6][0].setFill(Color.WHITE);
                break;
            case 11:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][1].setFill(Color.WHITE);
                break;
            case 12:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][2].setFill(Color.WHITE);
                break;
            case 13:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][3].setFill(Color.WHITE);
                break;
            case 14:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][0].setFill(Color.WHITE);
                break;
            case 15:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][1].setFill(Color.WHITE);
                break;
            case 16:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][2].setFill(Color.WHITE);
                break;
            case 17:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][3].setFill(Color.WHITE);
                break;
            case 18:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][0].setFill(Color.WHITE);
                break;
            case 19:
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][1].setFill(Color.WHITE);
                break;
            case 20:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                break;
            case 21:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][1].setFill(Color.WHITE);
                break;
            case 22:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][2].setFill(Color.WHITE);
                break;
            case 23:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][3].setFill(Color.WHITE);
                break;
            case 24:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][0].setFill(Color.WHITE);
                break;
            case 25:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][1].setFill(Color.WHITE);
                break;
            case 26:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][2].setFill(Color.WHITE);
                break;
            case 27:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][3].setFill(Color.WHITE);
                break;
            case 28:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][0].setFill(Color.WHITE);
                break;
            case 29:
                textGrid[5][0].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][1].setFill(Color.WHITE);
                break;
            case 30:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                break;
            case 31:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][1].setFill(Color.WHITE);
                break;
            case 32:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][2].setFill(Color.WHITE);
                break;
            case 33:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][3].setFill(Color.WHITE);
                break;
            case 34:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][0].setFill(Color.WHITE);
                break;
            case 35:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][1].setFill(Color.WHITE);
                break;
            case 36:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][2].setFill(Color.WHITE);
                break;
            case 37:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][3].setFill(Color.WHITE);
                break;
            case 38:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][0].setFill(Color.WHITE);
                break;
            case 39:
                textGrid[5][1].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][1].setFill(Color.WHITE);
                break;
            case 40:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                break;
            case 41:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][1].setFill(Color.WHITE);
                break;
            case 42:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][2].setFill(Color.WHITE);
                break;
            case 43:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][3].setFill(Color.WHITE);
                break;
            case 44:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][0].setFill(Color.WHITE);
                break;
            case 45:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][1].setFill(Color.WHITE);
                break;
            case 46:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][2].setFill(Color.WHITE);
                break;
            case 47:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][3].setFill(Color.WHITE);
                break;
            case 48:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][0].setFill(Color.WHITE);
                break;
            case 49:
                textGrid[5][2].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][1].setFill(Color.WHITE);
                break;
            case 50:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                break;
            case 51:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][1].setFill(Color.WHITE);
                break;
            case 52:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][2].setFill(Color.WHITE);
                break;
            case 53:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[6][3].setFill(Color.WHITE);
                break;
            case 54:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][0].setFill(Color.WHITE);
                break;
            case 55:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][1].setFill(Color.WHITE);
                break;
            case 56:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][2].setFill(Color.WHITE);
                break;
            case 57:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[7][3].setFill(Color.WHITE);
                break;
            case 58:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][0].setFill(Color.WHITE);
                break;
            case 59:
                textGrid[5][3].setFill(Color.WHITE);
                textGrid[6][0].setFill(Color.WHITE);
                textGrid[8][1].setFill(Color.WHITE);
                break;
        }
        textGrid[8][2].setFill(Color.WHITE);

        String[] secondToHangul = secondToHangul(second);
        tenSecondText.setText(secondToHangul[0]);
        oneSecondText.setText(secondToHangul[1]);

        tenSecondText.setFill(Color.WHITE);
        oneSecondText.setFill(Color.WHITE);
    }

    private String[] secondToHangul(int second) {
        String[] hangulNumbers = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
        int ten = second / 10;
        int one = second % 10;

        String tenHangul = ten > 0 ? hangulNumbers[ten] + "십" : "";
        String oneHangul = hangulNumbers[one] + "초";

        return new String[]{tenHangul, oneHangul};
    }

    public static void main(String[] args) {
        launch(args);
    }
}
