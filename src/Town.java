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
      ArrayList<Item> weaponCatalog = new ArrayList<Item>();
      weaponCatalog.add(new Item("sword"));
      weaponCatalog.add(new Item("wand"));
      weaponCatalog.add(new Item("Razor"));
      weaponCatalog.add(new Item("shiv"));
      ArrayList<Item> headCatalog = new ArrayList<Item>();
      headCatalog.add(new Item("Iron Helmet"));
      headCatalog.add(new Item("Head Band"));
      headCatalog.add(new Item("Mortarboard"));
      headCatalog.add(new Item("Bandana"));
      ArrayList<Item> bodyCatalog = new ArrayList<Item>();
      bodyCatalog.add(new Item("leather vest"));
      bodyCatalog.add(new Item("novice Robes"));
      bodyCatalog.add(new Item("hunter's hoodie"));
      bodyCatalog.add(new Item("rusted chainmail"));
      ArrayList<Item> feetCatalog = new ArrayList<Item>();
      feetCatalog.add(new Item("Boots"));
      feetCatalog.add(new Item("Flip-flops"));
      feetCatalog.add(new Item("sneakers"));
      feetCatalog.add(new Item("pointy shoes"));
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
         if (townInput.equalsIgnoreCase("Armory")) {
            boolean armoryPause = true;
            do {
               Art.drawArmorySign();
               System.out.println("Blacksmith: \"BROTHAAAAAAAAA! What type o' equip ya lookin fer?\"");
               String armoryInput = input.nextLine();
               if (armoryInput.equalsIgnoreCase("?")) {
                  System.out.println("Weapons: You need a weapon? Right this way.");
                  System.out.println("Head: go browse the various headgear to find the hat that will define your look.");
                  System.out.println("Body: head over to the mannequins and select what atire you wish to enter battle with");
                  System.out.println("Feet: peruse the shoe aisle and get somthing that really shouldn't effect your stats but does.");
                  System.out.println("Quit: Leave the armory for the town.");
               }
               if (armoryInput.equalsIgnoreCase("quit")) {
                  System.out.println("Blacksmith: \"See ya round frugal fellas!\"");
                  armoryPause = false;
               }
               if (armoryInput.equalsIgnoreCase("Weapons") || armoryInput.equalsIgnoreCase("weapon")) {
                  System.out.println("Blacksmith: \"Right this way mates, we got the sharpest swords in all of this place.\"");
                  Art.drawSword();
                  for (int g = 0; g < weaponCatalog.size(); g++) {
                     System.out.println(weaponCatalog.get(g).getName() + " for " + weaponCatalog.get(g).getCost());
                  }
                  do {
                     System.out.println("Blacksmith: \"Which weapon tickles ya fancy?\"");
                     String weaponInput = input.nextLine();
                     if (weaponInput.equalsIgnoreCase("?")) {
                        System.out.println("Catalog: List the weapon items you can buy.");
                        System.out.println("Quit: Leave the weapongear aisle.");
                        System.out.println("Type in the name of the item you would like to buy. Unlike the shop, quantity is not an issue.");
                     }  
                     else
                        if (weaponInput.equalsIgnoreCase("Catalog")) {
                           for (int g = 0; g < weaponCatalog.size(); g++) {
                              System.out.println(weaponCatalog.get(g).getName() + " for " + weaponCatalog.get(g).getCost());
                           }
                        } 
                        else
                           if (weaponInput.equalsIgnoreCase("Quit")) {
                              armoryPause = false;
                           } 
                           else {
                              if (containsItem(weaponCatalog, new Item(weaponInput))) {
                                 Item interest = new Item (weaponInput);
                                 if (interest.getCost() > Heros.getGold()) {
                                    System.out.println("Blacksmith: \"Yer shy a few shllings lad.\"");
                                 } 
                                 else {
                                    Heros.modGold(-interest.getCost());
                                    Heros.addItem(interest, 1);
                                    System.out.println("You have purchased a " + interest.getName() + " for its cost of " + interest.getCost() + ".");
                                 }
                              } 
                              else {
                                 System.out.println("Blacksmith: \"Don't hav' that here, perhaps sothing diffrent?\"");
                              }
                           }
                  } while (armoryPause);
                  armoryPause = true;
               }
               
               if (armoryInput.equalsIgnoreCase("head") || armoryInput.equalsIgnoreCase("hat") || armoryInput.equalsIgnoreCase("hats")) {
                  System.out.println("Blacksmith: \"We be selling the whole backpack for pure... gold.\"");
                  Art.drawHelmet();
                  for (int g = 0; g < headCatalog.size(); g++) {
                     System.out.println(headCatalog.get(g).getName() + " for " + headCatalog.get(g).getCost());
                  }
                  do {
                     System.out.println("Blacksmith: \"Which piece o' headgear catches yer eye?\"");
                     String headInput = input.nextLine();
                     if (headInput.equalsIgnoreCase("?")) {
                        System.out.println("Catalog: List the head items you can buy.");
                        System.out.println("Quit: Leave the headgear aisle.");
                        System.out.println("Type in the name of the item you would like to buy. Unlike the shop, quantity is not an issue.");
                     }  
                     else
                        if (containsItem(headCatalog, new Item(headInput))) {
                           for (int g = 0; g < headCatalog.size(); g++) {
                              System.out.println(headCatalog.get(g).getName() + " for " + headCatalog.get(g).getCost());
                           }
                        } 
                        else
                           if (headInput.equalsIgnoreCase("Quit")) {
                              armoryPause = false;
                           } 
                           else {
                              if (headCatalog.contains(new Item(headInput))) {
                                 Item interest = new Item (headInput);
                                 if (interest.getCost() > Heros.getGold()) {
                                    System.out.println("Blacksmith: \"Yer shy a few shllings lad.\"");
                                 } 
                                 else {
                                    Heros.modGold(-interest.getCost());
                                    Heros.addItem(interest, 1);
                                    System.out.println("You have purchased a " + interest.getName() + " for its cost of " + interest.getCost() + ".");
                                 }
                              } 
                              else {
                                 System.out.println("Blacksmith: \"Don't hav' that here, perhaps sothing diffrent?\"");
                              }
                           }
                  } while (armoryPause);
                  armoryPause = true;
               }
               
               if (armoryInput.equalsIgnoreCase("body") || armoryInput.equalsIgnoreCase("armor")) {
                  System.out.println("Blacksmith: \"Ye'll be needin' a second hide t'keep yer first one in-tact!\"");
                  Art.drawArmor();
                  for (int g = 0; g < bodyCatalog.size(); g++) {
                     System.out.println(bodyCatalog.get(g).getName() + " for " + bodyCatalog.get(g).getCost());
                  }
                  do {
                     System.out.println("Blacksmith: \"Which o' my pieces of art would ya like?\"");
                     String bodyInput = input.nextLine();
                     if (bodyInput.equalsIgnoreCase("?")) {
                        System.out.println("Catalog: List the body items you can buy.");
                        System.out.println("Quit: Leave the bodygear aisle.");
                        System.out.println("Type in the name of the item you would like to buy. Unlike the shop, quantity is not an issue.");
                     }  
                     else
                        if (bodyInput.equalsIgnoreCase("Catalog")) {
                           for (int g = 0; g < bodyCatalog.size(); g++) {
                              System.out.println(bodyCatalog.get(g).getName() + " for " + bodyCatalog.get(g).getCost());
                           }
                        } 
                        else
                           if (bodyInput.equalsIgnoreCase("Quit")) {
                              armoryPause = false;
                           } 
                           else {
                              if (containsItem(bodyCatalog, new Item(bodyInput))) {
                                 Item interest = new Item (bodyInput);
                                 if (interest.getCost() > Heros.getGold()) {
                                    System.out.println("Blacksmith: \"Yer shy a few shllings lad.\"");
                                 } 
                                 else {
                                    Heros.modGold(-interest.getCost());
                                    Heros.addItem(interest, 1);
                                    System.out.println("You have purchased a " + interest.getName() + " for its cost of " + interest.getCost() + ".");
                                 }
                              } 
                              else {
                                 System.out.println("Blacksmith: \"Don't hav' that here, perhaps sothing diffrent?\"");
                              }
                           }
                  } while (armoryPause);
                  armoryPause = true;
               }
               
               if (armoryInput.equalsIgnoreCase("feet") || armoryInput.equalsIgnoreCase("shoes") || armoryInput.equalsIgnoreCase("boots")) {
                  System.out.println("Blacksmith: \"Lookin' fer some kicks? We got the finest.\"");
                  Art.drawSword();
                  for (int g = 0; g < feetCatalog.size(); g++) {
                     System.out.println(feetCatalog.get(g).getName() + " for " + feetCatalog.get(g).getCost());
                  }
                  do {
                     System.out.println("Blacksmith: \"Which pair are gonna be touching my doorway today?\"");
                     String feetInput = input.nextLine();
                     if (feetInput.equalsIgnoreCase("?")) {
                        System.out.println("Catalog: List the feet items you can buy.");
                        System.out.println("Quit: Leave the feetgear aisle.");
                        System.out.println("Type in the name of the item you would like to buy. Unlike the shop, quantity is not an issue.");
                     }  
                     else
                        if (feetInput.equalsIgnoreCase("Catalog")) {
                           for (int g = 0; g < feetCatalog.size(); g++) {
                              System.out.println(feetCatalog.get(g).getName() + " for " + feetCatalog.get(g).getCost());
                           }
                        } 
                        else
                           if (feetInput.equalsIgnoreCase("Quit")) {
                              armoryPause = false;
                           } 
                           else {
                              if (containsItem(feetCatalog, new Item(feetInput))) {
                                 Item interest = new Item (feetInput);
                                 if (interest.getCost() > Heros.getGold()) {
                                    System.out.println("Blacksmith: \"Yer shy a few shllings lad.\"");
                                 } 
                                 else {
                                    Heros.modGold(-interest.getCost());
                                    Heros.addItem(interest, 1);
                                    System.out.println("You have purchased a " + interest.getName() + " for its cost of " + interest.getCost() + ".");
                                 }
                              } 
                              else {
                                 System.out.println("Blacksmith: \"Don't hav' that here, perhaps sothing diffrent?\"");
                              }
                           }
                  } while (armoryPause);
                  armoryPause = true;
               }
               
            } while (armoryPause);
         }
         if (townInput.equalsIgnoreCase("Inventory")) {
            boolean inventoryPause = true;
            Art.drawInventory();
            do {
               System.out.println("You have acessed your inventory, what would you like to do?");
               String inventoryInput = input.nextLine();
               if (inventoryInput.equalsIgnoreCase("Equips")) {
                  Heros.printHeroNames();
                  Heros.printFullEquips();
               }
               if (inventoryInput.equalsIgnoreCase("Stats")) {
                  Heros.printHeroNames();
                  Heros.printTrueStatCheckup();
               }
               if (inventoryInput.equalsIgnoreCase("Inventory")) {
                  Heros.printInventoryEnhance();
               }
               if (inventoryInput.equalsIgnoreCase("?")) {
                  System.out.println("Equips: see all of your heros and their equips in one orderly screen");
                  System.out.println("Stats: see all of your heros and their stats in one orderly screen");
                  System.out.println("Inventory: see your inventory in all its splendor");
                  System.out.println("Type in the name of a hero to get an in detail description of them, and the ability to tweak them");
                  System.out.println("Type in the name of an inventory item in order to use/equip it");
                  System.out.println("Quit: leave the inventory menu");
               }
               if (inventoryInput.equalsIgnoreCase("quit")) {
                  inventoryPause = false;
                  System.out.println("You have chosen to leave the inventory menu");
               }
            } while (inventoryPause);
         }
      
         if (townInput.equalsIgnoreCase("Shop")) {
            boolean shopPause = true;
            do{
               Art.drawShopSign();
               System.out.println("ShopKeep: \"Anything I can do for you?\"");
               String shopInput = input.nextLine();
               if (shopInput.equalsIgnoreCase("?")) {
                  System.out.println("Buy: bring up the menu to purchase items.");
                  System.out.println("Sell: Bring up your inventory to sell items.");
                  System.out.println("Quit: Leave the shop.");
               }
               if (shopInput.equalsIgnoreCase("Sell")) {
                  do {
                     System.out.println("ShopKeep: \"What are you selling? I'll give a fair price.\"");
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
                                 System.out.println("ShopKeep: \"You appear to be attempting to sell more of those than you have.\"");
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
                              System.out.println("ShopKeep: \"You don't appear to have an item under that name.\"");
                           }
                        }
                  
                  } while (shopPause);
                  shopPause = true;
               }
               if (shopInput.equalsIgnoreCase("Buy")) {
                  do {
                     System.out.println("ShopKeep: \"What can I get for you?\"");
                     String buyInput = input.nextLine();
                     
                     if (buyInput.equalsIgnoreCase("quit")) {
                        shopPause = false;
                     } 
                     else
                        if (buyInput.equalsIgnoreCase("?")) {
                           System.out.println("Catalog: bring up of a list of items avalible to purchase.");
                           System.out.println("Quit: Leave the buy menu.");
                           System.out.println("Buy items by typing in their name, if you would like to purchas many, add an x then the desired number of it.");
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
                              System.out.println("ShopKeep: \"We can't find that item, perhaps another one?\"");
                           } 
                           else {
                              if ((interest.getCost()*quantity) > Heros.getGold()) {
                                 System.out.println("ShopKeep: \"You don't have enough money for that purchase.\"");
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
                  System.out.println("ShopKeep: \"Have a nice day!\"");
               }
            
            } 
            while (shopPause); 
         }
        
      } while (pause);
      System.out.println("Town has ended");
   }
   
   public static boolean containsItem(ArrayList<Item> line, Item subject) {
      for (int i = 0; i < line.size(); i++) {
         if (line.get(i).getName().equalsIgnoreCase(subject.getName())) {
            return true;
         }
      }
      return false;
   }
}
