package student;

import student.Maps.CavernMap;
import student.Nodes.CavernNode;
import student.Nodes.CavernNodeImpl;

/**
 * Created by Alexander Worton on 06/02/2017.
 */
public class TestHelperMethods {

    public static void populateCavern(CavernMap map) {
        for(int i = 1; i <= 50; i++){
            CavernNode currentNode = generateNode(i);
            map.addNode(currentNode);
            if(i > 1)
                map.connectNodes(map.getNode(i-1), currentNode);
        }
        map.connectNodes(map.getNode(4), map.getNode(50));
    }

    public static CavernNode generateNode(int id) {
        CavernNode node = new CavernNodeImpl();
        node.setId(id);
        return node;
    }
}
