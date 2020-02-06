package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getRows()];

        Position p = new Position(0,0);

        /* Better implementation with for loop
	        // above
	        p.setValues(position.getRow() - 1, position.getColumn());
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }

	        // below
	        p.setValues(position.getRow() + 1, position.getColumn());
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }

	        // left
	        p.setValues(position.getRow(), position.getColumn() - 1);
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }

	        // right
	        p.setValues(position.getRow(), position.getColumn() + 1);
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }

	        // nw
	        p.setValues(position.getRow() - 1, position.getColumn() - 1);
	        System.out.println("Position Exists: " + getBoard().positionExists(p));
	        System.out.println("Can move: " + canMove(p));
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }

	        // ne
	        p.setValues(position.getRow() - 1, position.getColumn() + 1);
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }

	        // sw
	        p.setValues(position.getRow() + 1, position.getColumn() - 1);
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }

	        // se
	        p.setValues(position.getRow() + 1, position.getColumn() + 1);
	        if (getBoard().positionExists(p) && canMove(p)) {
	            mat[p.getRow()][p.getColumn()] = true;
	        }
        */

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                p.setValues(position.getRow() + i, position.getColumn() + j);
                if (getBoard().positionExists(p) && canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        }

        return mat;
    }
}
