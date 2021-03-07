import java.util.Scanner;

// 1717�� ������ ǥ��
public class Main {
	
	public static int arr[] = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[n + 1];
		
		// �ʱ⿡�� �ڱ� �ڽ��� ��Ʈ ���� ����
		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}
		
		// mȸ ��ŭ ���� ����
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a == 0) {
				union_root(b, c);
			}
			
			if(a == 1) {
				int root_b = find_root(b);
				int root_c = find_root(c);
				String answer = (root_b == root_c) ? "YES" : "NO"; 
				System.out.println(answer);
			}
			
		}
		
		sc.close();
	}
	
	// ��Ʈ ��� ã��
	public static int find_root(int i) {
		if(arr[i] != i)
			// ��� ����
			arr[i] = find_root(arr[i]);
		
		return arr[i];
	}
	
	// ���� ��ġ��
	public static void union_root(int i, int j) {
		
		int root_i = find_root(i);
		int root_j = find_root(j);
		
		// �� ���� ���� ��Ʈ�� �ǵ��� �Ѵ�.
		if(root_i != root_j) 
			arr[root_j] = root_i;
		else 
			arr[root_i] = root_j;
	}

}
