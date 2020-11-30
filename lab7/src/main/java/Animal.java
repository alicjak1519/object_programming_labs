import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {
    private MapDirection mapDirection;
    private final IWorldMap thisMap;
    private final List<IPositionChangeObserver> observers;


    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        thisMap = map;
        position = initialPosition;
        mapDirection = MapDirection.NORTH;
        observers = new ArrayList();
    }

    public MapDirection getMapDirection() {
        return mapDirection;
    }

    public void move(MoveDirection direction) {
        Vector2d newPosition = new Vector2d(-1, -1);
        switch (direction) {
            case RIGHT:
                mapDirection = mapDirection.next();
                break;
            case LEFT:
                mapDirection = mapDirection.previous();
                break;
            case FORWARD:
                switch (mapDirection) {
                    case NORTH:
                        newPosition = position.add(new Vector2d(0, 1));
                        break;
                    case EAST:
                        newPosition = position.add(new Vector2d(1, 0));
                        break;
                    case WEST:
                        newPosition = position.add(new Vector2d(-1, 0));
                        break;
                    case SOUTH:
                        newPosition = position.add(new Vector2d(0, -1));
                        break;
                }
                break;
            case BACKWARD:
                switch (mapDirection) {
                    case NORTH:
                        newPosition = position.add(new Vector2d(0, -1));
                        break;
                    case EAST:
                        newPosition = position.add(new Vector2d(-1, 0));
                        break;
                    case WEST:
                        newPosition = position.add(new Vector2d(1, 0));
                        break;
                    case SOUTH:
                        newPosition = position.add(new Vector2d(0, 1));
                        break;
                }
                break;
        }

        if (thisMap.canMoveTo(new Vector2d(newPosition.x, newPosition.y))) {
            positionChanged(position, newPosition);
            position = newPosition;
        }

    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public String toString() {
        return getMapDirection().toString();
    }
}
