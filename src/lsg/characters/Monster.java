package lsg.characters;

import lsg.buffs.talismans.Talisman;

public class Monster extends Character {
	
	private static int INSTANCES_COUNT = 0 ;
	
	private static String DEFAULT_NAME = "Monster" ; // Nom par défaut
	private static int DEFAULT_MAX_LIFE = 10 ; // Nombre de points de vie par défaut
	private static int DEFAULT_MAX_STAMINA = 10 ; // Nombre de points d'action par défaut
	
	private float skinThickness = 20f ; // pour le calcul du taux de réduction des dégats subis
	
	private Talisman talisman ;
	
	public Monster(String name) {
		super(name) ;
		setMaxLife(DEFAULT_MAX_LIFE);
		setLife(DEFAULT_MAX_LIFE) ;
		setMaxStamina(DEFAULT_MAX_STAMINA);
		setStamina(DEFAULT_MAX_STAMINA) ;
		INSTANCES_COUNT++ ;
	}
	
	public Monster(){
		this(DEFAULT_NAME) ;
		setName(getName() + "_" + INSTANCES_COUNT);
	}
	
	protected float getSkinThickness() {
		return skinThickness;
	}
	
	protected void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}

	@Override
	protected float computeProtection() {
		return getSkinThickness() ;
	}
	
	public void setTalisman(Talisman talisman) {
		this.talisman = talisman;
	}
	
	public Talisman getTalisman() {
		return talisman;
	}

	@Override
	protected float computeBuff() {
		float buff = (talisman != null) ? talisman.computeBuffValue() : 0 ;
		return buff ;
	}
	
}
