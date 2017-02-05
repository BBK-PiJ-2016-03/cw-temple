package student;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public interface CavernMap<T> {

    /**
     * add a new node to the map
     * @param node
     */
    void addNode(T node);

    void connectNode(T start, T end);

}
