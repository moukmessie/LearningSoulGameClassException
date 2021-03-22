package lsg.exceptions;

import lsg.bags.Bag;

public class BagFullException extends Exception {
    private Bag bag;
    public BagFullException(Bag bag) {
      super(bag + " is full !");
      this.bag=bag;
    }

    public Bag getBag() {
        return bag;
    }

    public BagFullException() {
        super(" is full !");
    }
}
