package week3.day1;

import java.util.ArrayList;
import java.util.List;

public class LogList {

    private static List<LogEntry> SystemLogList = new ArrayList<>();

    public void addLogList(LogEntry logData) {
        SystemLogList.add(logData);
    }
}
