package proxy.demo1;

public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("张三");
        player.login("zhangSan","password");
        player.killBoss();
        player.upgrade();
    }
}
