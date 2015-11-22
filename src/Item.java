import java.util.*;
public class Item {
   private String name;
   private String type;
   private String effect;
   private String description;
   private int cost;
   private int value;
   private int power;
   private double strScale;
   private double intScale;
   private double agiScale;
   private double dodgeMod;
   private double critMod;
   private int strMod;
   private int intMod;
   private int agiMod;
   private int strMin;
   private int intMin;
   private int agiMin;
   private boolean range;

   public String getName() {
      return name;}
   public String getType() {
      return type;}
   public String getEffect() {
      return effect;}
   public String getDescription() {
      return description;}
   public int getCost() {
      return cost;}
   public int getValue() {
      return value;}
   public int getPower() {
      return power;}
   public double getStrScale() {
      return strScale;}
   public double getIntScale() {
      return intScale;}
   public double getAgiScale() {
      return agiScale;}
   public double getDodgeMod() {
      return dodgeMod;}
   public double getCritMod() {
      return critMod;}
   public int getStrMod() {
      return strMod;}
   public int getIntMod() {
      return intMod;}
   public int getAgiMod() {
      return agiMod;}
   public int getStrMin() {
      return strMin;}
   public int getIntMin() {
      return intMin;}
   public int getAgiMin() {
      return agiMin;}
   public boolean getRange() {
      return range;}
      
      
   public void Search(String nm) {
      name = "Nothing";
      type = "Nothing";
      effect = "";
      cost = 0;
      value = 0;
      range = true;
      strMin = 0;
      intMin = 0;
      agiMin = 0;
      // WEAPONS
      if (nm.equalsIgnoreCase("sword")) {
         name = "sword";
         type = "weapon";
         cost = 100;
         value = 75;
         range = false;
         strMin = 3;
         intMin = 2;
         agiMin = 1;
         power = 25;
         agiScale = 0.1;
         strScale = 0.5;
      }
      if (nm.equalsIgnoreCase("wand")) {
         name = "wand";
         type = "weapon";
         cost = 115;
         value = 100;
         range = true;
         intMin = 6;
         agiMin = 2;
         intMod = 5;
         power = 10;
         intScale = 0.5;
      }
      if (nm.equalsIgnoreCase("Razor")) {
         name = "razor";
         type = "weapon";
         cost = 75;
         value = 25;
         range = false;
         strMin = 2;
         intMin = 2;
         agiMin = 5;
         power = 30;
      }
      if (nm.equalsIgnoreCase("Razor")) {
         name = "razor";
         type = "weapon";
         cost = 75;
         value = 25;
         range = false;
         strMin = 2;
         intMin = 2;
         agiMin = 5;
         power = 30;
      }
      if (nm.equalsIgnoreCase("Shiv")) {
         name = "shiv";
         type = "weapon";
         cost = 25;
         value = 5;
         range = false;
         power = 20;
      }
      // BODY ARMOR
      if (nm.equalsIgnoreCase("leather vest")) {
         name = "leather vest";
         type = "body";
         cost = 115;
         value = 85;
         power = 8;
      }
      if (nm.equalsIgnoreCase("Rusted Chainmail")) {
         name = "Rusted Chainmail";
         type = "body";
         cost = 125;
         value = 85;
         power = 12;
         strMin = 6;
         agiMod = -1;
      }
      if (nm.equalsIgnoreCase("Hunters Hoodie")) {
         name = "Hunters Hoodie";
         type = "body";
         cost = 90;
         value = 60;
         power = 4;
         agiMod = 4;
      }
      if (nm.equalsIgnoreCase("Novice Robes")) {
         name = "Novice Robes";
         type = "body";
         cost = 100;
         value = 60;
         power = 2;
         intMod = 8;
      }
      // HELMETS
      if (nm.equalsIgnoreCase("Iron helmet")) {
         name = "Iron Helmet";
         type = "head";
         cost = 100;
         value = 75;
         power = 7;
         strMin = 3;
      }
      if (nm.equalsIgnoreCase("Bandana")) {
         name = "Bandana";
         type = "head";
         cost = 75;
         value = 50;
         power = 1;
         strMod = 4;
         agiMod = 3;
      }
      if (nm.equalsIgnoreCase("Mortarboard")) {
         name = "Mortarboard";
         type = "head";
         cost = 80;
         value = 50;
         power = 1;
         intMod = 6;
         intMin = 4;
      }
      //SHOES
      if (nm.equalsIgnoreCase("Boots")) {
         name = "Boots";
         type = "feet";
         cost = 75;
         value = 50;
         power = 5;
         strMod = 3;
         agiMod = 1;
         strMin = 1
      }
      if (nm.equalsIgnoreCase("Flip-Flops")) {
         name = "Flip-Flops";
         type = "feet";
         cost = 25;
         value = 15;
         power = 1;
         agiMod = -1;
      }
      if (nm.equalsIgnoreCase("Sneakers")) {
         name = "Sneakers";
         type = "feet";
         cost = 100;
         value = 76;
         power = 3;
         agiMod = 6;
      }
      if (nm.equalsIgnoreCase("Pointy shoes")) {
         name = "Pointy shoes";
         type = "feet";
         cost = 75;
         value = 43;
         power = 2;
         intMod = 6;
      }
   }
}
