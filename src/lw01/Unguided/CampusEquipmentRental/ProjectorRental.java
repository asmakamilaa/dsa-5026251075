package lw01.Unguided.CampusEquipmentRental;

public class ProjectorRental extends Rental {
    
    int limit = 3;
    int first3DaysCharge = 60000;
    int beyond3DaysCharge = 45000;
    int addSetupCharge = 20000;
    
    public ProjectorRental(String id, int days, int units){
        super(id, days, units);
    }

    @Override
    public int calculateCharge(){
        int days = getDays();

        if (days <= limit) {
            return days*first3DaysCharge + addSetupCharge;
        } else {
            return (limit*first3DaysCharge) + ((days-limit)*beyond3DaysCharge) + addSetupCharge;
        }
    }

    @Override
    public String label(){
        return "Projector";
    }
    
}