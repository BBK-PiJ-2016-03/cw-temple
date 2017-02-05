package student;

import java.util.Queue;

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
     */
    Queue<CavernNode> getPathFromStartToDestination();
}
