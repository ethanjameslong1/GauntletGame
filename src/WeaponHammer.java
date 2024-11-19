public class WeaponHammer<T> extends Item
{
  final int DEFAULT_HAMMER_DAMAGE=12;


  public WeaponHammer(T owner, int level)
  {
    usesLeft = 25 * level;
    type = 'W';
    subType = 'H';
    this.user = owner;
    name = "Hammer lvl. " + level;
    damage = DEFAULT_HAMMER_DAMAGE * (level * 3);
  }
}
