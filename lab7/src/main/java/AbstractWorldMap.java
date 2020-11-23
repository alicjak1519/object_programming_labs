import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();
    protected List<Animal> animals = new ArrayList();

    public abstract boolean canMoveTo(Vector2d position);

    public boolean place(Animal animal) {
        try {
            if (isOccupied(animal.getPosition())) {
                return false;
            }
            animals.add(animal);
            animalsMap.put(animal.getPosition(), animal);
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
        for (Map.Entry<Vector2d, Animal> entry : animalsMap.entrySet()) {
            Vector2d key = entry.getKey();
            if (key == position) {
                return true;
            }
        }
        return false;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
       Animal animal = animalsMap.get(oldPosition);
       animalsMap.remove(oldPosition);
       animalsMap.put(newPosition, animal);
    }

    public String toString() {
        return new MapVisualizer(this).draw(findTheSmallestVector(), findTheBiggestVector());
    }

    public abstract Vector2d findTheSmallestVector();

    public abstract Vector2d findTheBiggestVector();
}
