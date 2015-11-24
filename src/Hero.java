import java.util.*;
public class Hero extends GameObject{
      
   protected String heroClass;
      
   protected Item weapon;
   protected Item head;
   protected Item body;
   protected Item feet;
   
   public Item getWeapon() {
   return weapon;
   }
   public Item getHead() {
   return head;
   }
   public Item getBody() {
   return body;
   }
   public Item getFeet() {
   return feet;
   }
   
   
   public String getHeroClass() { 
      return heroClass;}
      
   public Hero(String na, String cls, Skill skill1, Skill skill2, Skill skill3) {
      super(na);
      skills = new ArrayList<Skill>();
      skills.add(skill1);
      skills.add(skill2);
      skills.add(skill3);
      Item nothing = new Item("");
      weapon = head = body = feet = nothing;
      heroClass = cls;
      level = 1;
      exp = 0;
      
      life = true;
   }
   
   public Item equipItem(Item given){
      Item holder = new Item("");
      if (trueStrength < given.getStrMin()) {
         System.out.println(name + " doesn't have enough strength to equip " + given.getName() + ". " + given.getStrMin() + " strength is required, " + name + " only has " + trueStrength + ".");
         System.out.println("They are the human noodle after all.");
      }
      if (trueIntelligence < given.getIntMin()) {
         System.out.println(name + " doesn't have enough intelligence to equip " + given.getName() + ". " + given.getIntMin() + " intelligence is required, " + name + " only has " + trueIntelligence + ".");
         if (given.getType().equalsIgnoreCase("weapon")) {
            System.out.println("Do you really think they could figure out which end points twords the bad guys?");}
         else {
            System.out.println("They can't even find where on thier body they are supposed to put it.");
         }
      }
      if (trueAgility < given.getAgiMin()) {
         System.out.println(name + " doesn't have enough agility to equip " + given.getName() + ". " + given.getAgiMin() + " agility is required, " + name + " only has " + trueAgility + ".");
         System.out.println("They would probably find a way to drop it and kill themselves with it.");
      }
      if (given.getType().equalsIgnoreCase("feet")){
         holder = feet;
         feet = given;
         return holder;
      }
      if (given.getType().equalsIgnoreCase("body")){
         holder = body;
         body = given;
         return holder;
      }
      if (given.getType().equalsIgnoreCase("head")){
         holder = head;
         head = given;
         return holder;
      }
      if (given.getType().equalsIgnoreCase("weapon")){
         holder = weapon;
         weapon = given;
         return holder;
      }
      System.out.println("Somthing went wrong with the equip process, please submit a support ticket to Mercer Court Masters");
      return holder;
   }
   
   
   public void useSkill(String skillName)
   {
      System.out.println("We haven't implemented skills yet");
   //       if(skills.contains(skillName))
   //       {
   //          
   //       }
   }
   
   public int basicAttack()
   {
      int damage = 0;
      if (weapon.getType().equalsIgnoreCase("nothing")) {
         return trueStrength;
      } 
      else {
         damage = weapon.getPower() + (int)Math.round(head.getStrScale()*strength) + (int)Math.round(head.getIntScale()*intelligence) + (int)Math.round(head.getAgiScale()*agility);
      return damage;
      }
   }
   
   public int getArmor(){
   int armor = 0;
   armor = armor + head.getPower() + (int)Math.round(head.getStrScale()*strength) + (int)Math.round(head.getIntScale()*intelligence) + (int)Math.round(head.getAgiScale()*agility);
   armor = armor + body.getPower() + (int)Math.round(body.getStrScale()*strength) + (int)Math.round(body.getIntScale()*intelligence) + (int)Math.round(body.getAgiScale()*agility);
   armor = armor + feet.getPower() + (int)Math.round(feet.getStrScale()*strength) + (int)Math.round(feet.getIntScale()*intelligence) + (int)Math.round(feet.getAgiScale()*agility);
   return armor;
   }
}
