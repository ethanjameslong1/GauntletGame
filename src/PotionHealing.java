public class PotionHealing<T> extends Potion
{
  public PotionHealing(int level, T owner)
  {
    super(owner);
    this.level = level;
    subType='H';
    //This is a java comment I believe.
    name = "Healing Potion lvl. "+level;
  }
}
