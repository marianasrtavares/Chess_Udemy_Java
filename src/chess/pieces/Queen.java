package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position p = new Position(0, 0);
		// nw
		p.setValues(getBoard().getRow() - 1, getBoard().getColumn() - 1);
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
		// se
		p.setValues(getBoard().getRow() + 1, getBoard().getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setValues(getBoard().getRow() + 1, getBoard().getColumn() + 1);
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
		// n
		p.setValues(getBoard().getRow() - 1, getBoard().getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setRow(getBoard().getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}
		// s
		p.setValues(getBoard().getRow() + 1, getBoard().getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setRow(getBoard().getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}
		// o
		p.setValues(getBoard().getRow(), getBoard().getColumn()-1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setRow(getBoard().getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}
		// e
		p.setValues(getBoard().getRow(), getBoard().getColumn()+1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
			p.setRow(getBoard().getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}
		return mat;
	}

	

	@Override
	public String toString() {
		return "Q";
	}

}
