package student.Nodes;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
@SuppressWarnings("ALL")
public class CavernNodeImpl implements CavernNode {

    private long id;
    private int pathValue;
    private Boolean visited;
    private int distance;

    {
        id = -1;
        pathValue = Integer.MAX_VALUE;
        visited = false;
        distance = Integer.MAX_VALUE;
    }

    public CavernNodeImpl(){}

    public CavernNodeImpl(long nodeId){
        setId(nodeId);
    }

    public CavernNodeImpl(long nodeId, int distanceToTarget){
        setId(nodeId);
        setDistance(distanceToTarget);
    }

    @Override
    public final int getPathValue() {
        return this.pathValue;
    }

    @Override
    public final void setPathValue(int newPathValue) {
        if(newPathValue < 0) {
            throw new IllegalArgumentException("Path values must be valid to be set. " + newPathValue + " is invalid.");
        }
        this.pathValue = newPathValue;
    }

    @Override
    public final int getDistance() {
        return this.distance;
    }

    @Override
    public final void setDistance(int newDistance){
        if(newDistance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        this.distance = newDistance;
    }

    @Override
    public final long getId() {
        if(this.id < 0) {
            throw new IllegalStateException("Id has not yet been set for this node");
        }
        return this.id;
    }

    @Override
    public final void setId(long newId) {
        if(newId < 0) {
            throw new IllegalArgumentException("Provided Id is invalid. Please supply a positive id >= 0");
        }
        this.id = newId;
    }

    @Override
    public final Boolean isVisited() {
        return this.visited;
    }

    @Override
    public final void setVisited(Boolean newVisited) {
        this.visited = newVisited;
    }

    @Override
    public final boolean equals(Object obj){
        if(!(obj instanceof CavernNodeImpl)) {
            return false;
        }

        CavernNodeImpl cObj = (CavernNodeImpl)obj;

        return cObj.id == this.id
                && cObj.pathValue == this.pathValue
                && cObj.hashCode() == this.hashCode();
    }

    @Override
    public final int hashCode(){
        return (int)(this.id % Integer.MAX_VALUE);
    }

    @Override
    public final String toString(){
        return "Id: " + id + " pv: " + pathValue + " dist: " + distance;
    }
}
