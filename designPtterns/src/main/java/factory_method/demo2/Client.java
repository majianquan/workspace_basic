package factory_method.demo2;

public class Client {
    public static void main(String[] args) {
        Creator concreteCreator = new ConcreteCreator();
        ConcreteProduct1 product = concreteCreator.createProduct(ConcreteProduct1.class);
        product.method2();

        ConcreteProduct2 product1 = concreteCreator.createProduct(ConcreteProduct2.class);
        product1.method2();
    }
}
