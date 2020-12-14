import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2839¹ø ¼³ÅÁ ¹è´Þ
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[5001];

		Arrays.fill(dp, 1700);
		
		dp[3] = 1;
		dp[5] = 1;
		
		for (int i = 6; i < N + 1; i++) {
			dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
		}
		
		if(dp[N] >= 1700) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[N]);
		}
	}

}
