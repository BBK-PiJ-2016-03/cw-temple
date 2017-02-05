package student;

/**
 * Created by Alexander Worton on 05/02/2017.
 */
public interface CavernNode {
    /**
     * used to determine if the final value of the nodes path value has been set
     * @return true if path value is golden, false otherwise
     */
    boolean isGoldenValue();

    /**
     * Setter for the node Golden value flag
     * @param value true or false
     */
    void setGoldenValue(boolean value);

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
     */
    long getId();

    /**
     * Setter for the node id
     * @param pathValue
     */
    void setId(long pathValue);
}
