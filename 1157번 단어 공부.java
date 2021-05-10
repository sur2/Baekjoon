import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1157번 단어 공부
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 알파벳 개수
		int[] alpha = new int[26];
		
		String input = br.readLine();
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			// 'A' = 65
			// 'Z' = 90
			// 'a' = 97
			// 'z' = 122
			
			// 대소문자 구분하여 알파벳의 개수를 배열에 저장
			if (ch > 90) {
				alpha[ch - 97]++;
			}
			else {
				alpha[ch - 65]++;
			}
		}
		
		int max = 0;
		int imax = 0;
		// 최대값의 인덱스와 비교하기 위한 변수
		int sameIndex = 0;
		
		for (int i = 0; i < alpha.length; i++) {
			if (max < alpha[i]) {
				max = alpha[i];
				// 최대값의 인덱스 저장
				imax = i;
			}
			// 최대값과 같은 값의 위치를 저장
			// 이 값이 최대값의 인덱스와 다르다면 최대값과 같은 값이 더 존재함을 의미
			if (max == alpha[i]) {
				sameIndex = i;
			}
		}
		
		// 최대값이 두 개 이상
		if (sameIndex != imax) {
			bw.write("?\n");
		}
		else {
			bw.write(imax + 65);
		}
		br.close();
		bw.flush();
		bw.close();
	
	}

}
