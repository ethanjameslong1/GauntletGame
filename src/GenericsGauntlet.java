import java.util.Scanner;
import java.util.Random;

import static java.lang.Character.toUpperCase;

public class GenericsGauntlet {

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    System.out.println("Hello!! Welcome to the Generics Gauntlet. You will begin by choosing a character.");
    Knight user = makeCharacter();
    System.out.println("\n\nThroughout this gauntlet you will encounter Enemies and Traps, be wary.");
    System.out.println("If you do encounter a trap and live, you will choose between 1 of 3 items to keep.");
    System.out.println("Mana and healing potions, gives you health or mana based on the potion's level.");
    System.out.println("Potions also have a chance of increasing maximum value of their respective type.");
    System.out.println("You can also pick up weapons on your path, they will replace your current weapon in the process");
    System.out.println("Any wand uses mana, and having weapons based on your chosen race also boosts damage slightly");
    System.out.println("Humans are the best middle ground, Elves are best for wands and suck with blunt weapons, Dwarves are the opposite.");
    System.out.println("However if you chose Knight they are well trained with sharp weapons, getting the highest boost to sharp weapons.");
    System.out.println("Are you ready for the gauntlet? (Y/N)");
    char readiness = sc.next().charAt(0);
    readiness = toUpperCase(readiness);
    int readinessCount=0;
    while (readiness != 'Y')
    {
      System.out.println("You seemed to not have entered a Y, enter a Y if you want to play!");
      readiness = sc.next().charAt(0);
      readiness = toUpperCase(readiness);
      readinessCount++;
      if (readinessCount>=3) System.exit(0);
    }
    int currentGamesLevel=1;
    int encounterCount =0;
    boolean isAlive = true;
    while (isAlive && readiness == 'Y')
    {
      Enemy currentVillain = encounter(currentGamesLevel);
      encounterCount++;
      if (encounterCount%3==0)
      {
        currentGamesLevel++;
        System.out.println("Game level has increased to "+currentGamesLevel);
      }

      //Because I'm using the name to determine this, it'll
      //be awful to add more variety of traps later, i should make a function that returns a boolean
      //if the villain is any kind of trap, but I have to turn this assignment in soon
      if (currentVillain.name != "Arrow Trap")
      {
        try {isAlive = user.encounterBadGuy(currentVillain);}
        catch (InvalidSubTypeException e) {throw new RuntimeException(e);}
      }
      else
      {
        isAlive = user.encounterTrap((ArrowTrap) currentVillain);
      }
      if (isAlive) System.out.println("One encounter done! You heal 7 health for ever level passed in between battles");
      user.health+=(7*currentGamesLevel);

      if(isAlive)
      {
        System.out.println("you're health is at: " + user.health);
        System.out.println("Play on? (Y/N)");
        readiness = sc.next().charAt(0);
        readiness = toUpperCase(readiness);
        readinessCount = 0;
        while (readiness != 'Y' && readiness != 'N') {
          System.out.println("You seemed to not have entered a Y, enter a Y if you want to play!");
          readiness = sc.next().charAt(0);
          readiness = toUpperCase(readiness);
          readinessCount++;
          if (readinessCount >= 3) System.exit(0);
        }
      }
    }



  }

  public static Knight makeCharacter()
  {
    System.out.println("1) Elf: Well known for it's magical expertise, having by far the best mana stat.");
    System.out.println("Everytime it's attacked it has a chance of dodging! Works especially well against slow, blunt weapons.");
    System.out.println("2) Knight: Standard Knight, good defense and offensive abilities against most enemies, most weak to magic attacks.");
    System.out.println("3) Dwarf: Great defense with a mighty Hammer.");
    Scanner sc = new Scanner(System.in);
    int CharacterChoice = sc.nextInt();
    sc.nextLine();
    while (CharacterChoice != 1 && CharacterChoice != 2 && CharacterChoice != 3)
    {
      System.out.println("Please enter a valid option! (1,2,3)");
      CharacterChoice = sc.nextInt();
    }
    System.out.println("Great Choice! Now name your warrior!");

    String characterName = sc.nextLine();

    switch(CharacterChoice)
    {
      case 1: return new KnightElf(characterName);
      case 2: return new KnightKnight(characterName);
      case 3: return new KnightDwarf(characterName);
      default: return new KnightKnight(characterName);
    }
  }

  public static Enemy encounter(int level)
  {
    Enemy encounteredEnemy = Enemy.getRandomEnemy(level);
    switch (encounteredEnemy.name)
    {
      case "Ogre": case "Sorcerer": case "Undead Knight":
        System.out.println("Your Encounter: ");
        System.out.println(encounteredEnemy.toString());
      break;
      case "Arrow Trap":
        System.out.println("You've Hit A Trap!: ");
        System.out.println("The Arrow trap is level "+encounteredEnemy.level);
        break;
      default:
        System.out.println("Something is weird, hopefully this doesn't break anything...");
    }
    return encounteredEnemy;
  }
}
