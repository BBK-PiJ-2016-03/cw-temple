package student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Worton on 22/01/2017.
 */
public class CavernSquare {

    private Long id;
    private int distanceToTarget;
    private List<CavernSquare> destinations;
    private boolean explored;
    private boolean deadEnd;

    {
        destinations = new ArrayList<>();
        explored = false;
        deadEnd = false;
    }

    public CavernSquare(Long id, int distanceToTarget){
        setId(id);
        setDistanceToTarget(distanceToTarget);
    }

    /**
     *
     * @param cavernSquare the supplied cavernSquare
     * @throws IllegalArgumentException if attempting to add to a destination to a square already holding
     */
    public void addDestination(CavernSquare cavernSquare){
        destinations.add(cavernSquare);
    }

    public int getDistanceToTarget() {
        return distanceToTarget;
    }

    private void setDistanceToTarget(int distanceToTarget) {
        this.distanceToTarget = distanceToTarget;
    }

    public List<CavernSquare> getDestinations() {
        return destinations;
    }

    private void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public boolean isDeadEnd() {
        return deadEnd;
    }

    public void setDeadEnd(boolean deadEnd) {
        this.deadEnd = deadEnd;
    }
}
