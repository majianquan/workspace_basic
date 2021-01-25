package proxy.demo3;

public class Client {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("张三");
//        IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
        IGamePlayer proxy = gamePlayer.getProxy();
        proxy.login("zhangSan","password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
