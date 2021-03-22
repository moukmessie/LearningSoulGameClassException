package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.HashSet;

public class MenuBestOfV2 {

    HashSet<Consumable> menu ;

    public MenuBestOfV2(){
        menu = new HashSet<>() ;
        menu.add(new Hamburger()) ;
        menu.add(new Wine()) ;
        menu.add(new Americain()) ;
        menu.add(new Coffee()) ;
        menu.add(new Whisky()) ;
    }

    @Override
    public String toString() {
        String description = getClass().getSimpleName() + " : \n" ;
        int i = 1 ;
        for(Consumable c : menu){
            description += i + " : " + c.toString() + "\n" ;
            i++ ;
        }
        return description ;
    }

    public static void main(String[] args) {
        System.out.println(new MenuBestOfV2());
    }

}
