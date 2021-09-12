package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		board= new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece [][] chesspieces= new ChessPiece[this.board.getRow()][this.board.getColumn()];
	    for(int i=0; i<board.getRow();i++)
	    	 for(int j=0; j<board.getColumn();j++)
	    		 chesspieces[i][j]=(ChessPiece) board.piece(i,j);
	    	
	return chesspieces;			
	}
	
	public void initialSetup() {
		board.placePiece(new Rook (board,Color.WHITE), new Position(2,1));
		board.placePiece(new Rook (board,Color.WHITE), new Position(2,1));
		board.placePiece(new Rook (board,Color.WHITE), new Position(2,1));
	}
	
	
	
}
