package student.Nodes;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public interface CavernNode{
    /**
     * Getter for the node path value
     * @return path value
     */
    int getPathValue();

    /**
     * Setter for the node path value
     * This should be set to the max value (in place of infinity) by default
     * @param pathValue
     * @throws IllegalArgumentException if the argument provided is negative
     */
    void setPathValue(int pathValue) throws IllegalArgumentException;

    /**
     * Getter for the node id
     * @return id
     * @throws IllegalStateException if a valid id has not been set
     */
    long getId() throws IllegalStateException;

    /**
     * Setter for the node id
     * @param pathValue
     * @throws IllegalArgumentException if the argument provided is les than 1
     */
    void setId(long pathValue) throws IllegalArgumentException;

    /**
     * Getter for visited state
     * @return true if node has been visited, false otherwise
     */
    Boolean isVisited();

    /**
     * Setter for the visited state
     * @param visited the new state
     */
    void seVisited(Boolean visited);
}
