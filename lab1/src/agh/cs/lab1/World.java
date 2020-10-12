package agh.cs.lab1;

import static java.lang.System.out;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        Stream<String> directionsStream = Stream.of(args);
        Direction[] directions = directionsStream.map(World::mapToDirection).toArray(Direction[]::new);
        run(directions);
        out.println("Stop");
    }

    public static void run(Direction[] directions) {
        Stream<Direction> directionsStream = Stream.of(directions);
        directionsStream.map(World::mapToAction).forEach(System.out::println);
    }

    public static Direction mapToDirection(String sign) {
        Map<String, Direction> directionMap = new TreeMap<>();
        directionMap.put("f", Direction.FORWARD);
        directionMap.put("b", Direction.BACKWARD);
        directionMap.put("l", Direction.LEFT);
        directionMap.put("r", Direction.RIGHT);
        return directionMap.get(sign);
    }

    public static String mapToAction(Direction dir) {
        Map<Direction, String> actionMap = new TreeMap<>();
        actionMap.put(Direction.FORWARD, "Step forward");
        actionMap.put(Direction.BACKWARD, "Step backward");
        actionMap.put(Direction.LEFT, "Turn left");
        actionMap.put(Direction.RIGHT, "Turn right");
        return actionMap.getOrDefault(dir, "");
    }

}
