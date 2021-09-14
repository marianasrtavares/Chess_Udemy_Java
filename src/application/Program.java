package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch chess1= new ChessMatch();
		Scanner sc= new Scanner(System.in);
	   while(true) {
		   UI.printBoard(chess1.getPieces()); 
		   System.out.println();
		   System.out.println("source: ");
		   ChessPosition source=UI.readChessPosition(sc);
		   System.out.println("target: ");
		   ChessPosition target= UI.readChessPosition(sc);
		   ChessPiece p= chess1.performChessMove(source, target);
	   }
	   
	   
	  
	   
}
}

