package lsg.characters;

import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.RingedKnightArmor;
import lsg.buffs.rings.Ring;
import lsg.exceptions.NoBagException;

public class Hero extends Character {
	
	private static String DEFAULT_NAME = "Gregooninator" ; // Nom par défaut
	private static int DEFAULT_MAX_LIFE = 100 ; // Nombre de points de vie par défaut
	private static int DEFAULT_MAX_STAMINA = 50 ; // Nombre de points d'action par défaut
	
	private static int MAX_ARMOR_PIECES = 3 ; // nombre max de pièces d'armures
	
	private static int MAX_RINGS = 2 ; // nombre max d'anneaux
	
	private ArmorItem[] armor ; // l'ensemble des pieces d'armure portees par le hero
	
	private Ring[] rings ;
	
	public Hero(String name){
		super(name) ;
		setMaxLife(DEFAULT_MAX_LIFE);
		setLife(DEFAULT_MAX_LIFE) ;
		setMaxStamina(DEFAULT_MAX_STAMINA);
		setStamina(DEFAULT_MAX_STAMINA) ;
		
		armor = new ArmorItem[MAX_ARMOR_PIECES] ;
		rings = new Ring[MAX_RINGS] ;
	}
	
	public Hero(){
		this(DEFAULT_NAME) ;
	}

	/**
	 * Recherche l'item d'armure passée en paramètre dans le sac, et l'équipe (donc le retire du sac)
	 * Ne fait rien si l'item n'est pas dans le sac
	 * @param item
	 */
	public void equip(ArmorItem item, int slot) throws NoBagException {
		if(item==null) throw new NoBagException();

		if(bag.contains(item)){
			pullOut(item) ;
			System.out.println(" and equips it !");
			setArmorItem(item, slot);
		}
	}

	/**
	 * Recherche l'anneau passée en paramètre dans le sac, et l'équipe (donc le retire du sac)
	 * Ne fait rien si l'anneau n'est pas dans le sacs
	 * @param item
	 */
	public void equip(Ring item, int slot) throws NoBagException {
		if(item==null) throw new NoBagException();
		if(bag.contains(item)){
			pullOut(item) ;
			System.out.println(" and equips it !");
			setRing(item, slot);
		}
	}

	/**
	 * Place une piece d'armure
	 * @param item : la piece d'amure 
	 * @param slot : slot a utiliser (NB: si une piece était en place, elle est remplacee)
	 */
	public void setArmorItem(ArmorItem item, int slot){
		int index = slot-1 ;
		if(index >=0 && index < MAX_ARMOR_PIECES){
			armor[index] = item ;
		}
	}
	
	/**
	 * @return un tableau contenant les pièces d'armure effectivement portées
	 */
	public ArmorItem[] getArmorItems() {
		
		// Comptage du nombre de pièces portées (NB: on pourrait être plus efficace avec une Collection... cf. plus tard)
		int count = 0 ;
		for (ArmorItem item: armor){
			if(item != null) count++ ;
		}
		
		// Création et remplissage du tableau résultat
		ArmorItem[] items = new ArmorItem[count] ;
		int i = 0 ;
		for(ArmorItem item: armor) {
			if(item != null){
				items[i] = item ;
				i++ ;
			}
		}
		
		return items ;
	}
	
	/**
	 * Place un anneau
	 * @param ring
	 * @param slot : slot a utiliser (NB: si un anneau était en place, il est remplacee)
	 */
	public void setRing(Ring ring, int slot){
		int index = slot-1 ;
		if(index >=0 && index < MAX_RINGS){
			rings[index] = ring ;
			ring.setHero(this);
		}
	}
	
	public Ring[] getRings() {
		
		// Comptage du nombre d'anneaux (NB: on pourrait être plus efficace avec une Collection... cf. plus tard)
		int count = 0 ;
		for (Ring ring: rings){
			if(ring != null) count++ ;
		}
		
		// Création et remplissage du tableau résultat
		Ring[] result = new Ring[count] ;
		int i = 0 ;
		for(Ring r: rings) {
			if(r != null){
				result[i] = r ;
				i++ ;
			}
		}
		
		return result ;
	}
	
	/**
	 * @return la valeur totale de l'armure du hero
	 */
	public float getTotalArmor(){
		float total = 0 ;
		for(ArmorItem i : armor){
			total = (i != null) ? total + i.getArmorValue() : total ;
		}
		return total ;
	}
		
	/**
	 * @return une representation de l'armure portee par le hero
	 */
	public String armorToString(){
		String msg = "ARMOR " ;
		String item ;
		for(int i=0 ; i<MAX_ARMOR_PIECES ; i++){
			item = (armor[i] !=null) ? armor[i].toString() : "empty" ;
			msg = String.format("%s %2d:%-30s", msg, i+1, item) ; 
		}
		return msg + "TOTAL:" + getTotalArmor() ;
	}

	public void printArmor(){
		System.out.println(armorToString());
	}

	@Override
	protected float computeProtection() {
		return getTotalArmor() ;
	}
	
	@Override
	protected float computeBuff() {
		float total = 0 ;
		for(Ring r : rings){
			total = (r != null) ? total + r.computeBuffValue() : total ;
		}
		return total ;
	}	
	
	public static void main(String[] args) {
		Hero hero = new Hero() ;
		
		hero.setArmorItem(new BlackWitchVeil(), 1);
//		hero.addArmor(new DragonSlayerLeggings(), 2);
		hero.setArmorItem(new RingedKnightArmor(), 3);
		System.out.println(hero.armorToString());
		
	}

	public void printRings(){
		System.out.print("RINGS");
		for (int i=0; i< rings.length;i++){
			System.out.print(" "+(i+1)+" :" + rings[i]);
		}
		System.out.println();

	}

	
}
