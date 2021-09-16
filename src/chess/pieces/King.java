package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
	    return p== null || p.getColor()!=this.getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean [][]mat = new boolean [getBoard().getRow()][getBoard().getColumn()];
		Position p= new Position(0,0);
		p.setValues(position.getRow()-1, position.getColumn());
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		
		p.setValues(position.getRow()+1, position.getColumn());
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		p.setValues(position.getRow(), position.getColumn()-1);
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		p.setValues(position.getRow(), position.getColumn()+1);
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		p.setValues(position.getRow()-1, position.getColumn()+1);
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		p.setValues(position.getRow()-1, position.getColumn()-1);
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		p.setValues(position.getRow()+1, position.getColumn()-1);
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		p.setValues(position.getRow()+1, position.getColumn()+1);
		if(canMove(p) && getBoard().positionExists(p)) {
			mat[p.getRow()][ p.getColumn()]=true;
		}
		return mat;
	}
}
