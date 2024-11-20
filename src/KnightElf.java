import java.util.Random;
public class KnightElf extends Knight
{
  final float SHARP_WEAPON_DAMAGE_MODIFIER = 1.85f;
  final float BLUNT_WEAPON_DAMAGE_MODIFIER = 2.3f;
  final float MAGIC_WEAPON_DAMAGE_MODIFIER = 1.2f;
  final int INITIAL_MANA_ELF = 40;
  final int INITIAL_HEALTH_ELF = 20;
  public KnightElf(String name) {
    super(name);
    race = "Elf";
    maxMana=INITIAL_MANA_ELF;
    mana = maxMana;
    health=INITIAL_HEALTH_ELF;
    WeaponWand myWand = new WeaponWand(this, 1);
    inventory.addWeapon(myWand);

  }

  @Override
  public int takeDamage(int damage, char weaponSubType) throws InvalidSubTypeException
  {
    Random rand = new Random();
    int dice = rand.nextInt(6);
    switch(weaponSubType)
    {
      case 'A': case'S':
        if(dice<=1) return 0;
        health-=1+(int)(damage*SHARP_WEAPON_DAMAGE_MODIFIER);
        return 1+(int)(damage*SHARP_WEAPON_DAMAGE_MODIFIER);
      case 'H':
        if(dice<=2) return 0;
        health-=1+(int)(damage*BLUNT_WEAPON_DAMAGE_MODIFIER);
        return 1+(int)(damage*BLUNT_WEAPON_DAMAGE_MODIFIER);
      case 'W':
        if (dice==0) return 0;
        health-=1+(int)(damage*MAGIC_WEAPON_DAMAGE_MODIFIER);
        return 1+(int)(damage*MAGIC_WEAPON_DAMAGE_MODIFIER);
      default: throw new InvalidSubTypeException("Error: No valid weapon subType Detected!");
    }
  }
}
