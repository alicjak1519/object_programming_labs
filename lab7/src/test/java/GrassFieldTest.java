import org.junit.Test;

import static org.junit.Assert.*;


public class GrassFieldTest {
    IWorldMap map = new GrassField(10);

    @Test
    public void canMoveToEmptyMapTest() {
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(100, 100)));
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    public void canMoveToNonEmptyMapTest() {
        map.place(new Animal(map, new Vector2d(3, 4)));
        assertFalse(map.canMoveTo(new Vector2d(3, 4)));
    }

    @Test
    public void placeTest() {
        map.place(new Animal(map, new Vector2d(3, 4)));
        assertFalse(map.canMoveTo(new Vector2d(3, 4)));
    }

    @Test
    public void runTest() {
        Animal squirrel = new Animal(map, new Vector2d(3, 4));
        map.place(squirrel);
        String[] strDirs = {"f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(strDirs);
        map.run(directions);
        assertEquals(squirrel.getPosition(), new Vector2d(3, 7));
    }

    @Test
    public void isOccupiedTest() {
        Animal squirrel = new Animal(map, new Vector2d(3, 4));
        map.place(squirrel);
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
    }
}
