package lsg.exceptions;

import lsg.consumables.Consumable;

public abstract class  ConsumeException extends Exception {
   private Consumable consumable;

    public ConsumeException(String message, Consumable consumable) {
        super(message);
        this.consumable=consumable;
    }

    public ConsumeException(String message) {
       super(message);
    }

    public Consumable getConsumable() {
        return consumable;
    }
}
