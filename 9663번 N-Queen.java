import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // �� �࿡�� �ϳ��� ���� ���� �� �� �ֱ� ������ �� ���� ������ �ִ� 1���� �迭�� �����
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
                // ��ȯ ���� ���Ͽ� ����� �� ��
                queen_case += DFS(row,  n, cnt + 1);
            }
        }
        return queen_case;
    }

    public static boolean check(int[] row, int now) {
        for (int i = 0; i < now; i++) {
            // �� �࿡ ���� ���� ���� ��� �������� ����
            if (row[i] == row[now]) {
                return false;
            }
            // ���� �ٸ� �� ��� ���� ���̰� ���ٸ� �밢���� ��ġ�� ��
            int a = Math.abs(row[i] - row[now]);
            int b = Math.abs(i - now);
            if (a == b) {
                return false;
            }
        }

        return true;
    }

}