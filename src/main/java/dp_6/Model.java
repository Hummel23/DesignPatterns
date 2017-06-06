package dp_6;

import java.util.LinkedList;
import java.util.List;

import static dp_6.State.FREE;

public class Model {

    State[][] field = new State[7][7];

    List<Move> moves = new LinkedList<>();

    public Model() {
        instantiateField();
    }

    private void instantiateField() {
        for (int row = 0; row < 7; row++)
            for (int col = 0; col < 7; col++)
                if (isOutsideGameField(row, col)){
                    field[row][col] = State.NOT;
                }
                else if (isCenterField(row, col)){
                    System.out.println("row = " + row + ", col = " + col + "." );
                    field[row][col] = FREE;
                    System.out.println(field[row][col]);
                }
                else{
                    field[row][col] = State.USED;
                }
                print();
    }

    private boolean isCenterField(int row, int col) {
        return row == 3 && col == 3;
    }

    private boolean isOutsideGameField(int row, int col) {
        return (row == 0 || row == 1 ||row == 5 ||row == 6) && (col == 0 || col == 1 || col == 5 || col == 6) ;

    }

    public boolean move(Move move) {
        return false;
    }

    private void useEndPointField(int endPointXValue, int endPointYValue) {
        field[endPointXValue][endPointYValue] = State.USED;
    }

    private void freeStartPointField(int startPointXValue, int startPointYValue) {
        field[startPointXValue][startPointYValue] = State.FREE;
    }

    private void removeMiddleStone(Move move) {
        if (move.getStartPointXValue() == move.getEndPointXValue()) {
            field[move.getStartPointXValue()][Math.abs(move.getEndPointYValue() - move.getStartPointYValue())] = FREE;
        } else{
            field[Math.abs(move.getStartPointXValue() - move.getEndPointXValue())] [move.getStartPointYValue()] = FREE;
        }
    }

    private boolean isFreeField(int endPointXValue, int endpointYValue) {
        System.out.println(field[endPointXValue] [endpointYValue] );
        return field[endPointXValue] [endpointYValue] == FREE;
    }

    private void print() {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (field[row][col] == State.NOT) System.out.print("  ");
                else if (field[row][col] == FREE) System.out.print("  ");
                else if (field[row][col] == State.USED) System.out.print("o ");
            }
            System.out.println();
        }
    }


    public void checkWin() {
    }
}
