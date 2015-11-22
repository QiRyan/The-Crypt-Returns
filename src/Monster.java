import java.util.*;
public class Monster extends GameObject
{
   protected List<Skill> skills;
   
   public Monster(String name, int level, int exp, int trueStrength, int trueAgility, int trueIntelligence, int trueHealth, int trueMana)
   {
      super(name, level, exp, trueStrength, trueAgility, trueIntelligence, trueHealth, trueMana);
      
      decisions = new ArrayList<String>();
      this.decisions.add("Attack");
      this.decisions.add("Defend");
      this.decisions.add("Skill");
   }
   
   public Monster clone()
   {
      return new Monster(this.name, this.level, this.exp, this.trueStrength, this.trueAgility, this.trueIntelligence, this.trueHealth, this.trueMana);
   }
}