package Assignment;

public class Product extends Menu {
    private int price;
    public Product(){

    }
    public Product(String name, String desc, int price){
        super(name,desc);
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    @Override
    public String toString() {
        return this.getName() + "   - " + this.getDesc() + "   - " + this.price;
    }
}
