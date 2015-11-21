import java.util.*;
public class Warrior extends Hero
{

   public Warrior (String nm, Skill skl1, Skill skl2, Skill skl3) {
     super (nm, "warrior", skl1, skl2, skl3);
      System.out.println(nm + " is a strong warrior!");
      Random stat = new Random();
      int hlth = 300 + stat.nextInt(50);
      int mna = 150 + stat.nextInt(50);
      int str = 8 + stat.nextInt(4);
      int Int = 5 + stat.nextInt(2);
      int agi = 3 + stat.nextInt(6);
      this.strength = str;
      this.trueStrength = str;
      this.agility = agi;
      this.trueAgility = agi;
      this.intelligence = Int;
      this.trueIntelligence = Int;
      this.mana = mna;
      this.trueMana = mna;
      this.health = hlth;
      this.trueHealth = hlth;   
      System.out.println("With Health of " + hlth + ".");
      System.out.println("Mana of " + mna + ".");
      System.out.println("Strength of " + str + ".");
      System.out.println("Agility of " + agi + ".");
      System.out.println("Intelligence of " + Int + ".");
   }
}
