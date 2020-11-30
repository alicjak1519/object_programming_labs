import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.StrictMath.sqrt;


public class GrassField extends AbstractWorldMap {
    private final List<Grass> grasses = new ArrayList();

    public GrassField(int grassNumber) {
        for (int i = 0; i < grassNumber; i++) {
            Grass newGrass = new Grass(generateRandomUnoccupiedVector((int) sqrt(grassNumber * 10)));
            grassesMap.put(newGrass.getPosition(), newGrass);
            grasses.add(newGrass);
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
    public Object objectAt(Vector2d position) {
        for (Map.Entry<Vector2d, Animal> entry : animalsMap.entrySet()) {
            Vector2d key = entry.getKey();
            Animal value = entry.getValue();
            if (key.x == position.x && key.y == position.y) {
                return value;
            }
        }
        for (Map.Entry<Vector2d, Grass> entry : grassesMap.entrySet()) {
            Vector2d key = entry.getKey();
            Grass value = entry.getValue();
            if (key.x == position.x && key.y == position.y) {
                return value;
            }
        }
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Map.Entry<Vector2d, Animal> entry : animalsMap.entrySet()) {
            Vector2d key = entry.getKey();
            if (key.x == position.x && key.y == position.y) {
                return true;
            }
        }
        for (Map.Entry<Vector2d, Grass> entry : grassesMap.entrySet()) {
            Vector2d key = entry.getKey();
            if (key.x == position.x && key.y == position.y) {
                return true;
            }
        }
        return false;
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
