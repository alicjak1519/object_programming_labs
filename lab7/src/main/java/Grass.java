public class Grass {
    private final Vector2d position;

    public Grass(Vector2d thisPosition) {
        position = thisPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "*";
    }
}
