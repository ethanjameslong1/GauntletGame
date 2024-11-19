import java.util.Random;

public class EnemySorcerer extends Enemy
{
  final float SHARP_WEAPON_DAMAGE_MODIFIER = 1.0f;
  final float BLUNT_WEAPON_DAMAGE_MODIFIER = 1.8f;
  final float MAGIC_WEAPON_DAMAGE_MODIFIER = 0.6f;
  EnemySorcerer(int level)
  {
    mana = 9999;
    inventory = new Inventory<Item>(DEFAULT_ENEMY_INV_SLOTS);
    this.level = level;
    this.health = 7*level;
    this.name = "Sorcerer";
    WeaponWand sorcererWand = new WeaponWand(this, level);
    inventory.addWeapon(sorcererWand);

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
      health-=(int)damage*SHARP_WEAPON_DAMAGE_MODIFIER;
      return (int)(damage*SHARP_WEAPON_DAMAGE_MODIFIER);
      case 'H':
        if(dice<=2) return 0;
        health-=(int)damage*BLUNT_WEAPON_DAMAGE_MODIFIER;
        return (int)(damage*BLUNT_WEAPON_DAMAGE_MODIFIER);
      case 'W':
        if (dice==0) return 0;
        health-=(int)damage*MAGIC_WEAPON_DAMAGE_MODIFIER;
        return (int)(damage*MAGIC_WEAPON_DAMAGE_MODIFIER);
      default: throw new InvalidSubTypeException("Error: No valid weapon subType Detected!");
    }
  }
}
