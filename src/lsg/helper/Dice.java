package lsg.helper;

import java.util.Random;

/**
 * Classe représentant un dé. 
 * Génère des nombres aléatoires compris entre 0 et le nombre de faces -1. 
 * 
 * @author Greg
 *
 */
public class Dice {
	
	private int faces ; // nombre de valeurs possibles
	
	private Random random ;
	
	
	/**
	 * @param faces : le nombre de faces du dé
	 */
	public Dice(int faces) {
		this.faces = faces ;
		random = new Random() ;
	}
	
	/**
	 * @return un nombre aléatoire entre 1 et le nombre de faces du dé
	 */
	public int roll(){
		return random.nextInt(faces) ;
	}

	/**
	 * MenuBestOfV1 de la classe Dice
	 * 
	 * @param args : non utilisés
	 */
	public static void main(String[] args) {
		Dice dice = new Dice(50) ;
		int val = dice.roll() ;
		int min = val  ;
		int max = val ;
		for(int i=0 ; i < 500 ; i++){
			System.out.print(val + " ");
			val = dice.roll() ;
			if(val > max) max = val ;
			if(val < min) min = val ;
		}
		
		System.out.println();
		System.out.println("Min : " + min);
		System.out.println("Max : " + max);
	}
	
}
