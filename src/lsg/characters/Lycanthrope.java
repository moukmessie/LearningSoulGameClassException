package lsg.characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {

	private static String NAME = "Lycanthrope" ;
	
	public Lycanthrope() {
		super(NAME) ;
		setWeapon(new Claw());
		setSkinThickness(30);
	}
	
}
