import java.util.Scanner;

public class Game {
	private static Scanner sc = new Scanner(System.in);
	private static char[][] field;
	private char playerChar;
	private int playerId;
	
	public Game() {
		field = new char[3][3];
		playerChar = 'o';
		playerId = 2;
	}
	
//	public int getFieldLength() {
//		int l = this.field.length;
//		return l;
//	}
	
	public void makeMove() {
		int row = -1;
		int col = -1;
		while (row < 0 || col < 0 || row > 2 || col > 2) {
			System.out.println("Player " + this.playerId + ": ");
			row = sc.nextInt() - 1;
			col = sc.nextInt() - 1;
			if (field[row][col] != 'x' && field[row][col] != 'o') {
				field[row][col] = this.playerChar;
			}
			else {
				System.out.println("Occupied! Try again: ");
				row = sc.nextInt() - 1;
				col = sc.nextInt() - 1;
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
	public boolean isDraw() {
		boolean isDraw = false;
		for (int row = 0; row < field.length; row++) {
			for (int col = 0; col < field[0].length; col++) {
				if (field[row][col] != 'x' && field[row][col] != 'o') {
					isDraw = false;
					break; // field is not filled, there is at least one empty spot
				}
				else {
					isDraw = true;
				}
			}
		}
		return isDraw;
	}
	
	public boolean hasSameChars(char ch1, char ch2, char ch3) {
		boolean sameChars = false;
		if ((ch1 == 'x' || ch1 == 'o') && (ch1 == ch2 && ch2 == ch3)) {
			sameChars = true;
		}
		return sameChars;
	}
	
	public boolean checkForWinnerDiagonal() {
		if (hasSameChars(field[0][0], field[1][1], field[2][2]) ||
				hasSameChars(field[0][2], field[1][1], field[2][0])) {
			return true;
		}
		else {
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
		if (checkForWinnerDiagonal() == true ||
				checkForWinnerHorizontal() == true ||
				checkForWinnerVertical() == true) {
			System.out.println("Winner is: Player " + this.playerId + "!");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void changePlayerChar() {
		if (this.playerId == 2) {
			this.playerChar = 'x';
			this.playerId = 1;
		}
		else {
			this.playerChar = 'o';
			this.playerId = 2;
		}
	}
}
