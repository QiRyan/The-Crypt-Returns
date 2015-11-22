import java.util.*;
public class Battle
{
   private Queue<GameObject> enemyOrder;
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
   
   public void battle()
   {
      Random decision = new Random();
      
      int heroTurns = 0;
      int monsterTurns = 0;
      
      while(!isBattleOver())
      {
         if(heroTurns < heroMaxTurns)
         {
            GameObject current = teamOrder.remove();            
            if(current.isAlive())
            {
               current.printStats();
               System.out.println(current.name + " stands stupidly as he waits for his turn to be implemented");
            }
            else
            {
               System.out.println();
               System.out.println(current.name + " is lying on the floor doing nothing");
              
            }
            System.out.println();
            teamOrder.add(current);
            heroTurns++;
            monsterTurns = 0;
         }
         else if(monsterTurns < monsterMaxTurns)
         {
            GameObject current = enemyOrder.remove();
            if(current.isAlive())
            {
               current.printStats();
               switch(current.getDecisions().get(decision.nextInt(current.getDecisions().size())))
               {
                  case "Attack": int target = findTarget(decision.nextInt(heroParty.getParty().size()));
                     heroParty.attackedHero(target, current.basicAttack());
                     System.out.println(current.name + " hits at " + heroParty.getParty().get(target).getName() + " for " + current.basicAttack() + " damage!");
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
               System.out.println("He looks pretty dead to me");
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
   
   public int findTarget(int index)
   {
      if(index >= heroParty.getParty().size())
      {
         return findTarget(0);
      }
      else if(heroParty.getParty().get(index).isAlive())
      {
         return index;
      }
      else
      {
         return findTarget(index + 1);
      }
   }
}