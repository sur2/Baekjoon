import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 11047번 동전 0
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputs = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputs[0]);
		int K = Integer.parseInt(inputs[1]);
		
		int coins[] = new int[N];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coins);
		
		int cnt = 0;
		
		int idx = N - 1;
		// 그리디: 큰 동전 부터 거슬러 준다. (단, 큰 동전들은 작은 동전들의 배수이다.)
		// 동전으로 나누면 몫이 동전의 개수, 나머지가 더 작은 동전으로 거슬러주어야 할 금액이다.
		// 나머지 == 거스를 돈이 없을 때 까지 반복한다.
		while(K > 0) {
			cnt += K / coins[idx];
			K = K % coins[idx];
			idx--;
		}
		br.close();
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

}
