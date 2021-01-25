package observer.demo3;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(new LiSi());
        hanFeiZi.haveBreakfast();
        hanFeiZi.haveFunc();
    }
}
