package student;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by Alexander Worton on 02/02/2017.
 */
public class Navigator {

    private CavernMap map;
    
    public Navigator(CavernMap map){
        setMap(map);
    }

    public long getNextMove() {
        Optional<Long> destination = getNode(map.getCurrentLocation(),
                                                            e -> !e.isExplored(),
                                                            Comparator.comparingLong(e -> e.getDistanceToTarget()));
        if(destination.isPresent())
            return destination.get();

        destination = getNode(map.getCurrentLocation(),
                e -> e.isExplored(),
                (a, b) -> b.getDistanceToTarget() - a.getDistanceToTarget());

        if(destination.isPresent())
            return destination.get();
        else
            throw new IllegalStateException();

    }

    private Optional<Long> getNode(CavernSquare currentLocation, Predicate<CavernSquare> filter, Comparator<CavernSquare> comp) {
        return currentLocation.getDestinations().stream()
                .filter(filter::test)
                .sorted(comp)
                .findFirst()
                .map(e -> e.getId());
    }

    private void setMap(CavernMap map) {
        this.map = map;
    }
}
