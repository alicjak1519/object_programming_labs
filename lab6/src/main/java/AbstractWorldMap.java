import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    public abstract boolean canMoveTo(Vector2d position);

    public boolean place(Animal animal) {
        try {
            if (isOccupied(animal.getPosition())) {
                return false;
            }
            animals.put(animal.getPosition(), animal);
            return true;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(animal.getPosition() + " is occupied by other animal");
        }
    }

    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    public boolean isOccupied(Vector2d position) {
        for (Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            Vector2d key = entry.getKey();
            Animal value = entry.getValue();
        }
        return true;
    }

    public String toString() {
        return new MapVisualizer(this).draw(findTheSmallestVector(), findTheBiggestVector());
    }

    public abstract Vector2d findTheSmallestVector();

    public abstract Vector2d findTheBiggestVector();
}
