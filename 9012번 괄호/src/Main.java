import java.util.Scanner;
import java.util.Stack;

// 9012�� ��ȣ
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
				
				// '(' �� �� ���ÿ� push
				if (parenthesis == '(') {
					stack.push(parenthesis);
				} 
				// ')' �� ��
				else {
					// ������ �̹� ����� �ִٸ� ¦�� ���� �ʾ� �ݺ��� Ż��
					if (stack.isEmpty()) {
						// �̹� ������ٴ� ���� �˸�
						flag = true;
						break;
					} 
					// ���ÿ� pop 
					else {
						stack.pop();
					}
				}
			}
			
			// �ݺ����� �� ���� ������ ������ �� ������ٸ� VPS
			if (stack.isEmpty() && flag == false) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}

}
