package student.Maps;

import game.Node;
import student.Nodes.CavernNodeImpl;

import java.util.Collection;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
public class MapImport {
    /**
     * Conversion function to parse map data supplied by game into student implemented map
     * @param vertices all nodes in the map
     * @param map the destination map format
     */
    public static void convertVerticesToMap(Collection<Node> vertices, EscapeCavernMap map){
        vertices.forEach(source -> {
            addNodeIfUnknown(source.getId(), source.getTile().getGold(), map);
            source.getNeighbours().forEach(neighbour -> {
                addNodeIfUnknown(neighbour.getId(), neighbour.getTile().getGold(), map);
                connectNeighbourToSourceNode(source.getId(), neighbour.getId(), map);
            });
        });
    }

    private static void connectNeighbourToSourceNode(long source, long neighbour, CavernMap map) {
        map.connectNodes(map.getNode(source), map.getNode(neighbour));
    }

    private static void addNodeIfUnknown(long id, int gold, CavernMap map) {
        if(!map.contains(id))
            map.addNode(new CavernNodeImpl(id));
            map.setNodeGold(map.getNode(id), gold);
    }
}
