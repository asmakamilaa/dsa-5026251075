package lw01.Unguided;

public class ProjectorRental extends Rental {

    int limit = 3;
    int first3Day = 60000;
    int beyond3Days = 45000;
    int addSetupCharge = 20000;

    public ProjectorRental(String id, int days){
        super(id, days);
    }

    @Override
    public int calculateCharge(){
        int days = getDays();

        if (days <= limit) {
            return ((days * first3Day) + addSetupCharge);
        } else {
            return((3*first3Day) + (units*beyond3Days) + addSetupCharge);
        }
    }

    @Override
    public String label(){
        return "Projector";
    }
    
}
