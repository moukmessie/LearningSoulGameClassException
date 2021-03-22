package lsg.consumables.food;

import lsg.characters.Character;
import lsg.consumables.Consumable;

public class Food extends Consumable{

    public Food(String name, int capacity){
        super(name, capacity, Character.LIFE_STAT_STRING);
    }

}
