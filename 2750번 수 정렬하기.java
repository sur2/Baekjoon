import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2750�� �� �����ϱ�
public class Main {
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sorting(0, N - 1);
		
		br.close();
		for (int i = 0; i < N; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void sorting(int left, int right) {
		// ������ ������ ����
		int part2 = partition(left, right);
		if (left < part2 - 1) {
			sorting(left, part2 - 1);
		}
		if (part2 < right) {
			sorting(part2, right);
		}
	}
	
	public static int partition(int left, int right) {
		// ���ذ� ���� ���� �� ��Ƽ�� ���� (���ذ��� �߾Ӱ��� �ʿ�� ����)
		int pivot = arr[(left + right) / 2];
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void swap(int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
