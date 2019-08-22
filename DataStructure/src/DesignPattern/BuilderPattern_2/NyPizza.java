package DesignPattern.BuilderPattern_2;

import java.util.Objects;

/**
 * @Date 2019/5/1 16:50
 */
public class NyPizza extends Pizza {
	public enum Size {SMALL, MEDIUM, LARGE}
	
	private final Size size;
	
	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;
		
		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}
		
		@Override
		public NyPizza build() {
			return new NyPizza(this);
		}
		
		@Override
		protected Builder self() {
			return this;
		}
	}
	
	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
}
