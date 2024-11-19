import java.util.Random;
public class ArrowTrap<T extends Combatant> extends Enemy
{
  public ArrowTrap(int level)
  {
    inventory = new Inventory<WeaponArrow>(DEFAULT_ENEMY_INV_SLOTS*2*level);
    this.level = level;
    this.health = 1;
    this.name = "Arrow Trap";
    for (int i=0; i<inventory.getSize();i++)
    {
      inventory.setSlot(i, new WeaponArrow(level, this));
    }
  }
  public void activate(T victim)
  {
    Random rand = new Random();
    int dice = rand.nextInt(3);
    for (int i=0;i<inventory.getSize();i++)
    {
      if (dice != 2) ((WeaponArrow)inventory.getSlot(i)).hit(victim);
      inventory.emptySlot(i);
      dice = rand.nextInt(3);
    }
    try{takeDamage(69,'#');}
    catch (InvalidSubTypeException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int takeDamage(int damage, char weaponSubType) throws InvalidSubTypeException
  {
    health=0;
    return 0;
  }
}
