import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2003번 수들의 합 2
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringTokenizer st_arr = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st_arr.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		while (start < N && end < N) {
			
			// 시작점에서 끝점까지 수를 더함
			if (start == end) {
				sum = arr[start];
			}
			else if(start < end) {
				sum += arr[end];
			}
			
			// 더한 숫자와 M을 비교
			// M보다 작으면 끝점을 오른쪽으로 한 칸 더 이동하여 수를 더함
			if (sum < M) {
				end++;
			}
			// M과 같다면 경우를 찾음, 시작점을 오른쪽으로 한 칸 이동, 끝점은 시작점과 같게 함.
			else if (sum == M) {
				cnt++;
				sum = 0;
				start++;
				end = start;
			}
			// M 보다 크다면 더 이상 수를 더해도 경우를 찾을 수 없으므로 시작점을 오른쪽으로 한 칸 이동, 끝점은 시작점과 같게 함.
			else if (sum > M) {
				sum = 0;
				start++;
				end = start;
			}
			
		}
		br.close();
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
		
	}

}
