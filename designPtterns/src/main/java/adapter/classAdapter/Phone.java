package adapter.classAdapter;

public class Phone {
	// 充电
	public void charging(IVoltage5V iVoltage5V) {
		if(iVoltage5V.output5V() == 5) {
			System.out.println("电压为5伏充电正常");
		} else if(iVoltage5V.output5V() > 5) {
			System.out.println("电压超过5V , 无法充电");
		}
	}
}
