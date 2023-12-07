package filess;

public class World {
    private Caterpillar caterpillar;
    private Position food;
    private Region region;
    private ActionQueue actionQueue;
    private TargetQueue targetQueue;
    private GameState gameState;

    public World(TargetQueue targetQueue, ActionQueue actionQueue) {
        this.targetQueue = targetQueue;
        this.actionQueue = actionQueue;
        this.region = new Region(0, 0, 15, 15);
        this.caterpillar = new Caterpillar();
        this.food = targetQueue.dequeue();
        this.gameState = GameState.MOVE;
    }

    public static void moveP(Direction d, Position p) {
        if (d.equals(Direction.EAST)) {
            p.moveEast();
        } else if (d.equals(Direction.WEST)) {
            p.moveWest();
        } else if (d.equals(Direction.NORTH)) {
            p.moveNorth();
        } else if (d.equals(Direction.SOUTH)) {
            p.moveSouth();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void step() {
        if (actionQueue.isEmpty()) {
            gameState = GameState.NO_MORE_ACTION;
            return;
        } else {
            if (gameState != GameState.MOVE && gameState != GameState.EAT) {
                return;
            }
            Direction nextD = actionQueue.dequeue();
            Position headP = new Position(caterpillar.getHead());
            moveP(nextD, headP);
            if (!region.contains(headP)) {
                gameState = GameState.WALL_COLLISION;
                return;
            }
            if (caterpillar.selfCollision(headP)) {
                gameState = GameState.SELF_COLLISION;
                return;
            }
            if (food.equals(headP)) {
                caterpillar.eat(headP);
                if (targetQueue.isEmpty()) {
                    gameState = GameState.DONE;
                    food = null;
                } else {
                    gameState = GameState.EAT;
                    food = targetQueue.dequeue();
                }
            } else {
                caterpillar.move(headP);
                gameState = GameState.MOVE;
            }
        }
    }


    public GameState getState(){
        return gameState;
    }
    public Caterpillar getCaterpillar(){
        return caterpillar;
    }
    public Position getFood(){
        return food;
    }
    public boolean isRunning(){
        return gameState == GameState.MOVE || gameState == GameState.EAT;
    }

}
