package lsg.weapons;

import lsg.consumables.repair.RepairKit;
import lsg.bags.Collectible;
import lsg.exceptions.ConsumeNullException;

public class Weapon implements Collectible{

	public static final String DURABILITY_STAT_STRING = "durability" ;
	
	protected String name ;
	
	private int minDamage ;
	private int maxDamage ;
	private int stamCost ;
	private int durability ;
	
	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		this.name = name ;
		this.minDamage = minDamage ;
		this.maxDamage = maxDamage ;
		this.stamCost = stamCost ;
		this.durability = durability ;
	}

	@Override
	public int getWeight() {
		return 2 ;
	}

	public void repairWith(RepairKit kit) throws ConsumeNullException {
		if (kit == null)throw new ConsumeNullException();
		setDurability(durability + kit.use());
	}

	public void use(){
		setDurability(durability-1) ; ;
	}
	
	public boolean isBroken(){
		return durability <=0 ;
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getMinDamage() {
		return minDamage;
	}

	private void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	private void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getStamCost() {
		return stamCost;
	}

	private void setStamCost(int stamCost) {
		this.stamCost = stamCost;
	}

	public int getDurability() {
		return durability;
	}

	private void setDurability(int durability) {
		this.durability = durability;
	}
	
	@Override
	public String toString() {
		return getName() + " (min:" + getMinDamage() + " max:" + getMaxDamage() + " stam:" + getStamCost() + " " + DURABILITY_STAT_STRING.substring(0,3) + ":" + getDurability() + ")" ;
	}

}
