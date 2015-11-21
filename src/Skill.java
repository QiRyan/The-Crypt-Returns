import java.util.*;
public class Skill {
   private String name;
   private int cost;
   private int cooldown;
   private int trueCooldown;

   public String getName() { 
      return name;}
   public int getCost() { 
      return cost;}
   public int getCooldown() { 
      return cooldown;}
   public int getTrueCooldown() { 
      return trueCooldown;}

   public Skill(String nm){
   name = nm;
   }
}
