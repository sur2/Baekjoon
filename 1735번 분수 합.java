import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1735번 분수 합
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input1 = br.readLine();
		String input2 = br.readLine();

		// 첫 번째 수 분자, 분모
		int numerator1 = Integer.parseInt(input1.split(" ")[0]);
		int denominator1 = Integer.parseInt(input1.split(" ")[1]);

		// 두 번째 수 분자, 분모
		int numerator2 = Integer.parseInt(input2.split(" ")[0]);
		int denominator2 = Integer.parseInt(input2.split(" ")[1]);
		
		// 새로운 분모 : 최소 공배수
		int denominator = LCM(denominator1, denominator2);
		// 새로운 분자
		int numerator = denominator / denominator1 * numerator1 + denominator / denominator2 * numerator2;

		// 새로운 분자, 분모 기약분수로 만들기
		int gcd = GCD(denominator, numerator);
		bw.write(numerator/gcd + " " + denominator/gcd);

		br.close();
		bw.flush();
		bw.close();
	}

	// 유클리드 호제법
	// a = b*q1 + r1 (0 < r1 < a)
	// b = r1*q2 + r2 (0 < r2 < r1)
	// r1 = r2*q3 + r3 (0 < r3 < r2)
	// ...
	// rn-2 = rn-1*qn + rn (0 < rn < rn-1)
	// rn-1 = rn*qn+1 + rn+1 (rn+1 = 0 < rn)
	// rn-1 = rn*qn+1
	// gcd(a, b) = rn

	// 유클리드 호제법(반복문)
	private static int GCD(int a, int b) {

		// 나머지가 0이 될 때까지 반복
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}

	// 유클리드 호제법(재귀함수)
	private static int recursiveGCD(int a, int b) {
		/*
		if (a % b == 0) {
			return b;
		}
		return recursiveGCD(b, a % b);
		*/
		return a % b == 0 ? b : recursiveGCD(b, a % b);
	}
	
	
	// 최소공배수
	private static int LCM(int a, int b) {
		return a * b / recursiveGCD(a, b);
	}
}
