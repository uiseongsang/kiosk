package Assignment;

import java.util.Scanner;
// 수정사항: 장바구니를 조회, 상품 추가 전부 삭제 기능
public class Order extends Product{
    private static Scanner sc = new Scanner(System.in);
    private int count;
    public Order(){

    }
    public Order(String name, String desc, int price, int count){
        super(name, desc, price);
        this.count = count++;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    @Override
    public String toString() {
        return this.getName() + " - " + this.getDesc() + " - " + this.getPrice() + " x " + count + "개";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        // 다른 필드들도 고려해서 계산
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (getName() == null) {
            if (other.getName() != null)
                return false;
        } else if (!getName().equals(other.getName()))
            return false;
        // 다른 필드들도 고려해서 비교
        return true;
    }
}
