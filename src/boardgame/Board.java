package boardgame;

public class Board {
  private int row;
  private int column;
  public Piece[][] pieces;
  
  
public Board(int row, int column) {
	if(row<1 || column<1) {
		throw new BoardException("Error creating board. there must be at least 1 row and 1 column");
	}
	this.row = row;
	this.column = column;
	pieces= new Piece[row][column];
	
}



public int getRow() {
	return row;
	
}

public int getColumn() {
	return column;
}

public Piece piece (int row, int column) {
	if(!positionExists(row, column)) {
		throw new BoardException("That position doesnt exists on the board");
	}
	return pieces[row][column];
  
}

public Piece piece(Position position) {
	if(!positionExists(position)) {
		throw new BoardException("That position doesnt exists o the board");
	}
	
	return pieces[position.getRow()][position.getColumn()];
}

public void placePiece( Piece piece, Position position) {
	if(thereIsAPiece(position)) {
		throw new BoardException("There is already a piece on position ");
	}
		pieces[position.getRow()][position.getColumn()]=piece;
		piece.position=position;
}

private boolean positionExists(int row, int column) {
	return row<= this.row &&  row>=0 && column>=0 && column<=this.column; 
}


public boolean positionExists (Position position) {
	return positionExists(position.getRow(), position.getColumn());
}

public boolean thereIsAPiece(Position position) {
	if(!positionExists(position)) {
		throw new BoardException("That position doesnt exists o the board");
	}
	return piece(position)!=null;
}

public Piece removePiece(Position position) {
	
	if(!positionExists(position)) {
		throw new BoardException("That position doesnt exists o the board");
	}
	
	if(piece(position)==null) {
		return null;
	}
	Piece p= piece(position);
		p.position=null;
		pieces[position.getRow()][position.getColumn()]=null;
	return p;
}
}

  


