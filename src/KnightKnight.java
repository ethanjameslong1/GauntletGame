public class KnightKnight extends Knight
{
  final float SHARP_WEAPON_DAMAGE_MODIFIER = 0.8f;
  final float BLUNT_WEAPON_DAMAGE_MODIFIER = 1.2f;
  final float MAGIC_WEAPON_DAMAGE_MODIFIER = 1.5f;

  final int INITIAL_MANA_HUMAN = 25;
  final int INITIAL_HEALTH_HUMAN = 25;
  public KnightKnight(String name) {
    super(name);
    race = "Human";
    maxMana=INITIAL_MANA_HUMAN;
    mana = maxMana;
    health=INITIAL_HEALTH_HUMAN;
    WeaponSword mySword = new WeaponSword(this, 1);
    inventory.addWeapon(mySword);

  }

  @Override
  public int takeDamage(int damage, char weaponSubType) throws InvalidSubTypeException
  {
    switch(weaponSubType)
    {
      case 'A': case'S': health-=(int)damage*SHARP_WEAPON_DAMAGE_MODIFIER; return (int)(damage*SHARP_WEAPON_DAMAGE_MODIFIER);
      case 'H': health-=(int)damage*BLUNT_WEAPON_DAMAGE_MODIFIER; return (int)(damage*BLUNT_WEAPON_DAMAGE_MODIFIER);
      case 'W': health-=(int)damage*MAGIC_WEAPON_DAMAGE_MODIFIER; return (int)(damage*MAGIC_WEAPON_DAMAGE_MODIFIER);
      default: throw new InvalidSubTypeException("Error: No valid weapon subType Detected!");
    }
  }
}
