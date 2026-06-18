package Timus_2;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class T1101 {
    static String expr;
    static int pos;
    static boolean[] r = new boolean[26];

    static boolean[][] fork = new boolean[201][201];
    static char[][] inv = new char[201][201];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        expr = br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int shift = 100;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + shift;
            int y = Integer.parseInt(st.nextToken()) + shift;
            fork[x][y] = true;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + shift;
            int y = Integer.parseInt(st.nextToken()) + shift;
            char c = st.nextToken().charAt(0);
            inv[x][y] = c;
        }

        int x = 0, y = 0;
        int dx = 1, dy = 0;

        StringBuilder out = new StringBuilder();

        while (x >= -n && x <= n && y >= -n && y <= n) {
            out.append(x).append(' ').append(y).append('\n');

            char c = inv[x + shift][y + shift];
            if (c != 0) r[c - 'A'] = !r[c - 'A'];

            if (fork[x + shift][y + shift]) {
                pos = 0;
                boolean val = parseOr();

                if (val) {
                    int ndx = dy;
                    int ndy = -dx;
                    dx = ndx;
                    dy = ndy;
                } else {
                    int ndx = -dy;
                    int ndy = dx;
                    dx = ndx;
                    dy = ndy;
                }
            }

            x += dx;
            y += dy;
        }

        System.out.print(out);
    }

    static void skip() {
        while (pos < expr.length() && expr.charAt(pos) == ' ') pos++;
    }

    static boolean match(String s) {
        skip();
        if (expr.startsWith(s, pos)) {
            pos += s.length();
            return true;
        }
        return false;
    }

    static boolean parseOr() {
        boolean res = parseAnd();

        while (true) {
            skip();
            if (match("OR")) {
                res = res | parseAnd();
            } else {
                return res;
            }
        }
    }

    static boolean parseAnd() {
        boolean res = parseNot();

        while (true) {
            skip();
            if (match("AND")) {
                res = res & parseNot();
            } else {
                return res;
            }
        }
    }

    static boolean parseNot() {
        skip();

        if (match("NOT")) {
            return !parseNot();
        }

        return parseAtom();
    }

    static boolean parseAtom() {
        skip();

        char c = expr.charAt(pos);

        if (c == '(') {
            pos++;
            boolean res = parseOr();
            skip();
            pos++;
            return res;
        }

        if (match("TRUE")) return true;
        if (match("FALSE")) return false;

        pos++;
        return r[c - 'A'];
    }
}
