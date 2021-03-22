package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import lsg.characters.Hero;

public abstract class Ring extends BuffItem {
	
	protected int power ; 
	protected Hero hero ;
	
	public Ring(String name, int power) {
		super(name) ;
		this.power = power ;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return hero;
	}
	
}
