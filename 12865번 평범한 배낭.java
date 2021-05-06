import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 12865번 평범한 배낭
public class Main {

	static class Item {
		int weight = 0;
		int value = 0;
		
		Item(int w, int v) {
			this.weight = w;
			this.value = v;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer input_st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(input_st.nextToken());
		int K = Integer.parseInt(input_st.nextToken());
		
		Item[] WV = new Item[N + 1];
		WV[0] = new Item(0, 0);
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			WV[n + 1] = new Item(W, V);  
		}
		
		int[][] DP = new int[N + 1][K + 1];
		Arrays.fill(DP[0], 0);

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				
				// 점화식에 따른 메모이제이션
				// DP[i][j] = D[i - 1][j] (if j < W[i])
				// DP[i][j] = max(D[i - 1][j], DP[i - 1][j - W[i]] + V[i]) (if j >= W[i])
				if (WV[i].weight > j) {
					DP[i][j] = DP[i - 1][j];
				}else {
					int a = DP[i - 1][j];
					int b = WV[i].value + DP[i - 1][j - WV[i].weight];
					DP[i][j] = Math.max(a, b);
				}
				
			}
		}
		
		br.close();
		bw.write(DP[N][K] + "\n");
		bw.flush();
		bw.close();
		
	}

}
