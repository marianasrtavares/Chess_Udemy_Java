package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	
	public boolean makeMove(Position position) {
		ChessPiece chessPiece= (ChessPiece) getBoard().piece(position);
		return chessPiece==null || chessPiece.getColor()!= this.getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
	  boolean [][] mat = new boolean [getBoard().getRow()][getBoard().getColumn()];
	  Position p= new Position(0,0);
	  
	  //-2,-1
	  p.setValues(getBoard().getRow()-2, getBoard().getColumn()-1);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
	  
	 //-2,+1
	  p.setValues(getBoard().getRow()-2, getBoard().getColumn()+1);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
	  
	 //-1,+2
	  p.setValues(getBoard().getRow()-1, getBoard().getColumn()+2);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
	  
	//+1,+2
	  p.setValues(getBoard().getRow()+1, getBoard().getColumn()+2);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
	  
	//+2,+1
	  p.setValues(getBoard().getRow()+2, getBoard().getColumn()+1);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
	  
	//+2,-1
	  p.setValues(getBoard().getRow()+2, getBoard().getColumn()-1);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
	  
	//+1,-2
	  p.setValues(getBoard().getRow()+1, getBoard().getColumn()-2);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
	  
	//-1,-2
	  p.setValues(getBoard().getRow()-1, getBoard().getColumn()-2);
	  if(getBoard().positionExists(p) && makeMove(p)) {
		  mat[getBoard().getRow()][getBoard().getColumn()]=true;
	  }
		return mat;
	}
	@Override
	public String toString() {
		return "K";
		
	}

}
