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

    public CavernNodeImpl(long id){
        setId(id);
    }

    public CavernNodeImpl(long id, int distance){
        setId(id);
        setDistance(distance);
    }

    @Override
    public final int getPathValue() {
        return this.pathValue;
    }

    @Override
    public final void setPathValue(int pathValue) {
        if(pathValue < 0)
            throw new IllegalArgumentException("Path values must be valid to be set. "+pathValue+" is invalid.");
        this.pathValue = pathValue;
    }

    @Override
    public final int getDistance() {
        return this.distance;
    }

    @Override
    public final void setDistance(int distance) throws IllegalArgumentException {
        if(distance < 0)
            throw new IllegalArgumentException("Distance cannot be negative");
        this.distance = distance;
    }

    @Override
    public final long getId() {
        if(this.id < 0)
            throw new IllegalStateException("Id has not yet been set for this node");
        return this.id;
    }

    @Override
    public final void setId(long id) {
        if(id < 0)
            throw new IllegalArgumentException("Provided Id is invalid. Please supply a positive id >= 0");
        this.id = id;
    }

    @Override
    public final Boolean isVisited() {
        return this.visited;
    }

    @Override
    public final void setVisited(Boolean visited) {
        this.visited = visited;
    }

    @Override
    public final boolean equals(Object obj){
        if(!(obj instanceof CavernNodeImpl))
            return false;

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
