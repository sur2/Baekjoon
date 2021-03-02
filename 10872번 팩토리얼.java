import java.util.Scanner;

// 10872¹ø ÆÑÅä¸®¾ó
public class Main {
	
	public static int array[] = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		array = new int[N + 1];
		
		System.out.println(Factorial(N));
	}
	
	public static int Factorial(int n) {
		if(n < 2) {
			array[n] = 1;
			return array[n];
		}
		
		array[n] = n * Factorial(n - 1);
		
		return array[n];
	}

}
