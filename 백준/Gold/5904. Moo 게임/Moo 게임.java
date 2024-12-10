import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 1번 수열의 길이
 * m idx : 0, length : 3
 * 2번 수열의 길이
 * m idx : 3, length : 4, total length: 7
 * 3번 수열의 길이
 * m idx : 7, length : 4, total length: 7
 * m idx : 10,
 * m idx
 */
public class Main {
	
	public static char answer;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();

		Moo(num);

		System.out.println(answer);

		scan.close();
	}

	public static void Moo(int num) {
		int size = 3;
		int index = 0;

		if (num == 1) {
			answer = 'm';
		} else if (num <= 3)
			answer = 'o';
		else {
			while (size < num) {
				size = size * 2 + index + 4;
				index++;
			}

			int front_back = (size - index - 3) / 2;

			if (size - front_back + 1 <= num) {
				Moo(num - size + front_back);
			} else if (num == front_back + 1)
				answer = 'm';
			else
				answer = 'o';
		}
	}
}
