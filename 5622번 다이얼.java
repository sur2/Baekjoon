import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 5622�� ���̾�
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int answer = 0;
		
		for (int i = 0; i < input.length(); i++) {
			answer += toNumber(input.charAt(i)) + 1;
		}
		
		br.close();
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int toNumber(char ch) {
		// 2������ 9������ ���ĺ� ��
		int[] filter = { 3, 3, 3, 3, 3, 4, 3, 4};
		int num = ch - 65;
		int max = 0;
		// ���� ������� ���ĺ� ������ ���ϸ鼭 �Է¹��� ���ڿ� ���͸� �Ǵ��� Ȯ��
		// ��) ���ĺ� 'D'�� ��  
		// num = 3
		// i = 0, max = 3, 3 < 3 : false
		// i = 1, max = 6, 3 < 6 : true 
		// for�� ���� �Լ� ����
		for (int i = 0; i < filter.length; i++) {
			max += filter[i];
			if (num < max) {
				return i + 2;
			}
		}
		return 0;
	}

}
