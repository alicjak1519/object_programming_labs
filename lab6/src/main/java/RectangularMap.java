public class RectangularMap extends AbstractWorldMap {
    private final Integer mapWidth;
    private final Integer mapHeight;

    public RectangularMap(Integer width, Integer height) {
        mapWidth = width;
        mapHeight = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(position.x > mapWidth || position.x < 0 || position.y > mapHeight || position.y < 0 || isOccupied(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public Vector2d findTheSmallestVector() {
        return new Vector2d(0, 0);
    }

    @Override
    public Vector2d findTheBiggestVector() {
        return new Vector2d(mapWidth, mapHeight);
    }
}
