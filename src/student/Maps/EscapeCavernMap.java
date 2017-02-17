package student.Maps;

import student.Nodes.CavernNode;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
@SuppressWarnings("ALL")
public interface EscapeCavernMap extends CavernMap{

    /**
     * Setter for the gold amount at a node
     * @param node the node in question
     * @param gold the amount of gold to be set at the location
     * @throws IllegalArgumentException if the node is unknown
     */
    void setNodeGold(CavernNode node, int gold);

    /**
     * Getter for the gold stored at a location
     * @param node the node of interest
     * @return the amount of gold
     */
    int getNodeGold(CavernNode node);

    /**
     * setter for the exit node
     * @param node the node value to be set
     */
    void setExit(CavernNode node);

    /**
     * getter for the exit node
     * @return the exit node or null if not set
     */
    CavernNode getExit();
}
