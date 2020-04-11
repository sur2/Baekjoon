import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1019�� å ������
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Long.parseLong(br.readLine());
		
		// ���� ������
		long start = 1;
		// �� ������
		long end = N;
		// ���� �� �� �ڸ���
		int digits = 1;
		// 0���� 9���� ���� ���� �迭
		long zeroToNine[] = new long[10];
		
		while(start <= end) {
			// start�� �������� 0�� �� ������ start�� ����
			while(start <= end && start % 10 != 0) {
				calcurate(start++, zeroToNine, digits);
			}
			// ���� ����
			if (start > end) {
				break;
			}
			// end�� �������� 9�� �� ������ end�� ����
			while(start <= end && end % 10 != 9) {
				calcurate(end--, zeroToNine, digits);
			}
			// 1 <= start <= end <= N ����
			// start % 10 == 0 && end % 10 == 0 ����
			// �� ���ҿ� ���� Ƚ���� ����
			for (int i = 0; i < 10; i++) {
				zeroToNine[i] += digits * (end / 10 - start / 10 + 1);
			}
			// �ڸ� �� �̵��� ���� ���������� ����Ʈ
			start /= 10;
			end /= 10;
			digits *= 10;
		}
		// �迭�� ��� ���� ���
		for (int i = 0; i < 10; i++) {
			bw.write(zeroToNine[i]+" ");
		}
		bw.write("\r\n");
		bw.flush();
		bw.close();
	}
	
	// �ڸ� ���� ���� ���� ���� Ƚ���� �����ϴ� �Լ�
	private static void calcurate(long number, long array[], int digit) {
		while (number > 0) {
			int n = (int) (number % 10);
			array[n] += digit;
			number /= 10;
		}
	}

}
