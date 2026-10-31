package RSA_;

// WEEK-12: RSA Algorithm Implementation
import java.util.Scanner;

public class RSA
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter p: ");
        int p = sc.nextInt();
        System.out.print("Enter q: ");
        int q = sc.nextInt();
        int n = p * q;
        System.out.println("n = " + n);

        int phi = (p - 1) * (q - 1);
        System.out.println("phi(n) = " + phi);
        System.out.print("Enter public key e: ");
        int e = sc.nextInt();
        int d = 1;
        while (((d * e) % phi) != 1)
        {
            d++;
        }

        System.out.println("Public Key = (" + e + "," + n + ")");
        System.out.println("Private Key = (" + d + "," + n + ")");
        sc.nextLine(); // clear buffer
        System.out.print("Enter Text Message: ");
        String message = sc.nextLine();

        int[] encrypted = new int[message.length()];
        System.out.print("Encrypted Message: ");

        for (int i = 0; i < message.length(); i++)
        {
            int m = (int) message.charAt(i);
            int c = 1;
            for (int j = 0; j < e; j++)
            {
                c = (c * m) % n;
            }

            encrypted[i] = c;
            System.out.print(c + " ");
        }

        System.out.println();
        String decryptedMessage = "";
        for (int i = 0; i < encrypted.length; i++)
        {
            int decrypted = 1;
            for (int j = 0; j < d; j++)
            {
                decrypted = (decrypted * encrypted[i]) % n;
            }
            decryptedMessage += (char) decrypted;
        }
        System.out.println("Decrypted Message: " + decryptedMessage);
        sc.close();
    }
}


// Enter p: 17
// Enter q: 11
// n = 187
// phi(n) = 160
// Enter public key e: 7
// Public Key = (7,187)
// Private Key = (23,187)
// Enter Text Message: Hello
// Encrypted Message: 30 84 48 48 155 
// Decrypted Message: Hello