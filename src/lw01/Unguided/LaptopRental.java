package lw01.Unguided;

public class LaptopRental extends Rental {
    
    int idrPerDay = 40000;
    int addChargeEachUnit = 10000;
    
    public LaptopRental(String id, int days){
        super(id, days);
    }

    @Override
    public int calculateCharge(){
        return ((getDays() * idrPerDay) + addChargeEachUnit) * units;
    }

    @Override
    public String label(){
        return "Laptop";
    }
    
}
