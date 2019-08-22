package Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Date 2019/7/18 15:04
 */
/*
 * 一、方法引用：在 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 * 			（可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *
 * 	主要有三种语法格式：
 * 		对象::实例方法名
 * 		类::静态方法名
 * 		类::实例方法名
 * 	注意：
 * 		① Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表
 * 			和返回值类型保持一致 ！
 * 		② 若 Lambda 参数列表中的第一参数是实例方法的调用者，而第二个参数是实例方法的参数时，
 * 			可以使用 类::实例方法名 ！
 *
 *  二、构造器引用
 * 	class_name::new
 * 		注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致 ！
 *
 *  三、数组引用
 * 	type[]::new
 */
public class TestMethodReference {
	
	@Test
	public void test1() {
		//Consumer<String> consumer = (x) -> System.out.println(x);
		Consumer<String> consumer = System.out::println;
		consumer.accept("wq");
	}
	
	@Test
	public void test2() {
		Comparator<Integer> comparator = Integer::compare;
		int compare = comparator.compare(1, 4);
		System.out.println(compare);
	}
	
	@Test
	public void test3() {
		// BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
		BiPredicate<String, String> biPredicate = String::equals;
		boolean test = biPredicate.test("a", "b");
		System.out.println(test);
	}
	
	@Test
	public void test4() {
		Supplier<Date> supplier = () -> new Date();
		
		// 构造器引用方式
		Supplier<Date> supplier1 = Date::new;
		Date date = supplier1.get();
		System.out.println(date);
		
		Function<Integer, Date> function = x -> new Date(x);
		
		Function<Integer, Date> function1 = Date::new;
		Date apply = function1.apply(1);
		System.out.println(apply);
	}
	
	@Test
	public void test5() {
		Function<Integer, String[]> function = x -> new String[x];
		String[] apply = function.apply(10);
		System.out.println(apply.length);
		
		Function<Integer, int[]> function1 = int[]::new;
		int[] apply1 = function1.apply(100);
		System.out.println(apply1.length);
	}
}
