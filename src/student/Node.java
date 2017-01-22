package student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Worton on 22/01/2017.
 */
public class Node {

    private Long id;
    private int hashCode;
    private int distanceToTarget;
    private List<Node> destinations;
    private boolean explored;
    private boolean deadEnd;

    {
        destinations = new ArrayList<>();
        explored = false;
        deadEnd = false;
    }

    public Node(long id, int hashCode, int distanceToTarget){
        setId(id);
        setHashCode(hashCode);
        setDistanceToTarget(distanceToTarget);
    }

    public void addDestination(Node node){
        destinations.add(node);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    private void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public int getDistanceToTarget() {
        return distanceToTarget;
    }

    private void setDistanceToTarget(int distanceToTarget) {
        this.distanceToTarget = distanceToTarget;
    }

    public List<Node> getDestinations() {
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
