package proxy.demo4;

import pattern.proxy.demo1.GamePlayer;
import pattern.proxy.demo1.IGamePlayer;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer("张三");

        GamePlayIH gamePlayIH = new GamePlayIH(gamePlayer);
        IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(gamePlayer.getClass().getClassLoader(), new Class[]{IGamePlayer.class}, gamePlayIH);
        proxy.login("zhangSan","password");
        proxy.killBoss();
        proxy.upgrade();
    }
}
