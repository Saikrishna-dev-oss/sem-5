package week6;
import java.util.Scanner;

public class CyclicRedundancyCheck {

    // Function to perform XOR operation
    static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();

        // Ignore the first bit
        for (int i = 1; i < b.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                result.append('0');
            else
                result.append('1');
        }

        return result.toString();
    }

    // Function to perform Modulo-2 Division
    static String mod2Division(String dividend, String divisor) {

        int pick = divisor.length();
        String temp = dividend.substring(0, pick);

        while (pick < dividend.length()) {

            if (temp.charAt(0) == '1')
                temp = xor(divisor, temp) + dividend.charAt(pick);
            else
                temp = xor("0".repeat(divisor.length()), temp)
                        + dividend.charAt(pick);

            pick++;
        }

        // Last step of division
        if (temp.charAt(0) == '1')
            temp = xor(divisor, temp);
        else
            temp = xor("0".repeat(divisor.length()), temp);

        return temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sender Side
        System.out.println("========== CRC GENERATION ==========");

        System.out.print("Enter Data Bits      : ");
        String data = sc.next();

        System.out.print("Enter Divisor        : ");
        String divisor = sc.next();

        int n = divisor.length();

        // Append zeros
        String appendedData = data + "0".repeat(n - 1);

        System.out.println("\nOriginal Data        : " + data);
        System.out.println("Data + Appended Zeros: " + appendedData);
        System.out.println("Generator Polynomial : " + divisor);

        // Generate CRC
        String crc = mod2Division(appendedData, divisor);

        // Generate Codeword
        String codeword = data + crc;

        System.out.println("CRC Bits             : " + crc);
        System.out.println("Transmitted Codeword : " + codeword);

        // Receiver Side
        System.out.println("\n========== CRC CHECKING ==========");

        System.out.print("Enter Received Codeword: ");
        String received = sc.next();

        String remainder = mod2Division(received, divisor);

        System.out.println("Remainder after Division: " + remainder);

        boolean error = false;

        for (int i = 0; i < remainder.length(); i++) {
            if (remainder.charAt(i) == '1') {
                error = true;
                break;
            }
        }
        if (error)
            System.out.println("Result : ERROR detected in the received data.");
        else
            System.out.println("Result : No Error. Data received correctly.");

        sc.close();
    }
}
