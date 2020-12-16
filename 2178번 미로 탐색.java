import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2178번 미로 탐색
public class Main {
	private static int N;
	private static int M;
	private static int arr[][];
	private static boolean visit[][];
	
	// 상, 하, 좌, 우 
	private static int[] dy = {-1, 1, 0, 0};
	private static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		arr = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			String input = sc.nextLine();
			for (int j = 1; j < M + 1; j++) {
				arr[i][j] = input.charAt(j - 1) - '0';
			}
		}
		
		int answer = BFS(1, 1);
		
		System.out.println(answer);
		sc.close();
		
	}
	
	public static int BFS(int start_i, int start_j) {
		int cnt = 1;

		Queue<int[]> queue = new LinkedList<int[]>();
		// 0: i, 1: j, 2: 이동횟수
		queue.offer(new int[] {start_i, start_j, cnt});
		visit[start_i][start_j] = true;
		
		// 큐를 모두 비울 때 까지 반복 (BFS)
		while(!queue.isEmpty()) {
			
			// 가장 먼저 큐에서 빠져나오는 원소
			int[] point = queue.poll();
			arr[point[0]][point[1]] = 0;
			cnt = point[2];
			
			// N, M에 도착하면 함수 종료, 이동횟수 반환
			if(point[0] == N && point[1] == M)
				return point[2];
			
			// 4가지 방향에 대해 BFS(넓이우선그래프탐색)
			for (int i = 0; i < 4; i++) {
				int next_y = point[0] + dy[i];
				int next_x = point[1] + dx[i];
				
				// 배열의 범위 안에 이동할 수 있는 조건이 충족되면
				if(next_y > 0 && next_y < N + 1)
					if(next_x > 0 && next_x < M + 1)
						if(arr[next_y][next_x] == 1 && !visit[next_y][next_x]) {
							// 충족된 위치와 이동횟수를 큐에 삽입
							queue.offer(new int[] {next_y, next_x, cnt + 1});
							visit[next_y][next_x] = true;
						}
							
			}
		}
		
		return cnt;
	}

}
