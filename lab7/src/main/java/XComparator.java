import java.util.Comparator;

public class XComparator implements Comparator<Vector2d> {

    @Override
    public int compare(Vector2d firstVector, Vector2d secondVector) {
        if (firstVector.x == secondVector.x) {
            return Integer.compare(firstVector.y, secondVector.y);
        } else {
            return Integer.compare(firstVector.x, secondVector.x);
        }
    }
}