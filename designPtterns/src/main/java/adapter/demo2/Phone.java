package adapter.demo2;

public class Phone {
    public void charging(IVoltage5V iVoltage5V) {
        int detV = iVoltage5V.output5V();
        if(detV == 5) {
            System.out.println("可以充电..");
        } else if(detV > 5) {
            System.out.println("电压过大...");
        }
    }
}
