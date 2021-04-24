import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 2493번 탑
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
			// 스택이 비어있으면 전파를 수신할 곳이 없음
			if (tops.isEmpty()) {
				tops.push(top);
				idx.push(i);
				bw.write("0 ");
				continue;
			}
			// 새로운 탑이 이전 탑 보다 높다면
			else if(tops.peek() < top) {
				// 새로운 탑보다 작은 탑은 전부 비운다.
				while (tops.isEmpty() == false) {
					if (tops.peek() < top) {
						tops.pop();
						idx.pop();
					}
					else {
						break;
					}
				}
				// 탑이 남지 않으면 수신 할 곳이 없다.
				if (tops.isEmpty()) {
					bw.write("0 ");
				}
				// 수신할 탑이 있다면 탑의 번호를 출력
				else {
					bw.write(idx.peek() + " ");
				}
			}
			// 이전 탑이 새로운 탑보다 더 크기 때문에 수신 받을 수 있다.
			// 이전 탑의 번호를 출력
			else {
				bw.write(idx.peek() + " ");
			}
			// 매 턴 마다 탑을 추가
			tops.push(top);
			idx.push(i);
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
