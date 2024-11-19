import java.util.Random;

public class EnemyUndeadKnight extends Enemy
{
  final float SHARP_WEAPON_DAMAGE_MODIFIER = 0.8f;
  final float BLUNT_WEAPON_DAMAGE_MODIFIER = 1.2f;
  final float MAGIC_WEAPON_DAMAGE_MODIFIER = 1.5f;
  EnemyUndeadKnight(int level)
  {
    inventory = new Inventory<Item>(DEFAULT_ENEMY_INV_SLOTS);
    this.level = level;
    this.health = 6*level;
    this.name = "Undead Knight";
    WeaponSword zombieSword = new WeaponSword(this, level);
    inventory.addWeapon(zombieSword);

  }


  @Override
  public int takeDamage(int damage, char weaponSubType) throws InvalidSubTypeException
  {
    switch(weaponSubType)
    {
      case 'A': case'S':
      health-=(int)damage*SHARP_WEAPON_DAMAGE_MODIFIER;
      return (int)(damage*SHARP_WEAPON_DAMAGE_MODIFIER);
      case 'H':
        health-=(int)damage*BLUNT_WEAPON_DAMAGE_MODIFIER;
        return (int)(damage*BLUNT_WEAPON_DAMAGE_MODIFIER);
      case 'W':
        health-=(int)damage*MAGIC_WEAPON_DAMAGE_MODIFIER;
        return (int)(damage*MAGIC_WEAPON_DAMAGE_MODIFIER);
      default: throw new InvalidSubTypeException("Error: No valid weapon subType Detected!");
    }
  }

}
