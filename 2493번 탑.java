import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 2493�� ž
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> tops = new Stack<Integer>();
		Stack<Integer> idx = new Stack<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int i = 0;
		while (st.hasMoreTokens()) {
			i++;
			int top = Integer.parseInt(st.nextToken());
			// ������ ��������� ���ĸ� ������ ���� ����
			if (tops.isEmpty()) {
				tops.push(top);
				idx.push(i);
				bw.write("0 ");
				continue;
			}
			// ���ο� ž�� ���� ž ���� ���ٸ�
			else if(tops.peek() < top) {
				// ���ο� ž���� ���� ž�� ���� ����.
				while (tops.isEmpty() == false) {
					if (tops.peek() < top) {
						tops.pop();
						idx.pop();
					}
					else {
						break;
					}
				}
				// ž�� ���� ������ ���� �� ���� ����.
				if (tops.isEmpty()) {
					bw.write("0 ");
				}
				// ������ ž�� �ִٸ� ž�� ��ȣ�� ���
				else {
					bw.write(idx.peek() + " ");
				}
			}
			// ���� ž�� ���ο� ž���� �� ũ�� ������ ���� ���� �� �ִ�.
			// ���� ž�� ��ȣ�� ���
			else {
				bw.write(idx.peek() + " ");
			}
			// �� �� ���� ž�� �߰�
			tops.push(top);
			idx.push(i);
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
