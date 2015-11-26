import java.util.ArrayList;

public enum Item2 {
	//Nothing
	EMPTY(0, "Nothing", Type.NOTHING, pricing(0,0), 0, statScale(0,0,0), otherMod(0,0), flatStat(0,0,0), minReq(0,0,0), false),
	
	//Weapons
	SWORD(1, "Sword", Type.WEAPON, pricing(100, 75), 25, statScale(0.5, 0, 0.1), otherMod(0,0), flatStat(0,0,0), minReq(3,2,1), false),
	WAND(2, "Wand", Type.WEAPON, pricing(115,100), 10, statScale(0,0.5,0), otherMod(0,0), flatStat(0,5,0), minReq(0,6,2), true),
	RAZOR(3, "Razor", Type.WEAPON, pricing(75, 25), 30, statScale(0,0,0), otherMod(0,0), flatStat(0,0,0), minReq(2,2,5), false),
	SHIV(4, "Shiv", Type.WEAPON, pricing(25, 5), 20, statScale(0,0,0), otherMod(0,0), flatStat(0,0,0), minReq(0,0,0), false),
	
	//Body
	LEATHER_VEST(100, "Leather vest", Type.BODY, pricing(115, 85), 8, statScale(0,0,0), otherMod(0,0), flatStat(0,0,0), minReq(0,0,0), false),
	RUSTED_CHAINMAIL(101, "Rusted Chainmail", Type.BODY, pricing(125, 85), 12, statScale(0,0,0), otherMod(0,0), flatStat(0,0,-1), minReq(6,0,0), false),
	HUNTERS_HOODIE(102, "Hunters Hoodie", Type.BODY, pricing(90, 60), 4, statScale(0,0,0), otherMod(0,0), flatStat(0,0,4), minReq(0,0,0), false),
	NOVICE_ROBES(103, "Novice Robes", Type.BODY, pricing(100, 60), 2, statScale(0,0,0), otherMod(0,0), flatStat(0,8,0), minReq(0,0,0), false),
	
	//Head
	IRON_HELMET(200, "Iron Helmet", Type.HEAD, pricing(100, 75), 7, statScale(0,0,0), otherMod(0,0), flatStat(0,0,0), minReq(3,0,0), false),
	BANDANA(201, "Bandana", Type.HEAD, pricing(75, 50), 1 , statScale(0,0,0), otherMod(0,0), flatStat(4,0,3), minReq(0,0,0), false),
	MORTARBOARD(202, "Mortarboard", Type.HEAD, pricing(80, 50), 1, statScale(0,0,0), otherMod(0,0), flatStat(0,6,0), minReq(0,4,0), false),
	
	//Shoes
	BOOTS(300, "Boots", Type.FEET, pricing(75, 50), 5, statScale(0,0,0), otherMod(0,0), flatStat(3,0,1), minReq(1,0,0), false),
	FLIP_FLOPS(301, "Flip-Flops", Type.FEET, pricing(25, 15), 1 , statScale(0,0,0), otherMod(0,0), flatStat(0,0,-1), minReq(0,0,0), false),
	SNEAKERS(302, "Sneakers", Type.FEET, pricing(100, 76), 3, statScale(0,0,0), otherMod(0,0), flatStat(0,0,3), minReq(0,0,0), false),
	POINTY_SHOES(303, "Pointy Shoes", Type.FEET, pricing(75, 43), 2, statScale(0,0,0), otherMod(0,0), flatStat(0,6,0), minReq(0,0,0), false)
	;
	
	
	private final int id;
	private final String name;
	private final Type type;
	//private final String effect;
	//private final String description;
	private final int cost;
	private final int value;
	private final int power;
	private final double strScale;
	private final double intScale;
	private final double agiScale;
	private final double dodgeMod;
	private final double critMod;
	private final int strMod;
	private final int intMod;
	private final int agiMod;
	private final int strMin;
	private final int intMin;
	private final int agiMin;
	private final boolean range;

	
	/**
	 * @param id - integer id
	 * @param name - name of the object
	 * @param type - type of equipment
	 * @param effect - N/A
	 * @param description - N/A
	 * @param pricing - 2 element array containing cost, value
	 * @param power - integer value, flat damage
	 * @param scaleArr - 3 element array containing strScale, intScale, agiScale
	 * @param modOther - 2 element array containing dodgeMod, critMod
	 * @param flatMod - 3 element array containing strMod, intMod, agiMod
	 * @param minReq - 3 element array containing strMin, intMin, agiMin
	 * @param range - boolean whether item is ranged
	 */
	private Item2(int id, String name, Type type, int[] price, int power,
			double[] scaleArr, double[] modOther, int[] flatMod, int[] minReq, boolean range) {
		this.id = id;
		this.name = name;
		this.type = type;
		//this.effect = effect;
		//this.description = description;
		this.cost = price[0];
		this.value = price[1];
		this.power = power;
		this.strScale = scaleArr[0];
		this.intScale = scaleArr[1];
		this.agiScale = scaleArr[2];
		this.dodgeMod = modOther[0];
		this.critMod = modOther[1];
		this.strMod = flatMod[0];
		this.intMod = flatMod[1];
		this.agiMod = flatMod[2];
		this.strMin = minReq[0];
		this.intMin = minReq[1];
		this.agiMin = minReq[2];
		this.range = range;
		
		addToDatabase(this);
	}

	private static ArrayList<Item2> database = new ArrayList<Item2>(1000);
	/**
	 * 
	 * @param costVal
	 * @param val
	 * @return
	 */
	private static int[] pricing(int costVal, int val){
		return new int[]{costVal, val};
	}
	/**
	 * 
	 * @param strVal
	 * @param intVal
	 * @param agiVal
	 * @return
	 */
	private static double[] statScale(double strVal, double intVal, double agiVal){
		return new double[]{strVal, intVal, agiVal};
	}
	/**
	 * 
	 * @param dodgeChance
	 * @param critChance
	 * @return
	 */
	private static double[] otherMod(double dodgeChance, double critChance){
		return new double[]{dodgeChance, critChance};
	}
	
	/**
	 * @param strVal
	 * @param intVal
	 * @param agiVal
	 * @return
	 */
	private static int[] flatStat(int strVal, int intVal, int agiVal){
		return new int[]{strVal, intVal, agiVal};
	}
	/**
	 * 
	 * @param strVal
	 * @param intVal
	 * @param agiVal
	 * @return
	 */
	private static int[] minReq(int strVal, int intVal, int agiVal){
		return new int[]{strVal, intVal, agiVal};
	}
	
	private void addToDatabase(Item2 item){
		database.add(item.getId(), this);
	}
	
	public int getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}
	public Type getType() {
		return type;
	}
	/*public String getEffect() {
		return effect;
	}
	public String getDescription() {
		return description;
	}*/
	public int getCost() {
		return cost;
	}
	public int getValue() {
		return value;
	}
	public int getPower() {
		return power;
	}
	public double getStrScale() {
		return strScale;
	}
	public double getIntScale() {
		return intScale;
	}
	public double getAgiScale() {
		return agiScale;
	}
	public double getDodgeMod() {
		return dodgeMod;
	}
	public double getCritMod() {
		return critMod;
	}
	public int getStrMod() {
		return strMod;
	}
	public int getIntMod() {
		return intMod;
	}
	public int getAgiMod() {
		return agiMod;
	}
	public int getStrMin() {
		return strMin;
	}
	public int getIntMin() {
		return intMin;
	}
	public int getAgiMin() {
		return agiMin;
	}
	public boolean isRange() {
		return range;
	}
	
	
}
