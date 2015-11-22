import java.util.*;
public class Warrior extends Hero implements Player
{
   public Warrior (String nm, Skill skl1, Skill skl2, Skill skl3) {
      super (nm, "warrior", skl1, skl2, skl3);
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
   }
   
   public int attack(int bonus, double multiply)
   {
      return (int)(multiply * (this.strength + bonus));
   }
   
   public void levelUp()
   {
      this.level += 1;
   }
}