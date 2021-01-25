package factory_method.demo2;

public  abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
