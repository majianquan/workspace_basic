package singleton.demo3;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    private static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
