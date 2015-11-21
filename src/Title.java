import java.util.*;
public class Title{
	public static void main(String[] args) {
		displayBanner();
		Party pt;
		Scanner input = new Scanner(System.in);

		System.out.println("Most points of input in this game offer help sections, if you don't know what you need to type, type in \"?\" in order to get help, try it now");
		System.out.println("My spelling is bad so please don't be mad :(");
		String nametry;
		do {
			nametry = input.nextLine();
			if (nametry.equalsIgnoreCase("?")){
				System.out.println("good!");
			} 
			else {
				System.out.println("Type in a question mark.");
			}
		} while (!nametry.equals("?"));
		System.out.println("Now thant you know the basics please enter the name of yoou first of 4 heros");
		input.close();
		pt = createParty(4);
			}
	private static Party createParty(int number){
		Scanner input = new Scanner(System.in);
		Hero[] pt = new Hero[number];
		String lad;
		for (int i = 0; i < number; i++){
			System.out.print("New hero's name: ");
			lad = null;
				do {
					String nametry = input.nextLine();
					if (nametry.length() == 0) 
						System.out.println("Please enter a name");
					else {
						if (nametry.equalsIgnoreCase("?"))
							System.out.print("Type in the name of your " +(i+1)+"th Hero");
						else 
							lad = nametry;
					}
				} while (lad == null);

			System.out.println(lad + " is the hero's name!");
			System.out.println("Please enter a class. The three are, warriors, mages, and thiefs");
			String classtry = null; Hero temp = null;
			do {
				classtry = input.nextLine();
				if (classtry.length() == 0) {
					System.out.println("Please enter a class");
				} 
				if (classtry.equalsIgnoreCase("?")){
					System.out.print("Type in the class of your "+(i+1)+"th Hero");
					System.out.println("You can be a warrior, a mage, or a thief.");
				} 
				switch (classtry.toLowerCase()){
				case "warrior":
					temp = generateWarrior(lad);
					break;
				case "mage":
					temp = generateMage(lad);
					break;
				case "thief":
					temp = generateThief(lad);
					break;
				default:
					classtry = null;
					break;
				}
			} while(temp == null);
			pt[i] = temp;
		}
		System.out.println("You have sucessfully, compeated your heros! Congradumulations!");
		input.close();
		return new Party(pt);

	}
	private static Hero generateWarrior(String lad){
		Skill chosen1, chosen2, chosen3;
		chosen1 = chosen2 = chosen3 = null;
		Scanner input = new Scanner(System.in);
		System.out.println("You have chosen " + lad +" to be a Warrior");
		System.out.println("Because " + lad + " is a warrior their first skill will be power attack, dealing extra damage on attack.");
		chosen1 = new Skill("Power Slam");
		do {
			System.out.println("Choose between, Monk, Berserker, Gladiator");
			String skilltry = input.nextLine();
			switch (skilltry.toLowerCase()){
			case "monk":
				chosen2 = new Skill("Monk");
				break;
			case "berserker":
				chosen2 = new Skill("Berserker");
				break;
			case "gladiator":
				chosen2 = new Skill("Gladiator");
				break;
			case "?":
				System.out.println("Warriors have a class based skill system, so all of these skills lead to diffrent trees of skills with similar themes");
				System.out.println("Monks specilize in meditating, buffing up their power for a devistating strike at the right time.");
				System.out.println("Berserkers gain power the more carnage happens");
				System.out.println("Gladiators specilize in one on one fights and using tools to take down foes");
				System.out.println("You can aquire any of these down the road so don't sweat it too much");
				break;
			default:
				break;
			}
		} while (chosen2 == null);
		System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s second skill");

		do {
			System.out.println("Choose between, Defender, Titan, Paladin");
			String skilltry = input.nextLine();
			switch (skilltry.toLowerCase()){
			case "defender":
				chosen3 = new Skill("Defender");
				break;
			case "titan":
				chosen3 = new Skill("Titan");
				break;
			case "paladin":
				chosen3 = new Skill("Paladin");
				break;
			case "?":
				System.out.println("Warriors have a class based skill system, so all of these skills lead to diffrent trees of skills with similar themes");
				System.out.println("Defender sokes up damage with good armor and blocks for vunerable teamates");
				System.out.println("Titans are brute strength and lots of health, using their size to destroy enemies and be cover for teamates");
				System.out.println("Paladins focus on buffing/healing teamates and using debuff attacks");
				System.out.println("You can aquire any of these down the road so don't sweat it too much");
				break;
			default:
				break;
			}
		} while (chosen3 == null);
		System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s third skill");
		input.close();
		return new Warrior(lad, chosen1, chosen2, chosen3);
	} 

	private static Hero generateMage(String lad){	
		Skill chosen1, chosen2, chosen3;
		chosen1 = chosen2 = chosen3 = null;
		Scanner input = new Scanner(System.in);
		System.out.println("You have chosen " + lad + " to be a Mage.");
		System.out.println("Because " + lad + " is a mage, their first skill will be fire ball, dealing damage and setting them on fire.");
		chosen1 = new Skill("Fire Ball");
		do {
			System.out.println("Choose between, Ice blast, Blood drain, Shock");
			String skilltry = input.nextLine();
			switch (skilltry.toLowerCase()){
			case "ice blast":
				chosen2 = new Skill("Ice blast");
				break;
			case "blood drain":
				chosen2 = new Skill("Blood drain");
				break;
			case "shock":
				chosen2 = new Skill("Shock");
				break;
			case "?":
				System.out.println("Mages have a tier based Skill system, meaning once you unlock a specific number of tier one spells, you unlock tier two.");
				System.out.println("Ice blast deals damage and slows target.");
				System.out.println("Blood drain deals damage and heals you for a set amount");
				System.out.println("Shock deals damage and has a chance to stun an enemy");
				System.out.println("You can aquire any of these down the road so don't sweat it too much");
				break;
			default:
				break;
			}
		} while (chosen2 == null);
		System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s second skill");

		do {
			System.out.println("Choose between, Arcane Meditation, Soul drain, Kinetic sheild");
			String skilltry = input.nextLine();
			switch(skilltry.toLowerCase()){
			case "arcane meditation":
				chosen3 = new Skill("Arcane Meditation");
				break;
			case "soul drain":
				chosen3 = new Skill("Soul drain");
				break;
			case "kinetic shield":
				chosen3 = new Skill("Kinetic sheild");
				break;
			case "?":
				System.out.println("Mages have a tier based Skill system, meaning once you unlock a specific number of tier one spells, you unlock tier two.");
				System.out.println("Arcane meditation regenerates mana based on intelligence.");
				System.out.println("Soul drain deals damage and steals mana from a foe");
				System.out.println("Kinetic sheild reduces incoming damage and replenishes mana");
				System.out.println("You can aquire any of these down the road so don't sweat it too much");
				break;
			default:
				break;
			}
		} while (chosen3 == null);
		System.out.println("You have chosen " + chosen3.getName() + " as " + lad + "'s third skill");
		input.close();
		return new Mage(lad, chosen1, chosen2, chosen3);
	} 

	private static Hero generateThief(String lad){
		Skill chosen1, chosen2, chosen3;
		chosen1 = chosen2 = chosen3 = null;
		Scanner input = new Scanner(System.in);
		System.out.println("You have chosen " + lad +" to be a Thief.");
		System.out.println("Because " + lad + " is a thief their first skill will be shadow fade, putting them into stealth.");
		chosen1 = new Skill("Shadow Fade");
		do {
			System.out.println("Choose between, Shadow Strike, Shadow Dash, Dirk Darks");
			String skilltry = input.nextLine();
			switch (skilltry.toLowerCase()){
			case "shadow strike":
				chosen2 = new Skill("Shadow Strike");
				break;
			case "shadow dash":
				chosen2 = new Skill("Shadow Dash");
				break;
			case "dirk darks":
				chosen2 = new Skill("Dirk Darks");
				break;
			case "?":
				System.out.println("Thiefs have a three way tree skill system, the cuthroat tree does damage, the spy tree specilizes in utiliy, and the jester tree specilizes in gadgets");
				System.out.println("Shadow Strike deals more bonus damage when coming out of stealth.");
				System.out.println("Shadow Dash changes position and stealths");
				System.out.println("Dirk Darks deals a small amount of damage to any target, bonus damage if health is low");
				System.out.println("You can aquire any of these down the road so don't sweat it too much");
				break;
			default:
				break;
			}
		} while (chosen2 == null);

		System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s second skill");

		do {
			System.out.println("Choose between, Assault of black, Soak in Shadow, Venomous Strike");
			String skilltry = input.nextLine();
			switch (skilltry.toLowerCase()){
			case "assault of black":
				chosen3 = new Skill("Assault of black");
				break;
			case "soak in shadow":
				chosen3 = new Skill("Soak in Shadow");
				break;
			case "venomous strike":
				chosen3 = new Skill("Venomous Strike");
				break;
			case "?":
				System.out.println("Thiefs have a three way tree skill system, the cuthroat tree does damage, the spy tree specilizes in utiliy, and the jester tree specilizes in gadgets");
				System.out.println("Assault of black grants stealth whenever you finish an enemy");
				System.out.println("Soak in Shadow heals for every turn ended in stealth");
				System.out.println("Venomous Strike applies a damage over time effect to the next attack");
				System.out.println("You can aquire any of these down the road so don't sweat it too much");
				break;
			default:
				break;
			}
		} while (chosen3 == null);
		System.out.println("You have chosen " + chosen2.getName() + " as " + lad + "'s third skill");
		input.close();
		return new Thief(lad, chosen1, chosen2, chosen3);
	}
	private static void displayBanner(){
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
	}
}
