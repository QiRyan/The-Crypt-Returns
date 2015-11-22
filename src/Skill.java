import java.util.*;
public class Skill implements Comparable<Skill>{
   private String name;
   private int cost;
   private int cooldown;
   private int trueCooldown;
   private int skillTier;

   public String getName() { 
      return name;}
   public int getCost() { 
      return cost;}
   public int getCooldown() { 
      return cooldown;}
   public int getTrueCooldown() { 
      return trueCooldown;}

   public Skill(String nm, int tier){
      this.name = nm;
      this.skillTier = tier;
   }
   
   public int compareTo(Skill other)
   {
      return this.skillTier - other.skillTier;
   }
}