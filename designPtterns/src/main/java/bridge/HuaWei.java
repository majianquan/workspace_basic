package bridge;

public class HuaWei implements Brand{
	@Override
	public void call() {
		System.out.println("华为手机打电话");
	}
	@Override
	public void open() {
		System.out.println("华为手开机");
	}

	@Override
	public void close() {
		System.out.println("华为手机关机");
	}
}