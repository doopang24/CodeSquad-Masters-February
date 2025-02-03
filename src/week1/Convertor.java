package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Convertor {

    public boolean[] dec2bin(int decInput) {
        boolean[] bin = new boolean[8];
        int count = 0;
        int copyDec = decInput;
        while (copyDec > 0) {
            copyDec /= 2;
            count++;
        }
        boolean[] answer = Arrays.copyOf(bin, count);
        int pos = 0;
        while (decInput > 0) {
            if (decInput % 2 == 1) {
                answer[pos] = true;
            }
            decInput /= 2;
            pos++;
        }
        return answer;
    }

    public int bin2dec(boolean[] binInput) {
        int binLength = binInput.length - 1;
        int answer = 0;
        while (binLength >= 0) {
            if (binInput[binLength]) {
                answer += (int) Math.pow(2, binLength);
            }
            binLength--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Convertor convertor = new Convertor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("2진 boolean 배열로 변환할 10진수를 입력하세요.");
        int decInput = scanner.nextInt();
        System.out.print(decInput + " -> ");
        boolean[] binOutput = convertor.dec2bin(decInput);
        System.out.println(Arrays.toString(binOutput));

        System.out.println("10진수로 변환할 boolean 배열을 \",\"로 구분하여 입력하세요.");
        String binInput = scanner.next();
        String[] binArray = binInput.split(",");
        boolean[] handledBinInput = new boolean[binArray.length];
        int pos = 0;
        for(String cell : binArray) {
            if(cell.equals("true")) {
                handledBinInput[pos] = true;
            }
            pos++;
        }
        System.out.print(Arrays.toString(handledBinInput) + " -> ");
        int decOutput = convertor.bin2dec(handledBinInput);
        System.out.println(decOutput);
    }
}
