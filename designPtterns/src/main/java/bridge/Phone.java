package bridge;

public abstract class Phone {
	private Brand brand;

	public Phone(Brand brand) {
		this.brand = brand;
	}
	protected void open(){
		this.brand.open();
	}
	protected void close(){
		this.brand.close();
	}
	protected void call(){
		this.brand.call();
	}
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
