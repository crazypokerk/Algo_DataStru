package DynamicProxy;

/**
 * @Date 2019/6/29 9:05
 */
public class AccountLoginImpl implements login {
	@Override
	public void accountLogin() {
		System.out.println("账户登录。。。");
		System.out.println("登录成功！");
	}
}
