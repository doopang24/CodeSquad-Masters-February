package week2.day5;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    private static final String INITIALIZATION = "CREATE TABLE";
    private static final String INSERTION = "INSERT INTO";

    // Map<String, Map<String, String>> 으로 수정하면 좋겠다는 피드백 받음
    private static Map<String, List<Map<String, String>>> fileList;

    CSVHandler csvHandler = new CSVHandler();

    public InputHandler() {
        fileList = new HashMap<>();
    }

    // table 추가
    public void addTable(String tableName, List<Map<String, String>> columnList) {
        fileList.put(tableName, columnList);
    }

    // input 을 받아서 CREATE TABLE 인지, INSERT INTO 인지 분류
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.startsWith(INITIALIZATION)) {
            initialize(input);
        } else if (input.startsWith(INSERTION)) {
            insert(input);
        }
        System.out.println("올바른 입력이 아닙니다.");
    }

    // CREATE TABLE
    // Map<String, List<Map<String, String>>> 을 CSVHandler 로 보내야 함
    // 이미 있는 fileList 에서 tableName 이 같은 게 없는지 확인한 후에 fileList 에 넣는다
    private void initialize(String input) {
        String tableName;
        List<Map<String, String>> columnList = new ArrayList<>();

        Pattern tablePattern = Pattern.compile("CREATE\\s+TABLE\\s+(\\w+)\\s*\\((.+?)\\)");
        Matcher tableMatcher = tablePattern.matcher(input);

        // Matcher.find() 는 문자열에서 패턴이 존재하는지 확인하고, 찾을 때마다 매칭된 부분을 반환
        if (tableMatcher.find()) {
            tableName = tableMatcher.group(1);   // 테이블명 추출
            String columnPart = tableMatcher.group(2);
            if (fileList.containsKey(tableName)) {  // 이미 존재하는 table_name 이면 return
                System.out.println("이미 존재하는 table_name 입니다.");
                return;
            }

            Pattern columnPattern = Pattern.compile("\\s*(\\w+)\\s+(\\w+)(?:,\\s*(\\w+)\\s+(\\w+))*");
            Matcher columnMatcher = columnPattern.matcher(columnPart);

            while (columnMatcher.find()) {
                Map<String, String> columnNameAndType = new HashMap<>();
                String columnName = columnMatcher.group(1);
                String dataType = columnMatcher.group(2);
                columnNameAndType.put(columnName, dataType);
                columnList.add(columnNameAndType);
            }
            csvHandler.createCSVTable(tableName, columnList);
        } else {
            System.out.println("유효한 CREATE TABLE 문이 아닙니다.");
        }
    }

    // INSERT INTO
    private void insert(String input) {

    }
}
