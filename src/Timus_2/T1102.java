package Timus_2;

import java.io.*;

public class T1102 {
    static final byte[][] WORDS = {
            {'o','u','t'},
            {'o','u','t','p','u','t'},
            {'p','u','t','o','n'},
            {'i','n'},
            {'i','n','p','u','t'},
            {'o','n','e'}
    };

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        StringBuilder ans = new StringBuilder();

        for (int t = 0; t < n; t++) {
            ans.append(fs.checkWord() ? "YES" : "NO").append('\n');
        }

        System.out.print(ans);
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
            int c;
            do c = read(); while (c <= ' ');

            int x = 0;
            while (c > ' ') {
                x = x * 10 + c - '0';
                c = read();
            }
            return x;
        }

        boolean checkWord() throws IOException {
            byte[] last = new byte[6];
            boolean[] dp = new boolean[7];

            dp[0] = true;
            int pos = 0;

            int c;
            do c = read(); while (c <= ' ');

            while (c > ' ') {
                pos++;
                last[pos % 6] = (byte)c;

                boolean ok = false;

                for (byte[] w : WORDS) {
                    int l = w.length;
                    if (pos >= l && dp[(pos - l) % 7]) {
                        boolean same = true;

                        for (int i = 0; i < l; i++) {
                            int p = pos - l + 1 + i;
                            if (last[p % 6] != w[i]) {
                                same = false;
                                break;
                            }
                        }

                        if (same) {
                            ok = true;
                            break;
                        }
                    }
                }

                dp[pos % 7] = ok;
                c = read();
            }

            return dp[pos % 7];
        }
    }
}
