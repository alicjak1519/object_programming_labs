public class World {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            map.place(new Animal("Squirrel John", map));
            map.place(new Animal("Squirrel Julia", map, new Vector2d(3, 4)));
            map.place(new Animal("Squirrel Julia", map, new Vector2d(3, 4)));

            System.out.println(map);

            map.run(directions);

            System.out.println(map);
        }
        catch (IllegalArgumentException ex){
            throw new IllegalArgumentException(ex);
        }
    }
}
