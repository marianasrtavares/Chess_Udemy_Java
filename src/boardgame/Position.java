package boardgame;

public class Position {
  private int row;
  private int column;
  
  
public Position(int row, int column) {
	this.row = row;
	this.column = column;
}


public Integer getRow() {
	return row;
}


public Integer getColumn() {
	return column;
}

public void setValues (Integer row, Integer column) {
	this.row=row;
	this.column= column;
}

@Override
public String toString() {
	return this.row+", "+this.column;
}

  
  
}
