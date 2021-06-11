import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2941�� ũ�ξ�Ƽ�� ���ĺ�
public class Main {
	
	// �� �ڸ��� "dz=" ���̹Ƿ� �� �������� ��ġ��Ų��.
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
			// �� �ڸ��� ���� ���, i�� °���� �� �ڸ� �˻� �������� ���� Ȯ��
			if (i < array.length - 1) {
				// �� �ڸ��� ���� �˻��ϱ� ���� ����(�迭�� ������ �ܾ�)
				for (int j = 0; j < Croatia.length - 1; j++) {
					if (array[i] == Croatia[j].charAt(0) && array[i + 1] == Croatia[j].charAt(1)) {
						// �� �ڸ��� ��� �����ϸ� �� ĭ �پ�ѱ� ���� i�� �� ĭ �̵�
						i++;
						has2Croatia = true;
						break;
					}
				}				
			}
			// �� �ڸ��� ���� ���, i�� °���� �� �ڸ� �˻� �������� ���� Ȯ�� ��, �� �ڸ��� �ܾ �������� �ʾ��� ���
			if (i < array.length - 2 && has2Croatia == false) {
				if (array[i] == Croatia[7].charAt(0) 
						&& array[i + 1] == Croatia[7].charAt(1)
						&& array[i + 2] == Croatia[7].charAt(2)) {
					// �� �ڸ��� ��� �����ϸ� �� ĭ �پ�ѱ� ���� i�� �� ĭ �̵�
					i += 2;
				}				
			}
			// i�� �̵��ϸ鼭 �ܾ� ������ ��
			count++;
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		
	}

}
