import java.util.*;

//Party creation, party printing, party life status
public class Party 
{
   protected List<GameObject> party;
   protected int gold;
   protected Map<String, Integer> inventory;
   protected List<String> blessings;
      
   public Party(List<GameObject> team, int gold) {
      this.party = new ArrayList<GameObject>();
      for(GameObject being : team)
      {
         party.add(being);
      }
      this.gold = gold;
      this.inventory = new TreeMap<String, Integer>();
      this.blessings = new ArrayList<String>();
   }
   
   public List<GameObject> getParty(){return this.party;}
   
   public void printParty()
   {
      Stack<String> s = new Stack<String>();
      for(GameObject thing : this.party)
      {
         s.push(thing.getName());
      }
      System.out.println(s);
   }
   
   public boolean isAlive()
   {
      for(GameObject thing : this.party)
      {
         if(thing.isAlive())
         {
            return true;
         }
      }
      return false;
   }
   
   public void attackedHero(int index, int damage)
   {
      this.party.get(index).takeDamage(damage);
   }
}