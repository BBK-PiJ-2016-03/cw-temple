package student.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import student.dataobjects.Connection;
import student.dataobjects.NodeConnection;
import student.nodes.CavernNode;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
@SuppressWarnings("ALL")
public class CavernMapImpl implements CavernMap {

  /**
   * nodes field - forms the node existence component of the map.
   **/
  private final Map<Long, CavernNode> nodes = new HashMap<>();
  /**
   * connections field - holds the connections between nodes component of the map.
   **/
  private final List<Connection> connections = new ArrayList<>();

  /**
   * {@inheritDoc}.
   */
  @Override
  public void addNode(CavernNode node) {
    nodes.put(node.getId(), node);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void connectNodes(CavernNode start, CavernNode end, int weight) {
    if (!nodes.values().contains(start) || !nodes.values().contains(end)) {
      throw new IllegalArgumentException("Node not known in CavernMap");
    }

    Connection connection = new Connection(weight, start, end);

    if (!connections.contains(connection)) {
      connections.add(connection);
    } else {
      connections.add(connections.indexOf(connection), connection);
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void connectNodes(CavernNode start, CavernNode end) {
    connectNodes(start, end, 1);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer getConnectedNodesWeight(CavernNode start, CavernNode end) {
    return connections.stream()
            .filter(n -> n.getConnectedNodes().contains(start)
                    && n.getConnectedNodes().contains(end))
            .findFirst()
            .map(Connection::getWeight)
            .orElse(null);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<NodeConnection> getConnectedNodes(CavernNode targetNode)
                                                                  throws IllegalArgumentException {
    if (!nodes.values().contains(targetNode)) {
      throw new IllegalArgumentException("Node not known in CavernMap");
    }

    return connections.stream()
            .filter(connection -> connection.getConnectedNodes().contains(targetNode))
            .distinct()
            .map(connection -> connection.getConnectedNode(targetNode))
            .collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<CavernNode> getAllNodes() {
    return nodes.values().stream()
            .collect(Collectors.toList());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public CavernNode getNode(long id) {
    return nodes.get(id);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean contains(long id) {
    return nodes.get(id) != null;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    nodes.values().forEach(n -> {
      sb.append(n);
      sb.append("\n");
    });
    return sb.toString();
  }
}
