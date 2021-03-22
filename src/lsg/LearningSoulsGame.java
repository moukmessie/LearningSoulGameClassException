
package lsg;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.buffs.rings.DragonSlayerRing;
import lsg.buffs.rings.RingOfDeath;
import lsg.buffs.talismans.MoonStone;
import lsg.characters.Character;
import lsg.characters.Hero;
import lsg.characters.Lycanthrope;
import lsg.characters.Monster;
import lsg.consumables.Consumable;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;
import lsg.bags.MediumBag;
import lsg.exceptions.*;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

import java.util.Scanner;

public class LearningSoulsGame {

	public static final String BULLET_POINT = "\u2219 " ;

	Scanner scanner = new Scanner(System.in) ;
	
	Hero hero ;
	Monster monster ;

	private void createExhaustedHero(){
		System.out.println("Create exhausted hero : ");
		hero = new Hero() ;

		// pour vider la vie
		hero.getHitWith(99) ;

		// pour depenser la stam
		hero.setWeapon(new Weapon("Grosse Arme", 0, 0, 1000, 100));

		try{
			try {
				try {
					hero.attack() ;
				} catch (StaminaEmptyException e) {
					e.printStackTrace();
				}
			} catch (WeaponBrokenException e) {
				e.printStackTrace();
			}

		} catch (WeaponNullException e) {
			e.printStackTrace();
		}

//		hero.setWeapon(null);

		System.out.println(hero);
//		System.out.println(hero.getWeapon());

	}

	/*private void aTable() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException {
		MenuBestOfV4 menu = new MenuBestOfV4();
		for (Consumable c : menu) {
			System.out.println();
			hero.use(c);
			System.out.println(hero);
			System.out.println("Apres utilisation : " + c);
		}
		System.out.println(hero.getWeapon());
	}

	private void testBag() throws NoBagException {
		ArmorItem armor1 = new DragonSlayerLeggings() ;
		hero.pickUp(armor1);
		System.out.println();
		hero.pickUp(new RingedKnightArmor());
		System.out.println();

		Weapon weapon = new ShotGun() ;
		hero.pickUp(weapon);
		System.out.println();

		System.out.println();
		hero.printBag();

		System.out.println();
		hero.setBag(new MediumBag());
		System.out.println();
		hero.printBag();

		System.out.println();
		hero.pickUp(new Coffee());
		System.out.println();
		hero.pickUp(new Hamburger());
		System.out.println();
		hero.pickUp(new Whisky());
		System.out.println();
		hero.pickUp(new RepairKit());
		System.out.println();
		hero.pickUp(new RepairKit());
		System.out.println();

		System.out.println();
		hero.printBag();

		System.out.println() ;
		System.out.println("--- AVANT ---");
		hero.printStats();
		hero.printArmor();
		hero.printWeapon();
		hero.printBag();

		System.out.println();
		System.out.println("--- ACTIONS ---");
		hero.fastDrink();
		System.out.println();
		System.out.println();
		hero.fastEat();
		System.out.println();
		System.out.println();

		hero.equip(weapon);
		System.out.println();
		hero.equip(armor1, 1);
		System.out.println();
		hero.fastRepair();

		System.out.println();
		System.out.println("--- APRES ---");
		hero.printStats();
		hero.printArmor();
		hero.printWeapon();
		hero.printBag();

	}*/
	private void testExceptions(){
		hero.setWeapon(null);
		hero.setArmorItem(null,0);
	fight1v1();

	}

	private void init(){
		hero = new Hero() ;
		hero.setWeapon(new Sword());
		hero.setArmorItem(new DragonSlayerLeggings(), 1);
		hero.setRing(new RingOfDeath(), 1);
		hero.setRing(new DragonSlayerRing(), 2);

		hero.setConsumable(new Hamburger());

		monster = new Lycanthrope() ; // plus besoin de donner la skin et l'arme !
		monster.setTalisman(new MoonStone());
	}

	private void play(){
		init();
		fight1v1();
	}
	
	private void fight1v1(){

		refresh();
		
		Character agressor = hero ;
		Character target = monster ;
		int action ; // TODO sera effectivement utilise dans une autre version
		int attack = 0, hit ;
		Character tmp ;

		while(hero.isAlive() && monster.isAlive()){ // ATTENTION : boucle infinie si 0 stamina...

			action = 1 ; // par defaut on lancera une attaque
			System.out.println();

			if(agressor == hero) {
				do {
					System.out.print("Hero's action for next move : (1) attack | (2) consume > ");
					action = scanner.nextInt(); // GENERERA UNE ERREUR L'UTILISATEUR ENTRE AUTRE CHOSE QU'UN ENTIER (ON TRAITERA PLUS TARD)
				}while(action < 1 || action > 2) ;
				System.out.println();
			}

			if(action == 2){
				try {
					try {
						hero.consume();
					} catch (ConsumeRepairNullWeaponException e) {
						System.out.println("IMPOSSIBLE ACTION : no weapon has been equiped !");
					}
				} catch (ConsumeNullException e) {
					e.printStackTrace();
				} catch (ConsumeEmptyException e) {
					System.out.println("ACTION HAS NO EFFET : "+e.getConsumable() + "is empty");
				}
				System.out.println();

			}else{


				try {

					try {
						try {
							attack = agressor.attack() ;
						} catch (StaminaEmptyException e) {
							System.out.println("WARNING : "+e);
							attack=0;
						}
					} catch (WeaponBrokenException e) {
						System.out.println("WARNING : "+e);
						attack=0;
					}

				} catch (WeaponNullException e) {
					System.out.println("WARNING : "+e+" has been equiped !!!");
					attack=0;
				}

				hit = target.getHitWith(attack);
				System.out.printf("%s attacks %s with %s (ATTACK:%d | DMG : %d)", agressor.getName(), target.getName(), agressor.getWeapon().getName(), attack, hit);
				System.out.println();
				System.out.println();
			}

			refresh();
			
			tmp = agressor ;
			agressor = target ;
			target = tmp ;
			
		}
		
		Character winner = (hero.isAlive()) ? hero : monster ;
		System.out.println();
		System.out.println("--- " + winner.getName() + " WINS !!! ---");
		
	}
	
	private void refresh(){
		hero.printStats();
		hero.printArmor();
		hero.printRings();
		hero.printConsumable();
		hero.printWeapon();
		hero.printBag();
		//System.out.println(BULLET_POINT + hero.getWeapon()) ;
		//System.out.println(BULLET_POINT + hero.getConsumable());
		System.out.println();
		monster.printStats();
	}

	private void title(){
		System.out.println();
		System.out.println("###############################");
		System.out.println("#   THE LEARNING SOULS GAME   #");
		System.out.println("###############################");
		System.out.println();
	}

	public static void main(String[] args) {

		LearningSoulsGame lsg = new LearningSoulsGame() ;
		lsg.title();
		//lsg.createExhaustedHero();
		System.out.println();
//		lsg.aTable();
		lsg.init();
//		lsg.fight1v1();
		lsg.refresh();
		//lsg.testExceptions();
	}

}
