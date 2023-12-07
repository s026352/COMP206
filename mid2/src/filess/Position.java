package filess;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void reset(Position position) {
        reset(position.getX(), position.getY());
    }

    public int getDistance(Position position) {
        int dis = Math.abs(position.x - this.x) + Math.abs(position.y - this.y);
        return dis;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveWest() {
        x--;
    }

    public void moveEast() {
        x++;
    }

    public void moveNorth() {
        y--;
    }

    public void moveSouth() {
        y++;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Position)) {
            return false;
        }
        Position position1 = (Position) object;
        return (x == position1.getX() && y == position1.getY());


    }



}
