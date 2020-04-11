import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 1707번 이분 그래프
public class Main {
	private static LinkedList<Integer>[] list;
	private static int K; // 테스트 케이스
	private static int V; // 정점의 수
	private static int E; // 간선의 수
	private static Scanner sc;

	private static boolean visit[]; // 방문 노드 판단
	private static int hop;
	// 방문한 첫 번째 노드는 1, 다음 노드는 2로 정점끼리 인접하지 않은지 구분
	private static int bipartite[];
	private static boolean result;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		K = sc.nextInt();
		for (int t = 0; t < K; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			V = V + 1; // 간선 V는 1부터 시작
			list = new LinkedList[V];
			for (int i = 1; i < V; i++) {
				list[i] = new LinkedList<Integer>();
			}
			hop = 1;
			visit = new boolean[V];
			bipartite = new int[V];

			for (int i = 0; i < E; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				list[n1].add(n2);
				list[n2].add(n1);
			}

//			for (int i = 1; i < V; i++) {
//				System.out.println(list[i]);
//			}
			result = true;
			for (int i = 1; i < V; i++) {
				if (!result) {
					break;
				}
				if (bipartite[i] == 0) {
					bipartiteDFS(i, 1);
				}
			}
			System.out.println(result ? "YES" : "NO");
//			System.out.println(Arrays.toString(bipartite));
		}

	}

	private static void bipartiteDFS(int start, int mark) {
//		System.out.print(start + " ");
		bipartite[start] = mark;
		for (int temp : list[start]) {
			if (bipartite[temp] == mark) {
				result = false;
				return;
			}
			if (bipartite[temp] == 0) {
				bipartiteDFS(temp, -mark);
			}
		}
	}
	/*
	  1
	  5 5
	  1 2
	  2 3 
	  3 4 
	  2 5 
	  5 4 
	  
	 */
}
