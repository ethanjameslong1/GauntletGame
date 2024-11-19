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


  public boolean encounterBadGuy(Enemy villain) throws InvalidSubTypeException
  {
    System.out.println("Encountered bad guy");
    boolean UserAlive=true;
    Random rand = new Random();
    boolean coin = rand.nextBoolean();
    if (coin) //randomly decides who attacks first
    {
      villain.attack(this);
    }

    while (health>0 && villain.health>0)
    {
      this.attack(villain);
      if (villain.health<=0) break;
      villain.attack(this);
    }
    UserAlive=(health>0);
    return UserAlive;
  }
  public boolean encounterTrap(ArrowTrap trap)
  {
    boolean UserAlive=true;
    trap.activate(this);
    return UserAlive;
  }
}
