import java.util.*;
public class Exerimental{
   public static void main(String[] args) {
      System.out.println("The Mercer Court Masters presents:");
      System.out.println("                       WWWWWWWWWWW   WW      WW    WWWWWWWWW");
      System.out.println("                           WWW       WW      WW    WW       ");
      System.out.println("                           WWW       WW      WW    WW       ");
      System.out.println("                           WWW       WWwwwwwwWW    WW       ");
      System.out.println("                           WWW       WWWWWWWWWW    WWWWWWWWW");
      System.out.println("                           WWW       WW      WW    WW       ");
      System.out.println("                           WWW       WW      WW    WW       ");
      System.out.println("                           WWW       WW      WW    WWWWWWWWW");
      System.out.println("");
      System.out.println("           WWWWWW            WWWWWW      WWW         WWW   WWWWWWWWW     WWWWWWWWWWWW");
      System.out.println("        WWWWWWWWWWWW       WWW    WWW     WWW       WWW   WWW     WWW    WWWWWWWWWWWW");
      System.out.println("       WWWW       WWWW    WWW      WWW     WWW     WWW    WWW      WWW        WWW");
      System.out.println("      WWWW        WWWW    WWW      WWW      WWW   WWW     WWW      WWW        WWW");
      System.out.println("      WWW                 WWWWW   WWW        WWW WWW      WWW     WWW         WWW ");
      System.out.println("      WWWW                WWWWWWWWWW          WWWWW       WWWWWWWWWW          WWW");
      System.out.println("       WWWW               WWW   WWW            WWW        WWW                 WWW");
      System.out.println("        WWWWWWWWWWWW      WWW    WWW           WWW        WWW                 WWW");
      System.out.println("          WWWWWWW         WWW     WWW          WWW        WWW                 WWW");
      System.out.println("");
      System.out.println("     WWWWWW     WWWWWWWWW  WWWWWWWWWWWW  WW          WW    WWWWWW     WWW       WW      WWWWW ");
      System.out.println("   WWW    WWW   WW         WWWWWWWWWWWW  WW          WW  WWW    WWW   WWWW      WW   WWWWWW      ");
      System.out.println("  WWW      WWW  WW             WWW       WW          WW WWW      WWW  WW WW     WW  WWWWW          ");
      System.out.println("  WWW      WWW  WW             WWW       WW          WW WWW      WWW  WW  WW    WW  WWWW        ");
      System.out.println("  WWWW    WWW   WWWWWWWWW      WWW       WW          WW WWW     WWW   WW   WW   WW  WWWWWWWWWW    ");
      System.out.println("  WWWWWWWWWW    WW             WWW        WW        WW  WWWWWWWWWW    WW    WW  WW        WWWW   ");
      System.out.println("  WWW   WWW     WW             WWW        WW        WW  WWW   WWW     WW     WW WW       WWWWW  ");
      System.out.println("  WWW    WWW    WW             WWW         WWW    WWW   WWW    WWW    WW      WWWW     WWWWWW    ");
      System.out.println("  WWW     WWW   WWWWWWWWW      WWW          WWWWWWWW    WWW     WWW   WW       WWW   WWWWWW       ");
      System.out.println("");
      Scanner input = new Scanner(System.in);
      boolean pause = true;
      System.out.println("Most points of input in this game offer help sections, if you don't know what you need to type, type in \"?\" in order to get help, try it now");
      System.out.println("My spelling is bad so please don't be mad :(");
      do {
         String nametry = input.nextLine();
         if (nametry.equalsIgnoreCase("?")){
            System.out.println("good!");
            pause = false;
         } 
         else {
            System.out.println("Type in a question mark.");
         }
      } while (pause);
      pause = true;
      System.out.println("Now thant you know the basics please enter the name of yoou first of 4 heros");
   
      Skill filler = new Skill("Gaze");
      Hero Hero1 = new Hero("noman", "lost", filler, filler, filler);
      Hero Hero2 = new Hero("noman", "lost", filler, filler, filler);
      Hero Hero3 = new Hero("noman", "lost", filler, filler, filler);
      Hero Hero4 = new Hero("noman", "lost", filler, filler, filler);
      
      for (int i = 0; i < 4; i++){
         System.out.print("New hero's name: ");
         Hero Morph = new Hero("noman", "lost", filler, filler, filler);
         String lad = "null";
         do {
            String nametry = input.nextLine();
            if (nametry.length() == 0) {
               System.out.println("Please enter a name");
            } 
            else {
               if (nametry.equalsIgnoreCase("?")){
                  System.out.print("Type in the name of your ");
                  if (i == 0){
                     System.out.println("1st hero.");
                  }
                  if (i == 1){
                     System.out.println("2nd hero.");
                  }
                  if (i == 2){
                     System.out.println("3rd hero.");
                  }
                  if (i == 3){
                     System.out.println("4th hero.");
                  }
               } 
               else {
                  lad = nametry;
                  pause = false;
               }
            }
         } while (pause);
         pause = true;
         System.out.println(lad + " is the hero's name!");
         System.out.println("Please enter a class. The three are, warriors, mages, and thiefs");
         do {
            Skill chosen1 = new Skill("Gaze");
            Skill chosen2 = new Skill("Gaze");
            Skill chosen3 = new Skill("Gaze");
            String classtry = input.nextLine();
            if (classtry.length() == 0) {
               System.out.println("Please enter a class");
            } 
            if (classtry.equalsIgnoreCase("?")){
               System.out.print("Type in the class of your ");
               if (i == 0){
                  System.out.println("1st hero.");
               }
               if (i == 1){
                  System.out.println("2nd hero.");
               }
               if (i == 2){
                  System.out.println("3rd hero.");
               }
               if (i == 3){
                  System.out.println("4th hero.");
               }
               System.out.println("You can be a warrior, a mage, or a thief.");
                  
            } 
            
            if (classtry.equalsIgnoreCase("warrior")) {
               System.out.println("You have chosen " + lad +" to be a " + classtry);
               System.out.println("Because " + lad + " is a warrior their first skill will be power attack, dealing extra damage on attack.");
               chosen1 = new Skill("Power Slam");
               do {
                  System.out.println("Choose between, Monk, Berserker, Gladiator");
                  String skilltry = input.nextLine();
                  if (skilltry.equalsIgnoreCase("Monk")) {
                     chosen2 = new Skill("Monk");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Berserker")) {
                     chosen2 = new Skill("Berserker");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Gladiator")) {
                     chosen2 = new Skill("Gladiator");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("?")) {
                     System.out.println("Warriors have a class based skill system, so all of these skills lead to diffrent trees of skills with similar themes");
                     System.out.println("Monks specilize in meditating, buffing up their power for a devistating strike at the right time.");
                     System.out.println("Berserkers gain power the more carnage happens");
                     System.out.println("Gladiators specilize in one on one fights and using tools to take down foes");
                     System.out.println("You can aquire any of these down the road so don't sweat it too much");
                  }
               } while (pause);
               System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s second skill");
               pause = false;
               do {
                  System.out.println("Choose between, Defender, Titan, Paladin");
                  String skilltry = input.nextLine();
                  if (skilltry.equalsIgnoreCase("Defender")) {
                     chosen2 = new Skill("Defender");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Titan")) {
                     chosen2 = new Skill("Titan");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Paladin")) {
                     chosen2 = new Skill("Paladin");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("?")) {
                     System.out.println("Warriors have a class based skill system, so all of these skills lead to diffrent trees of skills with similar themes");
                     System.out.println("Defender sokes up damage with good armor and blocks for vunerable teamates");
                     System.out.println("Titans are brute strength and lots of health, using their size to destroy enemies and be cover for teamates");
                     System.out.println("Paladins focus on buffing/healing teamates and using debuff attacks");
                     System.out.println("You can aquire any of these down the road so don't sweat it too much");
                  }
               } while (pause);
               System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s third skill");
               pause = false;
            
               Morph = new Warrior(lad, chosen1, chosen2, chosen3);
               pause = false;
            } 
            else if (classtry.equalsIgnoreCase("mage")) {
               System.out.println("You have chosen " + lad +" to be a " + classtry);
               System.out.println("Because " + lad + " is a mage, their first skill will be fire ball, dealing damage and setting them on fire.");
               chosen1 = new Skill("Fire Ball");
               do {
                  System.out.println("Choose between, Ice blast, Blood drain, Shock");
                  String skilltry = input.nextLine();
                  if (skilltry.equalsIgnoreCase("Ice blast")) {
                     chosen2 = new Skill("Ice blast");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Blood drain")) {
                     chosen2 = new Skill("Blood drain");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Shock")) {
                     chosen2 = new Skill("Shock");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("?")) {
                     System.out.println("Mages have a tier based Skill system, meaning once you unlock a specific number of tier one spells, you unlock tier two.");
                     System.out.println("Ice blast deals damage and slows target.");
                     System.out.println("Blood drain deals damage and heals you for a set amount");
                     System.out.println("Shock deals damage and has a chance to stun an enemy");
                     System.out.println("You can aquire any of these down the road so don't sweat it too much");
                  }
               } while (pause);
               System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s second skill");
               pause = false;
               do {
                  System.out.println("Choose between, Arcane Meditation, Soul drain, Kinetic sheild");
                  String skilltry = input.nextLine();
                  if (skilltry.equalsIgnoreCase("Arcane Meditation")) {
                     chosen2 = new Skill("Arcane Meditation");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Soul drain")) {
                     chosen2 = new Skill("Soul drain");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Kinetic sheild")) {
                     chosen2 = new Skill("Kinetic sheild");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("?")) {
                     System.out.println("Mages have a tier based Skill system, meaning once you unlock a specific number of tier one spells, you unlock tier two.");
                     System.out.println("Arcane meditation regenerates mana based on intelligence.");
                     System.out.println("Soul drain deals damage and steals mana from a foe");
                     System.out.println("Kinetic sheild reduces incoming damage and replenishes mana");
                     System.out.println("You can aquire any of these down the road so don't sweat it too much");
                  }
               } while (pause);
               System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s third skill");
               pause = false;
            
            
               Morph = new Mage(lad, chosen1, chosen2, chosen3);
               pause = false;
            } 
            else if (classtry.equalsIgnoreCase("thief")) {
               System.out.println("You have chosen " + lad +" to be a " + classtry);
               System.out.println("Because " + lad + " is a thief their first skill will be shadow fade, putting them into stealth.");
               chosen1 = new Skill("Shadow Fade");
               do {
                  System.out.println("Choose between, Shadow Strike, Shadow Dash, Dirk Darks");
                  String skilltry = input.nextLine();
                  if (skilltry.equalsIgnoreCase("Shadow Strike")) {
                     chosen2 = new Skill("Ice blast");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Shadow Dash")) {
                     chosen2 = new Skill("Shadow Dash");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Dirk Darks")) {
                     chosen2 = new Skill("Dirk Darks");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("?")) {
                     System.out.println("Thiefs have a three way tree skill system, the cuthroat tree does damage, the spy tree specilizes in utiliy, and the jester tree specilizes in gadgets");
                     System.out.println("Shadow Strike deals more bonus damage when coming out of stealth.");
                     System.out.println("Shadow Dash changes position and stealths");
                     System.out.println("Dirk Darks deals a small amount of damage to any target, bonus damage if health is low");
                     System.out.println("You can aquire any of these down the road so don't sweat it too much");
                  }
               } while (pause);
               System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s second skill");
               pause = false;
               do {
                  System.out.println("Choose between, Assault of black, Soak in Shadow, Venomous Strike");
                  String skilltry = input.nextLine();
                  if (skilltry.equalsIgnoreCase("Assault of Black")) {
                     chosen2 = new Skill("Assault of black");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Soak in Shadow")) {
                     chosen2 = new Skill("Soak in Shadow");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("Venomous Strike")) {
                     chosen2 = new Skill("Venomous Strike");
                     pause = false;
                  }
                  if (skilltry.equalsIgnoreCase("?")) {
                     System.out.println("Thiefs have a three way tree skill system, the cuthroat tree does damage, the spy tree specilizes in utiliy, and the jester tree specilizes in gadgets");
                     System.out.println("Assault of black grants stealth whenever you finish an enemy");
                     System.out.println("Soak in Shadow heals for every turn ended in stealth");
                     System.out.println("Venomous Strike applies a damage over time effect to the next attack");
                     System.out.println("You can aquire any of these down the road so don't sweat it too much");
                  }
               } while (pause);
               System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s third skill");
               pause = false;
            
            
            
               Morph = new Thief(lad, chosen1, chosen2, chosen3);
               pause = false;
            }
         } while (pause);
         pause = true;
         if (i == 0) {
            Hero1 = Morph;
         }
         if (i == 1) {
            Hero2 = Morph;
         }
         if (i == 2) {
            Hero3 = Morph;
         }
         if (i == 3) {
            Hero4 = Morph;
         }
         
      }
      System.out.println("You have sucessfully, compeated your heros! Congradumulations!");
      Party Heros = new Party(Hero1, Hero2, Hero3, Hero4);
      
   }
}
