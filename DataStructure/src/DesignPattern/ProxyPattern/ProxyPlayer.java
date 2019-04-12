package DesignPattern.ProxyPattern;

/**
 * @Date 2019/4/6 10:04
 */
public class ProxyPlayer implements R6GamePlayer {
    private R6GamePlayer r6GamePlayer = null;

    public ProxyPlayer(R6GamePlayer r6GamePlayer) {
        this.r6GamePlayer = r6GamePlayer;
    }

    @Override
    public void loginUbisoft(String account, String passwd) {
        this.r6GamePlayer.loginUbisoft(account, passwd);
    }

    @Override
    public void teamKill() {
        this.r6GamePlayer.teamKill();
    }

    @Override
    public void clearCush() {
        this.r6GamePlayer.clearCush();
    }

    //不光完成老板任务，还能帮忙杀个人质
    public void killHostage() {
        System.out.println("我，FUZE，人质杀手，^-^");
    }
}
