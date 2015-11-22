import java.util.*;
public class Mage extends Hero
{

   public Mage (String nm, Skill skl1, Skill skl2, Skill skl3) {
      super (nm, "mage", skl1, skl2, skl3);
      System.out.println(nm + " is a wise mage!");
      Random stat = new Random();
      int hlth = 150 + stat.nextInt(25);
      int mna = 200 + stat.nextInt(50);
      int str = 2 + stat.nextInt(1);
      int Int = 10 + stat.nextInt(4);
      int agi = 5 + stat.nextInt(3);
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