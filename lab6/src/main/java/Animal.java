public class Animal {
    private final String name;
    private MapDirection mapDirection = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap thisMap;

    public Animal(String animalName) {
        name = animalName;
    }

    public Animal(String animalName, IWorldMap map) {
        name = animalName;
        thisMap = map;
    }

    public Animal(String animalName, IWorldMap map, Vector2d initialPosition) {
        name = animalName;
        thisMap = map;
        position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
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
            position = newPosition;
        }

    }

    @Override
    public String toString() {
        return getMapDirection().toString();
    }
}
