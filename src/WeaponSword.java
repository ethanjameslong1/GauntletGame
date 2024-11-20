public class WeaponSword<T> extends Item
{
  final int DEFAULT_SWORD_DAMAGE=8;
  final float SWORD_LEVEL_DAMAGE_MULTIPLIER=0.5f;


  public WeaponSword(T owner, int level)
  {
    usesLeft = 25 * level;
    type = 'W';
    subType = 'S';
    this.user = owner;
    name = "Sword lvl. " + level;
    damage = DEFAULT_SWORD_DAMAGE * (1+(int)(level * SWORD_LEVEL_DAMAGE_MULTIPLIER));
  }
}