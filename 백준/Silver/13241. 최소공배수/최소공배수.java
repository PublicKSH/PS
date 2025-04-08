import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            System.out.println(lcm(a,b));
    }

    static long gcd(long a, long b) {
        long r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
