package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    // Incrementa o contador de movimentos da peça (usado após cada movimento)
    public void increaseMoveCount() {
        moveCount++;
    }

    // Decrementa o contador de movimentos da peça (usado para desfazer um movimento)
    public void decreaseMoveCount() {
        moveCount--;
    }

    // Retorna a posição da peça no formato de xadrez (ex.: e4, d5)
    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    // Verifica se há uma peça do oponente em uma determinada posição
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}