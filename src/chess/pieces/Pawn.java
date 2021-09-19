package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position position = new Position(0, 0);
		if (getColor() == Color.WHITE) {

			position.setValues(getBoard().getRow() - 1, getBoard().getColumn());
			if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
			position.setValues(getBoard().getRow()-2, getBoard().getColumn());
			Position position2= new Position(getBoard().getRow()-1, getBoard().getColumn());
			if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getMoveCount()==0 && getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
			
			position.setValues(getBoard().getRow() - 1, getBoard().getColumn() - 1);
			if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
			position.setValues(getBoard().getRow() - 1, getBoard().getColumn() + 1);
			if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
		
		} else {

			position.setValues(getBoard().getRow() + 1, getBoard().getColumn());
			if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
			position.setValues(getBoard().getRow()+2, getBoard().getColumn());
			Position position2= new Position(getBoard().getRow()+1, getBoard().getColumn());
			if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getMoveCount()==0 && getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
			
			position.setValues(getBoard().getRow() + 1, getBoard().getColumn() - 1);
			if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
			position.setValues(getBoard().getRow() + 1, getBoard().getColumn() + 1);
			if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[getBoard().getRow()][getBoard().getColumn()] = true;
			}
			
		}

		return mat;
	}


@Override
public String toString() {
	return "P";
}
}