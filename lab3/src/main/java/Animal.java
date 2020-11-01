public class Animal {
    private String name;
    private MapDirection mapDirection = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public Animal(String animalName) {
        name = animalName;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getMapDirection() {
        return mapDirection;
    }

    public void move(MoveDirection direction) {
        Vector2d startPosition = position;
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
                        position = position.add(new Vector2d(0, 1));
                        break;
                    case EAST:
                        position = position.add(new Vector2d(1, 0));
                        break;
                    case WEST:
                        position = position.add(new Vector2d(-1, 0));
                        break;
                    case SOUTH:
                        position = position.add(new Vector2d(0, -1));
                        break;
                }
                break;
            case BACKWARD:
                switch (mapDirection) {
                    case NORTH:
                        position = position.add(new Vector2d(0, -1));
                        break;
                    case EAST:
                        position = position.add(new Vector2d(-1, 0));
                        break;
                    case WEST:
                        position = position.add(new Vector2d(1, 0));
                        break;
                    case SOUTH:
                        position = position.add(new Vector2d(0, 1));
                        break;
                }
                break;
        }
        if (position.x < 0 || position.x > 4 || position.y < 0 || position.y > 4) {
            position = startPosition;
        }
    }

    @Override
    public String toString() {
        return name + ": direction = " + mapDirection + ", position = " + position;
    }
}
