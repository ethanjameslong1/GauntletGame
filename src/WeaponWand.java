public class WeaponWand<T> extends Item
{
  final int DEFAULT_MAGIC_DAMAGE = 6;
  final int DEFAULT_MANA_USE = 5;
  final float WAND_LEVEL_DAMAGE_MULTIPLIER=0.5f;

  int manaUse; //probably can be private, we'll see
  public WeaponWand(T owner, int level)
  {
    manaUse = DEFAULT_MANA_USE*(int)(level/3)+2;
    user=owner;
    usesLeft = 99999;
    type = 'W';
    subType='W';
    damage = DEFAULT_MAGIC_DAMAGE*(int)(level*WAND_LEVEL_DAMAGE_MULTIPLIER);
  }
}
