import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 1316�� �׷� �ܾ� üĿ
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
			// �׷� �ܾ��� ��� ���� �߰�
			if (isGroup(input[i])) {
				cnt++;
			}
		}
		
		br.close();
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		
	}
	
	public static boolean isGroup(String word) {
		boolean result = false;
		List<Character> charList = new ArrayList<Character>();
		char pre = 0;
		// ������ �� ���ڸ� ��
		for (int i = 0; i < word.length(); i++) {
			char now = word.charAt(i);
			// ������ ������ ���ڿ� �ٸ� ���
			if (now != pre) {
				// ���ڸ���Ʈ�� ���� ���ڸ� ��
				for (char ch : charList) {
					// ���� ���ڰ� ���ڸ���Ʈ�� �ִ� ��� �׷� �ܾ� ����
					if (now == ch) {
						return result;
					}
				}
				// ���� ���ڸ� ���� ���ڷ� �����ϰ�, ���ڸ���Ʈ�� ����
				pre = now;
				charList.add(now);
			}
			// ������ ������ ���ڿ� ���� ��� �׷� �ܾ ���������� ���ٸ� ��ġ�� ���� ����
		}
		// ��� ���ڸ� ��ȸ�Ͽ� ���ٸ� ��ġ�� ���� ���� ��� �׷� �ܾ�� �Ǵ�
		result = true;
		return result;
	}

}
