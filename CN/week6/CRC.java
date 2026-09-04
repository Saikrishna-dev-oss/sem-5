package week6;
import java.util.Scanner;

public class CRC {
    
    // Modulo-2 division using an in-place character array
    static String mod2Division(String dividend, String divisor) {
        char[] data = dividend.toCharArray();
        int divLen = divisor.length();

        for (int i = 0; i <= data.length - divLen; i++) {
            // If the leading bit is '1', XOR with the divisor
            if (data[i] == '1') {
                for (int j = 0; j < divLen; j++) {
                    data[i + j] = (data[i + j] == divisor.charAt(j)) ? '0' : '1';
                }
            }
        }

        // The remaining (divLen - 1) bits represent the remainder (CRC)
        return new String(data, data.length - (divLen - 1), divLen - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sender Side
        System.out.println("========== CRC GENERATION ==========");
        System.out.print("Enter Data Bits      : ");
        String data = sc.next();

        System.out.print("Enter Divisor        : ");
        String divisor = sc.next();

        // Append (divisor length - 1) zeros
        String appendedData = data + "0".repeat(divisor.length() - 1);

        System.out.println("\nOriginal Data        : " + data);
        System.out.println("Data + Appended Zeros: " + appendedData);
        System.out.println("Generator Polynomial : " + divisor);

        // Generate CRC and Codeword
        String crc = mod2Division(appendedData, divisor);
        String codeword = data + crc;

        System.out.println("CRC Bits             : " + crc);
        System.out.println("Transmitted Codeword : " + codeword);

        // Receiver Side
        System.out.println("\n========== CRC CHECKING ==========");
        System.out.print("Enter Received Codeword: ");
        String received = sc.next();

        String remainder = mod2Division(received, divisor);
        System.out.println("Remainder after Division: " + remainder);

        // Check if any error bit is present
        if (remainder.contains("1")) {
            System.out.println("Result : ERROR detected in the received data.");
        } else {
            System.out.println("Result : No Error. Data received correctly.");
        }

        sc.close();
    }
}