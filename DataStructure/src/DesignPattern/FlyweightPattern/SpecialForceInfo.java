package DesignPattern.FlyweightPattern;

/**
 * @Date 2019/4/15 13:45
 */
public abstract class SpecialForceInfo {
	//干员ID
	private int id;
	//干员技能
	private String skill;
	//比赛地图
	private String map;
	//比赛模式
	private String model;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSkill() {
		return skill;
	}
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public String getMap() {
		return map;
	}
	
	public void setMap(String map) {
		this.map = map;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
}
