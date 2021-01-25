package proxy.demo1;

public class Client1 {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(player);
        gamePlayerProxy.login("zhangSan","password");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();
    }
}
