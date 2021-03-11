import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2252번 줄 세우기
public class Main {
	
	public static int N;
	public static int M;
	
	public static int[] indegree = null;
	public static ArrayList<ArrayList<Integer>> graph = null;
	
	public static Scanner sc = null;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 각 노드 별 진입 차수를 우선 0으로 모두 초기화
		indegree = new int[N + 1];
		Arrays.fill(indegree, 0);
		
		// 방향 그래프
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());			
		}
		
		// 방향 그래프 입력
		for (int i = 0; i < M; i++) {
			int nodeA = sc.nextInt();
			int nodeB = sc.nextInt();
			graph.get(nodeA).add(nodeB);
			// A -> B로 가는 진입 차수 하나 증가
			indegree[nodeB] += 1;
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		// 진입 차수가 0인 노드 부터 큐에 삽입
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		// 큐에서 노드를 하나씩 제거하고 연결된 노드의 진입 차수를 하나 감소
		while(queue.isEmpty() == false) {
			int node = queue.poll();
			result.add(node);
			for (int i = 0; i < graph.get(node).size(); i++) {
				int next = graph.get(node).get(i);
				indegree[next] -= 1;
				// 제거된 노드의 진입 차수가 0이면 큐에 삽입
				if(indegree[next] == 0) {
					queue.offer(next);
				}
			}
			
		}
		
		for (int i = 1; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		System.out.println();
		
	}

}
