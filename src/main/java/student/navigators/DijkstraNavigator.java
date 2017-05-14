package student.navigators;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import student.dataobjects.NodeConnection;
import student.maps.CavernMap;
import student.nodes.CavernNode;

/**
 * Created by Alexander Worton on 05/02/2017.
 * This class attempts to implement Dijkstra's shortest path algorithm,
 * albeit slightly modified from the original to better match the
 * requirements of the task.
 */
public class DijkstraNavigator implements Navigator {

  /**
   * map field.
   **/
  private CavernMap map;
  /**
   * startNode field.
   **/
  private CavernNode startNode;
  /**
   * destinationNode field.
   **/
  private CavernNode destinationNode;
  /**
   * destinationNode field.
   **/
  private List<CavernNode> nodesPendingProcessing;

  /**
   * Constructor.
   *
   * @param map the injected map
   */
  public DijkstraNavigator(CavernMap map) {
    setMap(map);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<CavernNode> getPathFromStartToDestination() {
    checkStartAndDestinationSet();

    initialiseAllNodes();
    return getShortestPath(map.getAllNodes());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int getShortestDistanceToDestination() {
    checkStartAndDestinationSet();

    initialiseAllNodes();
    List<CavernNode> path = getShortestPath(map.getAllNodes());
    return getPathDistance(path);
  }

  /**
   * Validator to ensure the start and destination have been set.
   */
  private void checkStartAndDestinationSet() {
    if (getStartNode() == null || getDestinationNode() == null) {
      final String message = "Start and destination nodes must be set before generating path";
      throw new IllegalStateException(message);
    }
  }

  /**
   * walk the path and return the sum of the vertices weight.
   * @param path supplied path
   * @return weight of path
   */
  private int getPathDistance(List<CavernNode> path) {
    int pathDistance = 0;
    for (int i = 0; i < path.size(); i++) {
      if (i > 0) {
        pathDistance += map.getConnectedNodesWeight(path.get(i), path.get(i - 1));
      }
    }
    return pathDistance;
  }

  /**
   * This is the driving method for obtaining the shortest path. Nodes (in order of lowest
   * path value first) which haven't been checked (by having all their connecting nodes examined)
   * are held in a list and popped off when checking is completed.
   *
   * @param allNodes the collection of all known nodes
   * @return the (a) shortest route from start to destination, start at index 0.
   */
  private List<CavernNode> getShortestPath(List<CavernNode> allNodes) {
    nodesPendingProcessing = allNodes;
    CavernNode currentNode;

    while (nodesPendingProcessing.size() > 0) {
      currentNode = getLowestPathValuePendingNode();
      processNeighbours(currentNode);
    }
    return getPath();
  }

  /**
   * To generate the shortest path, we start at the destination and work back one node at
   * a time choosing the first shortest node path value each time. There may be multiple
   * equal distance paths, all but the first are ignored.
   *
   * @return List of CavernNodes with the start at index 0
   */
  private List<CavernNode> getPath() {
    CavernNode currentNode = destinationNode;
    List<CavernNode> path = new LinkedList<>();
    path.add(0, currentNode);
    while (currentNode != startNode) {
      currentNode = getLowestPathValueNeighbour(currentNode).getNode();
      path.add(0, currentNode);
    }
    return path;
  }

  /**
   * This locates the neighbouring connected node with the lowest value
   * to become the next node in the return path to the start.
   *
   * @param currentNode the source node
   * @return the Lowest path value neighbour of the source node
   */
  private NodeConnection getLowestPathValueNeighbour(CavernNode currentNode) {
    return map.getConnectedNodes(currentNode).stream()
            .sorted(Comparator.comparingInt(e -> e.getNode().getPathValue()))
            .findFirst()
            .orElse(null);
  }

  /**
   * All neighbours of a specified node are processed by updating their path value
   * to be the value of the previous node + weight if and only if this new path
   * represents a shorter path (by being a smaller path value).
   *
   * @param currentNode the current node being checked
   */
  private void processNeighbours(CavernNode currentNode) {
    List<NodeConnection> neighbours = map.getConnectedNodes(currentNode);
    int prevPathValue = currentNode.getPathValue();
    neighbours.forEach(e -> {
      if (e.getNode().getPathValue() > (prevPathValue + e.getPathWeight())) {
        e.getNode().setPathValue(prevPathValue + e.getPathWeight());
      }
    });
  }

  /**
   * This gets a node holding the lowest available path value out of the set of
   * nodes which have not yet been checked.   *
   * @return a node with the lowest path value
   */
  private CavernNode getLowestPathValuePendingNode() {
    nodesPendingProcessing = nodesPendingProcessing.stream()
            .sorted(Comparator.comparingInt(CavernNode::getPathValue))
            .collect(Collectors.toList());

    return nodesPendingProcessing.remove(0);
  }

  /**
   * Set the initial state of all nodes.
   * - All path values to be set to max, except the start node path value which is set to 0
   */
  void initialiseAllNodes() {
    map.getAllNodes().forEach(e -> {
      if (e.equals(startNode)) {
        e.setPathValue(0);
      } else {
        e.setPathValue(Integer.MAX_VALUE);
      }
    });
  }

  /**
   * Setter for map.
   *
   * @param map the new map value
   */
  private void setMap(CavernMap map) {
    this.map = map;
  }

  /**
   * Getter for the start node.
   *
   * @return startNode
   */
  private CavernNode getStartNode() {
    return startNode;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void setStartNode(CavernNode node) {
    this.startNode = node;
  }

  /**
   * Getter for the destination node.
   *
   * @return destinationNode
   */
  private CavernNode getDestinationNode() {
    return destinationNode;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void setDestinationNode(CavernNode node) {
    this.destinationNode = node;
  }
}
