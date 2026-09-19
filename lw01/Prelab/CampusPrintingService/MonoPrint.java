package CampusPrintingService;
public class MonoPrint extends PrintJob{

    int idrPerPage = 500;

    public MonoPrint(String id, int pages){
        super(id, pages);
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