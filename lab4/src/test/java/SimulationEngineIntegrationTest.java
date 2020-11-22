import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class SimulationEngineIntegrationTest {
    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirection[] directions = new OptionsParser().parse(args);
    IWorldMap map = new RectangularMap(10, 5);
    Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
    IEngine engine = new SimulationEngine(directions, map, positions);

    @Test
    public void simulationEngineTest() {
        List<Vector2d> startPositions = new ArrayList();
        List<MapDirection> startMapDirections = new ArrayList();;

        for (Animal animal : map.getAnimals()) {
            startPositions.add(animal.getPosition());
            startMapDirections.add(animal.getMapDirection());
        }

        assertEquals(startPositions, Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        assertEquals(startMapDirections, Arrays.asList(MapDirection.NORTH, MapDirection.NORTH));
    }

    @Test
    public void simulationEngineRunTest(){
        engine.run();

        List<Vector2d> startPositions = new ArrayList();
        List<MapDirection> startMapDirections = new ArrayList();;

        for (Animal animal : map.getAnimals()) {
            startPositions.add(animal.getPosition());
            startMapDirections.add(animal.getMapDirection());
        }

        assertEquals(startPositions, Arrays.asList(new Vector2d(2,0), new Vector2d(3,5)));
        assertEquals(startMapDirections, Arrays.asList(MapDirection.SOUTH, MapDirection.NORTH));
    }
}
