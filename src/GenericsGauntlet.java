import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import static java.lang.Character.toUpperCase;

public class GenericsGauntlet {
  static Knight user;
  static GUI gui;
  static Enemy currentVillain;
  static int gameLevel = 1;
  static int encounters = 0;


  public static void main(String[] args)
  {
    gui = new GUI();
    playGame();
  }

  public static void playGame()
  {
    do {currentVillain = encounter(gameLevel);}
    while(currentVillain.name=="Arrow Trap" || currentVillain.level>1);
    gui.startingGUI();
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
    Enemy encounteredEnemy;
    do {encounteredEnemy = Enemy.getRandomEnemy(level);} while (Objects.equals(encounteredEnemy.name, "Arrow Trap"));
    return encounteredEnemy;
  }


  public static boolean fightTurn(boolean playerTurn)
  {
    if (playerTurn)
      user.attack(currentVillain);
    else currentVillain.attack(user);
    return !playerTurn;
  }

  public static boolean bothAlive(){ return (user.health>0 && currentVillain.health>0); }
}
