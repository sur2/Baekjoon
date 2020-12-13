import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 12865�� ����� �賶
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<int[]> items = new LinkedList<int[]>();
		for (int n = 0; n < N; n++) {
			items.add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		
		items.sort((o1, o2) -> o1[0] - o2[0]);

		int[][] bag = new int[N + 1][K + 1];
		
		for (int n = 1; n < N + 1; n++) {
			for (int k = 0; k < K + 1; k++) {
				// item�� ���濡 ���� �� �ִ� ���� �� ��
				if(k >= items.get(n - 1)[0]) {
					int itemValue = items.get(n - 1)[1];
					int preitemWeight = k - items.get(n - 1)[0];
					// ���� item�� ���� item�� �־��� �� �� �� ��ġ�� ���� ���� ���� 
					bag[n][k] = Math.max(bag[n - 1][k], itemValue + bag[n - 1][preitemWeight]);
				}
				// item�� ���濡 ���� �� �� ���� ������ ���� item�� �ְ� ��ġ�� ����
				else {
					bag[n][k] = bag[n - 1][k];
				}
			}
		}
		
		/*
		 * for (int i = 0; i <= N; i++) { System.out.println(Arrays.toString(bag[i])); }
		 */
		
		System.out.println(bag[N][K]);
	}

}
