package lsg.consumables;

import lsg.bags.Collectible;
import lsg.exceptions.ConsumeEmptyException;

public class Consumable implements Collectible{

    private String name ;
    private int capacity;
    private String stat;

    public Consumable(String name, int capacity, String stat) {
        this.name = name ;
        this.capacity = capacity ;
        this.stat = stat ;
    }

    @Override
    public int getWeight() {
        return 1 ;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity){
        this.capacity = capacity ;
    }

    public String getStat() {
        return stat;
    }

    public String getName() {
        return name;
    }

    public int use() throws ConsumeEmptyException {
        if (capacity ==0) throw new ConsumeEmptyException();
        int val = capacity;
        capacity = 0 ;
        return val ;
    }

    @Override
    public String toString() {
        return getName() + " [" + getCapacity() + " " + getStat() + " point(s)]" ;
    }

}
