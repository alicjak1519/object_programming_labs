public class World {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            AbstractWorldMap map = new GrassField(10);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(0, 9)));

            MapBoundary mapBoundary = new MapBoundary(map);

            System.out.println(map);
            map.run(directions);
            System.out.println(map);
        }
        catch (IllegalArgumentException ex){
            throw new IllegalArgumentException(ex);
        }
    }
}
