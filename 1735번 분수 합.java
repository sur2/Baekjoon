import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1735�� �м� ��
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input1 = br.readLine();
		String input2 = br.readLine();

		// ù ��° �� ����, �и�
		int numerator1 = Integer.parseInt(input1.split(" ")[0]);
		int denominator1 = Integer.parseInt(input1.split(" ")[1]);

		// �� ��° �� ����, �и�
		int numerator2 = Integer.parseInt(input2.split(" ")[0]);
		int denominator2 = Integer.parseInt(input2.split(" ")[1]);
		
		// ���ο� �и� : �ּ� �����
		int denominator = LCM(denominator1, denominator2);
		// ���ο� ����
		int numerator = denominator / denominator1 * numerator1 + denominator / denominator2 * numerator2;

		// ���ο� ����, �и� ���м��� �����
		int gcd = GCD(denominator, numerator);
		bw.write(numerator/gcd + " " + denominator/gcd);

		br.close();
		bw.flush();
		bw.close();
	}

	// ��Ŭ���� ȣ����
	// a = b*q1 + r1 (0 < r1 < a)
	// b = r1*q2 + r2 (0 < r2 < r1)
	// r1 = r2*q3 + r3 (0 < r3 < r2)
	// ...
	// rn-2 = rn-1*qn + rn (0 < rn < rn-1)
	// rn-1 = rn*qn+1 + rn+1 (rn+1 = 0 < rn)
	// rn-1 = rn*qn+1
	// gcd(a, b) = rn

	// ��Ŭ���� ȣ����(�ݺ���)
	private static int GCD(int a, int b) {

		// �������� 0�� �� ������ �ݺ�
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}

	// ��Ŭ���� ȣ����(����Լ�)
	private static int recursiveGCD(int a, int b) {
		/*
		if (a % b == 0) {
			return b;
		}
		return recursiveGCD(b, a % b);
		*/
		return a % b == 0 ? b : recursiveGCD(b, a % b);
	}
	
	
	// �ּҰ����
	private static int LCM(int a, int b) {
		return a * b / recursiveGCD(a, b);
	}
}
