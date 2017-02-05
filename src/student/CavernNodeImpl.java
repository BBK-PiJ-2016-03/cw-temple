package student;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class CavernNodeImpl implements CavernNode {

    long id;
    private boolean goldenValue;
    private int pathValue;

    {
        id = 0;
        goldenValue = false;
        pathValue = Integer.MAX_VALUE;
    }

    @Override
    public boolean isGoldenValue() {
        return false;
    }

    @Override
    public void setGoldenValue(boolean value) {
        this.goldenValue = value;
    }

    @Override
    public int getPathValue() {
        return this.pathValue;
    }

    @Override
    public void setPathValue(int pathValue) {
        if(pathValue < 0)
            throw new IllegalArgumentException("Path values must be valid to be set");
        this.pathValue = pathValue;
    }

    @Override
    public long getId() {
        if(this.id < 1)
            throw new IllegalStateException("Id has not yet been set for this node");
        return this.id;
    }

    @Override
    public void setId(long id) {
        if(id < 1)
            throw new IllegalArgumentException("Provided Id is invalid. Please supply a positive id greater than zero");
        this.id = id;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof CavernNodeImpl))
            return false;

        return ((CavernNodeImpl)obj).id == this.id;
    }

    @Override
    public int hashCode(){
        return (int)(this.id % Integer.MAX_VALUE);
    }
}
