import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 5622번 다이얼
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		
		int answer = 0;
		
		for (int i = 0; i < input.length(); i++) {
			answer += toNumber(input.charAt(i)) + 1;
		}
		
		br.close();
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int toNumber(char ch) {
		// 2번부터 9번까지 알파벳 수
		int[] filter = { 3, 3, 3, 3, 3, 4, 3, 4};
		int num = ch - 65;
		int max = 0;
		// 숫자 순서대로 알파벳 개수를 더하면서 입력받은 문자에 필터링 되는지 확인
		// 예) 알파벳 'D'일 때  
		// num = 3
		// i = 0, max = 3, 3 < 3 : false
		// i = 1, max = 6, 3 < 6 : true 
		// for문 종료 함수 리턴
		for (int i = 0; i < filter.length; i++) {
			max += filter[i];
			if (num < max) {
				return i + 2;
			}
		}
		return 0;
	}

}
