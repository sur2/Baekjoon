import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2751�� �� �����ϱ� 2
public class Main {

	// ���� ���� �ӽ� ����
	public static int[] tempArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		tempArr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		sort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			bw.write(String.valueOf(arr[i] + "\n"));
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void sort(int[] arr, int start, int end) {
		if (start < end) {
			// ���Ұ� �ϳ� ���� �� ���� ���
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			// �и��� ������ ���ϸ鼭 ���� �� ����
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		// �ӽ÷� �ʿ��� ���� �ʱ�ȭ
		for (int i = start; i <= end; i++) {
			tempArr[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		// �� ���� �� �� ���̶� ������ �񱳰� �Ϸ�Ǹ� �ݺ� ����
		while (part1 <= mid && part2 <= end) {
			if (tempArr[part1] <= tempArr[part2]) {
				 arr[index++] = tempArr[part1++];
			} else {
				 arr[index++] = tempArr[part2++];
			}
		}
		
		// �� �� ������ ���Ҵٸ� ���� �� ������ ����(�� �� ������ ���Ƶ� ������ �ڿ� ����Ǹ� ���ڸ��̱� ������ �������)
		for (int i = part1; i <= mid; i++, index++) {
			arr[index] = tempArr[i];
		}
	}
}
