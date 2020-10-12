package agh.cs.lab1;

import static java.lang.System.out;

import java.util.*;
import java.util.stream.Stream;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        Stream<Direction> directionsStream = Stream.of(args).filter(World::validDirection).map(World::stringToDirection);
        Direction[] directions = directionsStream.toArray(Direction[]::new);
        run(directions);
        out.println("Stop");
    }

    public static void run(Direction[] directions) {
        Stream<Direction> directionsStream = Stream.of(directions);
        directionsStream.map(World::mapToAction).forEach(System.out::println);
    }

    public static Boolean validDirection(String sign) {
        List<String> validDirections = Arrays.asList(new String[]{"f", "b", "l", "r"});
        return validDirections.contains(sign);
    }

    public static Direction stringToDirection(String sign) {
        switch (sign) {
            case "f":
                return Direction.FORWARD;
            case "b":
                return Direction.BACKWARD;
            case "l":
                return Direction.LEFT;
            case "t":
                return Direction.RIGHT;
        }
        return Direction.FORWARD;
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
