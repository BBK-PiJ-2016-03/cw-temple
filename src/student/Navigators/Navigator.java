package student.Navigators;

import student.Nodes.CavernNode;

import java.util.List;

/**
 * Created by Alexander Worton on 02/02/2017.
 */
public interface Navigator {
    /**
     * set starting node
     * @param node
     */
    void setStartNode(CavernNode node);

    /**
     * set destination node
     * @param node
     */
    void setDestinationNode(CavernNode node);

    /**
     * get the sequence of nodes to form the path from start to destination,
     * including both starting and destination nodes
     * @return a queue of cavernNodes
     * @throws IllegalStateException if start or destination are unset
     */
    List<CavernNode> getPathFromStartToDestination() throws IllegalStateException;

    /**
     *
     * @return shortest distance from source to destination
     */
    int getShortestDistanceToDestination();
}
