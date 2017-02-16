package student.Navigators;

import game.NodeStatus;
import student.Maps.EscapeCavernMap;
import student.Nodes.CavernNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alexander Worton on 14/02/2017.
 */
public class GoldSeeker implements Seeker {

    private Navigator navigator;
    private EscapeCavernMap map;
    private long currentLocationId;
    private List<CavernNode> path;

    public GoldSeeker(Navigator nav, EscapeCavernMap map) {
        setNav(nav);
        setMap(map);
    }

    /**
     * Overload to allow for calling the getNextMove without specifying any neighbouring nodes
     * @param currentLocation
     * @return the id of the next move
     * @throws IllegalStateException
     */
    public long getNextMove(long currentLocation) throws IllegalStateException {
        return getNextMove(currentLocation, new ArrayList<>());
    }

    @Override
    public long getNextMove(long currentLocation, Collection<NodeStatus> neighbours) throws IllegalStateException {
        if(!map.contains(currentLocation))
            throw new IllegalStateException("Node with that id not known");

        setCurrentLocationId(currentLocation);

        CavernNode location = map.getNode(currentLocation);
        return getNextNodeId(location);
    }

    /**
     * Determine whether to plot a new path or get the next move from the current one.
     * @param location
     * @return
     */
    private long getNextNodeId(CavernNode location) {
        if(!pathExists())
            return getNextMoveFromNewPath();
        return getNextPathNodeId();

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
     * @return the id of the next node to move to
     */
    private long getNextMoveFromNewPath() {
        navigator.setStartNode(map.getNode(this.currentLocationId));
        navigator.setDestinationNode(map.getExit());
        this.path = SeekerLibrary.setNewPath(navigator, this.currentLocationId);
        return getNextPathNodeId();
    }



    public void setNav(Navigator navigator) {
        this.navigator = navigator;
    }

    public void setMap(EscapeCavernMap map) {
        this.map = map;
    }

    private void setCurrentLocationId(long currentLocationId) {
        this.currentLocationId = currentLocationId;
    }
}
