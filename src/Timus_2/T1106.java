package Timus_2;

import java.io.*;
import java.util.*;

public class T1106 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[][] friend = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            while (true) {
                int x = sc.nextInt();
                if (x == 0) break;
                friend[i][x - 1] = true;
                friend[x - 1][i] = true;
            }
        }

        boolean[] team = new boolean[n];

        while (true) {
            boolean changed = false;

            for (int i = 0; i < n; i++) {
                boolean ok = false;

                for (int j = 0; j < n; j++) {
                    if (friend[i][j] && team[i] != team[j]) {
                        ok = true;
                        break;
                    }
                }

                if (!ok) {
                    team[i] = !team[i];
                    changed = true;
                }
            }

            if (!changed) break;
        }

        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (team[i]) {
                count++;
                ans.append(i + 1).append(' ');
            }
        }

        System.out.println(count);
        if (count > 0) {
            System.out.println(ans.toString().trim());
        }
    }
}
