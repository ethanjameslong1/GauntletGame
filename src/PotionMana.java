public class PotionMana<T> extends Potion
{
  public PotionMana(int level, T owner)
  {
    super(owner);
    subType='M';
    name = "Mana Potion lvl. "+level;
  }
}
