package Timus;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class T1409 {
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        byte Harry, Larry, Sum;

        Harry=in.nextByte();
        Larry = in.nextByte();
        in.close();
        Sum = (byte) (Harry+Larry-1);
        Harry = (byte) (Sum-Harry);
        Larry = (byte) (Sum-Larry);
        System.out.print(Harry+" "+Larry);
        out.flush();
    }
}
