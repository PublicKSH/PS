import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] st = br.readLine().split(" ");
        String n = st[0];
        int b = Integer.parseInt(st[1]);

        // Integer.parseInt를 이용하여 간단히 진법 변환
        int result = Integer.parseInt(n, b);

        System.out.println(result);
    }
}
