import java.util.Scanner;
import java.util.Random;

import static java.lang.Character.toUpperCase;

public class GenericsGauntlet {
  static Knight user;
  static GUI gui;
  static Enemy currentVillain;
  static int gameLevel = 1;
  public static void main(String[] args)
  {
    gui = new GUI();

  }

  public static void playGame()
  {
    do {currentVillain = encounter(gameLevel);}while(currentVillain.name=="Arrow Trap" || currentVillain.level>1);
    gui.addUserandEnemyPanel();


  }


  public static void makeCharacter(int characterChoice, String characterName)
  {
    switch(characterChoice)
    {
      case 2: user =  new KnightElf(characterName); break;
      case 1: user =  new KnightKnight(characterName); break;
      case 3: user =  new KnightDwarf(characterName); break;
      default: user=  new KnightKnight("BadInput");
    }
  }

  public static Enemy encounter(int level)
  {
    Enemy encounteredEnemy = Enemy.getRandomEnemy(level);
    return encounteredEnemy;
  }

}
