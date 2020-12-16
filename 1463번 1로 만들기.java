import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 1463번 1로 만들기
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		/*
		1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
		2. X가 2로 나누어 떨어지면, 2로 나눈다.
		3. 1을 뺀다.
		*/
		
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		dp[1] = 0;
		
		// i일 때 1을 만들 수 있는 최소값 dp[i]
		for (int i = 2; i < N + 1; i++) {
			// 적어도 1을 빼기 때문에 횟수 증가
			dp[i] = dp[i - 1] + 1;
			// 2로 나누어 떨어진다면 이전 값에서 하나 더한 것과  2로 나눈 수에서 하나 더 한 것 중 더 작은 것을 선택
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			// 3으로 나누어서 떨어질 때도 마찬가지
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
		}
		
		br.close();
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();	
	}
}
