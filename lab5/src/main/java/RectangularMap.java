import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Integer mapWidth;
    private final Integer mapHeight;
    private final List<Animal> animals = new ArrayList();

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
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(mapWidth, mapHeight));
    }
}
