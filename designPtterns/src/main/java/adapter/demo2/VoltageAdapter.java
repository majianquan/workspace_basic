package adapter.demo2;

public class VoltageAdapter extends Voltage220V implements IVoltage5V{
    @Override
    public int output5V() {
        int src = this.output220V();
        int det = src/ 44;
        System.out.println("输出电压为5V");
        return det;
    }
}
