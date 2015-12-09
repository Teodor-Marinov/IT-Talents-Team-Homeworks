import java.util.Scanner;

public class Zakachlivka_3 {

	// Тествай, изпробвай, крашвай, коригирай, подобрявай, отправяй препоръки,
	// критики или въпроси! :-) Когато тестваш имай предвид, че интересните
	// варианти са само когато поне единият рамер на матрицата е не по-голям от
	// 2 или 3. В противен
	// случай резултатът е, че конят може да стъпва
	// на всяко поле, което е... скучно. :-)

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int n = sc.nextInt();
		System.out.println("Enter number of columns");
		int m = sc.nextInt();
		int[][] field = new int[n][m];
		System.out.println("Enter cooridnates within the limits of the field");
		int row = sc.nextInt() - 1;
		int col = sc.nextInt() - 1;
		if ((row < 0) || (row >= n) || (col < 0) || (col >= m)) {
			System.out.println("Invalid coordinate");
		} else {

			nextMove(field, row, col);

			System.out.println("Possible position of the horse, starting from position " + (row + 1) + ";" + (col + 1)
					+ ", are marked with \"1\"");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(field[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

	// рекурсивна ф-я:

	static void nextMove(int[][] field, int r, int c) {
		if (field[r][c] != 0) {
			return;
		}
		field[r][c] = 1;
		if ((r - 2 >= 0) && (c - 1 >= 0)) {
			nextMove(field, r - 2, c - 1);
		}
		if ((r - 1 >= 0) && (c - 2 >= 0)) {
			nextMove(field, r - 1, c - 2);
		}
		if ((r + 2 < field.length) && (c + 1 < field[0].length)) {
			nextMove(field, r + 2, c + 1);
		}
		if ((r + 1 < field.length) && (c + 2 < field[0].length)) {
			nextMove(field, r + 1, c + 2);
		}
		if ((r + 1 < field.length) && (c - 2 >= 0)) {
			nextMove(field, r + 1, c - 2);
		}
		if ((r + 2 < field.length) && (c - 1 >= 0)) {
			nextMove(field, r + 2, c - 1);
		}
		if ((r - 1 >= 0) && (c + 2 < field[0].length)) {
			nextMove(field, r - 1, c + 2);
		}
		if ((r - 2 >= 0) && (c + 1 < field[0].length)) {
			nextMove(field, r - 2, c + 1);
		}
	}

}
