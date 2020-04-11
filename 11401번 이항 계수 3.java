import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11401�� ���� ��� 3
public class Main {

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static int N;
	private static int K;

	private static final long P = 1000000007;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		N = Integer.parseInt(input.split(" ")[0]);
		K = Integer.parseInt(input.split(" ")[1]);

		long result = 0; // AB^(P-2) % P

		long N_KfactorialToModular = 0; // (N-K)! % P
		long KfactorialToModular = 0; // K! % P

		long A = 1; // N! % P
		long B = 1; // {(N-K)!*K!}^(P-2) % P

		// N! % P
		A = factorialToModular(N, P);
		// (N-K)! % P
		N_KfactorialToModular = factorialToModular(N - K, P);
		// K! % P
		KfactorialToModular = factorialToModular(K, P);

		// {(N-K)! % P * K! % P} % P
		B = N_KfactorialToModular * KfactorialToModular % P;
		
		// AB^(P-2) % P
		result = A * powToModular(B, P-2, P) % P;
		
		bw.write(result+"");
		br.close();
		bw.flush();
		bw.close();

	}

	// �ŵ������� �������� ������������ ���ϴ� �Լ�(��Ͱ� �ƴ� �ݺ����� ����)
	private static long powToModular(long x, long y, long p) {
		long result = 1;

		while (y > 0) {
			if (y % 2 == 1) {
				result *= x;
				result %= p;
			}
			x *= x;
			x %= p;
			y /= 2;
		}
		return result;
	}

	// ������ ������ ���� Ư¡�� �̿��� ���丮�� ������ ����
	private static long factorialToModular(long number, long p) {
		long result = 1;
		if (number == 0) {
			return 1;
		}
		for (int i = 1; i <= number; i++) {
			result *= i;
			result %= p;
		}
		return result;
	}
}
