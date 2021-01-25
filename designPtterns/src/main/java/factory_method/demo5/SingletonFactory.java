package factory_method.demo5;

import java.lang.reflect.Constructor;

public class SingletonFactory  {
    private static Singleton singleton;
    static {
        try {
            Class cl = Class.forName(Singleton.class.getName());
            // 获得无参构造
            Constructor constructor = cl.getDeclaredConstructor();
            // 设置无参构造可访问
            constructor.setAccessible(true);
            // 创建对象
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            // 异常处理
        }
    }
    public static Singleton getInstance(){
        return singleton;
    }
}
