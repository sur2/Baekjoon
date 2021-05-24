import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2751번 수 정렬하기 2
public class Main {

	// 병합 정렬 임시 공간
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
			// 원소가 하나 남을 때 까지 재귀
			int mid = (start + end) / 2;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			// 분리된 구간를 비교하면서 정렬 및 병합
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		// 임시로 필요한 구간 초기화
		for (int i = start; i <= end; i++) {
			tempArr[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		// 두 구간 중 한 쪽이라도 끝까지 비교가 완료되면 반복 종료
		while (part1 <= mid && part2 <= end) {
			if (tempArr[part1] <= tempArr[part2]) {
				 arr[index++] = tempArr[part1++];
			} else {
				 arr[index++] = tempArr[part2++];
			}
		}
		
		// 앞 쪽 구간이 남았다면 남은 뒷 공간에 저장(뒤 쪽 구간은 남아도 어차피 뒤에 저장되면 재자리이기 때문에 고려안함)
		for (int i = part1; i <= mid; i++, index++) {
			arr[index] = tempArr[i];
		}
	}
}
