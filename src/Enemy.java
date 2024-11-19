import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Enemy<T> extends Combatant
{

  final int DEFAULT_ENEMY_INV_SLOTS = 2; //I want to eventually allow enemies to hold potions

  protected int level;
  public String name;

  public int getHealth() {
    return health;
  }
  public String getName() {
    return name;
  }


  public static Enemy getRandomEnemy(int level)
  {
    Random ran = new Random();
    int index = ran.nextInt(4);
    int enemyLevel = ran.nextInt(2);
    boolean coin = ran.nextBoolean();
    if (coin) enemyLevel = level-enemyLevel;
    else enemyLevel = level+enemyLevel;
    if (enemyLevel<1) enemyLevel=1;
    switch (index) {
      case 0:
        return new EnemyOgre(enemyLevel);
      case 1:
        return new EnemySorcerer(enemyLevel);
      case 2:
        return new EnemyUndeadKnight(enemyLevel);
      case 3:
        return new ArrowTrap(enemyLevel);
    }
    return null;
  }

  public String toString()
  {
    String output;
    output = "Enemy "+name+" lvl. "+level+" has "+health+" total health left";
    return output;
  }

}
