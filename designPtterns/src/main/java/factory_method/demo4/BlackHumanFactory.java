package factory_method.demo4;

import pattern.factory_method.demo1.BlackHuman;
import pattern.factory_method.demo1.Human;

public class BlackHumanFactory extends AbstractHumanFactory{
    @Override
    public Human createHuman() {
        return  new BlackHuman();
    }
}
