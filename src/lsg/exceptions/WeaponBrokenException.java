package lsg.exceptions;

import lsg.weapons.Weapon;

public class WeaponBrokenException extends Exception {
   private Weapon weapon;

    /**
     *
     * @param weapon
     */
    public WeaponBrokenException(Weapon weapon) {

        super(weapon+" is broken ! ");
        this.weapon=weapon;
    }

    /**
     *
     * @return l'arme
     */
    public Weapon getWeapon() {
        return weapon;
    }
}
