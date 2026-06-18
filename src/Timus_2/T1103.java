package Timus_2;

import java.io.*;
import java.util.*;

public class T1103 {
    static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point A, B;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        Point[] p = new Point[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Point(fs.nextLong(), fs.nextLong());
        }


        int a = 0;
        for (int i = 1; i < n; i++) {
            if (p[i].x < p[a].x || (p[i].x == p[a].x && p[i].y < p[a].y)) {
                a = i;
            }
        }


        int b = -1;
        for (int i = 0; i < n; i++) {
            if (i == a) continue;
            if (b == -1) {
                b = i;
                continue;
            }

            long cr = cross(p[a], p[b], p[i]);
            if (cr < 0) b = i;
        }

        A = p[a];
        B = p[b];

        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != a && i != b) {
                list.add(p[i]);
            }
        }

        list.sort((u, v) -> {
            double au = angle(u);
            double av = angle(v);
            return Double.compare(av, au); // по убыванию угла
        });

        int need = (n - 3) / 2;
        Point C = list.get(need);

        System.out.println(A.x + " " + A.y);
        System.out.println(B.x + " " + B.y);
        System.out.println(C.x + " " + C.y);
    }

    static double angle(Point p) {
        long ax = A.x - p.x;
        long ay = A.y - p.y;
        long bx = B.x - p.x;
        long by = B.y - p.y;

        long cross = ax * by - ay * bx;
        long dot = ax * bx + ay * by;

        return Math.atan2(Math.abs((double) cross), (double) dot);
    }

    static long cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

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
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int c;
            do c = read(); while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long x = 0;
            while (c > ' ') {
                x = x * 10 + c - '0';
                c = read();
            }

            return x * sign;
        }
    }
}
