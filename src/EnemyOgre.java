import java.util.Random;

public class EnemyOgre extends Enemy
{
  final float SHARP_WEAPON_DAMAGE_MODIFIER = 1.1f;
  final float BLUNT_WEAPON_DAMAGE_MODIFIER = 0.7f;
  final float MAGIC_WEAPON_DAMAGE_MODIFIER = 1.6f;
  EnemyOgre(int level)
  {
    inventory = new Inventory<Item>(DEFAULT_ENEMY_INV_SLOTS);
    this.level = level;
    this.health = 19*level;
    this.name = "Ogre";
    WeaponHammer ogreClub = new WeaponHammer(this, level);
    inventory.addWeapon(ogreClub);

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
