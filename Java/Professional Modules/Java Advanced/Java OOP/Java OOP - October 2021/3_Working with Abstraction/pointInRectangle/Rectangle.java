package pointInRectangle;

public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return point.getX() >= this.bottomLeft.getX()
                && point.getX() <= this.topRight.getX()
                && point.getY() <= this.topRight.getY()
                && point.getY() >= this.bottomLeft.getY();
    }
}
