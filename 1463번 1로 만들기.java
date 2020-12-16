import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 1463�� 1�� �����
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		/*
		1. X�� 3���� ������ ��������, 3���� ������.
		2. X�� 2�� ������ ��������, 2�� ������.
		3. 1�� ����.
		*/
		
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		dp[1] = 0;
		
		// i�� �� 1�� ���� �� �ִ� �ּҰ� dp[i]
		for (int i = 2; i < N + 1; i++) {
			// ��� 1�� ���� ������ Ƚ�� ����
			dp[i] = dp[i - 1] + 1;
			// 2�� ������ �������ٸ� ���� ������ �ϳ� ���� �Ͱ�  2�� ���� ������ �ϳ� �� �� �� �� �� ���� ���� ����
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			// 3���� ����� ������ ���� ��������
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
		}
		
		br.close();
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();	
	}
}
