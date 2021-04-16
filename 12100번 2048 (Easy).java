import java.io.*;
import java.util.*;

// 12100�� 2048 (Easy)
public class Main {

    public static int N;

    // �ִ� 5�� �̵��ϴ� ���� ����� ��
    public static final int MAX = 5;
    public static ArrayList<int[]> NumberOfCases = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] originMap = new int[N][N];

        // ��ϰ� �Է�
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                originMap[i][j] = n;
            }
        }

        // �ִ� 5�� �̵��ϴ� ���� ����� �� ���
        Recursive();

        long answer = 0;
        for (int[] numbers : NumberOfCases) {
            long blockSum = Move(map, numbers);
            if (answer < blockSum) {
                answer = blockSum;
            }
            // ���带 ������� ����� ���� ��� ����
            MakeOriginMap(map, originMap);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // ���� �ʱ�ȭ
    public static void MakeOriginMap(int[][] dst, int[][] src) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dst[i][j] = src[i][j];
            }
        }
    }

    // ���� ���
    public static void PrintMap(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%6d ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // ���忡�� ���� ū �� ã��
    public static long FindMaxNumber(int[][] map) {
        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (result < map[i][j]) {
                    result = map[i][j];
                }
            }
        }
        return result;
    }

    // ���带 �������� ť�� ����
    public static void UpdateQueue(Queue<Integer> mainQueue, Queue<Integer> subQueue) {
        // ����ť�� �� ĭ(0)�� ���ְ� �����Ѵ�.
        int size = mainQueue.size();
        for (int i = 0; i < size; i++) {
            int polling = mainQueue.poll();
            if (polling != 0) {
                mainQueue.offer(polling);
            }
        }
        // �� ���� ��� ���� �� ĭ�̸� �̵��� �ʿ䰡 ����
        if (mainQueue.isEmpty()) {
            return;
        }
        
        int compare = mainQueue.poll();
        while (mainQueue.isEmpty() == false) {
            int now = mainQueue.peek();
            // �񱳱��� ������ ��ϰ� ���ٸ� �� ���� ���� ����ť�� �����ϰ� ���ο� �񱳱��� �̴´�.
            if (compare == now) {
                now = mainQueue.poll();
                int sum = compare + now;
                subQueue.offer(sum);
                // ���ο� �񱳱��� �������� �ʴٸ� �� ĭ�� 0���� �д�.
                if (mainQueue.isEmpty()) {
                    compare = 0;
                }
                // ť�� ���Ұ� �ִٸ� �񱳱��� ����.
                else {
                    compare = mainQueue.poll();
                }
            }
            // �񱳱��� �ٸ��ٸ� ������ ����� �ٸ��� �񱳱��� ����ť�� ��� ���ο� �񱳱��� �̴´�.
            else {
                subQueue.add(compare);
                compare = mainQueue.poll();
            }
        }
        // ������ �񱳱��� ����ť�� �����ϰԵǸ� ����ť�� �̵��� ��ϵ��� ������ ��.
        if (compare != 0) {
            subQueue.offer(compare);
        }
    }

    // 5ȸ ���� �̵�
    public static long Move(int[][] map, int[] numbers) {
        long maxNumber = 0;

        // �� ���� �� ������
        for (int dir : numbers) {
            UpdateMap(map, dir);
        }
        maxNumber = FindMaxNumber(map);

        return maxNumber;
    }

    // �̵��Ͽ� �����Ǹ� ����
    public static void UpdateMap(int[][] map, int dir) {
        Queue<Integer>[] mainQueues = new Queue[N];
        Queue<Integer>[] subQueues = new Queue[N];
        // ��(0)
        if (dir == 0) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = 0; j < N; j++) {
                    mainQueues[i].offer(map[j][i]);
                    // �������� �� ���� ť�� ���, �� �ڸ��� ����� �� ĭ���� �ʱ�ȭ
                    map[j][i] = 0;
                }
                
                // ����ť�� ���� �� ���� ��� ����ť�� ���� �������� ����
                UpdateQueue(mainQueues[i], subQueues[i]);

                // ����ť�� ����� ����� ���忡 �ű�
                int subIndex = 0;
                while (subQueues[i].isEmpty() == false) {
                    map[subIndex][i] = subQueues[i].poll();
                    subIndex++;
                }
            }
        }

        // ��(1)
        if (dir == 1) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = N - 1; j >= 0; j--) {
                    mainQueues[i].offer(map[j][i]);
                    // �������� �� ���� ť�� ���, �� �ڸ��� ����� �� ĭ���� �ʱ�ȭ
                    map[j][i] = 0;
                }

                // ����ť�� ���� �� ���� ��� ����ť�� ���� �������� ����
                UpdateQueue(mainQueues[i], subQueues[i]);

                // ����ť�� ����� ����� ���忡 �ű�
                int subIndex = N - 1;
                while (subQueues[i].isEmpty() == false) {
                    map[subIndex][i] = subQueues[i].poll();
                    subIndex--;
                }
            }
        }

        // ��(2)
        if (dir == 2) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = 0; j < N; j++) {
                    mainQueues[i].offer(map[i][j]);
                    // �������� �� ���� ť�� ���, �� �ڸ��� ����� �� ĭ���� �ʱ�ȭ
                    map[i][j] = 0;
                }

                // ����ť�� ���� �� ���� ��� ����ť�� ���� �������� ����
                UpdateQueue(mainQueues[i], subQueues[i]);

                // ����ť�� ����� ����� ���忡 �ű�
                int subIndex = 0;
                while (subQueues[i].isEmpty() == false) {
                    map[i][subIndex] = subQueues[i].poll();
                    subIndex++;
                }
            }
        }

        // ��(3)
        if (dir == 3) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = N - 1; j >= 0; j--) {
                    mainQueues[i].offer(map[i][j]);
                    // �������� �� ���� ť�� ���, �� �ڸ��� ����� �� ĭ���� �ʱ�ȭ
                    map[i][j] = 0;
                }

                // ����ť�� ���� �� ���� ��� ����ť�� ���� �������� ����
                UpdateQueue(mainQueues[i], subQueues[i]);

                // ����ť�� ����� ����� ���忡 �ű�
                int subIndex = N - 1;
                while (subQueues[i].isEmpty() == false) {
                    map[i][subIndex] = subQueues[i].poll();
                    subIndex--;
                }
            }
        }
    }

    // �̵����� ����� �� ��� �Լ�
    public static void Recursive() {
        int[] arr = new int[MAX];
        Recursive(0, arr);
    }

    // �̵����� ����� �� ��� �Լ�(MAX ��ŭ ��ø for���� ����)
    public static void Recursive(int cnt, int[] arr) {
        if (cnt == MAX) {
            int[] numbers = Arrays.copyOf(arr, MAX);
            NumberOfCases.add(numbers);
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[cnt] = i;
            Recursive(cnt + 1, arr);
        }
    }
}