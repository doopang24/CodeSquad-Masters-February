package week3.day1;

import java.util.Scanner;

public class LogFilter {

    static Scanner scanner = new Scanner(System.in);
    static LogList logList = new LogList();

    public void startSearch() {
        System.out.println("메뉴를 선택하세요.\n1 : 로그 레벨\n2 : 기록 시각\n3 : 프로세스");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                findLogLevel();
                break;
            case 2:
                sortLogTime();
                break;
            case 3:
                findLogProcess();
                break;
        }
    }

    private void findLogLevel() {
        System.out.println("필터링 하고 싶은 로그 레벨을 입력하세요.");
        scanner.nextLine();
        String logLevelInput = scanner.nextLine();
        logList.filterByLevel(logLevelInput);
    }

    private void sortLogTime() {
        logList.sortByTime();
    }

    private void findLogProcess() {
        System.out.println("원하는 작업을 선택하세요.\n1 : 정렬\n2 : 필터링");
        int processInput = scanner.nextInt();
        switch (processInput) {
            case 1:
                sortProcess();
                break;
            case 2:
                filterProcess();
                break;
        }
    }

    private void sortProcess() {
        logList.sortByProcess();
    }

    private void filterProcess() {
        System.out.println("필터링 하고 싶은 프로세스를 입력하세요.");
        scanner.nextLine();
        String processInput = scanner.nextLine();
        logList.filterByProcess(processInput);
    }
}
