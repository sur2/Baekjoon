import java.util.Scanner;
import java.util.Stack;

// 9093�� �ܾ� ������
public class Main {

	private static int T = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		sc.nextLine();

		for (int t = 1; t <= T; t++) {
			
			// ���� �Է�
			String input = sc.nextLine();
			
			// �ܾ ���� ����
			Stack<Character> sentence = new Stack<Character>();

			int len = input.length();
			
			// �ܾ ���ÿ� ��� ����
			for (char temp : input.toCharArray()) {
				// ���Ⱑ ���� ��� ���ø� ��� ���(��������)
				if (temp == ' ') {
					while (!sentence.isEmpty()) {
						System.out.print(sentence.pop());
					}
					System.out.print(" ");
				} else {
					sentence.push(temp);
				}
			}
			// ������ ���ñ��� ����� �������� ���(��������)
			while (!sentence.isEmpty()) {
				System.out.print(sentence.pop());
			}
			System.out.println();
		}

		sc.close();
	}
}
