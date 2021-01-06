import java.util.Scanner;

// 1978번 소수 찾기
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		sc.nextLine();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (Check_is_Prime(arr[i])) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean Check_is_Prime(int number) {
		
		if(number == 0)
			return false;
		
		if(number == 1)
			return false;
		
		if(number == 2)
			return true;
		
		if(number == 3)
			return true;
		
		// 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수이다.
		// 2부터 N의 절반 만큼 숫자를 1씩 증가시키면서 N과 나누어 떨어지는지 확인한다.
		for (int i = 2; i <= number / 2; i++) {
			if(number % i == 0)
				return false;
		}
		
		return true;
	}

}
