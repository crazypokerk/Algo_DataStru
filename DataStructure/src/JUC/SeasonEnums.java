package JUC;

public enum SeasonEnums {
	SPRING(1, "春"), SUMMMER(2, "夏"), FALL(3, "秋"), WINTER(4, "冬");
	private Integer n;
	private String seas;
	
	SeasonEnums(Integer n, String seas) {
		this.n = n;
		this.seas = seas;
	}
	
	public Integer getN() {
		return n;
	}
	
	public void setN(Integer n) {
		this.n = n;
	}
	
	public String getSeas() {
		return seas;
	}
	
	public void setSeas(String seas) {
		this.seas = seas;
	}
	
	public static SeasonEnums foreachSeasons(Integer index) {
		for (SeasonEnums s : values()) {
			if (s.getN() == index) {
				return s;
			}
		}
		return null;
	}
}
