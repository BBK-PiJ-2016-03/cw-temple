package student.Maps;

import org.junit.Before;
import org.junit.Test;
import student.Nodes.CavernNode;
import student.Nodes.CavernNodeImpl;

import static org.junit.Assert.*;

/**
 * Created by aworton on 16/02/17.
 */
@SuppressWarnings("ALL")
public class EscapeCavernMapImplTest {

    private EscapeCavernMap map;

    @Before
    public void before(){
        map = new EscapeCavernMapImpl();
        map.addNode(new CavernNodeImpl(1));
        map.addNode(new CavernNodeImpl(2));
        map.addNode(new CavernNodeImpl(3));
    }

    @Test
    public void setNodeGold(){
        CavernNode node = map.getNode(1);
        int gold = 5;
        map.setNodeGold(node, gold);
        assertEquals(gold, map.getNodeGold(node));
    }

    @Test
    public void getNodeGold(){
        CavernNode node = map.getNode(1);
        for(int gold = 0; gold < 100; gold++){
            map.setNodeGold(node, gold);
            assertEquals(gold, map.getNodeGold(node));
        }

    }

    @Test
    public void setGetExit(){
        for(long nodeId = 1; nodeId <=3; nodeId++){
            CavernNode node = map.getNode(nodeId);
            map.setExit(node);
            assertEquals(node, map.getExit());
        }

    }

}