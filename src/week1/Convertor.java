package week1;

import java.util.Arrays;

public class Convertor {

    public boolean[] dec2bin(int decInput) {
        boolean[] bin = new boolean[8];
        int count = 1;
        int copyDec = decInput;
        while (copyDec > 1) {
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
}
