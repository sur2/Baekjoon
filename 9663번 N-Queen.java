import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 각 행에는 하나의 퀸만 존재 할 수 있기 때문에 각 행의 정보만 넣는 1차원 배열로 충분함
        int[] boardsRow = new int[N];
        int answer = DFS(boardsRow, N, 0);
        br.close();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static int DFS(int[] row, int n, int cnt) {
        int queen_case = 0;
        if (cnt == n) {
            queen_case = 1;
            return queen_case;
        }
        for (int i = 0; i < n; i++) {
            row[cnt] = i;
            if (check(row, cnt)) {
                // 반환 값을 더하여 경우의 수 셈
                queen_case += DFS(row,  n, cnt + 1);
            }
        }
        return queen_case;
    }

    public static boolean check(int[] row, int now) {
        for (int i = 0; i < now; i++) {
            // 각 행에 대한 열이 같은 경우 수직선상에 존재
            if (row[i] == row[now]) {
                return false;
            }
            // 서로 다른 두 행과 열의 차이가 같다면 대각선에 위치한 것
            int a = Math.abs(row[i] - row[now]);
            int b = Math.abs(i - now);
            if (a == b) {
                return false;
            }
        }

        return true;
    }

}