package lsg.bags;

import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.buffs.rings.RingOfDeath;
import lsg.buffs.talismans.MoonStone;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.food.Hamburger;
import lsg.exceptions.BagFullException;
import lsg.weapons.Sword;

public class SmallBag extends Bag{

    public SmallBag() {
        super(10);
    }

    public static void main(String[] args) throws BagFullException {
        SmallBag bag = new SmallBag() ;

        Collectible item ;

        bag.push(new BlackWitchVeil());
        item = new DragonSlayerLeggings() ;
        bag.push(item);
        bag.push(new Hamburger());
        bag.push(new Sword());
        bag.push(new Whisky());
        bag.push(new RingOfDeath());
        bag.push(new MoonStone());

        System.out.println();
        System.out.println(bag);

        System.out.println("Pop sur " + bag.pop(item)) ;

        System.out.println();
        System.out.println(bag);

    }

}
