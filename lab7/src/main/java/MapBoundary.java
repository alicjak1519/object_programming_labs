import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    protected Map<Vector2d, Animal> animalsMap;
    protected Map<Vector2d, Grass> grassesMap;
    SortedSet<Vector2d> xSortedObjects;
    SortedSet<Vector2d> ySortedObjects;

    public MapBoundary(AbstractWorldMap assignedMap) {
        animalsMap = assignedMap.animalsMap;
        grassesMap = assignedMap.grassesMap;
        Comparator<Vector2d> xComparator = new XComparator();
        SortedSet<Vector2d> xSortedObjects = new TreeSet<Vector2d>(xComparator);
        for (Map.Entry<Vector2d, Animal> entry : animalsMap.entrySet()) {
            xSortedObjects.add(entry.getKey());
        }
        for (Map.Entry<Vector2d, Grass> entry : grassesMap.entrySet()) {
            xSortedObjects.add(entry.getKey());
        }

        Comparator<Vector2d> yComparator = new YComparator();
        SortedSet<Vector2d> ySortedObjects = new TreeSet<Vector2d>(yComparator);
        for (Map.Entry<Vector2d, Animal> entry : animalsMap.entrySet()) {
            ySortedObjects.add(entry.getKey());
        }
        for (Map.Entry<Vector2d, Grass> entry : grassesMap.entrySet()) {
            ySortedObjects.add(entry.getKey());
        }

    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xSortedObjects.remove(oldPosition);
        xSortedObjects.add(newPosition);

        ySortedObjects.remove(oldPosition);
        ySortedObjects.add(newPosition);
    }
}
