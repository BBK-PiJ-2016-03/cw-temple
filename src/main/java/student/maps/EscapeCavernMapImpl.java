package student.maps;

import java.util.HashMap;
import java.util.Map;

import student.nodes.CavernNode;

/**
 * Created by Alexander Worton on 13/02/2017.
 */
@SuppressWarnings("ALL")
public class EscapeCavernMapImpl extends CavernMapImpl implements EscapeCavernMap {

  /**
   * goldMap field.
   **/
  private final Map<CavernNode, Integer> goldMap;
  /**
   * exit field.
   **/
  private CavernNode exit;

  {
    goldMap = new HashMap<>();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setNodeGold(CavernNode node, int gold) {
    goldMap.put(node, gold);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final int getNodeGold(CavernNode node) {
    return goldMap.get(node);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final CavernNode getExit() {
    return this.exit;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public final void setExit(CavernNode node) {
    this.exit = node;
  }
}
