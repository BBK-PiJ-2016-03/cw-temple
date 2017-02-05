package student;

import java.util.List;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public interface CavernMap<T> {

    /**
     * add a new node to the map
     * @param node
     */
    void addNode(T node);

    /**
     * COnnects the supplied nodes
     * @param start
     * @param end
     */
    void connectNode(T start, T end);

    /**
     *
     * @param node
     * @return a list of nodes connected to the supplied node. List is empty if no nodes are connected
     * @throws IllegalArgumentException if the supplied node is unknown to the map
     */
    List<T> getConnectedNodes(T node) throws IllegalArgumentException;

}
