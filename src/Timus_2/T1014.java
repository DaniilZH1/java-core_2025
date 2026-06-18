package Timus_2;

import java.io.*;
import java.util.*;

public class T1014 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        if (n == 0) {
            System.out.println(10);
            return;
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        ArrayList<Integer> digits = new ArrayList<>();

        for (int d = 9; d >= 2; d--) {
            while (n % d == 0) {
                digits.add(d);
                n /= d;
            }
        }

        if (n != 1) {
            System.out.println(-1);
            return;
        }

        Collections.sort(digits);

        StringBuilder ans = new StringBuilder();
        for (int d : digits) ans.append(d);

        System.out.println(ans);
    }
}
