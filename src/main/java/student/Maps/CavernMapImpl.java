package student.Maps;

import student.DataObjects.Connection;
import student.DataObjects.NodeConnection;
import student.Nodes.CavernNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
@SuppressWarnings("ALL")
public class CavernMapImpl implements CavernMap {

    private final Map<Long, CavernNode> nodes = new HashMap<>();
    private final List<Connection> connections = new ArrayList<>();

    @Override
    public void addNode(CavernNode node) {
        nodes.put(node.getId(), node);
    }

    @Override
    public void connectNodes(CavernNode start, CavernNode end, int weight) {
        if(!nodes.values().contains(start) || !nodes.values().contains(end))
            throw new IllegalArgumentException("Node not known in CavernMap");

        Connection connection = new Connection(weight, start, end);

        if(!connections.contains(connection))
            connections.add(connection);
        else
            connections.add(connections.indexOf(connection), connection);
    }

    @Override
    public void connectNodes(CavernNode start, CavernNode end) {
        connectNodes(start, end, 1);
    }

    @Override
    public Integer getConnectedNodesWeight(CavernNode start, CavernNode end) {
        return connections.stream()
                .filter(n -> n.getConnectedNodes().contains(start) && n.getConnectedNodes().contains(end))
                .findFirst()
                .map(Connection::getWeight)
                .orElse(null);
    }

    @Override
    public List<NodeConnection> getConnectedNodes(CavernNode targetNode) throws IllegalArgumentException {
        if(!nodes.values().contains(targetNode))
            throw new IllegalArgumentException("Node not known in CavernMap");

        return connections.stream()
                .filter(connection -> connection.getConnectedNodes().contains(targetNode))
                .distinct()
                .map(connection -> connection.getConnectedNode(targetNode))
                .collect(Collectors.toList());
    }

    @Override
    public List<CavernNode> getAllNodes() {
        return nodes.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public CavernNode getNode(long id) {
        return nodes.get(id);
    }

    @Override
    public Boolean contains(long id) {
        return nodes.get(id) != null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        nodes.values().forEach(n -> {sb.append(n); sb.append("\n");});
        return sb.toString();
    }
}
