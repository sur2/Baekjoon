import java.util.Scanner;
import java.util.Stack;

// 9012번 괄호
public class Main {
	
	public static int T = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			String input = sc.nextLine();
			int len = input.length();
			Stack<Character> stack = new Stack<Character>();
			boolean flag = false;
			for (int i = 0; i < len; i++) {
				char parenthesis = input.charAt(i);
				
				// '(' 일 때 스택에 push
				if (parenthesis == '(') {
					stack.push(parenthesis);
				} 
				// ')' 일 때
				else {
					// 스택이 이미 비워져 있다면 짝이 맞이 않아 반복문 탈출
					if (stack.isEmpty()) {
						// 이미 비워졌다는 것을 알림
						flag = true;
						break;
					} 
					// 스택에 pop 
					else {
						stack.pop();
					}
				}
			}
			
			// 반복문을 다 돌고 나서야 스택이 다 비워졌다면 VPS
			if (stack.isEmpty() && flag == false) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}

}
