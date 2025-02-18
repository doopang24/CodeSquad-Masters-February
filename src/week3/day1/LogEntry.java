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

    public String getLogLevel() {
        return logLevel;
    }

    public LocalTime getLogTime() {
        return logTime;
    }

    public String getLogProcess() {
        return logProcess;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public String entryToString() {
        return logLevel + "\t" + logTime.toString() + "\t" + logProcess + "\t" + logMessage;
    }
}
