package student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class CavernMapImpl implements CavernMap {

    private Map<Long, CavernNode> nodes = new HashMap<>();
    private List<Set<CavernNode>> connections = new ArrayList<>();

    @Override
    public void addNode(CavernNode node) {
        nodes.put(node.getId(), node);
    }

    @Override
    public void connectNodes(CavernNode start, CavernNode end) {
        Set<CavernNode> connection = new HashSet<>(Arrays.asList(start, end));
        if(!connections.contains(connection))
            connections.add(connection);
    }

    @Override
    public List<CavernNode> getConnectedNodes(CavernNode targetNode) throws IllegalArgumentException {
        if(!nodes.values().contains(targetNode))
            throw new IllegalArgumentException("Node not known in CavernMap");

        return connections.stream()
                .filter(set -> set.contains(targetNode))
                .flatMap(set -> set.stream())
                .filter(node -> !node.equals(targetNode))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<CavernNode> getAllNodes() {
        return nodes.values().stream()
                .collect(Collectors.toList());
    }
}
