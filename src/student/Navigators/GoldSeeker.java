package student.Navigators;

import student.Maps.EscapeCavernMap;
import student.Nodes.CavernNode;
import student.Nodes.GoldNode;
import student.Nodes.HasIdAndDistance;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alexander Worton on 14/02/2017.
 */
@SuppressWarnings("ALL")
public class GoldSeeker implements Seeker {

    private Navigator navigator;
    private EscapeCavernMap map;
    private long currentLocationId;
    private List<CavernNode> path;
    private int timeRemaining;

    public GoldSeeker(Navigator nav, EscapeCavernMap map) {
        setNav(nav);
        setMap(map);
    }

    /**
     * Overload to allow for calling the getNextMove without specifying any neighbouring nodes
     * @param currentLocation the current location id
     * @param neighbours the neighbouring nodes of the current location
     * @param timeRemaining the remaining 'time' to escape
     * @return the id of the next move
     * @throws IllegalStateException if the map doesn't contain the current location
     */
    public long getNextMove(long currentLocation, Collection<? extends HasIdAndDistance> neighbours, int timeRemaining) throws IllegalStateException {
        setTimeRemaining(timeRemaining);
        return getNextMove(currentLocation, neighbours);
    }

    @Override
    public long getNextMove(long currentLocation, Collection<? extends HasIdAndDistance> neighbours) throws IllegalStateException {
        if(!map.contains(currentLocation))
            throw new IllegalStateException("Node with that id not known");

        setCurrentLocationId(currentLocation);
        return getNextNodeId();
    }

    /**
     * check for immediate gold first, then fail over to pathing
     * Determine whether to plot a new path or get the next move from the current one.
     * @return the id of the next node to move to
     */
    private long getNextNodeId() {
        Long id = getIdOfLocalNodeHoldingGold();
        if(id != null && getDistanceToExitViaNode(id) <= timeRemaining) {
            path = null;
            return id;
        }

        if(pathExists())
            return getNextPathNodeId();

        return getNextMoveFromNewPath();

    }

    private Long getIdOfLocalNodeHoldingGold() {
        List<Long> localNodeIds = map.getConnectedNodes(map.getNode(currentLocationId)).stream()
                .map(connection -> connection.getNode().getId())
                .collect(Collectors.toList());

        return getSortedGoldNodes().stream()
                .filter(n -> localNodeIds.contains(n.getId()))
                .map(GoldNode::getId)
                .findFirst()
                .orElse(null);
    }

    /**
     *
     * @return true if a valid path exists, false otherwise
     */
    private Boolean pathExists(){
        return this.path != null && this.path.size() > 0;
    }

    /**
     * pop the element at the front of the list and return the id if available
     * @return null if list empty or null, node's id otherwise
     */
    private Long getNextPathNodeId() {
        if(!pathExists())
            return null;
        return path.remove(0).getId();
    }

    /**
     * Set up the navigator start and destination and generate a new path between them.
     * Store the path in the instance path variable.
     * @return the id of the next node to move to.
     */
    private Long getNextMoveFromNewPath() {
        generateGoldGrabbingPath(getSortedGoldNodes());
        return getNextPathNodeId();
    }

    /**
     * Get GoldNodes for map, sorted by Gold Descending weighted with distance.
     * @return sorted list of GoldNodes, highest gold / distance weight first
     */
    private List<GoldNode> getSortedGoldNodes() {
        return map.getAllNodes().stream()
                .map(n -> {
                    GoldNode node = new GoldNode(n);
                    node.setGold(map.getNodeGold(map.getNode(node.getId())));
                    return node;
                })
                .filter(node -> node.getGold() > 0)
                .sorted((n1, n2)-> n2.getGold() - n1.getGold())
                .collect(Collectors.toList());
    }

    /**
     * From currentlocation, calculate distance to node with highest gold
     * check that distance plus distance from that node to exit is lower than max time,
     * if so, generate a path to that node, otherwise, failover to next highest gold node
     */
    private void generateGoldGrabbingPath(List<GoldNode> pendingGoldNodes){
        GoldNode currentNode;
        while(!pathExists() && notOnExit() && pendingGoldNodes.size() > 0) {
            //remove the node at the front of the list (highest gold value)
            currentNode = pendingGoldNodes.remove(0);
            if (getDistanceToExitViaNode(currentNode.getId()) <= timeRemaining)
                setNewPath(this.currentLocationId, currentNode.getId());
        }

        if(pendingGoldNodes.size() <= 0)
            setNewPath(this.currentLocationId, map.getExit().getId());

    }

    /**
     *
     * @return true if we are not located at the exit
     */
    private boolean notOnExit() {
        return map.getExit() != map.getNode(currentLocationId);
    }

    /**
     * calculate and return the distance from the current location to the exit via the provided node
     * @param waypoint - the node to pass through to the exit
     */
    private int getDistanceToExitViaNode(long waypoint) {
        int distanceToNode = getDistanceBetween(map.getNode(currentLocationId), map.getNode(waypoint));
        int distanceFromNode = getDistanceBetween(map.getNode(waypoint), map.getExit());
        return distanceToNode + distanceFromNode;
    }

    /**
     * Get the distance between the specified nodes
     * @param node1 the first specified node
     * @param node2 the second specified node
     * @return distance
     */
    private int getDistanceBetween(CavernNode node1, CavernNode node2) {
        navigator.setStartNode(node1);
        navigator.setDestinationNode(node2);
        return navigator.getShortestDistanceToDestination();
    }

    /**
     * Setter for pathing from and to locations
     * @param startId the start node id
     * @param destinationId the destination node id
     */
    private void setNewPath(long startId, long destinationId){
        navigator.setStartNode(map.getNode(startId));
        navigator.setDestinationNode(map.getNode(destinationId));
        this.path = SeekerLibrary.setNewPath(navigator, this.currentLocationId);
    }



    private void setNav(Navigator navigator) {
        this.navigator = navigator;
    }

    private void setMap(EscapeCavernMap map) {
        this.map = map;
    }

    private void setCurrentLocationId(long currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

    private void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
}
