import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2941번 크로아티아 알파벳
public class Main {
	
	// 세 자리는 "dz=" 뿐이므로 젤 마지막에 위치시킨다.
	public static String[] Croatia = { "c=", "c-", "d-", "lj", "nj", "s=", "z=", "dz=" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		br.close();
		
		char[] array = input.toCharArray();
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			boolean has2Croatia = false;
			// 두 자리가 맞은 경우, i번 째에서 두 자리 검색 가능한지 먼저 확인
			if (i < array.length - 1) {
				// 세 자리는 따로 검사하기 위해 제외(배열의 마지막 단어)
				for (int j = 0; j < Croatia.length - 1; j++) {
					if (array[i] == Croatia[j].charAt(0) && array[i + 1] == Croatia[j].charAt(1)) {
						// 두 자리가 모두 동일하면 두 칸 뛰어넘기 위해 i를 한 칸 이동
						i++;
						has2Croatia = true;
						break;
					}
				}				
			}
			// 세 자리가 맞은 경우, i번 째에서 세 자리 검색 가능한지 먼저 확인 단, 두 자리가 단어가 존재하지 않았을 경우
			if (i < array.length - 2 && has2Croatia == false) {
				if (array[i] == Croatia[7].charAt(0) 
						&& array[i + 1] == Croatia[7].charAt(1)
						&& array[i + 2] == Croatia[7].charAt(2)) {
					// 세 자리가 모두 동일하면 세 칸 뛰어넘기 위해 i를 두 칸 이동
					i += 2;
				}				
			}
			// i가 이동하면서 단어 개수를 셈
			count++;
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		
	}

}
