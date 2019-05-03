package simonwalker;

import com.sun.deploy.util.StringUtils;

public class Board {
    enum PieceTypes {none,
                     w_king, w_queen, w_rook, w_bishop, w_knight, w_pawn,
                     b_king, b_queen, b_rook, b_bishop, b_knight, b_pawn}

    enum Teams {w, b}

    private PieceTypes[][] board = new PieceTypes[8][8];

    // ---

    boolean setCell(Vector2 pos, PieceTypes type) {
        if ((pos.getX() < 0) || (pos.getX() > board.length)) return false;
        else if ((pos.getY() < 0) || (pos.getY() > board[0].length)) return false;

        // the position is in bounds

        board[pos.getY()][pos.getX()] = type;
        return true;
    }           // a single cell version of the other one
    boolean setCell(Vector2 pos1, Vector2 pos2, PieceTypes type) {
        if ((pos1.getX() < 0) || (pos1.getX() > board.length)) return false;
        else if ((pos1.getY() < 0) || (pos1.getY() > board[0].length)) return false;
        if ((pos2.getX() < 0) || (pos2.getX() > board.length)) return false;
        else if ((pos2.getY() < 0) || (pos2.getY() > board[0].length)) return false;

        // both points are now in bounds

        int yShift = 0;
        for (int i = 0; i < Math.abs(pos1.getY() - pos2.getY()); i++) {
            int xShift = 0;
            for (int j = 0; j < Math.abs(pos1.getY() - pos2.getY()); j++) {
                board[pos1.getY() + yShift][pos1.getX() + xShift] = type;           // the setter

                xShift += (pos1.getX() - pos2.getX()) / -(pos1.getX() - pos2.getX());
            }

            yShift += (pos1.getY() - pos2.getY()) / -(pos1.getX() - pos2.getX());
        }

        return true;
    }

    PieceTypes getType(Vector2 pos) {
        return board[pos.getY()][pos.getX()];
    }

    void reset() {
        setCell(new Vector2(0, 0), new Vector2(7, 7), PieceTypes.none);         // first blank spaces are filled underneath

        setCell(new Vector2(0, 7), new Vector2(7, 7), PieceTypes.w_pawn);       // white pawns
        setCell(new Vector2(0, 1), new Vector2(7, 1), PieceTypes.b_pawn);       // black pawns

        setCell(new Vector2(0, 0), PieceTypes.b_rook);      // black rooks
        setCell(new Vector2(7, 0), PieceTypes.b_rook);

        setCell(new Vector2(0, 7), PieceTypes.w_rook);      // white rooks
        setCell(new Vector2(7, 7), PieceTypes.w_rook);

        setCell(new Vector2(6, 0), PieceTypes.b_knight);    // black knights
        setCell(new Vector2(1, 0), PieceTypes.b_knight);

        setCell(new Vector2(6, 7), PieceTypes.w_knight);    // white knights
        setCell(new Vector2(1, 7), PieceTypes.w_knight);

        setCell(new Vector2(5, 0), PieceTypes.b_bishop);    // black bishops
        setCell(new Vector2(2, 0), PieceTypes.b_bishop);

        setCell(new Vector2(5, 7), PieceTypes.w_bishop);    // white bishops
        setCell(new Vector2(2, 7), PieceTypes.w_bishop);

        setCell(new Vector2(3, 0), PieceTypes.b_queen);     // queens
        setCell(new Vector2(3, 7), PieceTypes.w_queen);

        setCell(new Vector2(4, 0), PieceTypes.b_king);      // kings
        setCell(new Vector2(4, 7), PieceTypes.w_king);
    }

    Vector2[] getAllMoves(Vector2 pos) {
        //
    }

    int getTeamValue(Teams team) {
        int val = 0;

        for (PieceTypes row[] : board) {
            for (PieceTypes piece : row) {
                if (piece.name().startsWith(team.name())) {             // checks the first char of the piece to determine if it adds to the score
                    switch (new StringBuilder(team.name()).deleteCharAt(0).deleteCharAt(0).toString()) {        // retrieves the piece name without the w/b_ in front
                        case "knight":
                            val += 3;
                            break;
                        case "bishop":
                            val += 3;
                            break;
                        case "rook":
                            val += 5;
                            break;
                        case "queen":
                            val += 9;
                            break;
                        case "pawn":
                            val += 1;
                            break;
                    }   // switch
                }
            } // inner for, iterates thru/ x
        } // outer for, iterates thru/ y

        return val;
    }

    boolean inCheck(Vector2 pos) {
        //
    }
}
