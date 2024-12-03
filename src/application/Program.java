package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // Criação de uma nova partida de xadrez
        ChessMatch chessMatch = new ChessMatch();
        
        // Lista para armazenar as peças capturadas durante a partida
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            try {
            	
            	// Exibe o estado da partida no console (tabuleiro e peças capturadas)
                UI.printMatch(chessMatch, captured);
                System.out.println();
                
                // Solicita ao usuário a posição de origem da peça a ser movida
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                // Obtém os movimentos possíveis para a peça selecionada
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                
                // Exibe o tabuleiro com os movimentos possíveis destacados
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                
                // Solicita ao usuário a posição de destino para o movimento
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                
                // Realiza o movimento de xadrez, retornando a peça capturada (se houver)
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                // Se houve captura, adiciona a peça capturada à lista
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                // Verifica se houve promoção de peão
                if (chessMatch.getPromoted() != null) {
                	// Solicita ao usuário qual peça ele deseja promover o peão
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    
                    // Valida a escolha do usuário para a promoção
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")){
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        
        // Exibe o estado final da partida (com xeque-mate e peças capturadas)
        UI.printMatch(chessMatch, captured);
    }
}