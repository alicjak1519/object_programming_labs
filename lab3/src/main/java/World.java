public class World {
    public static void main(String[] args) {
        Animal squirrel = new Animal("Squirrel John");
        System.out.println("My squirrel hits the road.");
        System.out.println(squirrel);
        MoveDirection[] actions = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};

        for (MoveDirection action : actions) {
            squirrel.move(action);
        }
        System.out.println(squirrel);

        OptionParser optionParser = new OptionParser();
        String[] actionAsString = {"f", "b", "x", "r"};

        actions = optionParser.parse(actionAsString);

        for (MoveDirection action : actions) {
            squirrel.move(action);
        }
        System.out.println(squirrel);

//        Aby zaimplementowac mechanizm wykluczania obecności dwóch zwierząt na tym samym miejscu,
//        utworzyłabym klasę Area, która odzwierciedlałaby planszę, po której mogą poruszać się zwierzęta,
//        a następnie w implementacji głownej metody programu zainicjalizowałabym obiekt tej klasy.
//        Klasa Area dysponowałaby metodą kontrolującą zajętość pól.


    }
}
