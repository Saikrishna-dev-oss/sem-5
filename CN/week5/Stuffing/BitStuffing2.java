package Stuffing;
import java.util.*;

public class BitStuffing2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String d1 = sc.nextLine();
        sc.close();

        // 1. Validate binary input
        if (!d1.matches("[01]+")) {
            System.out.println("Enter valid Binary values");
            return;
        }
        // for (int i = 0; i < d1.length(); i++) {
        //     if (d1.charAt(i) != '1' && d1.charAt(i) != '0') {
        //         System.out.println("Enter valid Binary values");
        //         return;
        //     }
        // }

        // 2. Bit Stuffing: insert '0' after every 5 consecutive '1's
        String remaining = d1.replace("11111", "111110");

        // 3. Display formatted output
        System.out.println("Flag --> 01111110");
        String new1 = "|01111110 | " + remaining + " | 01111110|";
        System.out.println("Stuffed data at intermediate site is:");
        
        String border = "-".repeat(new1.length() + 1);
        System.out.println(border);
        System.out.println(" " + new1);
        System.out.println(border);

        // 4. Bit Destuffing: remove the stuffed '0' after every 5 consecutive '1's
        String output = remaining.replace("111110", "11111");

        System.out.println("Destuffed BIT is: " + output);
    }
}
