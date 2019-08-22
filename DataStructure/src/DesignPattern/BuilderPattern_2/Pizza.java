package DesignPattern.BuilderPattern_2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Date 2019/5/1 16:46
 */
public abstract class Pizza {
	public enum Topping {HAN, MUSHROOM, ONION, PEPPER, SAUSAGE}
	
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();
		
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
}
