import java.util.Scanner;
import java.util.Stack;

// 9093번 단어 뒤집기
public class Main {

	private static int T = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		sc.nextLine();

		for (int t = 1; t <= T; t++) {
			
			// 문장 입력
			String input = sc.nextLine();
			
			// 단어를 담을 스택
			Stack<Character> sentence = new Stack<Character>();

			int len = input.length();
			
			// 단어를 스택에 담기 시작
			for (char temp : input.toCharArray()) {
				// 띄어쓰기가 있을 경우 스택를 비워 출력(선입후출)
				if (temp == ' ') {
					while (!sentence.isEmpty()) {
						System.out.print(sentence.pop());
					}
					System.out.print(" ");
				} else {
					sentence.push(temp);
				}
			}
			// 마지막 스택까지 비워서 역순으로 출력(선입후출)
			while (!sentence.isEmpty()) {
				System.out.print(sentence.pop());
			}
			System.out.println();
		}

		sc.close();
	}
}
