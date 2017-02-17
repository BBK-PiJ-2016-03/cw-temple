package student.Nodes;

/**
 * Created by aworton on 16/02/17.
 */
@SuppressWarnings("ALL")
public class GoldNode implements CavernNode {

    private final CavernNode instance;
    private Integer gold;

    public GoldNode(CavernNode suppliedInstance) {
        this.instance = suppliedInstance;
    }

    @Override
    public final int getPathValue() {
        return instance.getPathValue();
    }

    @Override
    public final void setPathValue(int pathValue){
        instance.setPathValue(pathValue);
    }

    @Override
    public final int getDistance() {
        return instance.getDistance();
    }

    @Override
    public final void setDistance(int distance){
        instance.setDistance(distance);
    }

    @Override
    public final long getId(){
        return instance.getId();
    }

    @Override
    public final void setId(long pathValue){
        instance.setId(pathValue);
    }

    @Override
    public final Boolean isVisited() {
        return instance.isVisited();
    }

    @Override
    public final void setVisited(Boolean visited) {
        instance.setVisited(visited);
    }


    public final int getGold() {
        if(gold == null) {
            throw new IllegalStateException("Gold value has not been set");
        }
        return gold;
    }

    public final void setGold(int goldAmount) {
        this.gold = goldAmount;
    }
}
