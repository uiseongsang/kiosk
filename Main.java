package Assignment;
import java.util.*;
public class Main {
    // 수정 사항!
    // 입력받을 때 문자열로 받고 int형으로 형변환!!

    private static final Scanner sc = new Scanner(System.in); // 전역변수로는 쓰지 않는다 , 여러명이 쓰다보면 변복 될수 있다
    private static int count = 0;
    private static int totalMount;
    private static final List<Order> totalOrderList = new ArrayList<>();
    private static void printMenu(Menu[] arr) {
        System.out.println();
        System.out.println("-------------- 매뉴정보 --------------");
        for(int i = 0; i < arr.length; i++){
            System.out.println((i+1) + ". " + arr[i]);
        }
        System.out.println("-------------- 주문정보 --------------");
        System.out.println("7. 주문하기     - 장바구니를 확인 하겠습니다."); // 총 장바구니
        System.out.println("8. 주문취소하기  - 진행중인 주문을 취소합니다."); // 장바구니 초기화
        System.out.println("------------------------------------");
        System.out.println("9. 종료하기  - 프로그램을 종료합니다.");
        System.out.println("0. 통계보기     - 총 판매 및 목록 조회합니다");
        System.out.println("------------------------------------");
        System.out.print("입력: ");
    }
    private static void printProduct(Product[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println((i+1) + ". " + arr[i]);
        }
        System.out.println("-------------------------------------");
    }
    private static void printOrder(List<Order> list)  {
        // 비어 있는지 체크
        if(list.isEmpty()){
            System.out.println("장바구니가 비어있습니다! 상품을 추가 해주세요");
            return;
        }
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        int total = 0;

        // 중복제거 + 카운트
        Map<Order, Integer> frequencyMap = new HashMap<>();
        for (Order order : list) {
            frequencyMap.put(order, frequencyMap.getOrDefault(order, 0) + 1);
            total += order.getPrice();
        }
        for (Map.Entry<Order, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getKey().getPrice() + " x " + entry.getValue() + "개");
        }
        System.out.println("[ Total ]");
        System.out.println("가격: " + total + "원");
        System.out.println("1. 주문      2. 메뉴판");
        int select;
        select = sc.nextInt();
        while (select != 1 && select != 2) {
            System.out.println("잘못 입력하셨습니다! ");
            System.out.println("1. 주문      2. 메뉴판");
            select = sc.nextInt();
        }
        if(select == 1) {
            // 장바구니 비우기
            totalMount += total; // 총 금액 저장
            for (Order o : list) totalOrderList.add(o);
            list.clear();
            System.out.println("주문이 완료되었습니다!");
            count++;
            System.out.println("대기번호는 [ " + count + " ] 번 입니다");
            System.out.println();
            for (int i = 3; i >= 1; i--) {
                System.out.println(i + "초후 메뉴판으로 돌아갑니다");
            }
        }
    }
    // ---------------------------------------- 메인 -------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("'김밥천국'에 오신걸 환영합니다");
        System.out.println("아래의 메뉴정보를 보시고 메뉴를 입력해주세요!");
        // Menu 객체배열
        // 추가 해주면 새로운 Product 객체배열 생성 +  118 라인에 object 배열도 추가해줘야함
        Menu[] menus = {
                new Menu("김밥", "새로지운 밥으로 만든 김밥"),
                new Menu("라면", "신라면 베이스로 끓인 라면"),
                new Menu("우동", "일본장인이 만든 우동"),
                new Menu("음료", "시원한 음료")
                //new Menu("디저트","완벽한 후식")
        };
        // Product 객체배열
        Product[] kimbob = {
                new Product("원조김밥", "그냥 일반 김밥", 2500),
                new Product("참치김밥", "참치가 들어간 김밥", 3500),
                new Product("치즈김밥", "치즈가 들어간 김밥", 3000),
                new Product("떙초김밥", "떙초가 들어간 김밥", 3200)
        };
        Product[] ramen = {
                new Product("계란라면", "계란이 들어간 라면", 4500),
                new Product("참치라면", "참치가 들어간 라면", 5500),
                new Product("김치라면", "김치가 들어간 라면", 5000),
                new Product("치즈라면", "치즈가 들어간 라면", 5500)
        };
        Product[] udon = {
                new Product("원조우동", "그냥 평범한 우동", 5500),
                new Product("해물우동", "해물이 들어간 우동", 7500),
                new Product("유부우동", "유부가 들어간 우동", 6500),
                new Product("야끼우동", "해물이 들어간 볶은 우동", 7000)
        };
        Product[] drinks = {
                new Product("콜라", "코카콜라가 아닌 펩시", 1000),
                new Product("사이다", "스프라이트가 아닌 칠성사이다", 1000),
                new Product("환타", "파인애플맛 환타", 1000),
                new Product("물", "제주도 삼다수물 ", 1000)
        };
//        Product[] dessert = {
//                new Product("케이크", "달콤한 생크림 케이크", 3000)
//        };

        Product[][] productArr = {kimbob, ramen, udon, drinks}; // 새로운 메뉴 추가시; 오브젝트도 추가해줘야함 dessert
        List<Order> orderList = new ArrayList<>();
        int selectProduct;

        while (true) {
            printMenu(menus);
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 0:
                    System.out.println("[ 총 판매금액 현황 ]");
                    System.out.println("현재까지 총 판매된 금액은 [ " + totalMount + "원 ] 입니다.");
                    System.out.println();
                    System.out.println("[ 총 판매상품 목록 현황 ]");
                    System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
                    for (Order totalOrder : totalOrderList) System.out.println(totalOrder);
                    break;
                case 1:
                    System.out.println("-------------- 김밥정보 --------------");
                    break;
                case 2:
                    System.out.println("-------------- 라면정보 --------------");
                    break;
                case 3:
                    System.out.println("-------------- 우동정보 --------------");
                    break;
                case 4:
                    System.out.println("-------------- 음료정보 --------------");
                    break;
            }

            // 1~menus.length 범위안 (1. 김밥 2. 라면 3. 우동 4.음료, 5...)
            if (selectMenu >= 1 && selectMenu <= menus.length) {
                Product[] product = productArr[selectMenu - 1];

                printProduct(product); // 선택한 상품정보 출력
                System.out.print("입력: ");
                selectProduct = sc.nextInt();

                // 각 메뉴 범위
                while (!(selectProduct >= 1) || !(selectProduct <= product.length)) {
                    System.out.println("1~4번 메뉴중에 선택해주세요");
                    selectProduct = sc.nextInt();
                }

                Product selectedProduct = product[selectProduct - 1];

                // 유저가 선택한 해당 김밥정보를 Order 쪽에 넘겨주기 -> 매번 갈아껴주는게 좋은 코드인가???
                Order order = new Order(selectedProduct.getName(), selectedProduct.getDesc(), selectedProduct.getPrice(), 1);
                System.out.println("'" + selectedProduct + "'"); // 선택 메뉴 정보 표시(이름,설명,가격)

                if (selectMenu == 2 || selectMenu == 3) {
                    // 상품옵션 기능 추가 - 곱배기 (라면,우동 한정)
                    System.out.println("곱배기를 추가하시겠습니까?");
                    System.out.println("1. 일반(+0원)   2. 곱배기(+500원)");
                    int selectOption = sc.nextInt();
                    if (selectOption == 2) {
                        order.setName(order.getName() + ("(곱배기)"));
                        order.setPrice(order.getPrice() + 500);
                        System.out.println("'" + order + "'"); // 곱배기 선택시 곱배기 가격추가된 메뉴 정보 표시(이름,설명,가격)
                    } else {
                        System.out.println("'" + order + "'");
                    } // 선택 메뉴 정보 표시(이름,설명,가격)
                }

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인         2. 취소");
                System.out.print("입력: ");
                int confirmed = sc.nextInt();

                if (confirmed == 1) {
                    orderList.add(order); // Order ArrayList
                    System.out.println("해당 상품을 장바구니에 넣었습니다!");
                } else {
                    System.out.println("해당 상품을 장바구니에 넣지 않았습니다!");
                }
            } else if (selectMenu == 7) {
                printOrder(orderList);
            } // 총 장바구니 조히
            else if (selectMenu == 8) {
                orderList.clear();
            } // 장바구니 삭제
            else if (selectMenu == 9) {
                break;
            } // 프로그램 종료
        }
        System.out.println("프로그램을 종료합니다!");
        sc.close();
    }
}
