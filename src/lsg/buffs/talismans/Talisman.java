package lsg.buffs.talismans;

import lsg.buffs.BuffItem;

import java.util.Calendar;

public class Talisman extends BuffItem {
	
	private float buff ;
	private int start, end ; 
	
	public Talisman(String name, float buff, int start, int end) {
		super(name) ;
		this.buff = buff ;
		this.start = start ;
		this.end = end ;
	}
	
	@Override
	public float computeBuffValue() {
		int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if(start <= end){
			if(now >= start && now < end) return buff ;
			else return 0f ;
		}else{
			if( (now <= 23 && now >= start) || (now >=0 && now < end)) return buff ;
			else return 0f ;
		}
	}
	
}
