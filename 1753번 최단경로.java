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

// 1753번 최단경로
public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int V = 0;
	private static int E = 0;
	private static int K = 0;
	
	// 1. 노드 간의 연결 그래프(리스트)
	private static List<List<Node>> graph = new ArrayList<List<Node>>();
	// 2. 시작점 부터 모든 경로의 비용을 담는 배열(최단거리가 저장됨)
	private static int[] path_distance = null;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer VE_Token = new StringTokenizer(br.readLine());
		V = Integer.parseInt(VE_Token.nextToken());
		E = Integer.parseInt(VE_Token.nextToken());
		K = Integer.parseInt(br.readLine());
		
		// 1. → 그래프(리스트) 인스턴화 작업
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// 2. → 배열 초기화 작업(초기에 거리를 무한대로 가늠할 10억으로 가정)
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
		
		// 그래프 정보 출력
//		for (int i = 1; i < V + 1; i++) {
//			System.out.println(i + ": " + graph.get(i));
//		}
		
		// 시작점부터 모든 경로의 최단 경로 계산
		Dijkstra_with_Priority_Queue(K);
		
		// 시작점부터 모든 경로의 최단거리 출력
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
		// 3. 인접 노드 중 거리가 짧은 노드 부터 최단 거리를 갱신 할 수 있도록 우선순위 큐를 선언 및 초기화
		PriorityQueue<Node> priority_queue = new PriorityQueue<Node>();
		
		// 3-1. 처음에는 시작점 부터 우선순위 큐에 삽입하며 자기자신이므로 거리는 0이다.
		priority_queue.offer(new Node(start, 0));
		path_distance[start] = 0; 
		
		// 3-2. 우선순위 큐가 전부 비워질 때 까지 반복
		while(!priority_queue.isEmpty()) {
			// 3-3. 인접노드 중 거리가 가장 짧은 노드를 우선순위 큐에서 뽑는다. 그 것이 현재 노드가 된다.
			Node adjacency_node = priority_queue.poll();
			int current_index = adjacency_node.index;
			int current_distance = adjacency_node.distance;
			// 3-3-1. 현재 노드까지의 거리가 최단 거리가 될 수 없다면 최단 거리를 갱신할 필요가 없으므로 다음 반복으로 넘김
			if(path_distance[current_index] < current_distance) {
				continue;
			}
			// 3-3-2. 현재 노드의 인접노드를 확인한다.
			for (Node node : graph.get(current_index)) {
				// 3-3-3. 시작점에서 현재노드까지 노드의 거리에서 인접노드 간의 거리를 더한다.
				int total_distance = path_distance[adjacency_node.index] + node.distance;
				// 3-3-4. 3-3-3의 거리와 인접노드까지의 최단거리 중 더 짧은 것으로 갱신한다.
				if(total_distance < path_distance[node.index]) {
					// 3-3-5. 갱신된 인접노드를 갱신된 거리와 함께 우선순위 큐에 넣는다.
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