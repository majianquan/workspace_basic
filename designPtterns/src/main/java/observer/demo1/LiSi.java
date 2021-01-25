package observer.demo1;

public class LiSi implements ILiSi {
    @Override
    public void update(String str) {
        System.out.println("李斯: 观察到韩非子活动,开始向老板汇报了...");
        this.reportToQinShiHuang(str);
        System.out.println("李斯: 汇报完毕...\n");
    }

    private void reportToQinShiHuang(String str) {
        System.out.println("李斯: 报告,秦老板!韩非子有活动了 ---> " + str);
    }
}
