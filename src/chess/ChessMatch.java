package chess;

import boardgame.Board;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		board= new Board(8,8);
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece [][] chesspieces= new ChessPiece[this.board.getRow()][this.board.getColumn()];
	    for(int i=0; i<board.getRow();i++)
	    	 for(int j=0; j<board.getColumn();j++)
	    		 chesspieces[i][j]=(ChessPiece) board.piece(i,j);
	    	
	return chesspieces;			
	}

	
}
