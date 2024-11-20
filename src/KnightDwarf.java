public class KnightDwarf extends Knight
{
  final float SHARP_WEAPON_DAMAGE_MODIFIER = 1.1f;
  final float BLUNT_WEAPON_DAMAGE_MODIFIER = 0.7f;
  final float MAGIC_WEAPON_DAMAGE_MODIFIER = 1.6f;
  final int INITIAL_MANA_DWARF = 15;
  final int INITIAL_HEALTH_DWARF = 35;

  public KnightDwarf(String name)
  {
    super(name);
    race = "Dwarf";
    maxMana=INITIAL_MANA_DWARF;
    mana = maxMana;
    health=INITIAL_HEALTH_DWARF;
    WeaponHammer myHammer = new WeaponHammer(this, 1);
    inventory.addWeapon(myHammer);
  }

  @Override
  public int takeDamage(int damage, char weaponSubType) throws InvalidSubTypeException
  {
    switch(weaponSubType)
    {
      case 'A': case'S': health-=1+(int)(damage*SHARP_WEAPON_DAMAGE_MODIFIER); return 1+(int)(damage*SHARP_WEAPON_DAMAGE_MODIFIER);
      case 'H': health-=1+(int)(damage*BLUNT_WEAPON_DAMAGE_MODIFIER); return 1+(int)(damage*BLUNT_WEAPON_DAMAGE_MODIFIER);
      case 'W': health-=1+(int)(damage*MAGIC_WEAPON_DAMAGE_MODIFIER); return 1+(int)(damage*MAGIC_WEAPON_DAMAGE_MODIFIER);
      default: throw new InvalidSubTypeException("Error: No valid weapon subType Detected!");
    }

  }

}
