package lsg.consumables.repair;

import lsg.consumables.Consumable;
import lsg.weapons.Weapon;

public class RepairKit extends Consumable {

    public RepairKit(){
        super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);
    }

    @Override
    public int use() {
        int amount = getCapacity() ;
        int val = (amount > 0) ? 1 : 0 ;
        setCapacity(amount - val);
        return val ;
    }
}
