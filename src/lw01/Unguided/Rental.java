package lw01.Unguided;

abstract public class Rental implements Chargeable{
    private String id;
    private int days;

    protected Rental(String id, int days){
        if (days <= 0) {
            throw new IllegalArgumentException("Number of days must be greater than zero.");
        }
        this.id = id;
        this.days = days;
    }

    public String getId(){ //getter
        return id;
    }

    public int getDays(){ //getter
        return days;
    }
    
    @Override //karena ada calculateCharge di interface Chargeable, maka harus di override
    public abstract int calculateCharge(); //tidak perlu body karena abstract, akan di implement di subclass
   
    //overloading
    public int calculateCharge(int units){
        if(units <= 0) {
            throw new IllegalArgumentException("Number of units must be greater than zero.");
        } else {
            return units * calculateCharge();
        }
    }

    public String label(){
        return "Rental";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}
