package Timus_2;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class T1118 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();

        int[] sum = new int[r + 1];

        for (int d = 1; d * 2 <= r; d++) {
            for (int x = d * 2; x <= r; x += d) {
                sum[x] += d;
            }
        }

        int best = l;

        for (int x = l + 1; x <= r; x++) {
            if ((long) sum[x] * best < (long) sum[best] * x) {
                best = x;
            }
        }

        System.out.println(best);
    }
}
