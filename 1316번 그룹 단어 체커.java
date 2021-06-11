import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 1316번 그룹 단어 체커
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
			// 그룹 단어인 경우 개수 추가
			if (isGroup(input[i])) {
				cnt++;
			}
		}
		
		br.close();
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		
	}
	
	public static boolean isGroup(String word) {
		boolean result = false;
		List<Character> charList = new ArrayList<Character>();
		char pre = 0;
		// 문장의 각 문자를 비교
		for (int i = 0; i < word.length(); i++) {
			char now = word.charAt(i);
			// 이전에 등장한 문자와 다를 경우
			if (now != pre) {
				// 문자리스트와 현재 문자를 비교
				for (char ch : charList) {
					// 현재 문자가 문자리시트에 있는 경우 그룹 단어 실패
					if (now == ch) {
						return result;
					}
				}
				// 현재 문자를 이전 문자로 변경하고, 문자리스트에 저장
				pre = now;
				charList.add(now);
			}
			// 이전에 등장한 문자와 같은 경우 그룹 단어가 유지됨으로 별다른 조치를 하지 않음
		}
		// 모든 문자를 조회하여 별다른 조치가 되지 않은 경우 그룹 단어로 판단
		result = true;
		return result;
	}

}
