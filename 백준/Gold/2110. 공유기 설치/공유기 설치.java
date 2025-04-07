import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;  // 가능한 최소 거리
        int end = arr[N - 1] - arr[0];  // 가능한 최대 거리
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2; // 공유기 사이의 거리
            int count = 1; // 첫 번째 집에는 공유기를 무조건 설치
            int lastInstalled = arr[0]; // 마지막으로 설치한 위치

            for (int i = 1; i < N; i++) {
                if (arr[i] >= lastInstalled + mid) { 
                    count++;
                    lastInstalled = arr[i];
                }
            }

            if (count >= C) { 
                result = mid;
                start = mid + 1; // 더 넓은 거리 시도
            } else {
                end = mid - 1; // 더 좁은 거리 시도
            }
        }

        System.out.println(result);
    }
}
