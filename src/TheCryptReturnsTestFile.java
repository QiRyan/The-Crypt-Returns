import java.util.*;
public class TheCryptReturnsTestFile
{
   public static void main(String[] args)
   {
      System.out.println("This is a test file for the Crypt");
      System.out.println("Combat testing");
      System.out.println();
      
      Scanner kb = new Scanner(System.in);
      Skill temp1 = new Skill("placeHolder", 1);
      Skill temp2 = new Skill("placeHolder", 1);
      Skill temp3 = new Skill("placeHolder", 1);
      
      List<GameObject> team = new ArrayList<GameObject>();
      Warrior onionCart = new Warrior("OnionCart", temp1, temp2, temp3);
      Warrior isience = new Warrior("Isience", temp1, temp2, temp3);
      Warrior bardyGuard = new Warrior("BardyGuard", temp1, temp2, temp3);
      Warrior shiinji = new Warrior("Shiinji", temp1, temp2, temp3);
      team.add(onionCart);
      team.add(isience);
      team.add(bardyGuard);
      team.add(shiinji);
      
      List<GameObject> encounter = new ArrayList<GameObject>();
      Monster slime1 = new Monster("Basic Slime", 1, 25, 100, 1, 2, 25, 25);
      Monster slime2 = new Monster("Strong Slime", 1, 25, 150, 4, 5, 46, 29);
      Monster slime3 = new Monster("Zric Ehang", 1, 100, 200, 36, 24, 150, 30);   
      encounter.add(slime1);
      encounter.add(slime2);
      encounter.add(slime3);
      
      System.out.println(encounter.get(0).getClass().getName());
      
      Party MCM606 = new Party(team, 500);
      Party monsterEncounter = new Party(encounter, 100);
//       for(GameObject member : MCM606.getParty())
//       {
//          member.printStats();
//       }
//       
//       for(GameObject monster : monsterEncounter.getParty())
//       {
//          monster.printStats();
//       }       
      MCM606.printParty();
      monsterEncounter.printParty();
      Battle testBattle = new Battle(MCM606, monsterEncounter);
      testBattle.battle();
   }
}