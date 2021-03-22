package lsg.exceptions;

public class StaminaEmptyException extends ConsumeException{
    public StaminaEmptyException() {
        super("no stamina ! ");
    }
}
