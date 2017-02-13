package student.Navigators;

import game.NodeStatus;
import student.Maps.CavernMap;
import student.Nodes.CavernNode;
import student.Nodes.CavernNodeImpl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alexander Worton on 06/02/2017.
 */
public class TargetSeeker implements Seeker {

    private Navigator navigator;
    private CavernMap map;
    private long currentLocationId;
    private List<CavernNode> path;

    public TargetSeeker(Navigator nav, CavernMap map) {
        setNav(nav);
        setMap(map);
    }

    @Override
    public long getNextMove(long location, Collection<NodeStatus> neighbours) {
        if(!map.contains(location))
            throw new IllegalStateException("Node with that id not known");
        setCurrentLocationId(location);
        CavernNode currentLocation = map.getNode(location);
        addNeighboursToMap(currentLocation, neighbours);
        return getNextClosestNodeId(neighbours);
    }

    /**
     * select any remaining unexplored neighbour node, closest first, then plot a path
     * to the next closest unexplored node in map
     * @return next closest node to target
     */
    private long getNextClosestNodeId(Collection<NodeStatus> neighbours) {
        if(pathExists())
            return getNextPathNodeId();
        return getNextNodeId(neighbours);
    }

    private long getNextNodeId(Collection<NodeStatus> neighbours) {
        Long nextNodeId = getClosestNeighbourNode(neighbours);
        if(nextNodeId == null) {
            nextNodeId = getNewPathToClosestAvailableNode();
        }
        return nextNodeId;
    }

    private Long getClosestNeighbourNode(Collection<NodeStatus> neighbours){
        return neighbours.stream()
                .sorted(Comparator.comparingInt(n -> n.getDistanceToTarget()))
                .map(n -> map.getNode(n.getId()))
                .filter(n -> !n.isVisited())
                .findFirst()
                .map(n -> n.getId())
                .orElse(null);
    }

    private long getNewPathToClosestAvailableNode() {
        navigator.setStartNode(map.getNode(this.currentLocationId));
        navigator.setDestinationNode(getClosestUnvisitedNodeOnMap());
        setNewPath();
        return getNextPathNodeId();
    }

    /**
     * grabs the new path from the navigator, then removes the starting
     * node if that is the current location
     */
    private void setNewPath() {
        this.path = navigator.getPathFromStartToDestination();
        if(this.path.get(0).getId() == currentLocationId)
            this.path.remove(0);
    }

    /**
     *
     * @return an unvisited node which is closest to target
     */
    private CavernNode getClosestUnvisitedNodeOnMap() {
        return map.getAllNodes().stream()
                .filter(n -> !n.isVisited())
                .sorted(Comparator.comparingInt(n -> n.getDistance()))
                .findFirst()
                .get();
    }

    /**
     * add neighbours to the map when supplied
     * @param currentLocation the current location
     * @param neighbours the neighbouring nodes
     */
    private void addNeighboursToMap(CavernNode currentLocation, Collection<NodeStatus> neighbours) {
        neighbours.forEach(n -> {
            CavernNode node = addToOrGetExistingNodeFromMap(n);
            map.connectNodes(currentLocation, node);
        });
    }

    /**
     * Check that a node with the id is in the map, if so, return it
     * otherwise add a new node to the map and return that.
     * @param n a nodestatus object received from the game.
     * @return node from map
     */
    private CavernNode addToOrGetExistingNodeFromMap(NodeStatus n) {
        if(!map.contains(n.getId())) {
            CavernNode node = new CavernNodeImpl(n.getId());
            node.setDistance(n.getDistanceToTarget());
            map.addNode(node);
        }
        return map.getNode(n.getId());
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    public void setNav(Navigator nav) {
        this.navigator = nav;
    }

    public CavernMap getMap() {
        return this.map;
    }

    public void setMap(CavernMap map) {
        this.map = map;
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

    private Boolean pathExists(){
        return this.path != null && this.path.size() > 0;
    }

    /**
     * Set the currentLocation and mark it as visited.
     * @param currentLocationId
     */
    public void setCurrentLocationId(long currentLocationId) {
        this.currentLocationId = currentLocationId;
        map.getNode(currentLocationId).setVisited(true);
    }
}
