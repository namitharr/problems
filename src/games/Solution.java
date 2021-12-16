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
		solution.play(4);
		solution.play(4);
		solution.play(4);
	}

	int player = 1;
	int numPlayers = 2;
	int winner = 0;
	int rowLength = 6;
	int columnLength = 7;
	int[][] board;

	Solution() {
		board = new int[rowLength][columnLength];
	}

	private void play(int column) {
		if (winner > 0) {
			System.out.println("Player " + player + " wins!");
			return;
		}

		if (board[0][column] != 0) {
			System.out.println("Column full! Try another move");
			return;
		}

		for (int i = board.length - 1; i >= 0; i--) {
			if (board[i][column] == 0) {
				board[i][column] = player;
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
		for (int i = row; i < board.length; i++) {
			if (board[i][column] == player) ++count;
			else break;
		}

		return count == 4;
	}

	private boolean checkRow(int row) {
		int count = 0;
		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		return false;
	}

	private boolean checkDiagonal(int row, int column) {
		int count = 0;
		for (int i = row, j = column; i < board.length && j < board.length; i++, j++) {
			if (board[i][j] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		count = 0;
		for (int i = row, j = column; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		count = 0;
		for (int i = row, j = column; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == player) {
				++count;
				if (count == 4) return true;
			} else count = 0;
		}

		count = 0;
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == player) {
				++count;
				if (count == 4) return true;
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
