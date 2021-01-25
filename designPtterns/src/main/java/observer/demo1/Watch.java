package observer.demo1;

public class Watch extends Thread {
    private HanFeiZi hanFeiZi;
    private LiSi liSi;
    private String type;
    public Watch(HanFeiZi hanFeiZi, LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }
    @Override
    public void run() {
        while (true) {
            if(this.type.equals("breakfast")) {
                System.out.println(this.hanFeiZi.isHavingBreakfast());
                if(this.hanFeiZi.isHavingBreakfast()) {
                    this.liSi.update("韩非子在吃饭");
                    this.hanFeiZi.setHavingBreakfast(false);

                }
            } else {
                System.out.println(this.hanFeiZi.isHavingFunc());
                if(this.hanFeiZi.isHavingFunc()) {
                    this.liSi.update("韩非子在娱乐");
                    this.hanFeiZi.setHavingFunc(false);
                }
            }
        }
    }
}
