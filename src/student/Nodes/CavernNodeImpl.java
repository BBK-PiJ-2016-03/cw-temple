package student.Nodes;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class CavernNodeImpl implements CavernNode {

    long id;
    private int pathValue;

    {
        id = 0;
        pathValue = Integer.MAX_VALUE;
    }

    public CavernNodeImpl(){}

    public CavernNodeImpl(long id){
        setId(id);
    }

    @Override
    public int getPathValue() {
        return this.pathValue;
    }

    @Override
    public void setPathValue(int pathValue) {
        if(pathValue < 0)
            throw new IllegalArgumentException("Path values must be valid to be set. "+pathValue+" is invalid.");
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

        CavernNodeImpl cObj = (CavernNodeImpl)obj;

        return cObj.id == this.id
                && cObj.pathValue == this.pathValue
                && cObj.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode(){
        return (int)(this.id % Integer.MAX_VALUE);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(id);
        sb.append(" pathValue: ");
        sb.append(pathValue);
        return sb.toString();
    }
}
