package CampusPrintingService;
abstract public class PrintJob implements Chargeable{
    private String id; //di soal bersimbol (-) yang artinya private
    private int pages;

    protected PrintJob(String id, int pages){ //use protected karena use (#)
        if (pages <= 0) {
            throw new IllegalArgumentException("Number of pages must be greater than zero.");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId(){ //getter
        return id;
    }

    public int getPages(){ //getter
        return pages;
    }
    
    @Override //karena ada calculateCharge di interface Chargeable, maka harus di override
    public abstract int calculateCharge(); //tidak perlu body karena abstract, akan di implement di subclass
   
    //overloading
    public int calculateCharge(int copies){
        if(copies <= 0) {
            throw new IllegalArgumentException("Number of copies must be greater than zero.");
        }
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}