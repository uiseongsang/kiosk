package Assignment;

public class Product extends Menu {
    private double price;
    public Product(){

    }
    public Product(String name, String desc, double price){
        super(name,desc);
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    @Override
    public String toString() {
        return this.getName() + "   - " + this.getDesc() + "   - " + this.price;
    }
}
