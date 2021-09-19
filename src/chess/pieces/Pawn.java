package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		chessMatch = this.chessMatch;

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
			position.setValues(getBoard().getRow() - 2, getBoard().getColumn());
			Position position2 = new Position(getBoard().getRow() - 1, getBoard().getColumn());
			if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getMoveCount() == 0
					&& getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2)) {
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
			// en passant
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left)
						&& getBoard().piece(left) == chessMatch.getEnPassanVulnerable())
					mat[getBoard().getRow() - 1][getBoard().getColumn()] = true;

				Position rigth = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(rigth) && isThereOpponentPiece(rigth)
						&& getBoard().piece(rigth) == chessMatch.getEnPassanVulnerable())
					mat[getBoard().getRow() - 1][getBoard().getColumn()] = true;
			}

		

	}else

	{

		position.setValues(getBoard().getRow() + 1, getBoard().getColumn());
		if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[getBoard().getRow()][getBoard().getColumn()] = true;
		}
		position.setValues(getBoard().getRow() + 2, getBoard().getColumn());
		Position position2 = new Position(getBoard().getRow() + 1, getBoard().getColumn());
		if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getMoveCount() == 0
				&& getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2)) {
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
		
		//en passant
		if (position.getRow() == 4 ) {
			Position left = new Position(position.getRow(), position.getColumn() - 1);
			if (getBoard().positionExists(left) && isThereOpponentPiece(left)
					&& getBoard().piece(left) == chessMatch.getEnPassanVulnerable())
				mat[getBoard().getRow() + 1][getBoard().getColumn()] = true;

			Position rigth = new Position(position.getRow(), position.getColumn() + 1);
			if (getBoard().positionExists(rigth) && isThereOpponentPiece(rigth)
					&& getBoard().piece(rigth) == chessMatch.getEnPassanVulnerable())
				mat[getBoard().getRow() + 1][getBoard().getColumn()] = true;
		}

	}

	return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
}