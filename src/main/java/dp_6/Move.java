package dp_6;

public class Move {

    Point startPoint;
    Point endPoint;


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
        System.out.println("start point x: " + startPoint.getX());
        System.out.println("end point x: " + endPoint.getX());

        System.out.println("start point y: " + startPoint.getY());
        System.out.println("end point y: " + endPoint.getY());
        System.out.println(startPoint.getY() == endPoint.getY() + 2 || startPoint.getY() == endPoint.getY() -2);
        return (((startPoint.getX() == endPoint.getX() + 2 || startPoint.getX() == endPoint.getX() -2) && startPoint.getY() == endPoint.getY()) ||
                (startPoint.getX() == endPoint.getX() && (startPoint.getY() == endPoint.getY() + 2 || startPoint.getY() == endPoint.getY() -2)));
    }
}
