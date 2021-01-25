package factory_method.demo4;

import pattern.factory_method.demo1.Human;
import pattern.factory_method.demo1.WhiteHuman;

public class WhiteHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createHuman() {
        return new WhiteHuman();
    }
}
