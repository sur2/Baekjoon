import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static final int INF = (int) 1e9;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node implements Comparable<Node> {
        public int point;
        public int distance;

        public Node(int point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.point - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stzr = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stzr.nextToken());
        int E = Integer.parseInt(stzr.nextToken());

        int v1, v2;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int[] fromS = new int[N + 1];
        int[] fromV1 = new int[N + 1];
        int[] fromV2 = new int[N + 1];

        Arrays.fill(fromS, INF);
        Arrays.fill(fromV1, INF);
        Arrays.fill(fromV2, INF);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer stzrE = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stzrE.nextToken());
            int b = Integer.parseInt(stzrE.nextToken());
            int c = Integer.parseInt(stzrE.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        StringTokenizer stzrV = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(stzrV.nextToken());
        v2 = Integer.parseInt(stzrV.nextToken());


        Dijkstra_with_Heap(graph, 1, fromS);
        Dijkstra_with_Heap(graph, v1, fromV1);
        Dijkstra_with_Heap(graph, v2, fromV2);

        int answer = -1;

        // case1 1 - v1 - v2 - N
        int case1 = INF;
        if(fromS[v1] < INF && fromV1[v2] < INF && fromV2[N] < INF) {
            case1 = fromS[v1] + fromV1[v2] + fromV2[N];
        }

        // case2 1 - v2 - v1 - N
        int case2 = INF;
        if(fromS[v2] < INF && fromV2[v1] < INF && fromV1[N] < INF) {
            case2 = fromS[v2] + fromV2[v1] + fromV1[N];
        }

        answer = Math.min(case1, case2);
        answer = answer == INF ? -1 : answer;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Dijkstra_with_Heap(ArrayList<ArrayList<Node>> graph, int start, int[] check) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(new Node(start, 0));
        check[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current_node = priorityQueue.poll();

            if(check[current_node.point] < current_node.distance)
                continue;

            for (Node next_node: graph.get(current_node.point)) {
                int total = check[current_node.point] + next_node.distance;
                if(check[next_node.point] > total) {
                    check[next_node.point] = total;
                    priorityQueue.offer(next_node);
                }
            }

        }
    }
}
