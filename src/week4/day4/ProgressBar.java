package week4.day4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProgressBar {
    // 비동기 출력

    private final int TOTAL_TIME = 5000;    // 총 시간 5초
    private final int INTERVAL = 500;       // 0.5초 간격
    private final int STEPS = TOTAL_TIME / INTERVAL;

    public void printProgressBar() {
        // 스케줄링 가능한 스레드 풀을 하나 만들어둔다.
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        StringBuilder processBar = new StringBuilder("▷▷▷▷▷▷▷▷▷▷");

        Runnable task = new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                if (count < STEPS) {
                    processBar.setCharAt(count, '▶');
                    System.out.print("\r" + processBar.toString() + " 화성까지의 여행 " + ((count + 1) * 10) + "%");
                    count++;
                } else {
                    scheduler.shutdown();
                }
            }
        };
        // Runnable 의 객체 task 를 스레드 객체의 생성자에 전달해서 새 스레드에서 실행한다.
        // 0초 뒤에 시작해서, INTERVAL 간격으로 실행한다.
        scheduler.scheduleAtFixedRate(task, 0, INTERVAL, TimeUnit.MILLISECONDS);

//        try {
//            scheduler.awaitTermination(TOTAL_TIME + 500, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            System.out.println("진행 상황 출력 중 문제 발생");
//            Thread.currentThread().interrupt();
//        }
    }
}
