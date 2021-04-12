import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 11438¹ø LCA2
public class Main {

    //public static Scanner sc = new Scanner(System.in);
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
    public static int N, M;

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visits;
    public static int[][] parents;
    public static int[] depths;
    public static final int MAX_DEPTH = 20;

    public static void main(String[] args) throws NumberFormatException, IOException {

        //N = sc.nextInt();
    	N = Integer.parseInt(br.readLine());
    	
        depths = new int[N + 1];
        visits = new boolean[N + 1];
        parents = new int[N + 1][MAX_DEPTH + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
        	String[] link = br.readLine().split(" ");
        	int node01 = Integer.parseInt(link[0]);
        	int node02 = Integer.parseInt(link[1]);
            //int node01 = sc.nextInt();
            //int node02 = sc.nextInt();

            graph.get(node01).add(node02);
            graph.get(node02).add(node01);
        }

        DFS(1);
        //BFS();
        SetParents();
		/*
		 * for (int i = 1; i < parents.length; i++) { System.out.println(i + ": " +
		 * Arrays.toString(parents[i])); }
		 */

        //M = sc.nextInt();
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
        	String[] finds = br.readLine().split(" ");
            int input01 = Integer.parseInt(finds[0]);
            int input02 = Integer.parseInt(finds[1]);
 
            //int input01 = sc.nextInt();
            //int input02 = sc.nextInt();

            int findLCA = LCA(input01, input02);
            sb.append(findLCA + "\n");
            //System.out.println(findLCA);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int node) {
        visits[node] = true;

        int adjacencyCnt = graph.get(node).size();
        for (int i = 0; i < adjacencyCnt; i++) {
            int adjacencyNode = graph.get(node).get(i);
            if (visits[adjacencyNode] == false) {
                // ±íÀÌ Áõ°¡, ºÎ¸ð³ëµå ÀúÀå
                depths[adjacencyNode] = depths[node] + 1;
                parents[adjacencyNode][0] = node;
                
                DFS(adjacencyNode);
            }
        }
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);

        while (queue.isEmpty() == false) {
            int visitNode = queue.poll();
            visits[visitNode] = true;

            int adjacencyNodeCnt = graph.get(visitNode).size();
            for (int i = 0; i < adjacencyNodeCnt; i++) {
                int adjacenyNode = graph.get(visitNode).get(i);
                if (visits[adjacenyNode] == false) {
                    queue.add(adjacenyNode);

                    // ±íÀÌ Áõ°¡, ºÎ¸ð³ëµå ÀúÀå
                    depths[adjacenyNode] = depths[visitNode] + 1;
                    parents[adjacenyNode][0] = visitNode;
                }
            }

        }
    }

    public static void SetParents() {
        for (int i = 1; i <= MAX_DEPTH; i++) {
            for (int n = 1; n <= N; n++) {
                int half = parents[n][i - 1];
                parents[n][i] = parents[half][i - 1];
            }
        }
    }

    public static int LCA(int nodeA, int nodeB) {
        // ´õ ±íÀº ÃþÀ» ´ú ±íÀº ÃþÀ¸·Î ¿Å°Ü¾ß ÇÔ.
        // nodeA¸¦ ´õ ±íÀº ÃþÀ¸·Î ¹Ù²Û µÚ ºÎ¸ð³ëµå·Î ¿È±â¸é¼­ nodeB¿Í °°Àº ÃþÀ» ¸ÂÃã.
        if (depths[nodeA] < depths[nodeB]) {
            int temp = nodeA;
            nodeA = nodeB;
            nodeB = temp;
        }
        //System.out.println("diff " + (depths[nodeA] - depths[nodeB]));
        for (int i = MAX_DEPTH; i >= 0; i--) {
            if (depths[nodeA] - depths[nodeB] >= (1 << i)) {
                nodeA = parents[nodeA][i];
            }
        }
        //System.out.println(nodeA + ", " + nodeB);
        if (nodeA == nodeB) {
            return nodeA;
        }

        for (int i = MAX_DEPTH; i >= 0; i--) {
            if (parents[nodeA][i] != parents[nodeB][i]) {
                nodeA = parents[nodeA][i];
                nodeB = parents[nodeB][i];
            }
        }
        return parents[nodeA][0];
    }
}
