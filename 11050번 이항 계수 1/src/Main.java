import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11050번 이항 계수 1
public class Main {
	
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int n = Integer.parseInt(input.split(" ")[0]);
		int k = Integer.parseInt(input.split(" ")[1]);
		
		// 분자
		long numerator = NtoK(n, k);
		// 분모
		long denominator = nFactorial(k); 
		
		
		long result = numerator/denominator;
	
		bw.write(result + "");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	private static long nFactorial(int n) {
		long result = 1;
		if (n == 0) {
			return result;
		}
		for (int i = 1; i < n + 1; i++) {
			result *= i;
		}
		return result;
	}
	
	private static long NtoK(int n, int k) {
		long result = 1;
		if (k == 0) {
			return 1;
		}
		for (int i = n; i > (n - k); i--) {
			result *= i;
		}
		return result;
	}
	
}
