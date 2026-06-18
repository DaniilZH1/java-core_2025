package Timus_2;

import java.io.*;

import java.io.*;

public class T1104 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int max = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int d = value(s.charAt(i));
            max = Math.max(max, d);
            sum += d;
        }

        for (int k = Math.max(2, max + 1); k <= 36; k++) {
            if (sum % (k - 1) == 0) {
                System.out.println(k);
                return;
            }
        }

        System.out.println("No solution.");
    }

    static int value(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        return c - 'A' + 10;
    }
}
