package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.HashSet;

public class MenuBestOfV3 extends HashSet<Consumable>{

    public MenuBestOfV3(){
        this.add(new Hamburger()) ;
        this.add(new Wine()) ;
        this.add(new Americain()) ;
        this.add(new Coffee()) ;
        this.add(new Whisky()) ;
    }

    @Override
    public String toString() {
        String description = getClass().getSimpleName() + " : \n" ;
        int i = 1 ;
        for(Consumable c : this){
            description += i + " : " + c.toString() + "\n" ;
            i++ ;
        }
        return description ;
    }

    public static void main(String[] args) {
        System.out.println(new MenuBestOfV3());
    }

}
