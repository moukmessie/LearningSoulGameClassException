package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;

import java.util.LinkedHashSet;

public class MenuBestOfV4 extends LinkedHashSet<Consumable> {

    public MenuBestOfV4(){
        this.add(new Hamburger()) ;
        this.add(new Wine()) ;
        this.add(new Americain()) ;
        this.add(new Coffee()) ;
        this.add(new Whisky()) ;
        this.add(new RepairKit()) ;
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
        System.out.println(new MenuBestOfV4());
    }

}
