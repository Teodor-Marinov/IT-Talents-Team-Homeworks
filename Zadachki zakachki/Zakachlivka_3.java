import java.util.Scanner;

public class Zakachlivka_3 {

	// �������, ���������, �������, ���������, ����������, �������� ���������,
	// ������� ��� �������! :-) ������ ������� ���� �������, �� �����������
	// �������� �� ���� ������ ���� ������� ����� �� ��������� � �� ��-����� ��
	// 2 ��� 3. � ��������
	// ������ ���������� �, �� ����� ���� �� ������
	// �� ����� ����, ����� �... ������. :-)

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int n = sc.nextInt();
		System.out.println("Enter number of columns");
		int m = sc.nextInt();
		char[][] field = new char[n][m];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				field[i][j] = ' ';
			}
		}
		System.out.println("Enter cooridnates within the limits of the field");
		int row = sc.nextInt() - 1;
		int col = sc.nextInt() - 1;
		if ((row < 0) || (row >= n) || (col < 0) || (col >= m)) {
			System.out.println("Invalid coordinate");
		} else {
			if ((n >= 3 && m > 3) || (n > 3 && m >= 3)) {
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field[0].length; j++) {
						field[i][j] = 'o';
					}
				}
			} else {
				nextMove(field, row, col);
			}

			System.out.println("Possible position of the horse, starting from position " + (row + 1) + ";" + (col + 1)
					+ ", are marked with \"o\"");
			for (int j2 = 0; j2 < field[0].length; j2++) {
				System.out.print("----");
			}
			System.out.println();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {

					System.out.print("| " + field[i][j] + " ");
				}
				System.out.print("|\n");
				for (int j2 = 0; j2 < field[0].length; j2++) {
					System.out.print("----");
				}
				System.out.println();
			}

		}

	}

	// ���������� �-�:

	static void nextMove(char[][] field, int r, int c) {
		if (field[r][c] != ' ') {
			return;
		}
		field[r][c] = 'o';
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
