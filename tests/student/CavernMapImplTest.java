package student;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public class CavernMapImplTest {

    CavernMap<CavernNode> map;

    @Before
    public void before(){
        map = new CavernMapImpl<>();
    }

    @Test
    public void addSingleNode() throws Exception {
        CavernNode node = addNodeWithIdToMap(map, 14);
        assertTrue(map.getConnectedNodes(node).size() == 0);
    }

    @Test
    public void addTwoConnectedNodesForwardLinked() throws Exception {
        CavernNode node5 = addNodeWithIdToMap(map, 5);
        CavernNode node8 = addNodeWithIdToMap(map, 8);
        CavernNode node12 = addNodeWithIdToMap(map, 12);
        map.connectNode(node5, node8);
        map.connectNode(node5, node12);
        assertTrue(map.getConnectedNodes(node5).size() == 2);
    }

    @Test
    public void addTwoConnectedNodesReverseLinked() throws Exception {
        CavernNode node5 = addNodeWithIdToMap(map, 5);
        CavernNode node8 = addNodeWithIdToMap(map, 8);
        CavernNode node12 = addNodeWithIdToMap(map, 12);
        map.connectNode(node5, node8);
        map.connectNode(node5, node12);
        assertTrue(map.getConnectedNodes(node8).size() == 1);
    }

    private CavernNode addNodeWithIdToMap(CavernMap<CavernNode> map, long id){
        CavernNode node = new CavernNodeImpl();
        node.setId(id);
        map.addNode(node);
        return node;
    }

}