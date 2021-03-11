import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2252�� �� �����
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
		
		// �� ��� �� ���� ������ �켱 0���� ��� �ʱ�ȭ
		indegree = new int[N + 1];
		Arrays.fill(indegree, 0);
		
		// ���� �׷���
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());			
		}
		
		// ���� �׷��� �Է�
		for (int i = 0; i < M; i++) {
			int nodeA = sc.nextInt();
			int nodeB = sc.nextInt();
			graph.get(nodeA).add(nodeB);
			// A -> B�� ���� ���� ���� �ϳ� ����
			indegree[nodeB] += 1;
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		// ���� ������ 0�� ��� ���� ť�� ����
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		// ť���� ��带 �ϳ��� �����ϰ� ����� ����� ���� ������ �ϳ� ����
		while(queue.isEmpty() == false) {
			int node = queue.poll();
			result.add(node);
			for (int i = 0; i < graph.get(node).size(); i++) {
				int next = graph.get(node).get(i);
				indegree[next] -= 1;
				// ���ŵ� ����� ���� ������ 0�̸� ť�� ����
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
