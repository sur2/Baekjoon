import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 1406번 에디터
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
		
		// 입력받은 문자열을 왼쪽스택에 저장
		for (int i = 0; i < len; i++) {
			LeftStack.push(input.charAt(i));
		}
		
		// 왼쪽 스택과 오른쪽 스택의 끝을 이어 붙은 꼴로 그 사이가 커서가 된다.
		for (int c = 0; c < commandLine; c++) {
			command.append(br.readLine());
			char c0 = command.charAt(0);
			if (c0 == 'P') {
				word = command.charAt(2);
				// 문자가 추가 될 때 왼쪽 스택에 쌓이면서 자동으로 커서가 이동하는 꼴
				LeftStack.push(word);
			}
			if (c0 == 'L' && !LeftStack.isEmpty()) {
				// 왼쪽으로 커서 이동은 왼쪽 스택에서 한 칸 비우고 오른쪽 스택을 한 칸 늘리는 꼴
				RightStack.push(LeftStack.pop());
			}
			if (c0 == 'D' && !RightStack.isEmpty()) {
				// 오른쪽으로 커서 이동은 오른쪽 스택에서 한 칸 비우고 왼쪽 스택을 한 칸 늘리는 꼴
				LeftStack.push(RightStack.pop());
			}
			if (c0 == 'B') {
				// 문자는 커서의 왼쪽 기준으로 삭제하기 때문에 왼쪽 스택을 push
				if (!LeftStack.isEmpty()) {
					LeftStack.pop();
				}
			}
			command = new StringBuilder("");
		}
		
		// 남은 왼쪽 스택을을 오른쪽 스택으로 쌓고
		while (!LeftStack.isEmpty()) {
			RightStack.push(LeftStack.pop());
		}
		// 오른쪽 스택을 순차적으로 비우면 문자열 완성
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
