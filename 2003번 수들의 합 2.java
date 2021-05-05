import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2003�� ������ �� 2
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
			
			// ���������� �������� ���� ����
			if (start == end) {
				sum = arr[start];
			}
			else if(start < end) {
				sum += arr[end];
			}
			
			// ���� ���ڿ� M�� ��
			// M���� ������ ������ ���������� �� ĭ �� �̵��Ͽ� ���� ����
			if (sum < M) {
				end++;
			}
			// M�� ���ٸ� ��츦 ã��, �������� ���������� �� ĭ �̵�, ������ �������� ���� ��.
			else if (sum == M) {
				cnt++;
				sum = 0;
				start++;
				end = start;
			}
			// M ���� ũ�ٸ� �� �̻� ���� ���ص� ��츦 ã�� �� �����Ƿ� �������� ���������� �� ĭ �̵�, ������ �������� ���� ��.
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
