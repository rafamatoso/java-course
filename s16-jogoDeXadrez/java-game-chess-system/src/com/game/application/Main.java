package com.game.application;


import com.game.chess.ChessException;
import com.game.chess.ChessMatch;
import com.game.chess.ChessPiece;
import com.game.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        System.out.println();

        while (!chessMatch.isCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
                if (chessMatch.getPromoted() != null) {
                    System.out.print("Enter piece for Promotion (B/N/R/Q): ");
                    String type = sc.nextLine();
                    chessMatch.replacePromotedPiece(type);
                }
                System.out.println();
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
