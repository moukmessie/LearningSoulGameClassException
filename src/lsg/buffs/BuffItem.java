package lsg.buffs;

import lsg.bags.Collectible;

import java.util.Locale;

public abstract class BuffItem implements Collectible{
	
	private String name ; 
	
	public BuffItem(String name) {
		this.name = name ;
	}

	@Override
	public int getWeight() {
		return 1 ;
	}
	
	public abstract float computeBuffValue() ;
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}
	
}
