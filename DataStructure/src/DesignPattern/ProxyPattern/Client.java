package DesignPattern.ProxyPattern;

/**
 * @Date 2019/4/6 10:11
 */
public class Client {
    public static void main(String[] args) {
        R6GamePlayer r6GamePlayer = new BossPlayer("Fuze");
        R6GamePlayer proxy = new ProxyPlayer(r6GamePlayer);

        proxy.loginUbisoft("fuckUbi", "thanksUbi");
        proxy.teamKill();
        proxy.clearCush();
        ((ProxyPlayer) proxy).killHostage();
    }
}
