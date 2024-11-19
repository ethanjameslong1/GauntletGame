public class PotionHealing<T> extends Potion
{
  public PotionHealing(int level, T owner)
  {
    super(owner);
    subType='H';
    name = "Healing Potion lvl. "+level;
  }
}
