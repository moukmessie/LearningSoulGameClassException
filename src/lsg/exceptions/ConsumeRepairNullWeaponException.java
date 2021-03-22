package lsg.exceptions;

public class ConsumeRepairNullWeaponException extends Exception{
    public ConsumeRepairNullWeaponException() {
        super( "Trying to repair null weapon ! ");
    }
}
