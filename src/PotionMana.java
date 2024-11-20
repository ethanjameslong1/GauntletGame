public class PotionMana<T> extends Potion
{
  public PotionMana(int level, T owner)
  {
    super(owner);
    this.level = level;
    subType='M';
    name = "Mana Potion lvl. "+level;
  }
}
