package Test;

/**
 * @Date 2019/7/28 19:09
 */
public class ABClass implements Ainterface, Binterface {
	@Override
	public void rock() {
		Ainterface.super.rock();
	}
}
