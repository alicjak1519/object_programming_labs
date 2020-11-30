public class Grass extends AbstractWorldMapElement {


    public Grass(Vector2d thisPosition) {
        position = thisPosition;
    }

    @Override
    public String toString() {
        return "*";
    }
}
