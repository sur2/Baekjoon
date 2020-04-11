import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 1874�� ���� ����
public class Main {

	public static int T = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		// �Է��� ���� �迭
		int[] array = new int[T + 1];
		
		for (int t = 1; t <= T; t++) {
			array[t] = Integer.parseInt(br.readLine());
		}
		
		// ������ ������ �̿��ϱ� ���� ���� ����
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder output = new StringBuilder("+\n");

		// ���ÿ� ���� ����
		int number = 1;
		// �Է� ���� ���� index
		int index = 1;
		// ó���� ���� 1�� �ݵ�� �ֱ� ������ push
		stack.push(number);
		
		int count = 0;
		// �ݺ����� Ƚ���� �ִ� push�� pop�� ���޾� �Ͼ �Էµ� ������ �� ��
		while(count < 2 * T + 1) {
			count++;
			// ������ ����� ���� ���� ��� ������ ������ ���ڿ� �Է¹��� ���ڰ� ������ pop
			if (!stack.isEmpty() && index < T + 1 && stack.peek() == array[index]) {
				stack.pop();
				output.append("-\n");
				index++;
			}
			// �Է¹��� ���ڿ� ���� �ʴٸ� push
			else if(index < T + 1) {
				number++;
				stack.push(number);
				output.append("+\n");
			}
		}
		// ������ ���������� ����� ���ٸ� ������ ����� �ִ�.
		if (stack.isEmpty()) {
			bw.write(output.toString());
		}else {
			bw.write("NO");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
