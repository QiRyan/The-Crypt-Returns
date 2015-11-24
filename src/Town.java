import java.util.*;
public class Town{
   public static void main(String[] args) {
      boolean pause = true;
      ArrayList<GameObject> newSquad = new ArrayList<GameObject>();
      Skill skill1 = new Skill("power attack", 1);
      Skill skill2 = new Skill("Monk", 1);
      Skill skill3 = new Skill("Defender", 1);
      Hero num1 = new Warrior("Isience", skill1, skill2, skill3);
      Hero num2 = new Warrior("BardyGaurd", skill1, skill2, skill3);
      Hero num3 = new Warrior("Onioncart", skill1, skill2, skill3);
      Hero num4 = new Warrior("Shiinji", skill1, skill2, skill3);
      newSquad.add(num1);
      newSquad.add(num2);
      newSquad.add(num3);
      newSquad.add(num4);
      Party Heros = new Party(newSquad);
      Scanner input = new Scanner(System.in);
      Item sp1 = new Item("Odd Trinket");
      Item sp2 = new Item("Bread");
      Item sp3 = new Item("Treasure Key");
      ArrayList<Item> shopCatalog = new ArrayList<Item>();
      shopCatalog.add(sp1);
      shopCatalog.add(sp2);
      shopCatalog.add(sp3);
      do{
         Art.drawTown();
         System.out.println("You are in the town with " + Heros.getGold() + " gold. Where would you like to go?");
         String townInput = input.nextLine();
         if (townInput.equalsIgnoreCase("?")) {
            System.out.println("Shop: Buy consumables and sell items.");
            System.out.println("Armory: Buy equips, both armor and weapons.");
            System.out.println("Library: Ask questions and have a chance of getting answers.");
            System.out.println("Temple: Interact with the gods of the relm.");
            System.out.println("Inventory: Acess your inventory and manage your heros.");
            System.out.println("Quit: Leave for the Crypt.");
         }
         if (townInput.equalsIgnoreCase("Inventory")) {
            Heros.printInventory();
         }
      
         if (townInput.equalsIgnoreCase("Shop")) {
            boolean shopPause = true;
            do{
               Art.drawShopSign();
               System.out.println("Anything I can do for you?");
               String shopInput = input.nextLine();
               if (shopInput.equalsIgnoreCase("?")) {
                  System.out.println("Buy: bring up the menu to purchase items.");
                  System.out.println("Sell: Bring up your inventory to sell items.");
                  System.out.println("Quit: Leave the shop.");
               }
               if (shopInput.equalsIgnoreCase("Sell")) {
                  do {
                     System.out.println("What are you selling? I'll give a fair price.");
                     String sellInput = input.nextLine();
                     if (sellInput.equalsIgnoreCase("quit")) {
                        shopPause = false;
                     } 
                     else
                        if (sellInput.equalsIgnoreCase("?")) {
                           System.out.println("Inventory: prints out your inventory and at what amount each item will sell for.");
                           System.out.println("Quit: Leave the sell menu.");
                           System.out.println("Sell Items by typing in their name and if you want, the number you are selling.");
                           System.out.println("Ex: \"MyThing x 14\" or just \"MyThing\" if you only want to sell one");
                        } 
                        else if (sellInput.equalsIgnoreCase("Inventory")) {
                           Heros.printInventoryPrices();
                        } 
                        else {
                           int quantity = 1;
                           Item interest = new Item("");
                           if (sellInput.indexOf(" x ") > 0) {
                              String[] split = sellInput.split(" x ");
                              sellInput = split[0];
                              quantity = Integer.parseInt(split[1]);} 
                              else {
                              interest = new Item(sellInput);
                              }
                              
                           
                           if (Heros.check(interest)) {
                              if (Heros.getItemQuantity(interest) < quantity) {
                                 System.out.println("You appear to be attempting to sell more of those than you have.");
                              }
                              else {
                                 Heros.modGold(interest.getValue() * quantity);
                              
                                 System.out.print("You successfully sold " + quantity + " " + interest.getName());
                                 if (quantity > 1) {
                                    System.out.println("s.");
                                 } 
                                 else {
                                    System.out.println(".");
                                 }
                              }
                           } 
                           else {
                              System.out.println("You don't appear to have an item under that name.");
                           }
                        }
                  
                  } while (shopPause);
                  shopPause = true;
               }
               if (shopInput.equalsIgnoreCase("Buy")) {
                  do {
                     System.out.println("What can I get for you?");
                     String buyInput = input.nextLine();
                     
                     if (buyInput.equalsIgnoreCase("quit")) {
                        shopPause = false;
                     } 
                     else
                        if (buyInput.equalsIgnoreCase("?")) {
                           System.out.println("Catalog: bring up of a list of items avalible to purchase.");
                           System.out.println("Quit: Leave the buy menu.");
                           System.out.println("Buy items by typing in their name or catalog number, if you would like to purchas many, add an x then the desired number of it.");
                           System.out.println("Ex: \"Product x 14\" or just \"Product\" if you only want one");
                        } 
                        else if (buyInput.equalsIgnoreCase("Catalog")) {
                           for (int g = 0; g < shopCatalog.size(); g++) {
                              System.out.println(shopCatalog.get(g).getName() + " for " + shopCatalog.get(g).getCost());
                           }
                        } 
                        else {
                           int quantity = 1;
                           Item interest = new Item("");
                           if (buyInput.indexOf(" x ") > 0) {
                              String[] split = new String[2];
                              split = buyInput.split(" x ");
                              buyInput = split[0];
                              quantity = Integer.parseInt(split[1]);
                           } 
                           int f = 0;
                           for (f = 0; f < shopCatalog.size();) {
                              if (shopCatalog.get(f).getName().equalsIgnoreCase(buyInput)) {
                                 interest = new Item(buyInput);
                                 f = shopCatalog.size() + 1;
                              } 
                              else {
                                 f++;
                              }
                           }
                           if (f == shopCatalog.size()) {
                              System.out.println("We can't find that item, perhaps another one?");
                           } 
                           else {
                              if ((interest.getCost()*quantity) > Heros.getGold()) {
                                 System.out.println("You don't have enough money for that purchase.");
                              }
                              else {
                                 Heros.modGold(-(interest.getCost()*quantity));
                                 Heros.addItem(interest, quantity);
                                 System.out.print("You successfully purchased " + quantity + " " + interest.getName());
                                 if (quantity > 1) {
                                    System.out.println("s.");
                                 } 
                                 else {
                                    System.out.println(".");
                                 }
                              }
                           }
                        }
                  
                  } while (shopPause);
                  shopPause = true;
               }
               if (shopInput.equalsIgnoreCase("Quit")) {
                  shopPause = false;
                  System.out.println("Have a nice day!");
               }
            
            } 
            while (shopPause); 
         }
        
      } while (pause);
      System.out.println("Town has ended");
   }
}
