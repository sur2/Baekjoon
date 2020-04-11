import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 1406�� ������
public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static StringBuilder input = new StringBuilder("");
	private static int commandLine = 0;
	private static StringBuilder command = new StringBuilder("");
	private static char word = 0;
	
	private static Stack<Character> LeftStack = new Stack<Character>();
	private static Stack<Character> RightStack = new Stack<Character>();
	private static StringBuilder output = new StringBuilder("");
	
	public static void main(String[] args) throws IOException {
		input.append(br.readLine());
		commandLine = Integer.parseInt(br.readLine());

		int len = input.length();
		
		// �Է¹��� ���ڿ��� ���ʽ��ÿ� ����
		for (int i = 0; i < len; i++) {
			LeftStack.push(input.charAt(i));
		}
		
		// ���� ���ð� ������ ������ ���� �̾� ���� �÷� �� ���̰� Ŀ���� �ȴ�.
		for (int c = 0; c < commandLine; c++) {
			command.append(br.readLine());
			char c0 = command.charAt(0);
			if (c0 == 'P') {
				word = command.charAt(2);
				// ���ڰ� �߰� �� �� ���� ���ÿ� ���̸鼭 �ڵ����� Ŀ���� �̵��ϴ� ��
				LeftStack.push(word);
			}
			if (c0 == 'L' && !LeftStack.isEmpty()) {
				// �������� Ŀ�� �̵��� ���� ���ÿ��� �� ĭ ���� ������ ������ �� ĭ �ø��� ��
				RightStack.push(LeftStack.pop());
			}
			if (c0 == 'D' && !RightStack.isEmpty()) {
				// ���������� Ŀ�� �̵��� ������ ���ÿ��� �� ĭ ���� ���� ������ �� ĭ �ø��� ��
				LeftStack.push(RightStack.pop());
			}
			if (c0 == 'B') {
				// ���ڴ� Ŀ���� ���� �������� �����ϱ� ������ ���� ������ push
				if (!LeftStack.isEmpty()) {
					LeftStack.pop();
				}
			}
			command = new StringBuilder("");
		}
		
		// ���� ���� �������� ������ �������� �װ�
		while (!LeftStack.isEmpty()) {
			RightStack.push(LeftStack.pop());
		}
		// ������ ������ ���������� ���� ���ڿ� �ϼ�
		while (!RightStack.isEmpty()) {
//			System.out.print(RightStack.pop());
			output.append(RightStack.pop());
		}
		
		bw.write(output.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
