package week4.day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataConverter {

    private static final Map<Integer, Character> CODE_MAP = new HashMap<>();
    private final List<Integer> mainData;
    private final List<Integer> errorData;
    private final int dataLength;

    public DataConverter(List<Integer> mainData, List<Integer> errorData, int dataLength) {
        this.mainData = mainData;
        this.errorData = errorData;
        this.dataLength = dataLength;
    }

    static {
        CODE_MAP.put(0, '0');
        CODE_MAP.put(1, '1');
        CODE_MAP.put(2, '2');
        CODE_MAP.put(3, '3');
        CODE_MAP.put(4, '4');
        CODE_MAP.put(5, '5');
        CODE_MAP.put(6, '6');
        CODE_MAP.put(7, '7');
        CODE_MAP.put(8, '8');
        CODE_MAP.put(9, '9');
        CODE_MAP.put(10, 'A');
        CODE_MAP.put(11, 'B');
        CODE_MAP.put(12, 'C');
        CODE_MAP.put(13, 'D');
        CODE_MAP.put(14, 'E');
        CODE_MAP.put(15, 'F');
        CODE_MAP.put(16, 'G');
        CODE_MAP.put(17, 'H');
        CODE_MAP.put(18, 'I');
        CODE_MAP.put(19, 'J');
        CODE_MAP.put(20, 'K');
        CODE_MAP.put(21, 'L');
        CODE_MAP.put(22, 'M');
        CODE_MAP.put(23, 'N');
        CODE_MAP.put(24, 'O');
        CODE_MAP.put(25, 'P');
        CODE_MAP.put(26, 'Q');
        CODE_MAP.put(27, 'R');
        CODE_MAP.put(28, 'S');
        CODE_MAP.put(29, 'T');
        CODE_MAP.put(30, 'U');
        CODE_MAP.put(31, 'V');
        CODE_MAP.put(32, 'W');
        CODE_MAP.put(33, 'X');
        CODE_MAP.put(34, 'Y');
        CODE_MAP.put(35, 'Z');
        CODE_MAP.put(36, ' ');
        CODE_MAP.put(37, '$');
        CODE_MAP.put(38, '%');
        CODE_MAP.put(39, '*');
        CODE_MAP.put(40, '+');
        CODE_MAP.put(41, '-');
        CODE_MAP.put(42, '.');
        CODE_MAP.put(43, '/');
        CODE_MAP.put(44, ':');
    }

    public String[] getDecodingResult() {
        String[] decodingResult = new String[2];
        decodingResult[0] = convertMainData();
        decodingResult[1] = "0x" + convertErrorData();

        return decodingResult;
    }

    private String convertMainData() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < dataLength; i++) {
            char convertedWord = CODE_MAP.get(mainData.get(i));
            builder.append(convertedWord);
        }
        return builder.toString();
    }

    private String convertErrorData() {
        StringBuilder builder = new StringBuilder();

        for (int error : errorData) {
            builder.append(Integer.toHexString(error));
        }
        return builder.toString().toUpperCase();
    }
}
