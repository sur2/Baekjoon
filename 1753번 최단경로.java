import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1753�� �ִܰ��
public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int V = 0;
	private static int E = 0;
	private static int K = 0;
	
	// 1. ��� ���� ���� �׷���(����Ʈ)
	private static List<List<Node>> graph = new ArrayList<List<Node>>();
	// 2. ������ ���� ��� ����� ����� ��� �迭(�ִܰŸ��� �����)
	private static int[] path_distance = null;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer VE_Token = new StringTokenizer(br.readLine());
		V = Integer.parseInt(VE_Token.nextToken());
		E = Integer.parseInt(VE_Token.nextToken());
		K = Integer.parseInt(br.readLine());
		
		// 1. �� �׷���(����Ʈ) �ν���ȭ �۾�
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// 2. �� �迭 �ʱ�ȭ �۾�(�ʱ⿡ �Ÿ��� ���Ѵ�� ������ 10������ ����)
		path_distance = new int[V + 1];
		Arrays.fill(path_distance, (int) 1e9);

		for (int i = 0; i < E; i++) {
			StringTokenizer uvw_Token = new StringTokenizer(br.readLine()); 
			int u, v, w;
			u = Integer.parseInt(uvw_Token.nextToken());
			v = Integer.parseInt(uvw_Token.nextToken());
			w = Integer.parseInt(uvw_Token.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		// �׷��� ���� ���
//		for (int i = 1; i < V + 1; i++) {
//			System.out.println(i + ": " + graph.get(i));
//		}
		
		// ���������� ��� ����� �ִ� ��� ���
		Dijkstra_with_Priority_Queue(K);
		
		// ���������� ��� ����� �ִܰŸ� ���
//		System.out.println(Arrays.toString(path_distance));
		
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < V + 1; i++) {
			String result = path_distance[i] < (int) 1e9 ? path_distance[i] + "\n" : "INF\n";
			sb.append(result);
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void Dijkstra_with_Priority_Queue(int start) {
		// 3. ���� ��� �� �Ÿ��� ª�� ��� ���� �ִ� �Ÿ��� ���� �� �� �ֵ��� �켱���� ť�� ���� �� �ʱ�ȭ
		PriorityQueue<Node> priority_queue = new PriorityQueue<Node>();
		
		// 3-1. ó������ ������ ���� �켱���� ť�� �����ϸ� �ڱ��ڽ��̹Ƿ� �Ÿ��� 0�̴�.
		priority_queue.offer(new Node(start, 0));
		path_distance[start] = 0; 
		
		// 3-2. �켱���� ť�� ���� ����� �� ���� �ݺ�
		while(!priority_queue.isEmpty()) {
			// 3-3. ������� �� �Ÿ��� ���� ª�� ��带 �켱���� ť���� �̴´�. �� ���� ���� ��尡 �ȴ�.
			Node adjacency_node = priority_queue.poll();
			int current_index = adjacency_node.index;
			int current_distance = adjacency_node.distance;
			// 3-3-1. ���� �������� �Ÿ��� �ִ� �Ÿ��� �� �� ���ٸ� �ִ� �Ÿ��� ������ �ʿ䰡 �����Ƿ� ���� �ݺ����� �ѱ�
			if(path_distance[current_index] < current_distance) {
				continue;
			}
			// 3-3-2. ���� ����� ������带 Ȯ���Ѵ�.
			for (Node node : graph.get(current_index)) {
				// 3-3-3. ���������� ��������� ����� �Ÿ����� ������� ���� �Ÿ��� ���Ѵ�.
				int total_distance = path_distance[adjacency_node.index] + node.distance;
				// 3-3-4. 3-3-3�� �Ÿ��� ������������ �ִܰŸ� �� �� ª�� ������ �����Ѵ�.
				if(total_distance < path_distance[node.index]) {
					// 3-3-5. ���ŵ� ������带 ���ŵ� �Ÿ��� �Բ� �켱���� ť�� �ִ´�.
					path_distance[node.index] = total_distance;
					priority_queue.offer(new Node(node.index, total_distance));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	public int index;
	public int distance;
	
	public Node(int index, int distance) {
		// TODO Auto-generated constructor stub
		this.index = index;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.index + ", " + this.distance + "]";
	}
}