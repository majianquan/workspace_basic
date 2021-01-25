package factory_method.demo4;
import pattern.factory_method.demo1.Human;

/**
 * 多工厂模式
 */
public abstract class AbstractHumanFactory {
    public abstract Human createHuman();
}
