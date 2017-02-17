package student.Nodes;

/**
 * Created by aworton on 16/02/17.
 */
@SuppressWarnings("ALL")
public interface HasIdAndDistance{

    /**
     * Getter for the node id
     * @return the id of the node
     */
    long getId();

    /**
     * Getter for the distance to target
     * @return distance
     */
    int getDistance();
}
