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
      } 
      else {
         System.out.println("You have nothing, good day sir.");
      }
   }
   
   public void printInventoryEnhance() {
      if (inventory.size() > 0){
         String Inven = Arrays.toString(inventory.entrySet().toArray()).substring(1, Arrays.toString(inventory.entrySet().toArray()).length() - 1);
         String[] split = new String[inventory.size()];
         split = Inven.split(", ");
         for (int g = 0; g < inventory.size(); g++) {
            String[] divide = new String[2];
            divide = split[g].split("=");
            Item subject = new Item(divide[0]);
            System.out.println(divide[0] + " X " + divide[1]);
         }
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
      
   public void printHeroNames() {
      System.out.println("Names: " + "  " + party.get(0).getName() + "  " + party.get(1).getName() + "  " + party.get(2).getName() + "  " + party.get(3).getName());
   }
      
   public void printFullEquips() {
      System.out.println("Weapon: "  + "  " + ((Hero)party.get(0)).getWeapon().getName()  + "  " + ((Hero)party.get(1)).getWeapon().getName()  + "  " + ((Hero)party.get(2)).getWeapon().getName()  + "  " + ((Hero)party.get(3)).getWeapon().getName());
      System.out.println("Head: "  + "  " + ((Hero)party.get(0)).getHead().getName()  + "  " + ((Hero)party.get(1)).getHead().getName()  + "  " + ((Hero)party.get(2)).getHead().getName()  + "  " + ((Hero)party.get(3)).getHead().getName());
      System.out.println("Body: "  + "  " + ((Hero)party.get(0)).getBody().getName()  + "  " + ((Hero)party.get(1)).getBody().getName()  + "  " + ((Hero)party.get(2)).getBody().getName()  + "  " + ((Hero)party.get(3)).getBody().getName());
      System.out.println("Feet: "  + "  " + ((Hero)party.get(0)).getFeet().getName()  + "  " + ((Hero)party.get(1)).getFeet().getName()  + "  " + ((Hero)party.get(2)).getFeet().getName()  + "  " + ((Hero)party.get(3)).getFeet().getName());
   }
      
   public void printTrueStatCheckup() {
      System.out.println("Health: "  + "  " + party.get(0).getTrueHealth()  + "  " + party.get(1).getTrueHealth()  + "  " + party.get(2).getTrueHealth()  + "  " + party.get(3).getTrueHealth());
      System.out.println("Mana: "  + "  " + party.get(0).getTrueMana()  + "  " + party.get(1).getTrueMana()  + "  " + party.get(2).getTrueMana()  + "  " + party.get(3).getTrueMana());
      System.out.println("Strength: "  + "  " + party.get(0).getTrueStrength()  + "  " + party.get(1).getTrueStrength()  + "  " + party.get(2).getTrueStrength()  + "  " + party.get(3).getTrueStrength());
      System.out.println("Intelligence: "  + "  " + party.get(0).getTrueIntelligence()  + "  " + party.get(1).getTrueIntelligence()  + "  " + party.get(2).getTrueIntelligence()  + "  " + party.get(3).getTrueIntelligence());
      System.out.println("Agility: "  + "  " + party.get(0).getTrueAgility()  + "  " + party.get(1).getTrueAgility()  + "  " + party.get(2).getTrueAgility()  + "  " + party.get(3).getTrueAgility());
   }
      
   public void printTrueStatCheckupResources() {
      System.out.println("Health: "  + "  " + party.get(0).getTrueHealth() + "/" + party.get(0).getHealth() + "  " + party.get(1).getTrueHealth() + "/" + party.get(1).getHealth() + "  " + party.get(2).getTrueHealth() + "/" + party.get(2).getHealth() + "  " + party.get(3).getTrueHealth() + "/" + party.get(3).getHealth());
      System.out.println("Mana: "  + "  " + party.get(0).getTrueMana() + "/" + party.get(0).getMana() + "  " + party.get(1).getTrueMana() + "/" + party.get(1).getMana() + "  " + party.get(2).getTrueMana() + "/" + party.get(2).getMana() + "  " + party.get(3).getTrueMana() + "/" + party.get(3).getMana());
   }
}
