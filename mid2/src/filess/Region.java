package filess;

public class Region {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Region(int minX, int minY, int maxX, int maxY){
        if (minX<0 || maxX>15 || minX>=maxX || minY>=maxY){
            throw new IllegalArgumentException();
        }
        this.minX=minX;
        this.minY=minY;
        this.maxX=maxX;
        this.maxY=maxY;
    }
    public boolean contains(Position position){
        return position.getX()>=minX && position.getX()<=maxX && position.getY()>=minY && position.getY()<=maxY;
    }
}
