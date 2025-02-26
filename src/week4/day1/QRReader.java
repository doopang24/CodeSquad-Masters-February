package week4.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QRReader {
    public List<String> getInput() {
        List<String> QRLine = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("QRCode.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                QRLine.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printQRCode(QRLine);
        return QRLine;
    }

    private void printQRCode(List<String> QRLine) {
        System.out.println("입력받은 QR 2차원 배열 : ");
        for (String line : QRLine) {
            System.out.println(line);
        }
    }
}
