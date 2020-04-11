import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1629¹ø °ö¼À
public class Main {

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static long A;
	private static long B;
	private static long C;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		A = Integer.parseInt(input.split(" ")[0]);
		B = Integer.parseInt(input.split(" ")[1]);
		C = Integer.parseInt(input.split(" ")[2]);

		bw.write("" + pow_mod_loop(A, B, C));

		br.close();
		bw.flush();
		bw.close();
	}

	// ºĞÇÒÁ¤º¹ °ÅµìÁ¦°ö
	private static long pow(long a, long b) {
		if (b == 0) {
			return 1;
		}
		long result = pow(a, b / 2);
		if (b % 2 == 0) {
			return result * result;
		} else {
			return a * result * result;
		}
	}

	// ºĞÇÒÁ¤º¹ °ÅµìÁ¦°ö ³ª¸ÓÁö ¿¬»ê
	private static long pow_mod(long a, long b, long c) {
		if (b == 0) {
			return c > 1 ? 1 : 0;
		}
		long result = pow_mod(a, b / 2, c);
		if (b % 2 == 0) {
			return result * result % c;
		} else {
			return (a % c) * (result * result % c) % c;
		}
	}

	// ºĞÇÒÁ¤º¹ °ÅµìÁ¦°ö ³ª¸ÓÁö ¿¬»ê ¹İº¹¹®
	private static long pow_mod_loop(long a, long b, long c) {
		long result = 1;

		while (b > 0) {
			if (b % 2 == 1) {
				result *= a;
				result %= c;
			}
			a *= a;
			a %= c;
			b /= 2;
		}

		return result;
	}

}
