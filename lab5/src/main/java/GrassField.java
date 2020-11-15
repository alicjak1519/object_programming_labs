import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.StrictMath.sqrt;


public class GrassField implements IWorldMap {
    private final List<Grass> grasses = new ArrayList();
    private final List<Animal> animals = new ArrayList();


    public GrassField(int grassNumber) {
        for (int i = 0; i < grassNumber; i++) {
            grasses.add(new Grass(generateRandomUnoccupiedVector((int) sqrt(grassNumber * 10))));
        }
    }

    public Vector2d generateRandomUnoccupiedVector(int max) {
        Random generator = new Random();
        int x = generator.nextInt(max);
        int y = generator.nextInt(max);
        Vector2d newVector = new Vector2d(x, y);
        if (isOccupied(newVector)) {
            return generateRandomUnoccupiedVector(max);
        } else {
            return newVector;
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
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
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
            if (!canMoveTo(position)) {
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
        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(findTheSmallestVector(), findTheBiggestVector());
    }

    public Vector2d findTheSmallestVector() {
        int theSmallestX = 0;
        int theSmallestY = 0;
        for (Animal animal : animals) {
            if (animal.getPosition().x < theSmallestX) {
                theSmallestX = animal.getPosition().x;
            }
            if (animal.getPosition().y < theSmallestY) {
                theSmallestY = animal.getPosition().y;
            }
        }
        for (Grass grass : grasses) {
            if (grass.getPosition().x < theSmallestX) {
                theSmallestX = grass.getPosition().x;
            }
            if (grass.getPosition().y < theSmallestY) {
                theSmallestY = grass.getPosition().y;
            }
        }
        return new Vector2d(theSmallestX, theSmallestY);
    }

    public Vector2d findTheBiggestVector() {
        int theBiggestX = 0;
        int theBiggestY = 0;
        for (Animal animal : animals) {
            if (animal.getPosition().x > theBiggestX) {
                theBiggestX = animal.getPosition().x;
            }
            if (animal.getPosition().y > theBiggestY) {
                theBiggestY = animal.getPosition().y;
            }
        }
        for (Grass grass : grasses) {
            if (grass.getPosition().x > theBiggestX) {
                theBiggestX = grass.getPosition().x;
            }
            if (grass.getPosition().y > theBiggestY) {
                theBiggestY = grass.getPosition().y;
            }
        }
        return new Vector2d(theBiggestX, theBiggestY);
    }
}
