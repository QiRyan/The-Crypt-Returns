import java.util.*;

//Party creation, party printing, party life status
public class Party 
{
   protected List<GameObject> party;
   protected int gold;
   protected Map<Item, Integer> inventory;
   protected List<String> blessings;
   
      
   public Party(List<GameObject> team) {
      this.party = new ArrayList<GameObject>();
      for(GameObject being : team)
      {
         party.add(being);
      }
      this.gold = 500;
      this.inventory = new TreeMap<Item, Integer>();
      this.blessings = new ArrayList<String>();
   }
   
   public List<GameObject> getParty(){
      return this.party;}
   
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
   
   public void printInventory() {
      System.out.println(Arrays.toString(inventory.entrySet().toArray()));
   }
   
   public void printInventoryPrices() {
   if (inventory.size() > 0){
   String Inven = Arrays.toString(inventory.entrySet().toArray()).substring(1, Arrays.toString(inventory.entrySet().toArray()).length() - 1);
   String[] split = new String[inventory.size()];
   split = Inven.split(", ");
   for (int g = 0; g < inventory.size(); g++) {
   String[] divide = new String[2];
   divide = split[g].split("=");
   Item subject = new Item(divide[0]);
   System.out.println(divide[0] + " X " + divide[1] + " priced at " + subject.getValue() + " gold each.");
   }
   } else {
   System.out.println("You have nothing, good day sir.");
   }
   }
   
   public int getGold() { 
      return gold;}
      
   public void modGold(int value) { 
      gold = gold + value;}
      
   public void addItem(Item granted, int quantity) {
      if (inventory.containsKey(granted)) {
         inventory.put(granted, inventory.get(granted) + quantity);
      } 
      else {
         inventory.put(granted, quantity);}
   }
   
   public void removeItem(Item granted, int quantity) {
      if (inventory.get(granted) > quantity) {
         inventory.put(granted, inventory.get(granted) - quantity);
      } 
      else {
         inventory.remove(granted);}
   }
   
   public int getItemQuantity(Item granted) {
      return inventory.get(granted);

   }
   
   public boolean check(Item request) {
      return inventory.containsKey(request);}
}
