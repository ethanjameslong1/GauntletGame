import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Knight extends Combatant
{

  final int INITIAL_INVENTORY_SIZE = 5;
  protected String race;
  protected int inventorySlots, maxMana;

  public Knight(String name)
  {
    this.name = name;
    inventorySlots = INITIAL_INVENTORY_SIZE; //I'll hopefully add a way to increase inventory space
    inventory = new Inventory(INITIAL_INVENTORY_SIZE);
  }



}
