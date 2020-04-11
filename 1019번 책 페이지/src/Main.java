import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1019번 책 페이지
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Long.parseLong(br.readLine());
		
		// 시작 페이지
		long start = 1;
		// 끝 페이지
		long end = N;
		// 왼쪽 맨 끝 자리수
		int digits = 1;
		// 0부터 9까지 수를 담은 배열
		long zeroToNine[] = new long[10];
		
		while(start <= end) {
			// start의 나머지가 0이 될 때까지 start를 증가
			while(start <= end && start % 10 != 0) {
				calcurate(start++, zeroToNine, digits);
			}
			// 종료 조건
			if (start > end) {
				break;
			}
			// end의 나머지가 9가 될 때까지 end를 감소
			while(start <= end && end % 10 != 9) {
				calcurate(end--, zeroToNine, digits);
			}
			// 1 <= start <= end <= N 만족
			// start % 10 == 0 && end % 10 == 0 만족
			// 각 원소에 등장 횟수를 저장
			for (int i = 0; i < 10; i++) {
				zeroToNine[i] += digits * (end / 10 - start / 10 + 1);
			}
			// 자리 수 이동에 따라 오른쪽으로 쉬프트
			start /= 10;
			end /= 10;
			digits *= 10;
		}
		// 배열에 담긴 원소 출력
		for (int i = 0; i < 10; i++) {
			bw.write(zeroToNine[i]+" ");
		}
		bw.write("\r\n");
		bw.flush();
		bw.close();
	}
	
	// 자리 수에 따른 원소 등장 횟수를 저장하는 함수
	private static void calcurate(long number, long array[], int digit) {
		while (number > 0) {
			int n = (int) (number % 10);
			array[n] += digit;
			number /= 10;
		}
	}

}
