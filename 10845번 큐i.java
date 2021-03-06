import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 10845�� ť
public class Main2 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int N = 0;
	private static StringBuilder command = new StringBuilder();

	private static Queue<Character> queue = new LinkedList<>();
	private static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		
		char last = 0;

		while (N-- != 0) {
			command.append(br.readLine());
			output = new StringBuilder();

			if (command.substring(0, 3).equals("pop")) {
				if (queue.isEmpty()) {
//					output.append("-1");
//					output.append("\n");
					System.out.println("-1");
				} else {
//					output.append(queue.poll());
//					output.append("\n");
					System.out.println(queue.poll());
				}
			} else if (command.substring(0, 4).equals("push")) {
				queue.add(command.charAt(5));
				last = command.charAt(5);
			} else if (command.substring(0, 4).equals("size")) {
//				output.append(queue.size());
//				output.append("\n");
				System.out.println(queue.size());
			} else if (command.substring(0, 4).equals("back")) {
				if (queue.isEmpty()) {
//					output.append("-1");
//					output.append("\n");
					System.out.println("-1");
				} else {
//					output.append(last);
//					output.append("\n");
					System.out.println(last);
				}
			} else if (command.substring(0, 5).equals("empty")) {
				if (queue.isEmpty()) {
//					output.append("1");
//					output.append("\n");
					System.out.println("1");
				} else {
//					output.append(0);
//					output.append("\n");
					System.out.println("0");
				}
			} else if (command.substring(0, 5).equals("front")) {
				if (queue.isEmpty()) {
//					output.append("-1");
//					output.append("\n");
					System.out.println("-1");
				} else {
//					output.append(queue.peek());
//					output.append("\n");
					System.out.println(queue.peek());
				}
			}
				command = new StringBuilder();
				bw.write(output.toString());
				bw.flush();
		}
		bw.close();
		br.close();
	}

}
