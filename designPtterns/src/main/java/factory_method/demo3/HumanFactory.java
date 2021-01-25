package factory_method.demo3;

import pattern.factory_method.demo1.Human;

/**
 * 简单工厂方法
 */
public class HumanFactory {
    public static <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {

        }
        return (T)human;
    }
}
