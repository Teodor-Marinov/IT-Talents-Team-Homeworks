
public class Program {
	public static void main(String[] args) {
		Game game = new Game();
		while (!game.hasWinner() || !game.isDraw()) {
			game.changePlayerChar();
			game.makeMove();
			game.printField();			
			game.hasWinner();
			game.isDraw();
			
		}
	}
}
