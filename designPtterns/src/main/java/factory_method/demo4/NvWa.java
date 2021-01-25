package factory_method.demo4;

import pattern.factory_method.demo1.Human;

public class NvWa {
    public static void main(String[] args) {
        Human whiteHuman = (new WhiteHumanFactory()).createHuman();
        whiteHuman.getColor();


        Human BlackHuman = (new BlackHumanFactory()).createHuman();
        BlackHuman.getColor();
    }
}
