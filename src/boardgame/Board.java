package boardgame;

public class Board {
    private int rows;
    private int columns;

    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1 ){
            throw  new BoardException("Error when creating the board: At least 1 row and 1 column are required. ");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Retorna a peça presente na posição (linha, coluna)
    public Piece piece(int row, int column){
        if (!positionExists(row,column)){
            throw new BoardException("This position does not exist on the board");
        }
        return pieces[row][column];
    }

    // Retorna a peça presente em uma posição específica, fornecida como objeto Position
    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("This position does not exist on the board");
        }
        return pieces[position.getRow()][position.getColunm()];
    }
    
    // Coloca uma peça no tabuleiro na posição especificada
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)){
            throw new BoardException("There is already someone in this position: "+position);
        }
        pieces[position.getRow()][position.getColunm()] = piece;
        piece.position = position;
    }

    // Remove uma peça da posição especificada no tabuleiro
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");

        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColunm()] = null;
        return aux;

    }
    
    // Verifica se a posição (linha, coluna) existe no tabuleiro
    public boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // Verifica se a posição especificada por um objeto Position existe no tabuleiro
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColunm());
    }

    // Verifica se há uma peça na posição especificada
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("This position does not exist on the board");
        }
        return piece(position) != null;
    }

}
