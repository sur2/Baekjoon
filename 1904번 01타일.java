import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1904�� 01Ÿ��
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// �ּ� 2�� °(0, 1, 2) �ε������� ���� �ֱ� ���� N + 3�� ��
		long[] DP = new long[N + 3];
		
		// ~1, ~00 �� ������ ������ �� 
		// D[i] = D[i - 1] + D[i - 2]
		DP[0] = 0;
		DP[1] = 1; // 1
		DP[2] = 2; // 11, 00
		
		for (int i = 3; i <= N; i++) {
			//DP[i] = (DP[i - 1] + DP[i - 2]) % 15746;
			DP[i] = (DP[i - 1] % 15746 + DP[i - 2] % 15746) % 15746;
		}
		
		br.close();
		bw.write(DP[N] + "\n");
		bw.flush();
		bw.close();
	}

}
