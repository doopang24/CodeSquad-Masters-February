package week3.day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LogList {

    private static List<LogEntry> systemLogList = new ArrayList<>();

    public void addLogList(LogEntry logData) {
        systemLogList.add(logData);
    }

    public List<LogEntry> getSystemLogList() {
        return systemLogList;
    }

    // 시간 오름차순 정렬
    public void sortByTime() {
        List<LogEntry> timeSortedLogs = new ArrayList<>(systemLogList);
        timeSortedLogs.sort(Comparator.comparing(LogEntry::getLogTime));
        for (LogEntry entry : timeSortedLogs) {
            System.out.println(entry.entryToString());
        }
    }

    // 프로세스 별 오름차순 정렬
    public void sortByProcess() {
        List<LogEntry> processSortedLogs = new ArrayList<>(systemLogList);
        processSortedLogs.sort(Comparator.comparing(LogEntry::getLogProcess));
        for (LogEntry entry : processSortedLogs) {
            System.out.println(entry.entryToString());
        }
    }

    // 레벨 필터링
    public void filterByLevel(String levelInput) {
        for (LogEntry entry : systemLogList) {
            if (entry.getLogLevel().equals(levelInput)) {
                System.out.println(entry.entryToString());
            }
        }
    }

    // 프로세스 필터링
    public void filterByProcess(String processInput) {
        for (LogEntry entry : systemLogList) {
            if (entry.getLogProcess().equals(processInput)) {
                System.out.println(entry.entryToString());
            }
        }
    }
}
