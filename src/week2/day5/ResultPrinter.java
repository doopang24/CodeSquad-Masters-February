package week2.day5;

import java.util.List;
import java.util.Map;

public class ResultPrinter {

    public void printInitializationResult(String tableName, List<Map<String, String>> columnList) {
        StringBuilder builder = new StringBuilder();
        for (Map<String, String> column : columnList) {
            builder.append(column.keySet());
        }
        System.out.println("Table 생성에 성공했습니다." + builder.toString());
    }
}
