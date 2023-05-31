package Assignment;

import java.util.Scanner;
// 수정사항: 장바구니를 조회, 상품 추가 전부 삭제 기능
public class Order extends Product{
    private static Scanner sc = new Scanner(System.in);
    private int count;
    public Order(){

    }
    public Order(String name, String desc, double price, int count){
        super(name, desc, price);
        this.count = count;
    }
    // 없애기!
    public int confirmOreder(){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인         2. 취소");
        System.out.print("입력: ");
        int selectOrder = sc.nextInt();

        return selectOrder;
    }
    @Override
    public String toString() {
        return this.getName() + "   - " + this.getDesc() + "   - " + this.getPrice() + " x " + count;
    }
}
