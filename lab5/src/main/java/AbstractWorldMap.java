import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final List<Animal> animals = new ArrayList();

    public abstract boolean canMoveTo(Vector2d position);


    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition())) {
            return false;
        }
        animals.add(animal);
        return true;
    }

    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return new MapVisualizer(this).draw(findTheSmallestVector(), findTheBiggestVector());
    }

    public abstract Vector2d findTheSmallestVector();

    public abstract Vector2d findTheBiggestVector();
}
