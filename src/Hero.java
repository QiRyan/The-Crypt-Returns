import java.util.*;
public class Hero extends GameObject{
   protected String heroClass;
   protected Set<Skill> skills;
   
   protected String weapon;
   protected String head;
   protected String body;
   protected String feet;
   
   public String getHeroClass() { 
      return heroClass;}
      
   public Hero(String na, String cls, Skill skill1, Skill skill2, Skill skill3) {
      super(na);
      skills = new TreeSet<Skill>();
      skills.add(skill1);
      skills.add(skill2);
      skills.add(skill3);
      
      heroClass = cls;
      level = 1;
      exp = 0;
      
      life = true;
   }
   
   public void useSkill(String skillName)
   {
      System.out.println("We haven't implemented skills yet");
//       if(skills.contains(skillName))
//       {
//          
//       }
   }   
}
