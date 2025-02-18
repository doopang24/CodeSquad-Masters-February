package week3.day1;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        LogFileReader reader = new LogFileReader();
        LogFilter filter = new LogFilter();

        try {
            reader.readLogFile();
        } catch (IOException e) {
            System.out.println("파일을 읽을 수 없습니다.");
        }

        filter.startSearch();
    }
}
