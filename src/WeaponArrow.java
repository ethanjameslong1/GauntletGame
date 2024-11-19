public class WeaponArrow<T extends Combatant> extends Item
{
  final int DEFAULT_ARROW_DAMAGE=3;
  int damage;
  int level;
  public WeaponArrow(int level, T user)
  {
    this.user=user;
    this.level=level;
    subType='A';
    damage=DEFAULT_ARROW_DAMAGE*(level/2);
    name="Normal Arrow";
    usesLeft=1;
  }
  public void hit(T victim)
  {
    try {victim.takeDamage(damage,subType);}
    catch (Exception e) {}
    usesLeft--;
  }
}
