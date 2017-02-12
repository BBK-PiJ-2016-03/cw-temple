package student;

import game.NodeStatus;
import student.Maps.CavernMap;
import student.Nodes.CavernNode;
import student.Nodes.CavernNodeImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

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

    /**
     * Create a mock set of neighbours for testing.
     * Since the NodeStatus object has a constructor restricted to the package
     * reflection has been used to instantiate objects
     * @param id the id of the current node
     * @return the collection of neighbours
     */
    public static Collection<NodeStatus> getMockNeighbours(long id){
        Class nodeStatus = NodeStatus.class;
        Collection<NodeStatus> neighbours = new ArrayList<>();
        for(long i = id+1; i < id+6; i++) {
            try {
                //get constructor
                Constructor nodeStatusConstructor = nodeStatus.getDeclaredConstructors()[0];
                nodeStatusConstructor.setAccessible(true);

                //define arguments
                Object[] constructorArgs = new Object[2];
                constructorArgs[0] = i;
                constructorArgs[1] = (int) (i - id);

                //use instantiated object
                neighbours.add((NodeStatus)nodeStatusConstructor.newInstance(constructorArgs));
            }
            catch(InstantiationException e){
                e.printStackTrace();
            }
            catch(IllegalAccessException e){
                e.printStackTrace();
            }
            catch(InvocationTargetException e){
                e.printStackTrace();
            }
        }

        neighbours.forEach(n -> System.out.println("Node ID: "+n.getId()+" Distance: "+n.getDistanceToTarget()));
        return neighbours;
    }
}
