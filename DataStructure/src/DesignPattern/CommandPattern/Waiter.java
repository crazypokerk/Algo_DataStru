package DesignPattern.CommandPattern;

/**
 * @Date 2019/4/13 18:42
 */
public class Waiter {
	private Breakfast changFen, hunDun, youTiao;
	
	public void setChangFen(Breakfast changFen) {
		this.changFen = changFen;
	}
	
	public void setHunDun(Breakfast hunDun) {
		this.hunDun = hunDun;
	}
	
	public void setYouTiao(Breakfast youTiao) {
		this.youTiao = youTiao;
	}
	
	public void chooseChangFen() {
		changFen.cooking();
	}
	
	public void chooseHunDun() {
		hunDun.cooking();
	}
	
	public void chooseYouTiao() {
		youTiao.cooking();
	}
}
