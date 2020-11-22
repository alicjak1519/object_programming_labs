import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
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
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) {
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
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
    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(mapWidth, mapHeight));
    }
}
