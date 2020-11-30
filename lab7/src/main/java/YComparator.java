import java.util.Comparator;

public class YComparator implements Comparator<Vector2d> {

    @Override
    public int compare(Vector2d firstVector, Vector2d secondVector) {
        if (firstVector.y == secondVector.y) {
            return Integer.compare(firstVector.x, secondVector.x);
        } else {
            return Integer.compare(firstVector.y, secondVector.y);
        }
    }
}