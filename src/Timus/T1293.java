package Timus;
import java.io.*;
import java.util.*;
public class T1293 {
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        int N,A,B;
        N=in.nextInt();
        A=in.nextInt();
        B=in.nextInt();
        int SulfidWeight = N*A*B*2;
        in.close();

        System.out.print(SulfidWeight);
        out.flush();
    }
}
