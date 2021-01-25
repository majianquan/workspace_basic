package template_method.demo2;

public class HummerH1Model extends HummerModel {
    private boolean alarmFlag = true;
    @Override
    public void start() {
        System.out.println("悍马h1发动...");
    }

    @Override
    public void stop() {
        System.out.println("悍马h1停止...");
    }

    @Override
    public void alarm() {
        System.out.println("悍马h1鸣笛...");
    }

    @Override
    public void engineeBoom() {
        System.out.println("悍马h1引擎声音...");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }
    public void setAlarmFlag(boolean isAlarm) {
        this.alarmFlag = isAlarm;
    }
}
