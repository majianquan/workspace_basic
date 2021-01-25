package proxy.demo3;

public class GamePlayerProxy implements IGamePlayer , IPayMoney{
    private IGamePlayer gamePlayer;

    public GamePlayerProxy(IGamePlayer gamePlayer)  {
        this.gamePlayer = gamePlayer;
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
        this.costMoney();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }

    @Override
    public void costMoney() {
        System.out.println("消费150块");
    }
}
