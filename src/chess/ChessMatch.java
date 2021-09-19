package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	private int turn;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;
	
	private List <Piece> piecesOnTheBoard = new ArrayList<>();
	private List <Piece> capturedPieces= new ArrayList<>();
	public ChessMatch() {
		board= new Board(8,8);
		turn = 1;
		currentPlayer= Color.WHITE;
		initialSetup();
	}

	public int getTurn() {
		return turn;
	}
	
	public boolean getCheckMate() {
		return checkMate;
	}
	public boolean getCheck() {
		return check;
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
		Piece capturedPiece= makeMove(source,target);
		if(testCheck(currentPlayer)){
			undoMove(source, target, capturedPiece);
			throw new ChessException("You cant put yourself in check");
		}
		
		check= (testCheck(opponent(currentPlayer))) ? true : false;
		
		if(testCheckMate(opponent(currentPlayer))){
			checkMate=true;
		}else {
			nextTurn();
		}
		
		return (ChessPiece)capturedPiece;
		
		
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
		ChessPiece p= (ChessPiece) board.removePiece(source);
		p.increaseMoveCount();
		Piece pieceRemoved= board.removePiece(target);
	    board.placePiece(p,target);
	    if(pieceRemoved!=null) {
	    	piecesOnTheBoard.remove(pieceRemoved);
	    	capturedPieces.add(pieceRemoved);
	    }
		
		return pieceRemoved;
	}
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		
		ChessPiece pieceTargetRemoved= (ChessPiece)board.removePiece(target);
		pieceTargetRemoved.decreaseMoveCount();
		board.placePiece(pieceTargetRemoved,source);
	    if(capturedPiece!=null) {
	    board.placePiece(capturedPiece,target);
	    piecesOnTheBoard.add(capturedPiece);
    	capturedPieces.remove(capturedPiece);
    	
	    }
	}

	private Color opponent(Color color) {
		return (color==Color.BLACK)? color.WHITE : color.BLACK;
	}
	private ChessPiece king (Color color) {
		List <Piece> list= piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor()==color).collect(Collectors.toList());
		for(Piece p:list) {
			if(p instanceof King) 
				return (ChessPiece)p;
		}
		throw new IllegalStateException("There is no king on the board whit color "+ color);
		
	}
	private boolean testCheck (Color color) {
		List <Piece> opponentList= piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() ==opponent(color)).collect(Collectors.toList());
		for(Piece p:opponentList) {
			if(p.possibleMoves()[king(color).getChessPosition().getRow()][king(color).getChessPosition().getColumn()]) 
				return true;
		}
		return false;
	}
	private boolean testCheckMate (Color color) {
		if(!testCheck (color)) 
			return false;
		List <Piece> currentList=piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() ==color).collect(Collectors.toList());
		for(Piece p: currentList) {
			boolean [][] possibleMoves=p.possibleMoves();
		    for(int i=0;i<board.getRow();i++)
		    	for(int j=0;j<board.getColumn();j++)
		    		if(possibleMoves[i][j]) {
		    			Position source= ((ChessPiece)p).getChessPosition().toPosition();
		    		    Position target = new Position(i,j);
		    		    Piece captured= makeMove(source,target);
		    		    boolean testCheck = testCheck(color);
		    		    undoMove(source,target,captured);
		    		    if(!testCheck) {
		    		    	return false;
		    		    }
		    		}
		} 
		return true;
	}
	
	
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPiece('h', 1, new Rook(board, Color.WHITE));
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
	
	
	

