import java.util.*;
public class Hero{
   protected String name;
   protected String heroClass;
   protected int level;
   protected int exp;
   protected int strength;
   protected int agility;
   protected int intelligence;
   protected int health;
   protected int mana;
   protected int trueStrength;
   protected int trueAgility;
   protected int trueIntelligence;
   protected int trueHealth;
   protected int trueMana;
   protected boolean life;
   
   protected ArrayList<Skill> skills;
   protected Item weapon;
   protected Item head;
   protected Item body;
   protected Item feet;
   
   public String getName() { 
      return name;}
   public String getHeroClass() { 
      return heroClass;}
   public int getLevel() { 
      return level;}
   public int getStrength() { 
      return strength;}
   public int getAgility() { 
      return agility;}
   public int getIntelligence() { 
      return intelligence;}
   public int getTrueStrength() { 
      return trueStrength;}
   public int getTrueAgility() { 
      return trueAgility;}
   public int getTrueIntelligence() { 
      return trueIntelligence;}
   public int getHealth() { 
      return health;}
   public int getMana() { 
      return mana;}
   public int getTrueHealth() { 
      return trueHealth;}
   public int getTrueMana() { 
      return trueMana;}
      
   public void Hero() {
   }
      
   public Hero(String na, String cls, Skill skill1, Skill skill2, Skill skill3) {
      skills = new ArrayList<Skill>();
      skills.add(skill1);
      skills.add(skill2);
      skills.add(skill3);
      name = na;
      heroClass = cls;
      level = 1;
      exp = 0;
      life = true;
      
   }
   
   
}
