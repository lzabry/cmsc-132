package model;

import java.util.Random;

/* This class must extend Game */
public class ClearCellGame extends Game {
	private Random random;
	private int score=0;
	private int strategy;

	public ClearCellGame(int maxRows, int maxCols, java.util.Random random, int strategy) {
		super(maxRows, maxCols);
		this.random = random;
		this.score = 0;
		this.strategy = strategy;
	}

	public int getScore() {
		return this.score;
	}

	public boolean isGameOver() {

		for (int j = 0; j < this.getMaxCols(); j++) {
			if (board[this.board.length - 1][j] != BoardCell.EMPTY) {
				return true;
			}
		}
		return false;
	}

	public void nextAnimationStep() {
		if (this.isGameOver() == false) {
			for (int i = getMaxRows() - 1; i > 0; i--) {
				board[i] = board[i - 1].clone();
			}
			for (int j = 0; j < getMaxCols(); j++) {
				board[0][j] = BoardCell.getNonEmptyRandomBoardCell(this.random);
			}
		} else {
			return;
		}
	}

	public void processCell(int rowIndex, int colIndex) {
		if (this.isGameOver()) {
			return;
		}
		BoardCell color = getBoardCell(rowIndex, colIndex);
		// setBoardCell(rowIndex, colIndex, BoardCell.EMPTY);//
		int i = rowIndex;
		int j = colIndex;
		while (i >= 0) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				i = i - 1;
				this.score++;
			} else {
				break;
			}

		}
		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, color);
		while (i < getMaxRows()) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				i = i + 1;
				this.score++;
			} else {
				break;
			}

		}
		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, color);
		while (j >= 0) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				j = j - 1;
				this.score++;
			} else {
				break;
			}

		}

		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, color);
		while (j < getMaxCols()) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				j = j + 1;
				this.score++;
			} else {
				break;
			}

		}

		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, color);
		while (i >= 0 && j >= 0) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				i = i - 1;
				j = j - 1;
				this.score++;
			} else {
				break;
			}

		}

		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, color);
		while (j < getMaxCols() && i < getMaxRows()) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				i = i + 1;
				j = j + 1;
				this.score++;
			} else {
				break;
			}

		}

		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, color);
		while (j >= 0 && i < getMaxRows()) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				i = i + 1;
				j = j - 1;
				this.score++;
			} else {
				break;
			}

		}

		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, color);
		while (j < getMaxCols() && i >= 0) {
			if (board[i][j] == color) {
				setBoardCell(i, j, BoardCell.EMPTY);
				i = i - 1;
				j = j + 1;
				this.score++;
			} else {
				break;
			}

		}

		i = rowIndex;
		j = colIndex;
		setBoardCell(i, j, BoardCell.EMPTY);
		this.score=score-8;
		this.score++;
		collapse();

	}

	private void collapse() {
		int mark = 0;
		for (int i = getMaxRows() - 1; i > 0; i--) {
			if (!isempty(board[i])) {
				mark = i;
				break;
			}
		}
		for (int i = 0; i < mark; i++) {
			if (isempty(board[i])) {
				for (int j = i; j < getMaxRows() - 1; j++) {
					board[j] = board[j + 1].clone();
				}
			}
		}
	}

	private boolean isempty(BoardCell[] board) {
		for (int j = 0; j < board.length; j++) {
			if (board[j] != BoardCell.EMPTY) {
				return false;
			}
		}
		return true;
	}

}
