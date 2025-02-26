package week4.day1;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        QRReader reader = new QRReader();
        List<String> QRCode = reader.getInput();

        QRCodeDecoder decoder = new QRCodeDecoder(QRCode);
        decoder.startConvert();
    }
}
