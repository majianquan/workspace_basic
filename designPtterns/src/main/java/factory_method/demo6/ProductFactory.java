package factory_method.demo6;

import pattern.factory_method.demo2.ConcreteProduct1;
import pattern.factory_method.demo2.ConcreteProduct2;
import pattern.factory_method.demo2.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    private static final Map<String, Product> prMap = new HashMap();
    public static synchronized Product createProduct(String type) throws Exception{
        Product product = null;
        if(prMap.containsKey(type)) {
            product = prMap.get(type);
        } else {
            if(type.equals("Product1")) {
                product = new ConcreteProduct1();
            } else {
                product = new ConcreteProduct2();
            }
        }
        return product;
    }
}
