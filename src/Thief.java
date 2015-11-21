import java.util.*;
public class Thief extends Hero
{

   public Thief (String nm, Skill skl1, Skill skl2, Skill skl3) {
     super (nm, "thief", skl1, skl2, skl3);
      System.out.println(nm + " is a sneaky thief!");
      Random stat = new Random();
      int hlth = 200 + stat.nextInt(60);
      int mna = 175 + stat.nextInt(25);
      int str = 5 + stat.nextInt(1);
      int Int = 5 + stat.nextInt(4);
      int agi = 8 + stat.nextInt(3);
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
