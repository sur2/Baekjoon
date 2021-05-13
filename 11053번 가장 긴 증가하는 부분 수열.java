import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11053번 가장 긴 증가하는 부분 수열
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		int[]DP = new int[N];
		Arrays.fill(DP, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				// 0(j) 번째 부터 기준 값(i 번째)까지 하나씩 비교하여 테이블 갱신
				// i 번째 값이 더 크다면 현재 값과 j 번째 + 1과 비교하여 더 큰 것으로 갱신
				if (numbers[i] > numbers[j]) {
					DP[i] = Math.max(DP[i], DP[j] + 1);
				}
			}
			// 가장 큰 값을 찾음
			if (answer < DP[i]) {
				answer = DP[i];
			}
		}

		br.close();
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}

}
