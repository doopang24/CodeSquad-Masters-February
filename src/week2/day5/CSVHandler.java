package week2.day5;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

public class CSVHandler {

    private static InputHandler inputHandler = new InputHandler();
    private static ResultPrinter printer = new ResultPrinter();
    private static final String FILE_PATH = "C:\\intelij\\CodeSquad - Masters\\February\\5edf\\CSV";

    // 여기서 csv 파일 생성에 성공하면 InputHandler 의 Map 에 성공한 파일 추가해주고, 성공 여부 출력하는 클래스로 보내야 함
    public void createCSVTable(String tableName, List<Map<String, String>> columnList) {
        Path filePath = Paths.get(tableName + ".txt");
        String parsedColumn = parseInitialColumns(columnList);

        // 같은 이름의 파일이 이미 존재하는지 확인
        if (Files.exists(filePath)) {
            System.out.println("이미 존재하는 파일입니다.");
            return;
        }

        // 파일이 없으면 새로운 파일을 CREATE 하고, WRITE 모드로 연다.
        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.wrap(parsedColumn.getBytes());
            fileChannel.write(buffer);
        } catch (IOException e) {
            System.out.println("파일 생성 중 오류 발생");
            return;
        }

        // 파일 생성에 성공하면 InputHandler 클래스의 Map 에 추가해줌
        inputHandler.addTable(tableName, columnList);

        // 결과 출력하는 곳으로 보냄
        printer.printInitializationResult(tableName, columnList);
    }

    private String parseInitialColumns(List<Map<String, String>> initialColumns) {
        StringBuilder builder = new StringBuilder();
        for (Map<String, String> column : initialColumns) {
            builder.append(column.keySet()).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
