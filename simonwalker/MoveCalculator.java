package simonwalker;

import java.util.ArrayList;

public class MoveCalculator {
    private String getClass(Board.PieceTypes type) {
        return new StringBuilder(type.name()).deleteCharAt(0).deleteCharAt(0).toString();
    }

    private char getTeam(Board.PieceTypes type) {
        return type.name().charAt(0);
    }       // always gives a w or b ofc

    private boolean inBounds(Vector2 pos, Board.PieceTypes board[][]) {
        if (pos.getX() < 0 || pos.getX() > board[0].length) return false;
        else if (pos.getY() < 0 || pos.getX() > board.length) return  false;

        return true;
    }

    // utility stuff up there

    private ArrayList<Vector2> pawn(Board.PieceTypes board[][], Vector2 pos) {
        if (!inBounds(pos, board)) return null;

        // the piece is in bounds

        Board.PieceTypes type = board[pos.getX()][pos.getX()];
        char team = getTeam(type);
        String _class = getClass(type);

        int verticalShift = -1;                              // 1 for white team and -1 for black team
        if (getTeam(type) == 'b') verticalShift = 1;
        ArrayList<Vector2> possibilities = new ArrayList<>();

        // this line's condition is:     new spot in bounds and if its empty
        if (inBounds(new Vector2(pos.getY() + verticalShift, pos.getX()), board) && board[pos.getY() + verticalShift][pos.getX()] == Board.PieceTypes.none) possibilities.add(new Vector2(pos.getX(), pos.getY() + verticalShift));
        for (int i = -1; i < 2; i+=2) { // i will be 1 then -1
            // if the new spot is in bounds and it is of the enemy team
            Vector2 newslot = new Vector2(pos.getX(), pos.getY() + verticalShift);

            if (inBounds(newslot, board)) {
                if (getTeam(board[newslot.getY()][newslot.getY()]) != team || board[newslot.getY()][newslot.getX()] == Board.PieceTypes.none) possibilities.add(newslot);
            }           // I formatted it like this purely so it could be easily read
        }

        return possibilities;
    }

    private ArrayList<Vector2> rook(Board.PieceTypes board[][], Vector2 pos) {
//        if (!inBounds(pos, board)) return null;
//
//        // the piece is in bounds
//
//        Board.PieceTypes type = board[pos.getX()][pos.getX()];
//        char team = getTeam(type);
//        String _class = getClass(type);
//
//        int verticalShift = -1;                              // 1 for white team and -1 for black team
//        if (getTeam(type) == 'b') verticalShift = 1;
//        ArrayList<Vector2> possibilities = new ArrayList<>();
//
//        // this line's condition is:     new spot in bounds and if its empty
//        if (inBounds(new Vector2(pos.getY() + verticalShift, pos.getX()), board) && board[pos.getY() + verticalShift][pos.getX()] == Board.PieceTypes.none) possibilities.add(new Vector2(pos.getX(), pos.getY() + verticalShift));
//        for (int i = -1; i < 2; i+=2) { // i will be 1 then -1
//            // if the new spot is in bounds and it is of the enemy team
//            Vector2 newslot = new Vector2(pos.getX(), pos.getY() + verticalShift);
//
//            if (inBounds(newslot, board)) {
//                if (getTeam(board[newslot.getY()][newslot.getY()]) != team || board[newslot.getY()][newslot.getX()] == Board.PieceTypes.none) possibilities.add(newslot);
//            }           // I formatted it like this purely so it could be easily read
//        }
//
//        return possibilities;
    }
}