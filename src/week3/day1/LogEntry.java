package week3.day1;

import java.time.LocalTime;

public class LogEntry {
    private String logLevel;
    private LocalTime logTime;
    private String logProcess;
    private String logMessage;

    public LogEntry(String logLevel, LocalTime logTime, String logProcess, String logMessage) {
        this.logLevel = logLevel;
        this.logTime = logTime;
        this.logProcess = logProcess;
        this.logMessage = logMessage;
    }
}
