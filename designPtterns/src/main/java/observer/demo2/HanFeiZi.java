package observer.demo2;

public class HanFeiZi implements IHanFeiZi {
    private ILiSi liSi = new LiSi();
    @Override
    public void haveBreakfast() {
        System.out.println("韩非子: 开始吃饭了...");
        liSi.update("韩非子在吃饭");
    }

    @Override
    public void haveFunc() {
        System.out.println("韩非子: 开始娱乐了...");
        liSi.update("韩非子在娱乐");
    }
}
