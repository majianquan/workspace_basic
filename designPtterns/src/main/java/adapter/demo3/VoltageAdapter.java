package adapter.demo3;

public class VoltageAdapter implements IVoltage5V{
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int des = this.voltage220V.output220V() / 44;
        System.out.println("输出电压为5V");
        return des;
    }
}
