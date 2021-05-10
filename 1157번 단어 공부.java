import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1157�� �ܾ� ����
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// ���ĺ� ����
		int[] alpha = new int[26];
		
		String input = br.readLine();
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			// 'A' = 65
			// 'Z' = 90
			// 'a' = 97
			// 'z' = 122
			
			// ��ҹ��� �����Ͽ� ���ĺ��� ������ �迭�� ����
			if (ch > 90) {
				alpha[ch - 97]++;
			}
			else {
				alpha[ch - 65]++;
			}
		}
		
		int max = 0;
		int imax = 0;
		// �ִ밪�� �ε����� ���ϱ� ���� ����
		int sameIndex = 0;
		
		for (int i = 0; i < alpha.length; i++) {
			if (max < alpha[i]) {
				max = alpha[i];
				// �ִ밪�� �ε��� ����
				imax = i;
			}
			// �ִ밪�� ���� ���� ��ġ�� ����
			// �� ���� �ִ밪�� �ε����� �ٸ��ٸ� �ִ밪�� ���� ���� �� �������� �ǹ�
			if (max == alpha[i]) {
				sameIndex = i;
			}
		}
		
		// �ִ밪�� �� �� �̻�
		if (sameIndex != imax) {
			bw.write("?\n");
		}
		else {
			bw.write(imax + 65);
		}
		br.close();
		bw.flush();
		bw.close();
	
	}

}
