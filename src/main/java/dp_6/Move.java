package dp_6;

public class Move {

    private Point startPoint;
    private Point endPoint;


    public Move(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartPointXValue() {
        return startPoint.getX();
    }

    public int getStartPointYValue() {
        return startPoint.getY();
    }

    public int getEndPointXValue() {
        return endPoint.getX();
    }

    public int getEndPointYValue() {
        return endPoint.getY();
    }

    public boolean endPointIsWithinDistanceOfStartPoint() {
        return (((startPoint.getX() == endPoint.getX() + 2 || startPoint.getX() == endPoint.getX() -2) && startPoint.getY() == endPoint.getY()) ||
                (startPoint.getX() == endPoint.getX() && (startPoint.getY() == endPoint.getY() + 2 || startPoint.getY() == endPoint.getY() -2)));
    }

    public int getMiddlePointXValue() {
        if (startPoint.getX() == endPoint.getX()) {
            return startPoint.getX();
        } else {
            if (startPoint.getX() < endPoint.getX()) {
                return startPoint.getX() + 1;
            } else{
                return startPoint.getX() - 1;
            }
        }
    }

    public int getMiddlePointYValue() {
        if (startPoint.getY() == endPoint.getY()) {
            return startPoint.getY();
        }else{
            if (startPoint.getY() < endPoint.getY()) {
                return startPoint.getY() + 1;
            } else {
                return startPoint.getY() - 1;
            }
        }
    }
}
