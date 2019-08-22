package DesignPattern.FlyweightPattern;

/**
 * @Date 2019/4/15 13:55
 */
public class Client {
	public static void main(String[] args) {
		//初始化对象池
		for (int i = 0; i < 3; i++) {
			String model = "比赛模式" + i;
			//初始化比赛地图
			for (int j = 0; j < 10; j++) {
				String map = model + "比赛地图" + j;
				SpecialForceFactory.getSpecialForceInfo(map);
			}
		}
		SpecialForceInfo specialForceInfo = SpecialForceFactory.getSpecialForceInfo("比赛模式3比赛地图5");
	}
}
