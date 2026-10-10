package week12;

import java.util.Scanner;

public class RSA {

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            exp = exp / 2;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Choose two small prime numbers
        long p = 11;
        long q = 13;

        // 2. Formulas
        long n = p * q;               // n = 143 (Modulus)
        long phi = (p - 1) * (q - 1); // phi = 120 (Totient)

        // Choose public exponent e where gcd(e, phi) == 1
        long e = 7;

        // Find private exponent d: (d * e) % phi == 1
        long d = 0;
        for (long k = 1; k < phi; k++) {
            if ((k * e) % phi == 1) {
                d = k;
                break;
            }
        }

        // 3. Take user input
        System.out.print("enter the original msg: ");
        String originalMsg = scanner.nextLine();

        // 4. Output Keys & Encryption (Encrypt each char: C = M^e % n)
        System.out.println("\npublic key: (" + e + ", " + n + ")");
        System.out.print("CipherText: ");

        long[] cipherText = new long[originalMsg.length()];
        for (int i = 0; i < originalMsg.length(); i++) {
            long m = (int) originalMsg.charAt(i); // character to number
            cipherText[i] = modPow(m, e, n);      // C = M^e % n
            System.out.print(cipherText[i] + " ");
        }
        System.out.println();

        // 5. Decryption (Decrypt each number: M = C^d % n)
        System.out.println("\nprivate key: (" + d + ", " + n + ")");

        StringBuilder decryptedMsg = new StringBuilder();
        for (long c : cipherText) {
            long m = modPow(c, d, n);             // M = C^d % n
            decryptedMsg.append((char) m);        // number back to character
        }

        System.out.println("Decrypted message: " + decryptedMsg);
        scanner.close();
    }
}
