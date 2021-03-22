package lsg.weapons;

public class Claw extends Weapon {
	
	private static String NAME = "Bloody Claw" ;
	
	public Claw() {
		super(NAME, 50, 150, 5, 100) ;
	}

	public static void main(String[] args) {
		System.out.println(new Claw());
	}
	
}
