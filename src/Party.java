import java.util.*;
public class Party {

   protected List<GameObject> party;
   protected int gold;
   protected Map<String, Integer> inventory;
   protected ArrayList<String> blessings;

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
}
