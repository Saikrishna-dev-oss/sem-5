package Stuffing;

import java.util.*;

public class BitStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String d1 = sc.nextLine();

        String remaining = "";
        String output = "";
        int counter = 0;

        // Bit stuffing
        for (int i = 0; i < d1.length(); i++) {
            if (d1.charAt(i) != '1' && d1.charAt(i) != '0') {
                System.out.println("Enter valid Binary values");
                return;
            }

            if (d1.charAt(i) == '1') {
                counter++;
                remaining += d1.charAt(i);
            } else {
                remaining += d1.charAt(i);
                counter = 0;
            }

            if (counter == 5) {
                remaining += '0';
                counter = 0;
            }
        }

        // Display stuffed data
        System.out.println("Flag --> 01111110");
        String new1 = "|01111110 | " + remaining + " | 01111110|";
        System.out.println("Stuffed data at intermediate site is:");

        for (int k = 0; k <= (28 + d1.length()); k++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(" " + new1);
        for (int k = 0; k <= (28 + d1.length()); k++) {
            System.out.print("-");
        }
        System.out.println();

        // Bit destuffing
        counter = 0;
        for (int i = 0; i < remaining.length(); i++) {
            if (remaining.charAt(i) == '1') {
                counter++;
                output += remaining.charAt(i);
            } else {
                output += remaining.charAt(i);
                counter = 0;
            }

            if (counter == 5) {
                if ((i + 2) != remaining.length()) {
                    output += remaining.charAt(i + 2);
                } else {
                    output += '1';
                }
                i = i + 2;
                counter = 1;
            }
        }
        sc.close();

        System.out.println("Destuffed BIT is: " + output);
    }
}
