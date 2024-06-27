package chess.piece;

import chess.Board;
import chess.util.ChessPoint;
import chess.util.Direction;
import chess.util.MoveRule;

import java.util.*;

public class King extends Piece {
    public static final char WHITE_REPRESENTATION = '♔';
    public static final char BLACK_REPRESENTATION = '♚';
    public static final double DEFAULT_POINT = 0;

    private King(Color color, char representation) {
        super(color, representation, Direction.everyDirection(), 1);
    }

    public static King create(Color color) {
        return color == Color.WHITE ? createWhite() : createBlack();
    }

    public static King createWhite() {
        return new King(Color.WHITE, WHITE_REPRESENTATION);
    }

    public static King createBlack() {
        return new King(Color.BLACK, BLACK_REPRESENTATION);
    }

    @Override
    protected Map<ChessPoint, MoveRule> getSpecialMovablePoints(ChessPoint source, Board board, boolean onlyAttackable) {
        Map<ChessPoint, MoveRule> movablePoints = new HashMap<>();

        // castling
        MoveRule.Castling.adapt(movablePoints, board, source, this, onlyAttackable);

        return movablePoints;
    }

    @Override
    public double getDefaultPoint() {
        return DEFAULT_POINT;
    }
}
