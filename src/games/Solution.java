package games;

class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.play(0);
		solution.play(1);
		solution.play(1);
		solution.play(2);
		solution.play(3);
		solution.play(2);
		solution.play(3);
		solution.play(3);
		solution.play(2);
		solution.play(4);
		solution.play(4);
		solution.play(5);
		solution.play(4);
		solution.play(4);
	}

	int winner = 0;
	int player = 1;
	int numPlayers = 2;
	int rowLength = 6;
	int columnLength = 7;
	static int[][] gameState;

	Solution() {
		gameState = new int[rowLength][columnLength];
	}

	private void play(int column) {
		if (winner > 0) {
			System.out.println("Player " + player + " wins!");
			return;
		}

		if (gameState[0][column] != 0) {
			System.out.println("Column full! Try another move");
			return;
		}

		for (int i = gameState.length - 1; i >= 0; i--) {
			if (gameState[i][column] == 0) {
				gameState[i][column] = player;
				printBoard();
				if (checkWinner(i, column)) {
					System.out.println("Player " + player + " wins!");
					winner = player;
					return;
				}
				nextPlayer();
				break;
			}
		}
	}

	private boolean checkWinner(int row, int column) {
		if (checkColumn(row, column)) return true;
		if (checkRow(row)) return true;
		else return checkDiagonal(row, column);
	}

	private boolean checkColumn(int row, int column) {
		int count = 0;
		for (int i = row; i < gameState.length; i++) {
			if (gameState[i][column] == player) ++count;
			else break;
		}

		return count == 4;
	}

	private boolean checkRow(int row) {
		int count = 0;
		for (int i = 0; i < gameState[row].length; i++) {
			if (gameState[row][i] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		return false;
	}

	private boolean checkDiagonal(int row, int column) {
		int count = 0;
		for (int i = row, j = column; i < gameState.length && j < gameState.length; i++, j++) {
			if (gameState[i][j] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		count = 0;
		for (int i = row, j = column; i >= 0 && j < gameState.length; i--, j++) {
			if (gameState[i][j] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		count = 0;
		for (int i = row, j = column; i < gameState.length && j >= 0; i++, j--) {
			if (gameState[i][j] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		count = 0;
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (gameState[i][j] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		return false;
	}

	private void printBoard() {
		for (int[] row : gameState) {
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
