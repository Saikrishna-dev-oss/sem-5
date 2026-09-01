package Stuffing;

import java.util.*;

public class ByteStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of words: ");
        int n = sc.nextInt();

        System.out.println("Enter the message: ");
        String[] in = new String[n];
        for (int i = 0; i < n; i++) {
            in[i] = sc.next();
        }

        // Byte stuffing: replace "esc" with "esc esc"
        for (int i = 0; i < n; i++) {
            if (in[i].equals("esc")) {
                in[i] = "esc esc";
            }
        }

        // Transmitted message
        System.out.println("Transmitted message is: ");
        System.out.print(" esc stx ");
        for (int i = 0; i < n; i++) {
            System.out.print(in[i] + " ");
        }
        System.out.println("esc etx");

        sc.close();
    }
}
