package observer.demo1;

public class HanFeiZi implements IHanFeiZi{
    private boolean isHavingBreakfast = false;
    private boolean isHavingFunc = false;
    @Override
    public void haveBreakfast() {
        System.out.println("韩非子: 开始吃饭了...");
        this.isHavingBreakfast = true;
    }

    @Override
    public void haveFunc() {
        System.out.println("韩非子: 开始娱乐了...");
        this.isHavingFunc = true;
    }

    public boolean isHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setHavingBreakfast(boolean havingBreakfast) {
        this.isHavingBreakfast = havingBreakfast;
    }

    public boolean isHavingFunc() {
        return isHavingFunc;
    }

    public void setHavingFunc(boolean havingFunc) {
        this.isHavingFunc = havingFunc;
    }
}
