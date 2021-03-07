import java.util.Scanner;

// 1717번 집합의 표현
public class Main {
	
	public static int arr[] = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[n + 1];
		
		// 초기에는 자기 자신을 루트 노드로 설정
		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}
		
		// m회 만큼 연산 시작
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
	
	// 루트 노드 찾기
	public static int find_root(int i) {
		if(arr[i] != i)
			// 경로 압축
			arr[i] = find_root(arr[i]);
		
		return arr[i];
	}
	
	// 집합 합치기
	public static void union_root(int i, int j) {
		
		int root_i = find_root(i);
		int root_j = find_root(j);
		
		// 더 작은 값이 루트가 되도록 한다.
		if(root_i != root_j) 
			arr[root_j] = root_i;
		else 
			arr[root_i] = root_j;
	}

}
