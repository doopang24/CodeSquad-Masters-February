package week3.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogFileReader {
/*
1. 한 줄마다 가져온다.
2. 한 줄을 탭을 기준으로 split 한다.
3. 로그 시각은 적절하게 변환한다.
4. 얻은 정보들로 LogEntry 객체를 만든다.
5. 리스트로 넘긴다.
 */

    private static LogList logList = new LogList();
    private static final String FILE_PATH = "C:\\intelij\\CodeSquad - Masters\\February\\1701410305471system.log";

    public void readLogFile() throws IOException {
        List<String[]> logDataList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String singleLog;

        while ((singleLog = reader.readLine()) != null) {
            // 읽어오는 줄을 \t 로 분리했을 때, 크기가 4개가 아니면 해당 줄을 전 줄의 마지막에 붙여야 함
            String[] dataSet = singleLog.split("\t");
            if (dataSet.length < 4) {
                String[] lastDataSet = logDataList.getLast();
                lastDataSet[3] += singleLog;
                continue;
            }
            logDataList.add(dataSet);
        }
        dataToList(logDataList);
    }

    // TODO : 메서드 이름 수정
    private void dataToList(List<String[]> logDataList) {
        for (String[] logData : logDataList) {
            String logLevel, logProcess, logMessage;
            LocalTime logTime;

            logLevel = logData[0].trim();
            logTime = convertLogTime(logData[1]);
            logProcess = logData[2].trim();
            logMessage = logData[3].trim();

            LogEntry logEntry = new LogEntry(logLevel, logTime, logProcess, logMessage);
            logList.addLogList(logEntry);
        }
    }

    private LocalTime convertLogTime(String timeRecord) {
        String modifiedTimeRecord = timeRecord.substring(0, timeRecord.length() - 5);
        // 시간 형식 파싱 (HH:시간, mm:분, ss:초, SSSSSS:마이크로초
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
        // 시간을 객체로 변환
        return LocalTime.parse(modifiedTimeRecord, formatter);
    }
}
