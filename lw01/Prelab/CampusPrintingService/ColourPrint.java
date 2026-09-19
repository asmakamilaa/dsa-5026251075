package CampusPrintingService;
public class ColourPrint extends PrintJob{

    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    int limit = 10;
    int first10Pages = 1500;
    int perPageBeyond10 = 1000;
    int addPerCompleteCopy = 2000;

    @Override
    public int calculateCharge(){
        int pages = getPages();

        int first10Charge = Math.min(pages, limit);
        int extraPages = Math.max(pages - limit, 0);

        return (first10Charge * first10Pages) + (extraPages * perPageBeyond10) + addPerCompleteCopy;
    }

    @Override
    public String label(){
        return "Colour";
    }
}