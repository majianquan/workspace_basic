package proxy.demo2;

import pattern.proxy.demo1.IGamePlayer;

public class GamePlayerProxy implements IGamePlayer{
    private IGamePlayer gamePlayer;

    public GamePlayerProxy(String name) throws Exception {
        this.gamePlayer = new GamePlayer(this,name);
    }

    @Override
    public void login(String user, String password) {
         this.gamePlayer.login(user,password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
