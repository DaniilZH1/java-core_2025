package Timus;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class T1785 {
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        int n;
        String count = null;
        n=in.nextInt();
        in.close();

        if (n >= 1 && n <= 4) {count = "few";}
        else if (n >= 5 && n <= 9) {count = "several";}
        else if (n >= 10 && n <= 19) {count = "pack";}
        else if (n >= 20 && n <= 49) {count = "lots";}
        else if (n >= 50 && n <= 99) {count = "horde";}
        else if (n >= 100 && n <= 249) {count = "throng";}
        else if (n >= 250 && n <= 499) {count = "swarm";}
        else if (n >= 500 && n <= 999) {count = "zounds";}
        else if (n >= 1000) {count = "legion";}
        System.out.print(count);
        out.flush();
    }
}
