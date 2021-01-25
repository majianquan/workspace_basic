package bridge;

public class FoldedPhone extends Phone {
	public FoldedPhone(Brand brand) {
		super(brand);
	}
	public void open() {
		super.open();
		System.out.println("折叠样式打开手机");
	}
	public void close() {
		super.open();
		System.out.println("折叠样式关闭手机");
	}

}
