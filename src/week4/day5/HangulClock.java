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
