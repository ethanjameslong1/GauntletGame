public abstract class Combatant
{
  final int WEAPON_SLOT = 0;
  Inventory inventory;
  protected String name;
  protected int health,mana;
  public abstract int takeDamage(int damage, char weaponSubType) throws InvalidSubTypeException;

  public void attack(Combatant villain) throws InvalidSubTypeException {
    int attackersDamage = inventory.getSlot(WEAPON_SLOT).damage;
    char attackersSubtype = inventory.getSlot(WEAPON_SLOT).subType;
    if (attackersSubtype == 'W')
    {
      mana -= ((WeaponWand)inventory.getSlot(WEAPON_SLOT)).manaUse;
      if (mana <= 0) attackersDamage = 5; //uses stick when out of mana
    }
    if (inventory.getSlot(WEAPON_SLOT).usesLeft <= 0) attackersDamage = 3; //uses fist when out of uses
    inventory.getSlot(WEAPON_SLOT).usesLeft--;
    villain.takeDamage(attackersDamage,attackersSubtype);
  }
}
