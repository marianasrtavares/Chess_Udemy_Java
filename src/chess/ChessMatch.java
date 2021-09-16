package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	private int turn;
	private Color currentPlayer;
	
	public ChessMatch() {
		board= new Board(8,8);
		turn = 1;
		currentPlayer= Color.WHITE;
		initialSetup();
	}

	public int getTurn() {
		return turn;
	}

	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}


	public ChessPiece[][] getPieces(){
		ChessPiece [][] chesspieces= new ChessPiece[this.board.getRow()][this.board.getColumn()];
	    for(int i=0; i<board.getRow();i++)
	    	 for(int j=0; j<board.getColumn();j++)
	    		 chesspieces[i][j]=(ChessPiece) board.piece(i,j);
	    	
	return chesspieces;			
	}
	public boolean [][] possibleMoves(ChessPosition sourcePosition){
		Position source= sourcePosition.toPosition();
		boolean [][]mat = new boolean[board.getRow()][board.getColumn()];
		validateSourcePosition(source);
		return board.piece(source).possibleMoves();
	
	}

	public ChessPiece performChessMove (ChessPosition sourcePosition, ChessPosition targetPosition){
		Position source=sourcePosition.toPosition();
		Position target=targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Piece p= makeMove(source,target);
		nextTurn();
		return (ChessPiece)p;
		
		
	}
	
	
	private void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chesspiece cant move to target position");
		}
		
	}

	private void validateSourcePosition(Position position) {
		ChessPiece p= (ChessPiece) board.piece(position);
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece");
			
		}
		if(currentPlayer!=p.getColor()) {
			throw new ChessException ("Thats not your piece");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException ("Theres is no possible move");
		}
		
	}

	private void nextTurn() {
		turn++;
		
		currentPlayer= (currentPlayer == Color.WHITE) ? Color.BLACK : Color.BLACK;
	}
	private Piece makeMove(Position source, Position target) {
		Piece p= board.removePiece(source);
		Piece pieceRemoved= board.removePiece(target);
		board.placePiece(p,target);
		
		return p;
	}

	
	
	
	
	
	
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	

	}
	
	
	

