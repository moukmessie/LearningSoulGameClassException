package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

public class MenuBestOfV1 {

    Consumable[] menu ;

    public MenuBestOfV1(){
        menu = new Consumable[5] ;
        menu[0] = new Hamburger() ;
        menu[1] = new Wine() ;
        menu[2] = new Americain() ;
        menu[3] = new Coffee() ;
        menu[4] = new Whisky() ;
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
        System.out.println(new MenuBestOfV1());
    }

}
