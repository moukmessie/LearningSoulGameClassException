package lsg.weapons;

public class ShotGun extends Weapon {
	
	private static String NAME = "ShotGun" ;
	
	public ShotGun() {
		super(NAME, 6, 20, 5, 100) ;
	}
	
	public static void main(String[] args) {
		System.out.println(new ShotGun());
	}

}
