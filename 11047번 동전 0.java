import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 11047�� ���� 0
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		
		int coins[] = new int[N];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coins);
		
		int cnt = 0;
		
		int idx = N - 1;
		// �׸���: ū ���� ���� �Ž��� �ش�. (��, ū �������� ���� �������� ����̴�.)
		// �������� ������ ���� ������ ����, �������� �� ���� �������� �Ž����־�� �� �ݾ��̴�.
		// ������ == �Ž��� ���� ���� �� ���� �ݺ��Ѵ�.
		while(K > 0) {
			cnt += K / coins[idx];
			K = K % coins[idx];
			idx--;
		}
		br.close();
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

}
