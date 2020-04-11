import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2447번 별 찍기 - 10
public class Main {

	private static BufferedReader br = null;
	private static BufferedWriter bw = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력받은 수 (3의 배수)
		int input = Integer.parseInt(br.readLine());
		
		// 입력받의 수 만큰 정사각형의 2차원 배열을 만들어 전부 빈 칸으로 초기화한다.
		char[][] arr = new char[input][input];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		}
		recursive(input, arr, 0, 0);
		print_arr(arr);
	}
	
	// 완성된 배열을 출력하는 함수이다.
	public static void print_arr(char[][] arr) throws IOException {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	// 재귀함수이다. 큰 그림의 구성이되는 작은 그림을 재귀호출로 그린다.
	// input을 입력받은 수, arr은 별이 찍히는 2차원 배열, ii와 jj는 재귀호출 시 작은 그림이 시작되는 첫번째 위치이다.
	public static void recursive(int input, char[][] arr, int ii, int jj) {
		// 재귀 호출 시 input을 3으로 나누어 최종적으로 1이 될  때 별을 찍고 반환한다.
		if (input == 1) {
			arr[ii][jj] = '*';
			return;
		}
		// 반복문이 3번씩 진행되도록 input에 3을 나눈만큼 반복문의 index가 증가한다.
		int step = input / 3;
		// 그림을 그리기 위한 반복구간이다.
		int imax = input + ii;
		int jmax = input + jj;
		for (int i = ii; i < imax; i += step) {
			for (int j = jj; j < jmax; j += step) {
				// 정중앙 되는 지점이다. 아무 것도 그리지 않는다.
				if (i == ii + step && j == jj + step) {
					continue;
				}
				// 작은 그림을 그리기 위해 재귀호출한다.
				recursive(step, arr, i, j);
			}
		}
	}
} 
