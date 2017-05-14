package student.maps;

import game.Node;
import java.util.Collection;
import student.nodes.CavernNodeImpl;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
@SuppressWarnings("ALL")
public class MapImport {

  /**
   * Conversion function to parse map data supplied by game into student implemented map.
   *
   * @param vertices all nodes in the map
   * @param map      the destination map format
   */
  public static void convertVerticesToMap(Collection<Node> vertices, EscapeCavernMap map) {
    vertices.forEach(source -> {
      addNodeIfUnknown(source.getId(), source.getTile().getGold(), map);
      source.getNeighbours().forEach(neighbour -> {
        addNodeIfUnknown(neighbour.getId(), neighbour.getTile().getGold(), map);
        connectNeighbourToSourceNode(source.getId(),
                                    neighbour.getId(),
                                    source.getEdge(neighbour).length,
                                    map);
      });
    });
  }

  /**
   * Connects neighbour nodes to the source node.
   *
   * @param source    source id
   * @param neighbour neighbour id
   * @param weight    weight of connection
   * @param map       map target
   */
  private static void connectNeighbourToSourceNode(long source,
                                                   long neighbour,
                                                   int weight,
                                                   EscapeCavernMap map) {
    map.connectNodes(map.getNode(source), map.getNode(neighbour), weight);
  }

  /**
   * Adds a node to the map if it is not currently known to the map.
   *
   * @param id   the id of the node
   * @param gold the gold value of the node
   * @param map  the map target
   */
  private static void addNodeIfUnknown(long id, int gold, EscapeCavernMap map) {
    if (!map.contains(id)) {
      map.addNode(new CavernNodeImpl(id));
    }
    map.setNodeGold(map.getNode(id), gold);
  }
}
