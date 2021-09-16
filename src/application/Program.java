package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch chess1= new ChessMatch();
		Scanner sc= new Scanner(System.in);
	   while(true) {
		   try {
		   UI.clearScreen();
		   UI.printMatch(chess1); 
		   System.out.println();
		   System.out.println("source: ");
		   ChessPosition source=UI.readChessPosition(sc);
		   boolean [][] possibleMoves = chess1.possibleMoves(source);
		   UI.clearScreen();
		   UI.printBoard(chess1.getPieces(), possibleMoves);
		   System.out.println("target: ");
		   ChessPosition target= UI.readChessPosition(sc);
		   
		   ChessPiece p= chess1.performChessMove(source, target);
		   }
		   catch(ChessException e) {
			   System.out.println(e.getMessage());
			   sc.nextLine();
			   
		   }catch(InputMismatchException e) {
			   System.out.println(e.getMessage());
			   sc.nextLine();
			   
	   }
	   
	   
	  
	   
}
	}
}

