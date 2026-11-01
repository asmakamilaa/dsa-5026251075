package lw01.Unguided.CampusEquipmentRental;

public class LaptopRental extends Rental {
    
    int idrPerDay = 40000;
    int addChargeEachUnit = 10000;
    
    public LaptopRental(String id, int days, int units){
        super(id, days, units);
    }

    @Override
    public int calculateCharge(){
        return (getDays() * idrPerDay) + addChargeEachUnit;
    }

    @Override
    public String label(){
        return "Laptop";
    }
    
}
