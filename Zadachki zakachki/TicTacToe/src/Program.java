
public class Program {
	public static void main(String[] args) {
		Game game = new Game();
		int count = 0;
		// while (!game.hasWinner() || !game.isDraw()) {
		while (count < 9 && !game.hasWinner()) {
			game.changePlayerChar();
			game.makeMove();
			game.printField();

			if (game.hasWinner()) {
				break;
			}
			if (!game.hasWinner() && count == 8) {
				System.out.println("This game is a draw.");
				break;
			}
			count++;
		}
	}
}
