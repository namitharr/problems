package games;

class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.play(6); //player 1
		solution.play(0); //player 2
		solution.play(3); //player 1
		solution.play(3); //player 2
		solution.play(3); //player 1
		solution.play(0); //player 2
		solution.play(0); //player 1
		solution.play(4); //player 2
		solution.play(5); //player 1
		solution.play(4); //player 2
		solution.play(5); //player 1
		solution.play(4); //player 2
		solution.play(4); //player 1
		solution.play(2); //player 2
		solution.play(3); //player 1
		solution.play(2); //player 2
		solution.play(2); //player 1
		solution.play(5); //player 2
		solution.play(5); //player 1
		solution.play(2); //player 2
		solution.play(6); //player 1
		solution.play(1); //player 2
		solution.play(1); //player 1
		solution.play(1); //player 2
		solution.play(4); //player 1
	}

	int player = 1;
	int numPlayers = 2;
	int boardHeight = 6;
	int boardWidth = 7;
	int[][] board;
	int gameOver = -1;
	int streak = 4; // required amount of continuous coins to win

	Solution() {
		board = new int[boardHeight][boardWidth];
	}

	private void play(int column) {
		if (notGameOver() && isValidColumn(column) && isColumnAvailable(column)) {
			for (int i = board.length - 1; i >= 0; i--) {
				if (board[i][column] == 0) {
					board[i][column] = player;
					printBoard();
					if (checkWinner(i, column)) {
						System.out.println("Player " + player + " wins!");
						gameOver = player;
						return;
					}
					nextPlayer();
					break;
				}
			}
		}
	}

	private boolean notGameOver() {
		if (gameOver >= 0) {
			if (gameOver == 0) System.out.println("No more moves available!");
			else System.out.println("Player " + player + " wins!");
			return false;
		} else {
			return true;
		}
	}

	private boolean isValidColumn(int column) {
		if (column < boardWidth) {
			return true;
		} else {
			System.out.println("Not a valid column! Try another move.");
			return false;
		}
	}

	private boolean isColumnAvailable(int column) {
		if (board[0][column] != 0) {
			if (!isBoardFull())
				System.out.println("Column full! Try another move");
			return false;
		} else {
			return true;
		}
	}

	private boolean isBoardFull() {
		gameOver = 0;
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 0) {
				gameOver = -1;
				break;
			}
		}
		if (gameOver == 0) {
			System.out.println("No more moves available!");
			return true;
		} else {
			return false;
		}
	}

	private boolean checkWinner(int row, int column) {
		if (checkColumn(row, column)) return true;
		if (checkRow(row)) return true;
		else return checkDiagonal(row, column);
	}

	private boolean checkColumn(int row, int column) {
		int count = 0;
		for (int i = row; i < board.length; i++) {
			if (board[i][column] == player) ++count;
			else break;
		}

		return count == streak;
	}

	private boolean checkRow(int row) {
		int count = 0;
		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i] == player) {
				++count;
				if (count == streak) return true;
			} else count = 0;
		}

		return false;
	}

	private boolean checkDiagonal(int row, int column) {
		int i, j;
		for (i = row, j = column; i < board.length - 1 && j < board[i].length - 1; i++, j++) ;

		int count = 0;
		while (i >= 0 && j >= 0) {
			if (board[i--][j--] == player) {
				++count;
				if (count == streak) return true;
			} else count = 0;
		}

		count = 0;
		for (i = row, j = column; i > 0 && j < board[i].length - 1; i--, j++) ;

		while (i < board.length && j >= 0) {
			if (board[i++][j--] == player) {
				++count;
				if (count == streak) return true;
			} else count = 0;
		}

		return false;
	}

	private void printBoard() {
		for (int[] row : board) {
			for (int column : row) {
				System.out.print(column + " ");
			}
			System.out.print("\n");
		}
		System.out.println("==============");
	}

	private void nextPlayer() {
		if (++player > numPlayers) player = 1;
	}
}
