package week1.day3;

import java.util.Scanner;

public class ASCIICode {

    public int ASCIIConverter(char input) {
        return (int) input;
    }

    public static void main(String[] args) {
        ASCIICode ascii = new ASCIICode();
        Scanner scanner = new Scanner(System.in);

        char input = scanner.next().charAt(0);
        System.out.println(ascii.ASCIIConverter(input));
    }
}
