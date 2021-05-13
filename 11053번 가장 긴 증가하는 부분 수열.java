import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11053�� ���� �� �����ϴ� �κ� ����
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
				// 0(j) ��° ���� ���� ��(i ��°)���� �ϳ��� ���Ͽ� ���̺� ����
				// i ��° ���� �� ũ�ٸ� ���� ���� j ��° + 1�� ���Ͽ� �� ū ������ ����
				if (numbers[i] > numbers[j]) {
					DP[i] = Math.max(DP[i], DP[j] + 1);
				}
			}
			// ���� ū ���� ã��
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
