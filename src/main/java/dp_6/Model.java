package dp_6;

import java.util.LinkedList;
import java.util.List;

import static dp_6.State.*;
import static dp_6.State.FREE;

class Model {

    State[][] field = new State[7][7];

    private List<Move> moves = new LinkedList<>();

    Model() {
        instantiateField();
    }

    private void instantiateField() {
        for (int row = 0; row < 7; row++)
            for (int col = 0; col < 7; col++)
                if (isOutsideGameField(row, col)){
                    field[row][col] = NOT;
                }
                else if (isCenterField(row, col)){
                    System.out.println("row = " + row + ", col = " + col + "." );
                    field[row][col] = FREE;
                    System.out.println(field[row][col]);
                }
                else{
                    field[row][col] = USED;
                }
                print();
    }

    private boolean isCenterField(int row, int col) {
        return row == 3 && col == 3;
    }

    private boolean isOutsideGameField(int row, int col) {
        return (row == 0 || row == 1 ||row == 5 ||row == 6) && (col == 0 || col == 1 || col == 5 || col == 6) ;

    }

    boolean move(Move move) {
        int startX = move.getStartPointXValue();
        int startY = move.getStartPointYValue();

        int endX = move.getEndPointXValue();
        int endY = move.getEndPointYValue();

        int middleX = move.getMiddlePointXValue();
        int middleY = move.getMiddlePointYValue();

        if (field[startX][startY] == USED) {
            if (move.endPointIsWithinDistanceOfStartPoint()) {
                if (isFreeField(endX, endY)) {
                    freeField(startX, startY);
                    freeField(middleX, middleY);
                    useEndPointField(endX, endY);
                    moves.add(move);
                    return true;
                }
            }
        }
        return false;
    }

    private void freeField(int startX, int startY) {
        field[startX][startY] = FREE;
    }

    private void useEndPointField(int endPointXValue, int endPointYValue) {
        field[endPointXValue][endPointYValue] = USED;
    }

    private boolean isFreeField(int endPointXValue, int endpointYValue) {
        return field[endPointXValue] [endpointYValue] == FREE;
    }

    private void print() {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (field[row][col] == NOT) System.out.print("  ");
                else if (field[row][col] == FREE) System.out.print("  ");
                else if (field[row][col] == USED) System.out.print("o ");
            }
            System.out.println();
        }
    }


    boolean gameIsWon() {
        int numberOfUsedField = 0;
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (field[row][col] == State.USED) {
                    numberOfUsedField++;
                    if (numberOfUsedField == 2) {
                        return false;
                    }

                }
            }
        }
            return true;
    }

    boolean undoMove() {
        if (moves.size() > 0) {
            Move move = moves.get(moves.size() - 1);
            field[move.getStartPointXValue()][move.getStartPointYValue()] = USED;
            field[move.getMiddlePointXValue()][move.getMiddlePointYValue()] = USED;
            field[move.getEndPointXValue()][move.getEndPointYValue()] = FREE;
            moves.remove(move);
            return true;
        }
        return false;
    }
}
