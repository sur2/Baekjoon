import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 1874번 스택 수열
public class Main {

	public static int T = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		// 입력을 담을 배열
		int[] array = new int[T + 1];
		
		for (int t = 1; t <= T; t++) {
			array[t] = Integer.parseInt(br.readLine());
		}
		
		// 스택의 원리를 이용하기 위해 스택 선언
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder output = new StringBuilder("+\n");

		// 스택에 넣을 숫자
		int number = 1;
		// 입력 받은 수의 index
		int index = 1;
		// 처음에 숫자 1을 반드시 넣기 때문에 push
		stack.push(number);
		
		int count = 0;
		// 반복문의 횟수는 최대 push와 pop이 연달아 일어나 입력된 정수의 두 배
		while(count < 2 * T + 1) {
			count++;
			// 스택이 비워져 있지 않은 경우 스택의 마지막 숫자와 입력받은 숫자가 같으면 pop
			if (!stack.isEmpty() && index < T + 1 && stack.peek() == array[index]) {
				stack.pop();
				output.append("-\n");
				index++;
			}
			// 입력받은 숫자와 같지 않다면 push
			else if(index < T + 1) {
				number++;
				stack.push(number);
				output.append("+\n");
			}
		}
		// 수열이 정상적으로 만들어 졌다면 스택은 비워져 있다.
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
