public abstract class Combatant
{
  //******************************************************
  // Used to hold any class that will fight,
  // Enemies and Knights as of now
  //
  //******************************************************

  static final int WEAPON_SLOT = 0;
  Inventory inventory;
  protected String name;
  public int health,mana;
  public abstract int takeDamage(int damage, char weaponSubType) throws InvalidSubTypeException;

  public boolean isAlive(){ return (health > 0); }

  public void attack(Combatant villain){
    int attackersDamage = inventory.getSlot(WEAPON_SLOT).damage;
    char attackersSubtype = inventory.getSlot(WEAPON_SLOT).subType;
    if (attackersSubtype == 'W')
    {
      if (mana < 0+(((WeaponWand)inventory.getSlot(WEAPON_SLOT)).manaUse)) attackersDamage = 5; //uses stick when out of mana
      else {mana -= ((WeaponWand)inventory.getSlot(WEAPON_SLOT)).manaUse;}
    }
    else
    {
      if (inventory.getSlot(WEAPON_SLOT).usesLeft <= 0) attackersDamage = 3; //uses fist when out of uses
      else {inventory.getSlot(WEAPON_SLOT).usesLeft--;}
    }

    try {
      villain.takeDamage(attackersDamage,attackersSubtype);
    } catch (InvalidSubTypeException e) {
      throw new RuntimeException(e);
    }

  }
}
