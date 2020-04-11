import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 1406번 에디터
public class Main2 {

	private static Scanner sc = new Scanner(System.in);

	private static String input = "";
	private static int commandLine = 0;
	private static String command;
	private static char word;
	private static int cursor = 0;

	private static List<Character> list = new LinkedList<Character>();
	private static String output = "";

	public static void main(String[] args) {
		input = sc.nextLine();
		commandLine = sc.nextInt();
		sc.nextLine();
		int len = input.length();
		for (int i = 0; i < len; i++) {
			list.add(input.charAt(i));
		}
		cursor = len;
		for (int c = 0; c < commandLine; c++) {
			command = sc.nextLine();
			char c0 = command.charAt(0);
			if (c0 == 'L' && cursor > 0) {
				cursor--;
			}
			if (c0 == 'D' && cursor < list.size()) {
				cursor++;
			}
			if (c0 == 'B') {
				if (cursor > 0) {
					list.remove(--cursor);
				}
			}
			if (c0 == 'P') {
				word = command.charAt(2);
				list.add(cursor++, word);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}