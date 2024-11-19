public class WeaponSword<T> extends Item
{
  final int DEFAULT_SWORD_DAMAGE=8;


  public WeaponSword(T owner, int level)
  {
    usesLeft = 25 * level;
    type = 'W';
    subType = 'S';
    this.user = owner;
    name = "Sword lvl. " + level;
    damage = DEFAULT_SWORD_DAMAGE * (level * 3);
  }
}