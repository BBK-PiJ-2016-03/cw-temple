package student.Nodes;

/**
 * Created by aworton on 16/02/17.
 */
public class GoldNode implements CavernNode {

    private CavernNode instance;
    private Integer gold;

    public GoldNode(CavernNode instance) {
        this.instance = instance;
    }

    @Override
    public int getPathValue() {
        return instance.getPathValue();
    }

    @Override
    public void setPathValue(int pathValue) throws IllegalArgumentException {
        instance.setPathValue(pathValue);
    }

    @Override
    public int getDistance() {
        return instance.getDistance();
    }

    @Override
    public void setDistance(int distance) throws IllegalArgumentException {
        instance.setDistance(distance);
    }

    @Override
    public long getId() throws IllegalStateException {
        return instance.getId();
    }

    @Override
    public void setId(long pathValue) throws IllegalArgumentException {
        instance.setId(pathValue);
    }

    @Override
    public Boolean isVisited() {
        return instance.isVisited();
    }

    @Override
    public void setVisited(Boolean visited) {
        instance.setVisited(visited);
    }


    public int getGold() {
        if(gold == null)
            throw new IllegalStateException("Gold value has not been set");
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
