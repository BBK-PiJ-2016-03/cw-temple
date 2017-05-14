package student.nodes;

/**
 * Created by aworton on 16/02/17.
 */
@SuppressWarnings("ALL")
public class GoldNode implements CavernNode {

  /**
   * instance field.
   **/
  private final CavernNode instance;
  /**
   * gold field.
   **/
  private Integer gold;

  /**
   * Constructor.
   *
   * @param suppliedInstance the injected instance.
   */
  public GoldNode(CavernNode suppliedInstance) {
    this.instance = suppliedInstance;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int getPathValue() {
    return instance.getPathValue();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setPathValue(int pathValue) {
    instance.setPathValue(pathValue);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int getDistance() {
    return instance.getDistance();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setDistance(int distance) {
    instance.setDistance(distance);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final long getId() {
    return instance.getId();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setId(long pathValue) {
    instance.setId(pathValue);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final Boolean isVisited() {
    return instance.isVisited();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setVisited(Boolean visited) {
    instance.setVisited(visited);
  }


  /**
   * Getter for the gold amount.
   *
   * @return the amount of gold
   */
  public final int getGold() {
    if (gold == null) {
      throw new IllegalStateException("Gold value has not been set");
    }
    return gold;
  }

  /**
   * Setter for the gold amount.
   *
   * @param goldAmount the amount of gold to set.
   */
  public final void setGold(int goldAmount) {
    this.gold = goldAmount;
  }
}
