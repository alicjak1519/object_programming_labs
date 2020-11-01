import java.util.ArrayList;
import java.util.List;

public class OptionParser {
    public MoveDirection[] parse(String[] options) {
        List<MoveDirection> directions = new ArrayList<>();

        for (String option : options) {
            switch (option) {
                case "f":
                case "forward":
                    directions.add(MoveDirection.FORWARD);
                    break;
                case "b":
                case "backward":
                    directions.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                case "right":
                    directions.add(MoveDirection.RIGHT);
                    break;
                case "l":
                case "left":
                    directions.add(MoveDirection.LEFT);
                    break;
                default:
                    break;
            }
        }

        MoveDirection[] directionsArray = new MoveDirection[directions.size()];
        directionsArray = directions.toArray(directionsArray);

        return directionsArray;
    }
}
