package lsg.bags;

import lsg.LearningSoulsGame;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.exceptions.BagFullException;
import lsg.weapons.ShotGun;

import java.util.HashSet;

/**
 * Bag permet de définir des ensembles de Collectible.
 * Un bag est cree avec une capacite definie (en kg) qui limite le nombre de Collectible
 * qui peuvent y être rangés (en fonction de leur poids)
 */
public class Bag {

    private HashSet<Collectible> items = new HashSet<>();

    private int capacity, weight;

    public Bag(int capacity){
        this.capacity = capacity;
        this.weight = 0 ;
    }

    /**
     * Permet de savoir si in Collectible se trouve bien dans le Bag
     * @param item : le Collectible recherché
     * @return
     */
    public boolean contains(Collectible item){
        return items.contains(item) ;
    }

    /**
     * Permet d'ajouter un Collectible dans le Bag s'il y reste assez de place.
     * S'il n'y a pas assez de place, la méthode ne fait rien.
     * @param item : le Collectible à ranger
     */
    public void push(Collectible item) throws BagFullException {
        int weight = item.getWeight() ;
        if(!(this.weight + weight <= capacity)) throw new BagFullException();

            items.add(item) ;
            this.weight += weight ;

    }

    /**
     * Retire un Collectible du Bag.
     * @param item : le Collectible à retirer
     * @return le Collectible retiré ou null si l'item n'était pas dans le Bag
     */
    public Collectible pop(Collectible item){
        if(items.contains(item)){
            int weight = item.getWeight() ;
            items.remove(item) ;
            this.weight -= weight ;
            return item ;
        }else{
            return null ;
        }
    }

    /**
     * @return le nombre de kg total pouvant être contenus dans le Bag
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return le nombre de kg en cours d'utilisation
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return un tableau contenant les Collectible du Bag
     */
    public Collectible[] getItems(){
        Collectible[] result = new Collectible[items.size()] ;
        items.toArray(result) ;
        return result ;
    }

    @Override
    public String toString() {
        String description = getClass().getSimpleName() + " [ " + items.size() + " items | " + weight + "/" + capacity + " kg ]\n" ;
        if(weight == 0){
            description += LearningSoulsGame.BULLET_POINT + "(empty)" ;
        }else{
            for(Collectible c: items){
                description += LearningSoulsGame.BULLET_POINT + c.toString() + "[" + c.getWeight() + " kg]\n" ;
            }
        }
        return description ;
    }

    /**
     * Transfere le contenu d'un sac dans un autre, dans la limite de la capacite du sac de destination
     * @param from le sac qui doit être vidé
     * @param into le sac qui doit être rempli
     */
    public static void transfer(Bag from, Bag into) throws BagFullException {

        int size = into.getCapacity() ;
        Collectible[] items = from.getItems() ;
        for(Collectible item: items){
            if(!(item.getWeight() <= (size - into.getWeight())))throw new BagFullException();

                into.push(from.pop(item));

        }
    }

    public static void main(String[] args) throws BagFullException {
        System.out.println();
        Bag bag = new Bag(10) ;
        bag.push(new RingedKnightArmor());
        bag.push(new DragonSlayerLeggings());
        bag.push(new ShotGun());
        System.out.println("Sac 1 :");
        System.out.println(bag);

        Bag newBag = new Bag(5) ;
        System.out.println("Sac 2 :");
        System.out.println(newBag);
        transfer(bag, newBag);
        System.out.println();
        System.out.println("Sac 2 après transfert :");
        System.out.println(newBag);

        System.out.println("Sac 1 après transfert :");
        System.out.println(bag);
    }

}
