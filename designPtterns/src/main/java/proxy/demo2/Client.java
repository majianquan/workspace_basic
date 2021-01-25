package proxy.demo2;

public class Client {
    public static void main(String[] args) throws Exception {
        GamePlayerProxy zhagnSan = new GamePlayerProxy("李四");
        zhagnSan.login("zhangSan","password");
        zhagnSan.killBoss();
        zhagnSan.upgrade();
    }
}
