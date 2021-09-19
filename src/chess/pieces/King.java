package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	private ChessMatch chessMatch;

	public King(Board board, Color color,ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch=chessMatch;
		
	}
	private boolean testRookCasting(Position position) {
		ChessPiece chessPiece= (ChessPiece) getBoard().piece(position);
		return chessPiece!=null && chessPiece instanceof Rook && chessPiece.getMoveCount()==0 && chessPiece.getColor()==this.getColor() ;
		
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
		
		//specialmove castling
		if(getMoveCount()==0 && !chessMatch.getCheck()) {
			//small kingside rook
			Position pRook= new Position(position.getRow(),position.getColumn()+3);
		    if(testRookCasting(pRook)) {
		    	Position p1= new Position(position.getRow(),position.getColumn()+1);
		    	Position p2= new Position(position.getRow(),position.getColumn()+2);
		    	if(getBoard().piece(p1)==null && getBoard().piece(p2)==null ) {
		    		mat[position.getRow()][position.getColumn()+2]=true;
		    	}
		    	
		    }
			//big kingside rook
			Position pRook2= new Position(position.getRow(),position.getColumn()-4);
		    if(testRookCasting(pRook)) {
		    	Position p1= new Position(position.getRow(),position.getColumn()-1);
		    	Position p2= new Position(position.getRow(),position.getColumn()-2);
		    	Position p3= new Position(position.getRow(),position.getColumn()-3);
		    	if(getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null) {
		    		mat[position.getRow()][position.getColumn()-2]=true;
		    	}
		    	
		    }
		}
	
		return mat;
	}
}
