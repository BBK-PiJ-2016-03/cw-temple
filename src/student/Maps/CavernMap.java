package student.Maps;

import student.DataObjects.NodeConnection;
import student.Nodes.CavernNode;

import java.util.List;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
@SuppressWarnings("ALL")
public interface CavernMap {

    /**
     * add a new node to the map
     * @param node the new cavernNode to add
     */
    void addNode(CavernNode node);

    /**
     * Connects the supplied nodes if unconnected
     * @param start the start node
     * @param end the end node
     */
    void connectNodes(CavernNode start, CavernNode end, int weight);

    /**
     * Connects the supplied nodes if unconnected. Overload to default weight to 1.
     * @param start the start node
     * @param end the end node
     */
    void connectNodes(CavernNode start, CavernNode end);

    /**
     * Get the weight of the connection between two nodes
     * @param start the start node
     * @param end the end node
     * @return the weight of the connected nodes
     */
    Integer getConnectedNodesWeight(CavernNode start, CavernNode end);

    /**
     *
     * @param node the source node
     * @return a list of nodeConnections connected to the supplied node. List is empty if no nodes are connected
     * @throws IllegalArgumentException if the supplied node is unknown to the map
     */
    List<NodeConnection> getConnectedNodes(CavernNode node) throws IllegalArgumentException;

    /**
     * Getter for all nodes
     * @return a list of all nodes in the map
     */
    List<CavernNode> getAllNodes();

    /**
     * getter to return the latest stored properties for a node with a given Id
     * @return the matching node held in the map
     */
    CavernNode getNode(long id);

    /**
     * Check that the id supplied belongs to a known node
     * @param id the search value
     * @return true if node found false otherwise
     */
    Boolean contains(long id);


}
