package observer.demo2;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFunc();
    }
}
