import java.util.Arrays;
import java.util.Scanner;

// 1920번 수 찾기
public class Main {

	public static int N;
	public static long[] A;
	
	public static int M;
	public static long[] X;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new long[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextLong();
		}
		
		M = sc.nextInt();
		X = new long[M];
		
		for (int i = 0; i < M; i++) {
			X[i] = sc.nextLong();
		}
		
		// 이분탐색 전 오름차순 정렬 필수!
		Arrays.sort(A);
		
		for (int i = 0; i < M; i++) {
			System.out.println(BinarySearch(X[i]));
		}
		
	}
	
	public static int BinarySearch(long target) {
		if(target > A[N - 1]) {
			return 0;
		}
		
		if(target < A[0]) {
			return 0;
		}
		
		int result = 0;
		
		int start = 0;
		int end = N - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			for (int i = 0; i < N; i++) {
				if(target > A[mid]) {
					start = mid + 1;
				}
				else if(target < A[mid]) {
					end = mid - 1;
				}
				else if(target == A[mid]) {
					return 1;
				}
			}
		}
		
		return result;
	}

}
