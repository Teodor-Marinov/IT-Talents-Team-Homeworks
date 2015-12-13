import java.util.Scanner;

public class Game {
	private static Scanner sc = new Scanner(System.in);
	private static char[][] field;
	private char playerChar;
	 int playerId;

	public Game() {
		field = new char[3][3];
		playerChar = 'o';
		playerId = 2;
	}

	// public int getFieldLength() {
	// int l = this.field.length;
	// return l;
	// }

	public void makeMove() {
//		int row = -1;
//		int col = -1;
		boolean isValueEntered=false;
		while (!isValueEntered) {
			System.out.println("Player " + this.playerId + ": ");
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			if ((row >= 0 && row < 3) && (col >= 0 && col < 3)) {
				if (field[row][col] != 'x' && field[row][col] != 'o') {
					field[row][col] = this.playerChar;
					isValueEntered=true;
					break;
				} else {
					System.out.println("Occupied! Try again: ");
//					row = sc.nextInt() - 1;
//					col = sc.nextInt() - 1;
				}
			} else {
				System.out.println("Invalid coordinates!");
			}

		}
	}

	public void printField() {
		System.out.println("-------------");
		for (int row = 0; row < field.length; row++) {
			System.out.print("| ");
			for (int col = 0; col < field[0].length; col++) {
				System.out.print(field[row][col] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	// if all 9 spots are filled and there isn't a winner yet
	// public boolean isDraw() {
	// boolean isDraw = false;
	// for (int row = 0; row < field.length; row++) {
	// for (int col = 0; col < field[0].length; col++) {
	// if (field[row][col] != 'x' && field[row][col] != 'o') {
	// isDraw = false;
	// break; // field is not filled, there is at least one empty spot
	// }
	// else {
	// System.out.println("This game is a draw.");
	// isDraw = true;
	// }
	// }
	// }
	// return isDraw;
	// }

	public boolean hasSameChars(char ch1, char ch2, char ch3) {
		boolean sameChars = false;
		if ((ch1 == 'x' || ch1 == 'o') && (ch1 == ch2 && ch2 == ch3)) {
			sameChars = true;
		}
		return sameChars;
	}

	public boolean checkForWinnerDiagonal() {
		if (hasSameChars(field[0][0], field[1][1], field[2][2])
				|| hasSameChars(field[0][2], field[1][1], field[2][0])) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkForWinnerHorizontal() {
		for (int row = 0; row < field.length; row++) {
			if (hasSameChars(field[row][0], field[row][1], field[row][2])) {
				return true;
			}
		}
		return false;
	}

	public boolean checkForWinnerVertical() {
		for (int col = 0; col < field[0].length; col++) {
			if (hasSameChars(field[0][col], field[1][col], field[2][col])) {
				return true;
			}
		}
		return false;
	}

	public boolean hasWinner() {
		if (checkForWinnerDiagonal() == true || checkForWinnerHorizontal() == true
				|| checkForWinnerVertical() == true) {
			System.out.println("Winner is: Player " + this.playerId + "!");
			return true;
		} else {
			return false;
		}
	}

	public void changePlayerChar() {
		if (this.playerId == 2) {
			this.playerChar = 'x';
			this.playerId = 1;
		} else {
			this.playerChar = 'o';
			this.playerId = 2;
		}
	}
}
