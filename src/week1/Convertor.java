package week1;

import java.util.Arrays;

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

        int decInput = 50;
        System.out.print(decInput + " -> ");
        boolean[] binOutput = convertor.dec2bin(decInput);
        System.out.println(Arrays.toString(binOutput));

        boolean[] binInput = new boolean[]{true, true, false, false, true};
        System.out.print(Arrays.toString(binInput) + " -> ");
        int decOutput = convertor.bin2dec(binInput);
        System.out.println(decOutput);
    }
}
