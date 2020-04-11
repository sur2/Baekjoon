import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2447�� �� ��� - 10
public class Main {

	private static BufferedReader br = null;
	private static BufferedWriter bw = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// �Է¹��� �� (3�� ���)
		int input = Integer.parseInt(br.readLine());
		
		// �Է¹��� �� ��ū ���簢���� 2���� �迭�� ����� ���� �� ĭ���� �ʱ�ȭ�Ѵ�.
		char[][] arr = new char[input][input];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		}
		recursive(input, arr, 0, 0);
		print_arr(arr);
	}
	
	// �ϼ��� �迭�� ����ϴ� �Լ��̴�.
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

	// ����Լ��̴�. ū �׸��� �����̵Ǵ� ���� �׸��� ���ȣ��� �׸���.
	// input�� �Է¹��� ��, arr�� ���� ������ 2���� �迭, ii�� jj�� ���ȣ�� �� ���� �׸��� ���۵Ǵ� ù��° ��ġ�̴�.
	public static void recursive(int input, char[][] arr, int ii, int jj) {
		// ��� ȣ�� �� input�� 3���� ������ ���������� 1�� ��  �� ���� ��� ��ȯ�Ѵ�.
		if (input == 1) {
			arr[ii][jj] = '*';
			return;
		}
		// �ݺ����� 3���� ����ǵ��� input�� 3�� ������ŭ �ݺ����� index�� �����Ѵ�.
		int step = input / 3;
		// �׸��� �׸��� ���� �ݺ������̴�.
		int imax = input + ii;
		int jmax = input + jj;
		for (int i = ii; i < imax; i += step) {
			for (int j = jj; j < jmax; j += step) {
				// ���߾� �Ǵ� �����̴�. �ƹ� �͵� �׸��� �ʴ´�.
				if (i == ii + step && j == jj + step) {
					continue;
				}
				// ���� �׸��� �׸��� ���� ���ȣ���Ѵ�.
				recursive(step, arr, i, j);
			}
		}
	}
} 
