import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

public class GUI
{
  final int USES_FONT_SIZE=28;
  private JFrame frame;

  private JPanel enemyPanel;
  private JPanel userPanel;
  private JPanel introPanel;
  private JPanel characterSelectionPanel;

  public JTextPane dialogBox;
  private JTextArea userName;
  private JTextArea enemyName;

  private JTextField characterNameField;

  private JButton characterOptionButton;
  private JButton confirmCharacterButton;
  private JButton beginButton;
  private JButton actionButton;

  private JLabel userCharacterImageLabel;
  private JLabel userWeaponDisplayLabel;
  private JLabel healthPotionDisplayLabel;
  private JLabel manaPotionDisplayLabel;

  private JLabel enemyImageLabel;
  private JLabel enemyWeaponLabel;

  private String characterNameChoice="";
  public int characterChoice=1;
  private boolean playerTurn=true;


  public GUI(){ }
  //*****************************************************************
  //                                                                *
  //    Psueod-Constructor                                          *
  //                                                                *
  //*****************************************************************
  public void startingGUI()
  {
    frame = new JFrame("Gauntlet");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1024,512);
    frame.setResizable(false);
    frame.setIconImage(new ImageIcon("FantasyLogo.png").getImage());
    frame.setBackground(Color.WHITE);
    frame.setLayout(null);

    introPanel = new JPanel();
    introPanel.setBackground(Color.WHITE);
    introPanel.setBounds(0,0,1024,212);
    dialogBox = new JTextPane();
    dialogBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    dialogBox.setText("Hello!! Welcome to the Generics Gauntlet. You will begin by choosing a character.\n" +
        "1) Elf: Well known for it's magical expertise, having by far the best mana stat.\n" +
        "Everytime it's attacked it has a chance of dodging! Works especially well against slow, blunt weapons.\n" +
        "2) Knight: Standard Knight, good defense and offensive abilities against most enemies, most weak to magic attacks.\n" +
        "3) Dwarf: Great defense with a mighty Hammer.\n");
    dialogBox.setEditable(false);
    dialogBox.setBackground(Color.WHITE);
    introPanel.add(dialogBox);

    characterSelectionPanel = new JPanel();
    characterSelectionPanel.setBackground(Color.WHITE);
    characterSelectionPanel.setBounds(0,212,1024,300);
    characterOptionButton = new JButton("Click to change choice!");
    characterOptionButton.setBackground(Color.GRAY);
    characterOptionButton.setBounds(400,50,100,50);


    userCharacterImageLabel = new JLabel(new ImageIcon("KnightCharacterImage.png"));
    userCharacterImageLabel.setBounds(400,200,128,128);
    characterSelectionPanel.add(userCharacterImageLabel);
    userCharacterImageLabel.setVisible(true);

    characterNameField = new JTextField();
    characterNameField.setBounds(400,306,100,25);
    characterNameField.setText("Enter Character Name");
    characterNameField.addFocusListener(nameField);


    confirmCharacterButton = new JButton("Click to confirm character!");
    confirmCharacterButton.setBackground(Color.GRAY);
    confirmCharacterButton.setBounds(500,50,100,50);
    confirmCharacterButton.addActionListener(confirmCharAction);
    characterOptionButton.addActionListener(characterOptionListener);
    characterSelectionPanel.add(characterOptionButton);
    characterSelectionPanel.add(confirmCharacterButton);


    characterSelectionPanel.add(characterNameField);
    frame.add(introPanel);
    frame.add(characterSelectionPanel);
    frame.repaint();
    frame.setVisible(true);
  }

  public void newStartingGUI()
  {

    introPanel = new JPanel();
    introPanel.setBackground(Color.WHITE);
    introPanel.setBounds(0,0,1024,212);
    dialogBox = new JTextPane();
    dialogBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    dialogBox.setText("Hello!! Welcome to the Generics Gauntlet. You will begin by choosing a character.\n" +
            "1) Elf: Well known for it's magical expertise, having by far the best mana stat.\n" +
            "Everytime it's attacked it has a chance of dodging! Works especially well against slow, blunt weapons.\n" +
            "2) Knight: Standard Knight, good defense and offensive abilities against most enemies, most weak to magic attacks.\n" +
            "3) Dwarf: Great defense with a mighty Hammer.\n");
    dialogBox.setEditable(false);
    dialogBox.setBackground(Color.WHITE);
    introPanel.add(dialogBox);

    characterSelectionPanel = new JPanel();
    characterSelectionPanel.setBackground(Color.WHITE);
    characterSelectionPanel.setBounds(0,212,1024,300);
    characterOptionButton = new JButton("Click to change choice!");
    characterOptionButton.setBackground(Color.GRAY);
    characterOptionButton.setBounds(400,50,100,50);


    userCharacterImageLabel = new JLabel(new ImageIcon("KnightCharacterImage.png"));
    userCharacterImageLabel.setBounds(400,200,128,128);
    characterSelectionPanel.add(userCharacterImageLabel);
    userCharacterImageLabel.setVisible(true);

    characterNameField = new JTextField();
    characterNameField.setBounds(400,306,100,25);
    characterNameField.setText("Enter Character Name");
    characterNameField.addFocusListener(nameField);


    confirmCharacterButton = new JButton("Click to confirm character!");
    confirmCharacterButton.setBackground(Color.GRAY);
    confirmCharacterButton.setBounds(500,50,100,50);
    confirmCharacterButton.addActionListener(confirmCharAction);
    characterOptionButton.addActionListener(characterOptionListener);
    characterSelectionPanel.add(characterOptionButton);
    characterSelectionPanel.add(confirmCharacterButton);


    characterSelectionPanel.add(characterNameField);
    frame.add(introPanel);
    frame.add(characterSelectionPanel);
    frame.repaint();
    frame.setVisible(true);
  }

  //*****************************************************************
  //                                                                *
  //    Action Listeners                                            *
  //                                                                *
  //*****************************************************************

  ActionListener characterOptionListener = new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    characterChoice += 1;
    if (characterChoice > 3) characterChoice = 1;
    switch (characterChoice){
      case 1: userCharacterImageLabel.setIcon(new ImageIcon("KnightCharacterImage.png")); break;
      case 3: userCharacterImageLabel.setIcon(new ImageIcon("femaledwarf.png")); break;
      case 2: userCharacterImageLabel.setIcon(new ImageIcon("maleelf.png")); break;
      default: {}
    }
  }
  };


  ActionListener confirmCharAction = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {
      characterNameChoice = characterNameField.getText();
      if (characterNameChoice.equals("Enter Character Name")){}
      else {
        GenericsGauntlet.makeCharacter(characterChoice,characterNameChoice);
        introPanel.remove(dialogBox);
        frame.remove(introPanel);
        frame.remove(characterSelectionPanel);
        frame.revalidate();
        frame.repaint();
        addUserandEnemyPanel();
      }
    }
  };

  ActionListener beginButtonListener = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {
      GenericsGauntlet.fightTurn(true);
      updateEnemyDisplay();
      updateInventoryDisplay();
      beginButton.setText("Attack!!!!");
      if(GenericsGauntlet.currentVillain.isAlive()==false)
      {
        GenericsGauntlet.currentVillain = GenericsGauntlet.encounter(GenericsGauntlet.gameLevel);
        updateEnemyDisplay();
        dialogBox.setText("Congratulations! Next time the enemy will attack back.\nClick Continue to play for real.");
        actionButton = new JButton("Continue");
        actionButton.setBackground(Color.GRAY);
        actionButton.setBounds(100,250,100,25);
        actionButton.addActionListener(actionButtonListener);
        userPanel.add(actionButton);
        userPanel.remove(beginButton);
        userPanel.revalidate();
        userPanel.repaint();
      }
    }
  };

  ActionListener actionButtonListener = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    {
      if (GenericsGauntlet.bothAlive())
      {
        playerTurn = GenericsGauntlet.fightTurn(playerTurn);
        updateEnemyDisplay();
        updateInventoryDisplay();
        if (GenericsGauntlet.bothAlive())
        {
          if (playerTurn) actionButton.setText("Attack");
          else actionButton.setText("Ready...");
        }
        else if (!GenericsGauntlet.user.isAlive())
        {
          dialogBox.setText("It seems you have died.");
          frame.getContentPane().removeAll();
          frame.revalidate();
          frame.repaint();
          newStartingGUI();
        }
        else
        {
          Random rand = new Random();
          playerTurn = rand.nextBoolean();
          GenericsGauntlet.currentVillain = GenericsGauntlet.encounter(GenericsGauntlet.gameLevel);
          updateEnemyDisplay();
        }
      }
      else
      {
        dialogBox.setText("It seems something went wrong.");
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        newStartingGUI();
      }
      userPanel.revalidate();
      userPanel.repaint();
      enemyPanel.revalidate();
      enemyPanel.repaint();
    }
  };


  //*****************************************************************
  //                                                                *
  //    Focus Listeners                                             *
  //                                                                *
  //*****************************************************************
  FocusListener nameField = new FocusListener() {
  @Override
  public void focusGained(FocusEvent e) {
    // Clear the default text when the field gains focus
    if (characterNameField.getText().equals("Enter Character Name")) {
      characterNameField.setText("");
    }
  }
  @Override
  public void focusLost(FocusEvent e) {
    // Restore default text if the field is empty
    if (characterNameField.getText().isEmpty()) {
      characterNameField.setText("Enter Character Name");
    }
  }
};




  //*****************************************************************
  //                                                                *
  //    Initializing User and Enemy Displays                        *
  //                                                                *
  //*****************************************************************


  public void addUserandEnemyPanel()
  {
    userPanel = new JPanel();
    userPanel.setLayout(null);
    userPanel.setBackground(Color.WHITE);
    userPanel.setBounds(512,0,512,512);
    userPanel.add(userCharacterImageLabel);
    userCharacterImageLabel.setBounds(384,0,128,128);
    userCharacterImageLabel.setText(String.valueOf(GenericsGauntlet.user.health));
    userCharacterImageLabel.setFont(new Font("Arial", Font.BOLD, USES_FONT_SIZE));
    userCharacterImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    userCharacterImageLabel.setForeground(Color.RED);
    userName = new JTextArea(characterNameChoice); //ditto here
    userName.setEditable(false);
    userName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    userName.setBackground(Color.BLACK);
    userName.setForeground(Color.WHITE);
    userName.setBounds(384,128,128,25);
    dialogBox.setBounds(0,0,300,250);
    dialogBox.setText("Welcome to the game, you will face waves of enemies and the occasional trap.\n Should you live past a trap there will always be treasure to choose from!");
    userPanel.add(dialogBox);
    userPanel.add(userName);
    addUserWeaponLabel();
    beginButton = new JButton("Begin!");
    beginButton.setBackground(Color.GRAY);
    beginButton.setBounds(100,250,100,25);
    beginButton.addActionListener(beginButtonListener);
    userPanel.add(beginButton);

    userPanel.revalidate();
    userPanel.repaint();
    userPanel.setVisible(true);


    enemyPanel = new JPanel();
    enemyPanel.setLayout(null);
    enemyPanel.setBackground(Color.BLACK);
    enemyPanel.setBounds(0,0,512,512);
    updateEnemyDisplay();
    enemyPanel.revalidate();
    enemyPanel.repaint();
    enemyPanel.setVisible(true);

    frame.add(enemyPanel);
    frame.add(userPanel);
  }



  //*****************************************************************
  // Updating Weapon Displays                                       *
  // User Display                                                   *
  // Enemy Display                                                  *
  //*****************************************************************

  private void createGameLoop()
  {

  }

  private String getWeaponImage(char subType) {
    switch (subType) {
      case 'W': return "wandImg.png";
      case 'S': return "swordImg.png";
      case 'H': return "warhammerImg.png";
      default:  return "defaultImg.png";
    }
  }

  private void addUserWeaponLabel()
  {
    userWeaponDisplayLabel = new JLabel();
    userWeaponDisplayLabel.setBounds(384,160,64,64);
    userWeaponDisplayLabel.setFont(new Font("Arial", Font.BOLD, USES_FONT_SIZE));
    userWeaponDisplayLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    userWeaponDisplayLabel.setForeground(Color.RED);

    Item weaponSlot = GenericsGauntlet.user.inventory.getSlot(Combatant.WEAPON_SLOT);
    if (weaponSlot == null) return;
    else
    {
      String uses = String.valueOf(weaponSlot.usesLeft);
      char subType = weaponSlot.subType;
      if (subType=='W') uses = String.valueOf(GenericsGauntlet.user.mana);
      userWeaponDisplayLabel.setIcon(new ImageIcon(getWeaponImage(subType)));
      userWeaponDisplayLabel.setText(uses);
    }
    userPanel.add(userWeaponDisplayLabel);
  }


  //*****************************************************************
  // Resetting Displays                                             *
  // User Display                                                   *
  // Enemy Display                                                  *
  //*****************************************************************

  public void updateInventoryDisplay()
  {
    Knight user = GenericsGauntlet.user;
    if (user == null || user.inventory == null) return;
    userCharacterImageLabel.setText(String.valueOf(user.health));
    if (userPanel.isAncestorOf(userWeaponDisplayLabel)) userPanel.remove(userWeaponDisplayLabel);

    userWeaponDisplayLabel = new JLabel();
    userWeaponDisplayLabel.setBounds(384,160,64,64);
    userWeaponDisplayLabel.setFont(new Font("Arial", Font.BOLD, USES_FONT_SIZE));
    userWeaponDisplayLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    userWeaponDisplayLabel.setForeground(Color.RED);

    Item weaponSlot = user.inventory.getSlot(Combatant.WEAPON_SLOT);
    if (weaponSlot == null) return;
    else
    {
      String uses;
      if (weaponSlot.subType == 'W') {uses = String.valueOf(user.mana);}
      else {uses = String.valueOf(weaponSlot.usesLeft);}
      char subType = weaponSlot.subType;
      userWeaponDisplayLabel.setIcon(new ImageIcon(getWeaponImage(subType)));
      userWeaponDisplayLabel.setText(uses);
    }
    userPanel.add(userWeaponDisplayLabel);

    /*for (int i=1; i<user.inventory.getSize(); i++)
      if (user.inventory.getSlot(i)!=null)
      {
        switch(user.inventory.getSlot(i).subType)
        {
          case 'M':
            manaPotionDisplayLabel.setIcon(new ImageIcon("manapotion.png"));//by using a vector of display label I want
            manaPotionDisplayLabel.setBounds(384,(160+64),64,64); //to add support for having various potions
            manaPotionDisplayLabel.setFont(new Font("Arial", Font.BOLD, 14));//if you have say 1 level 1 potion and 2 level 2 potion
            manaPotionDisplayLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            manaPotionDisplayLabel.setForeground(Color.RED);//right now it's a bug if you have multiple levels of the same potion
            manaPotionDisplayLabel.setText(String.valueOf(user.inventory.getSlot(i).usesLeft));//it'll be fixed soon
            userPanel.add(manaPotionDisplayLabel);
            break;
          case 'H':
            healthPotionDisplayLabel.setIcon(new ImageIcon("healingpotion.png"));
            healthPotionDisplayLabel.setBounds(384,(160+(2*64)),64,64);
            healthPotionDisplayLabel.setFont(new Font("Arial", Font.BOLD, 14));
            healthPotionDisplayLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            healthPotionDisplayLabel.setForeground(Color.RED);
            healthPotionDisplayLabel.setText(String.valueOf(user.inventory.getSlot(i).usesLeft));
            userPanel.add(healthPotionDisplayLabel);
            break;
          default: {}
        }
      }*/
    userPanel.revalidate();
    userPanel.repaint();
  }

  private void updateEnemyDisplay()
  {
    if (enemyPanel.isAncestorOf(enemyImageLabel)){enemyPanel.remove(enemyImageLabel);
    enemyPanel.remove(enemyWeaponLabel);}
    enemyImageLabel=new JLabel();
    enemyWeaponLabel=new JLabel();
    enemyWeaponLabel.setFont(new Font("Arial", Font.BOLD, USES_FONT_SIZE));
    String enemyWeaponUses = String.valueOf((GenericsGauntlet.currentVillain.inventory.getSlot(Combatant.WEAPON_SLOT)).usesLeft);
    char weaponSubType = GenericsGauntlet.currentVillain.inventory.getSlot(Combatant.WEAPON_SLOT).subType;
    switch (weaponSubType)
    {
      case 'W':
        enemyWeaponLabel.setIcon(new ImageIcon(getWeaponImage('W')));
        enemyWeaponUses="∞";
        enemyWeaponLabel.setFont(new Font("Arial", Font.BOLD, 36));
        enemyImageLabel = new JLabel();
        enemyImageLabel.setIcon(new ImageIcon("sorcererimage.png"));
        break;
      case 'S':
        enemyWeaponLabel.setIcon(new ImageIcon(getWeaponImage('S')));
        enemyImageLabel = new JLabel();
        enemyImageLabel.setIcon(new ImageIcon("undeadknightimage.png"));
        break;
      case 'H':
        enemyWeaponLabel.setIcon(new ImageIcon(getWeaponImage('H')));
        enemyImageLabel = new JLabel();
        enemyImageLabel.setIcon(new ImageIcon("ogreimage.png"));
        break;
      default: enemyWeaponLabel.setIcon(new ImageIcon("FantasyLogo.png"));
        enemyImageLabel = new JLabel("FantasyLogo.png");
    }
    enemyImageLabel.setText(String.valueOf(GenericsGauntlet.currentVillain.getHealth()));
    enemyImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyImageLabel.setForeground(Color.RED);
    enemyImageLabel.setFont(new Font("Arial", Font.BOLD, USES_FONT_SIZE));


    enemyWeaponLabel.setText(enemyWeaponUses);
    enemyWeaponLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    enemyWeaponLabel.setForeground(Color.RED);
    enemyImageLabel.setBounds(0,0,128,128);
    enemyWeaponLabel.setBounds(0,160,64,64);

    enemyName = new JTextArea(GenericsGauntlet.currentVillain.getName()+" lvl. "+GenericsGauntlet.currentVillain.level);
    enemyName.setEditable(false);
    enemyName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    enemyName.setBackground(Color.BLACK);
    enemyName.setForeground(Color.WHITE);
    enemyName.setBounds(0,128,128,25);
    enemyPanel.add(enemyName);

    enemyPanel.add(enemyImageLabel);
    enemyPanel.add(enemyWeaponLabel);
    enemyWeaponLabel.setVisible(true);
    enemyPanel.revalidate();
    enemyPanel.repaint();
  }


}
