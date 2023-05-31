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
    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name){
        super.setName(name);
    }

    @Override
    public String toString() {
        return this.getName() + "   - " + this.getDesc() + "   - " + this.price + "원";
    }
}
