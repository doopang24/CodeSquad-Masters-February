package week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QRCodeDecoder {

    private final byte[][] QRCODE;
    private final int EXPECTED_START_CODE = 12;
    private final int EXPECTED_END_CODE = 6;

    // 생성자에서 QR 코드 생성
    public QRCodeDecoder(List<String> QRLine) {
        int row = QRLine.size();
        int col = QRLine.get(0).length();
        QRCODE = new byte[row][col];
        for (int i = 0; i < row; i++) {
            char[] tmp = QRLine.get(i).toCharArray();
            for (int j = 0; j < col; j++) {
                QRCODE[i][j] = (byte) (tmp[j] - '0');
            }
        }
    }

    public void startConvert() {
        if (checkValidQR()) {
            List<Integer> mainData = new ArrayList<>();
            List<Integer> errorData = new ArrayList<>();
            int dataLength = binaryCodeToIntValue(readFromBottom(20, 18));

            mainData.add(binaryCodeToIntValue(readFromBottom(20, 14)));
            mainData.add(binaryCodeToIntValue(readCounterClockwise(20, 10)));
            mainData.add(binaryCodeToIntValue(readFromTop(18, 11)));
            mainData.add(binaryCodeToIntValue(readFromTop(18, 15)));
            mainData.add(binaryCodeToIntValue(readClockwise(18, 19)));
            mainData.add(binaryCodeToIntValue(readFromBottom(16, 18)));
            mainData.add(binaryCodeToIntValue(readFromBottom(16, 14)));
            mainData.add(binaryCodeToIntValue(readCounterClockwise(16, 10)));
            mainData.add(binaryCodeToIntValue(readFromTop(14, 11)));
            mainData.add(binaryCodeToIntValue(readFromTop(14, 15)));
            mainData.add(binaryCodeToIntValue(readClockwise(14, 19)));
            mainData.add(binaryCodeToIntValue(readFromBottom(12, 18)));
            mainData.add(binaryCodeToIntValue(readFromBottom(12, 14)));
            mainData.add(binaryCodeToIntValue(readFromBottom(12, 10)));
            mainData.add(binaryCodeToIntValue(readFromBottom(12, 5)));
            mainData.add(binaryCodeToIntValue(readCounterClockwise(12, 1)));
            mainData.add(binaryCodeToIntValue(readFromTop(10, 2)));
            mainData.add(binaryCodeToIntValue(readFromTop(10, 7)));
            mainData.add(binaryCodeToIntValue(readFromTop(10, 11)));
            mainData.add(binaryCodeToIntValue(readFromTop(10, 15)));

            errorData.add(binaryCodeToIntValue(readFromBottom(8, 12)));
            errorData.add(binaryCodeToIntValue(readFromTop(5, 9)));
            errorData.add(binaryCodeToIntValue(readFromBottom(3, 12)));
            errorData.add(binaryCodeToIntValue(readFromTop(1, 9)));

            DataConverter converter = new DataConverter(mainData, errorData, dataLength);
            String[] convertResult = converter.getDecodingResult();
            System.out.println("디코딩 결과 : " + Arrays.toString(convertResult));
        } else {
            System.out.println("디코딩 결과 : \"\"");
        }
    }

    // 시작, 종료 코드가 규칙에 맞는지 확인
    private boolean checkValidQR() {
        int startCode = binaryCodeToIntValue(readStart());
        int endCode = binaryCodeToIntValue(readEnd());
        if (startCode != EXPECTED_START_CODE || endCode != EXPECTED_END_CODE) {
            return false;
        }
        return true;
    }

    // 시작 코드값 읽는 메서드
    private List<Byte> readStart() {
        List<Byte> startCode = new ArrayList<>();
        int startX = 20, startY = 20;
        for (int i = 0; i >= -1; i--) {
            for (int j = 0; j >= -1; j--) {
                startCode.add(QRCODE[startY + i][startX + j]);
            }
        }
        return startCode;
    }

    // 종료 코드값 읽는 메서드
    private List<Byte> readEnd() {
        List<Byte> endCode = new ArrayList<>();
        int endX = 10, endY = 19;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j >= -1; j--) {
                endCode.add(QRCODE[endY + i][endX + j]);
            }
        }
        return endCode;
    }

    // 0과 1로 이루어진 byte 배열 -> 10진수 int 값
    private int binaryCodeToIntValue(List<Byte> binaryCode) {
        int count = binaryCode.size() - 1, answer = 0;
        for (byte code : binaryCode) {
            answer += (int) (code * Math.pow(2, count--));
        }
        return answer;
    }

    // 위에서부터 읽어서 byte 리스트로 반환
    private List<Byte> readFromTop(int startX, int startY) {
        List<Byte> readData = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j >= -1; j--) {
                readData.add(QRCODE[startY + i][startX + j]);
            }
        }
        return readData;
    }

    // 아래부터 읽어서 byte 리스트로 반환
    private List<Byte> readFromBottom(int startX, int startY) {
        List<Byte> readData = new ArrayList<>();
        for (int i = 0; i >= -3; i--) {
            for (int j = 0; j >= -1; j--) {
                readData.add(QRCODE[startY + i][startX + j]);
            }
        }
        return readData;
    }

    // 시계 반대방향으로 읽어서 byte 리스트로 반환
    private List<Byte> readCounterClockwise(int startX, int startY) {
        List<Byte> readData = new ArrayList<>();
        for (int i = 0; i >= -1; i--) {
            for (int j = 0; j >= -1; j--) {
                readData.add(QRCODE[startY + i][startX + j]);
            }
        }
        for (int i = -1; i <= 0; i++) {
            for (int j = -2; j >= -3; j--) {
                readData.add(QRCODE[startY + i][startX + j]);
            }
        }
        return readData;
    }

    // 시계 방향으로 읽어서 byte 리스트로 반환
    private List<Byte> readClockwise(int startX, int startY) {
        List<Byte> readData = new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j >= -1; j--) {
                readData.add(QRCODE[startY + i][startX + j]);
            }
        }
        for (int i = 1; i >= 0; i--) {
            for (int j = -2; j >= -3; j--) {
                readData.add(QRCODE[startY + i][startX + j]);
            }
        }
        return readData;
    }
}
