package Timus_2;

import java.io.*;
import java.util.*;

public class T1100 {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= ' ');

            int x = 0;
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        ArrayList<int[]>[] buckets = new ArrayList[101];
        for (int i = 0; i <= 100; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int id = fs.nextInt();
            int m = fs.nextInt();

            buckets[m].add(new int[]{id, m});
        }

        StringBuilder out = new StringBuilder();

        for (int m = 100; m >= 0; m--) {
            for (int[] team : buckets[m]) {
                out.append(team[0]).append(' ')
                        .append(team[1]).append('\n');
            }
        }

        System.out.print(out);
    }
}
