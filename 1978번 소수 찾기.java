import java.util.Scanner;

// 1978�� �Ҽ� ã��
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
		
		// �ڽź��� ���� �� ���� �ڿ����� ���Ͽ� ���� �� ���� 1���� ū �ڿ����̴�.
		// 2���� N�� ���� ��ŭ ���ڸ� 1�� ������Ű�鼭 N�� ������ ���������� Ȯ���Ѵ�.
		for (int i = 2; i <= number / 2; i++) {
			if(number % i == 0)
				return false;
		}
		
		return true;
	}

}
