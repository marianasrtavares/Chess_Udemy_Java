package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position p = new Position(0, 0);
		p.setValues(getBoard().getRow() - 1, getBoard().getColumn() - 1);
		// nw
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setValues(getBoard().getRow() - 1, getBoard().getColumn() - 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}
		// ne
		p.setValues(getBoard().getRow() - 1, getBoard().getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setValues(getBoard().getRow() - 1, getBoard().getColumn() + 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}

		// sw
		p.setValues(getBoard().getRow() + 1, getBoard().getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setValues(getBoard().getRow() + 1, getBoard().getColumn() - 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}

		// se
		p.setValues(getBoard().getRow() + 1, getBoard().getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setValues(getBoard().getRow() + 1, getBoard().getColumn() + 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}

		return mat;
	}

	public String toString() {
		return "B";
	}

}
