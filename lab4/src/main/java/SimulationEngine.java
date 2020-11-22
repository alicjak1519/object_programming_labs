import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine {
    MoveDirection[] moveDirections;
    IWorldMap worldMap;
    List<Vector2d> animalsPositions;

    public SimulationEngine(MoveDirection[] simMoveDirection, IWorldMap simWorldMap, Vector2d[] simAnimalsPostitions) {
        moveDirections = simMoveDirection;
        worldMap = simWorldMap;
        animalsPositions = Arrays.asList(simAnimalsPostitions);

        for (Vector2d position : animalsPositions){
            worldMap.place(new Animal("John", worldMap, position));
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < moveDirections.length; i++) {
            worldMap.getAnimals().get(i % animalsPositions.size()).move(moveDirections[i]);
        }
    }

    public List<Vector2d> getAnimalsPositions(){
        return animalsPositions;
    }
}
