package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
    
    // Método abstrato para ser implementado pelas subclasses (peças específicas)
    // Retorna uma matriz de booleanos indicando os movimentos possíveis da peça
    public abstract boolean[][] possibleMoves ();

    // Verifica se a peça pode se mover para a posição fornecida
    public boolean possibleMove(Position position) {
       return possibleMoves()[position.getRow()][position.getColunm()];
    }

    // Verifica se a peça tem algum movimento possível
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }

            }

        }
        return false;
    }
}