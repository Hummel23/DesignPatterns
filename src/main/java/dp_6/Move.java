package dp_6;

class Move {

    private Point startPoint;
    private Point endPoint;
    private Point middlePoint;


    Move(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.middlePoint = new Point(getMiddlePointXValue(), getMiddlePointYValue());
    }

    int getStartPointXValue() {
        return startPoint.getX();
    }

    int getStartPointYValue() {
        return startPoint.getY();
    }

    int getEndPointXValue() {
        return endPoint.getX();
    }

    int getEndPointYValue() {
        return endPoint.getY();
    }

    boolean endPointIsWithinDistanceOfStartPoint() {
        return (((startPoint.getX() == endPoint.getX() + 2 || startPoint.getX() == endPoint.getX() -2) && startPoint.getY() == endPoint.getY()) ||
                (startPoint.getX() == endPoint.getX() && (startPoint.getY() == endPoint.getY() + 2 || startPoint.getY() == endPoint.getY() -2)));
    }

    int getMiddlePointXValue() {
        if (this.middlePoint == null) {
            if (startPoint.getX() == endPoint.getX()) {
                return startPoint.getX();
            } else {
                if (startPoint.getX() < endPoint.getX()) {
                    return startPoint.getX() + 1;
                } else{
                    return startPoint.getX() - 1;
                }
            }
        } else {
            return this.middlePoint.getX();
        }
    }

    int getMiddlePointYValue() {
        if (this.middlePoint == null) {
            if (startPoint.getY() == endPoint.getY()) {
                return startPoint.getY();
            }else{
                if (startPoint.getY() < endPoint.getY()) {
                    return startPoint.getY() + 1;
                } else {
                    return startPoint.getY() - 1;
                }
            }
        } else {
            return this.middlePoint.getY();
        }
    }
}
