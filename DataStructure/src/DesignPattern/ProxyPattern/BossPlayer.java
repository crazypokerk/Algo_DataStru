package DesignPattern.ProxyPattern;

/**
 * @Date 2019/4/6 10:06
 */
public class BossPlayer implements R6GamePlayer {
    private String name = "";

    public BossPlayer(String name) {
        this.name = name;
    }

    @Override
    public void loginUbisoft(String account, String passwd) {
        System.out.println("登录名为：" + account + "密码为：" + passwd);
    }

    @Override
    public void teamKill() {
        System.out.println("爆头队友，一爆一个准！");
    }

    @Override
    public void clearCush() {
        System.out.println("开包开包，开50包！墨冰必中！");
    }
}
