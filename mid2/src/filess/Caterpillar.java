package filess;

public class Caterpillar extends MyDoublyLinkedList<Position>{
    public Caterpillar(){
        super();
        this.add(new Position(7,7));
        this.size = 1;
    }

    public Position getHead(){
        return this.peekFirst();

    }
    public void eat(Position p1){

        if (!this.isOrthogonal(p1)){
            throw new IllegalArgumentException();
        }
        this.addFirst(p1);

    }
    public void move(Position p2){

        if(!this.isOrthogonal(p2)){
            throw new IllegalArgumentException();
        }
        this.addFirst(p2);
        this.removeLast();
    }
    public boolean selfCollision(Position overlap){
        for (Position part : this){
            if (part.equals(overlap)){
                return true;
            }
        }
        return false;
    }
    public boolean isOrthogonal(Position position){
        int xH = this.getHead().getX();
        int yH = this.getHead().getY();
        int x = position.getX();
        int y = position.getY();

        return ((xH==x && (yH == y-1 || yH == y+1)) || (yH == y && (xH == x+1 || xH == x -1)));
    }
}
