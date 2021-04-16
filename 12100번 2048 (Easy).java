import java.io.*;
import java.util.*;

// 12100번 2048 (Easy)
public class Main {

    public static int N;

    // 최대 5번 이동하는 방향 경우의 수
    public static final int MAX = 5;
    public static ArrayList<int[]> NumberOfCases = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] originMap = new int[N][N];

        // 블록값 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                originMap[i][j] = n;
            }
        }

        // 최대 5번 이동하는 방향 경우의 수 계산
        Recursive();

        long answer = 0;
        for (int[] numbers : NumberOfCases) {
            long blockSum = Move(map, numbers);
            if (answer < blockSum) {
                answer = blockSum;
            }
            // 보드를 원래대로 만들고 다음 경우 실행
            MakeOriginMap(map, originMap);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 보드 초기화
    public static void MakeOriginMap(int[][] dst, int[][] src) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dst[i][j] = src[i][j];
            }
        }
    }

    // 보드 출력
    public static void PrintMap(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%6d ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // 보드에서 가장 큰 수 찾기
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

    // 보드를 움직임을 큐로 구현
    public static void UpdateQueue(Queue<Integer> mainQueue, Queue<Integer> subQueue) {
        // 메인큐에 빈 칸(0)을 없애고 시작한다.
        int size = mainQueue.size();
        for (int i = 0; i < size; i++) {
            int polling = mainQueue.poll();
            if (polling != 0) {
                mainQueue.offer(polling);
            }
        }
        // 한 줄의 모든 블럭이 빈 칸이면 이동할 필요가 없음
        if (mainQueue.isEmpty()) {
            return;
        }
        
        int compare = mainQueue.poll();
        while (mainQueue.isEmpty() == false) {
            int now = mainQueue.peek();
            // 비교군이 인접한 블록과 같다면 두 수의 합을 서브큐에 저장하고 새로운 비교군을 뽑는다.
            if (compare == now) {
                now = mainQueue.poll();
                int sum = compare + now;
                subQueue.offer(sum);
                // 새로운 비교군이 남아있지 않다면 빈 칸인 0으로 둔다.
                if (mainQueue.isEmpty()) {
                    compare = 0;
                }
                // 큐에 원소가 있다면 비교군을 뽑음.
                else {
                    compare = mainQueue.poll();
                }
            }
            // 비교군과 다르다면 인접한 블록이 다르면 비교군을 서브큐에 담고 새로운 비교군을 뽑는다.
            else {
                subQueue.add(compare);
                compare = mainQueue.poll();
            }
        }
        // 마지막 비교군을 서브큐에 저장하게되면 서브큐가 이동한 블록들의 순서가 됨.
        if (compare != 0) {
            subQueue.offer(compare);
        }
    }

    // 5회 보드 이동
    public static long Move(int[][] map, int[] numbers) {
        long maxNumber = 0;

        // 각 뱡향 별 움직임
        for (int dir : numbers) {
            UpdateMap(map, dir);
        }
        maxNumber = FindMaxNumber(map);

        return maxNumber;
    }

    // 이동하여 보드판를 수정
    public static void UpdateMap(int[][] map, int dir) {
        Queue<Integer>[] mainQueues = new Queue[N];
        Queue<Integer>[] subQueues = new Queue[N];
        // 상(0)
        if (dir == 0) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = 0; j < N; j++) {
                    mainQueues[i].offer(map[j][i]);
                    // 보드판의 한 줄을 큐에 담고, 그 자리의 보드는 빈 칸으로 초기화
                    map[j][i] = 0;
                }
                
                // 메인큐에 보드 한 줄을 담고 서브큐로 보드 움직임을 구현
                UpdateQueue(mainQueues[i], subQueues[i]);

                // 서브큐에 담겨진 블록을 보드에 옮김
                int subIndex = 0;
                while (subQueues[i].isEmpty() == false) {
                    map[subIndex][i] = subQueues[i].poll();
                    subIndex++;
                }
            }
        }

        // 하(1)
        if (dir == 1) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = N - 1; j >= 0; j--) {
                    mainQueues[i].offer(map[j][i]);
                    // 보드판의 한 줄을 큐에 담고, 그 자리의 보드는 빈 칸으로 초기화
                    map[j][i] = 0;
                }

                // 메인큐에 보드 한 줄을 담고 서브큐로 보드 움직임을 구현
                UpdateQueue(mainQueues[i], subQueues[i]);

                // 서브큐에 담겨진 블록을 보드에 옮김
                int subIndex = N - 1;
                while (subQueues[i].isEmpty() == false) {
                    map[subIndex][i] = subQueues[i].poll();
                    subIndex--;
                }
            }
        }

        // 좌(2)
        if (dir == 2) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = 0; j < N; j++) {
                    mainQueues[i].offer(map[i][j]);
                    // 보드판의 한 줄을 큐에 담고, 그 자리의 보드는 빈 칸으로 초기화
                    map[i][j] = 0;
                }

                // 메인큐에 보드 한 줄을 담고 서브큐로 보드 움직임을 구현
                UpdateQueue(mainQueues[i], subQueues[i]);

                // 서브큐에 담겨진 블록을 보드에 옮김
                int subIndex = 0;
                while (subQueues[i].isEmpty() == false) {
                    map[i][subIndex] = subQueues[i].poll();
                    subIndex++;
                }
            }
        }

        // 우(3)
        if (dir == 3) {
            for (int i = 0; i < N; i++) {
                mainQueues[i] = new LinkedList<>();
                subQueues[i] = new LinkedList<>();

                for (int j = N - 1; j >= 0; j--) {
                    mainQueues[i].offer(map[i][j]);
                    // 보드판의 한 줄을 큐에 담고, 그 자리의 보드는 빈 칸으로 초기화
                    map[i][j] = 0;
                }

                // 메인큐에 보드 한 줄을 담고 서브큐로 보드 움직임을 구현
                UpdateQueue(mainQueues[i], subQueues[i]);

                // 서브큐에 담겨진 블록을 보드에 옮김
                int subIndex = N - 1;
                while (subQueues[i].isEmpty() == false) {
                    map[i][subIndex] = subQueues[i].poll();
                    subIndex--;
                }
            }
        }
    }

    // 이동방향 경우의 수 계산 함수
    public static void Recursive() {
        int[] arr = new int[MAX];
        Recursive(0, arr);
    }

    // 이동방향 경우의 수 계산 함수(MAX 만큼 중첩 for문과 같음)
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