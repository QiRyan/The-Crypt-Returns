import java.util.*;
public class Battle
{
   private List<GameObject> enemyOrder;
   private Queue<GameObject> teamOrder;
   
   private Party heroParty;
   private Party monsterEncounter;
   
   private int heroMaxTurns;
   private int monsterMaxTurns;
   
//    private boolean battleOver;
   
   public Battle(Party hero, Party encounter)
   {
      this.heroParty = hero;
      this.monsterEncounter = encounter;
      teamOrder = new LinkedList<GameObject>();
      enemyOrder = new LinkedList<GameObject>();
      
      for(GameObject member : heroParty.getParty())
      {
         teamOrder.add(member);
      }
      for(GameObject monster : monsterEncounter.getParty())
      {
         enemyOrder.add(monster);
      }
      
      heroMaxTurns = heroParty.getParty().size();
      monsterMaxTurns = monsterEncounter.getParty().size();
   }
   
   public void battle(Scanner input)
   {
      Random decision = new Random();
      
      int heroTurns = 0;
      int monsterTurns = 0;
      
      while(!isBattleOver())
      {
         if(heroTurns < heroMaxTurns)
         {
            heroParty.printBattleStats(); 
            monsterEncounter.printBattleStats();
            GameObject current = teamOrder.remove();            
            if(current.isAlive())
            {
               System.out.println("What should " + current.getName() + " do?");
               System.out.println(">Attack >Defend >Skill");
               String command = input.nextLine();
               while(!(command.equalsIgnoreCase("Attack") || command.equalsIgnoreCase("Defend") ||  command.equalsIgnoreCase("Skill")))
               {
                  System.out.println("Invalid command, please retry");
                  command = input.nextLine();
               } 
               if(command.equalsIgnoreCase("Attack"))
               {
                     System.out.println("Select a target");
                     int target = findMonster(input.nextLine().toUpperCase());
                     while(target == -1)
                     {
                        System.out.println("Invalid target");
                        target = findMonster(input.nextLine().toUpperCase());
                     }
                     if(monsterEncounter.getParty().get(target).isAlive())
                     {
                        System.out.println(current.getName() + " hits at " + monsterEncounter.getParty().get(target).getName() + " for " + current.basicAttack() + " damage!");
                        monsterEncounter.isAttacked(target, current.basicAttack());
                     }
                     else
                     {
                        System.out.println(current.name + " slaps at " + monsterEncounter.getNames().get(target) + "'s dead corpse, but it does nothing");
                     }
                     
               }
               else if(command.equalsIgnoreCase("Defend"))
               {
                  System.out.println(current.getName() + " readies for an incoming attack");   
               }                             
               else if(command.equalsIgnoreCase("Skill"))
               {
                  current.useSkill(0);
               }
            }
            else
            {
               System.out.println();
               System.out.println(current.getName() + " is lying on the floor doing nothing...");  
            }
            
            System.out.println();
            teamOrder.add(current);
            heroTurns++;
            monsterTurns = 0;
         }
         
         ////////
         else if(monsterTurns < monsterMaxTurns)
         {
            GameObject current = enemyOrder.remove(0);
            if(current.isAlive())
            {
               current.printStats();
               switch(current.getDecisions().get(decision.nextInt(current.getDecisions().size())))
               {
                  case "Attack": int target = findRandomHeroTarget(decision.nextInt(heroParty.getParty().size()));
                     System.out.println(current.getName() + " hits at " + heroParty.getParty().get(target).getName() + " for " + current.basicAttack() + " damage!");
                     heroParty.isAttacked(target, current.basicAttack());
                     break;
                  case "Defend": current.defend();
                     break;
                  case "Skill": current.useSkill(0);
                     break; 
               }
               System.out.println();
            }
            else
            {
               System.out.println(current.getName() + " looks pretty dead to me");
            }
            
            enemyOrder.add(current);
            monsterTurns++;
            if(monsterTurns == monsterMaxTurns)
            {
               heroTurns = 0;
            }
         }
      }
      System.out.println("And the battle ends, because that's all we got");
   }
   
   public boolean isBattleOver()
   {
      if(heroParty.isAlive())
      {
         return false;
      }
      return true;
   }
   
   public int findRandomHeroTarget(int index)
   {
      if(index >= heroParty.getParty().size())
      {
         return findRandomHeroTarget(0);
      }
      else if(heroParty.getParty().get(index).isAlive())
      {
         return index;
      }
      else
      {
         return findRandomHeroTarget(index + 1);
      }
   }
   
   public int findMonster(String name)
   {
      int nameIndex = monsterEncounter.getNames().indexOf(name);
      return nameIndex;
   }
}
