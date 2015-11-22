import java.util.*;

//GameObject - player, NPC, monsters, etc
//Contins stats
public class GameObject
{
   protected String name;
   protected int level;
   protected int exp;
   
   protected int attack;
   protected int defense;
   
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
   
   public String getName() { 
      return name;}
   public int getLevel() { 
      return level;}
   public int getExp(){
      return exp;}
      
//    public int getAttack() {
//       return attack;}  
//    public int getDefense() {
//       return defense;}
      
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
   public boolean isAlive(){
      return life;} 
   
   public GameObject(String name)
   {
      this.name = name;
   }
   
   public GameObject(String name, int level, int exp, int trueStrength, int trueAgility, int trueIntelligence, int trueHealth, int trueMana)
   {
      this.name = name;
      this.level = level;
      this.exp = exp;
      
      this.trueStrength = trueStrength;
      this.strength = trueStrength;
      
      this.trueAgility = trueAgility;
      this.agility = trueAgility;
      
      this.trueIntelligence = trueIntelligence;
      this.intelligence = intelligence;
      
      this.trueHealth = trueHealth;
      this.health = trueHealth;
      this.trueMana = mana;
      this.mana = trueMana;
      
      this.life = true;
   }
   
   public void takeDamage(int damage)
   {
      this.health -= damage; 
      if(this.health < 0)
      {
         this.health = 0;
         life = false;
      }
   }
   
   public void recoverHealth(int health)
   {
      if(life)
      {
         this.health += health;
         if(this.health >= trueHealth)
         {
            this.health = trueHealth;
         }
      }      
   }
   
   public void consumeMana(int mana)
   {
      if(this.mana - mana >= 0)
      {
         this.mana -= mana;
      }
   //       else
   //       {
   //          System.out.println(this.name + " does not have enough mana!");
   //       }
   }
   
   public void restoreMana(int mana)
   {
      this.mana += mana;
      if(this.mana > trueMana)
      {
         this.mana = trueMana;
      }
   }
   
   public void resetStats()
   {
      this.strength = trueStrength;
      this.agility = trueAgility;
      this.intelligence = trueIntelligence;
   }
   
//    public void atkModify(int value)
//    {
//       this.strength += value;
//    }
//    
//    public void atkModify(double ratio)
//    {
//       this.strength *= ratio;
//    }
//    
//    public void defModify(int value)
//    {
//       this.defense += value;
//    }
//    
//    public void defModify(double ratio)
//    {
//       this.defense *= ratio;
//    }
   
   public void strengthModify(int value)
   {
      this.strength += value;
   }
   public void strengthModify(double ratio)
   {
      this.strength *= ratio;
   }
   
   public void agilityModify(int value)
   {
      this.agility += value;
   }
   public void agilityModify(double ratio)
   {
      this.agility *= ratio;
   }
   
   public void intelligenceModify(int value)
   {
      this.intelligence += value;
   }
   public void intelligenceModify(double ratio)
   {
      this.intelligence *= ratio;
   }
}
