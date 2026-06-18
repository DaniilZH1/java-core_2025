package Timus_2;

import java.io.*;

import java.io.*;

public class T1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine().trim());

        for (long n = (long) Math.sqrt(2 * s) + 1; n >= 1; n--) {
            long t = 2 * s - n * (n - 1);

            if (t > 0 && t % (2 * n) == 0) {
                long a = t / (2 * n);
                System.out.println(a + " " + n);
                return;
            }
        }
    }
}
