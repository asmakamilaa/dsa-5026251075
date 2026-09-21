package CampusPrintingService;
public class MonoPrint extends PrintJob{

    int idrPerPage = 500;

    public MonoPrint(String id, int pages){
        super(id, pages); //manggil constructor parent class PrintJob
    }

    @Override
    public int calculateCharge(){
        return getPages() * idrPerPage;
    }

    @Override
    public String label(){
        return "Mono";
    }
}