import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1152�� �ܾ��� ����
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		char[] buf = input.toCharArray();
		int len = buf.length;
		int cnt = 0;

		// ���� ���� ���� �ܾ �ϳ� �� ����.
		for (int i = 0; i < buf.length; i++) {
			if (buf[i] == ' ') {
				cnt++;
			}
		}

		// ��, ù ��°�� �������� ���Ⱑ �ִ� ���� ����
		if (buf[0] == ' ') {
			cnt--;
		}
		if (buf[len - 1] == ' ') {
			cnt--;
		}
		
		cnt++;
		br.close();
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}

}
