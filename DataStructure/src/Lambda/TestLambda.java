package Lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date 2019/7/18 9:53
 */
/*
 * java8 内置的四大核心函数式接口
 * Consumer<T> : 消费型接口
 * Supplier<T> ：供给型接口
 * Function<T,R> ：函数型接口
 * Predicate<T> ：断言型接口
 *
 */
public class TestLambda {
	@Test
	public void testConsumer() {
		consumer(999, money -> System.out.println(money * 100));
	}
	
	@Test
	public void testSupplier() {
		Integer supplier = supplier(() -> {
			String str = "123";
			Integer integer = Integer.valueOf(str);
			System.out.println(integer);
			return integer;
		});
	}
	
	@Test
	public void testFunction() {
		function("112341342", (String x) -> Integer.valueOf(x.substring(1, 5)));
	}
	
	@Test
	public void testPredicate() {
		boolean flag = predicate("rrrrr", (String x) -> x.length() > 5);
		System.out.println(false);
	}
	
	public boolean predicate(String str, Predicate<String> predicate) {
		return predicate.test("aaa");
	}
	
	public void function(String str, Function<String, Integer> function) {
		Integer apply = function.apply(str);
		System.out.println(apply);
	}
	
	public Integer supplier(Supplier<Integer> supplier) {
		Integer S = supplier.get();
		return S;
	}
	
	public void consumer(int money, Consumer<Integer> consumer) {
		consumer.accept(money);
	}
	
	@Test
	public void test() {

//		Consumer<Integer> con = x -> System.out.println(x * x);
//
//		con.accept(123);
//
//		Predicate<String> predicate = str -> str.equals("aaa");
//
//		predicate.test("aaa");
//
//		Supplier supplier = () -> new Date();
//		Date date = (Date) supplier.get();
//		System.out.println(date);
//
//		List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());
//
//		collect.forEach(System.out::print);
		
		List<String> collected = Stream.of("fuck", "u", "baby")
				.map(str -> str.toLowerCase()).collect(Collectors.toList());
		
		
		collected.forEach(System.out::println);
		
		
	}
	
	@Test
	public void test1() {
		Consumer<String> c = a -> System.out.println(a);
		
		c.accept("fuck");
		
		Function<Integer, Integer> triple = x -> x * 3;
		Function<Integer, Integer> square = x -> x * x;
		
		Integer a = triple.apply(10);
		System.out.println(a);
		
		Function<Integer, Function<Integer, Integer>> plus = x -> y -> x + y;
		
		Integer result = plus.apply(12).apply(15);
		System.out.println(result);
		
		Function<
				Function<Integer, Integer>,
				Function<
						Function<Integer, Integer>, Function<Integer, Integer>>> com =
				x -> y -> z -> x.apply(y.apply(z));
		
		Function<Integer, Integer> apply = com.apply(square).apply(triple);
		Integer res = apply.apply(2);
		System.out.println(res);
	}
	
	@Test
	public void test2() {
		Function<Double, Double> sin = Math::sin;
	}
	
	static <T, U, V> Function<
			Function<T, U>,
			Function<Function<V, T>,
					Function<V, U>>> higherCompose() {
		return tuFunc -> uvFunc -> t -> tuFunc.apply(uvFunc.apply(t));
		
	}
	
	
	<A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> func() {
		return a -> b -> c -> d -> String.format("%s %s %s %s", a, b, c, d);
	}
	
	final Pattern emailPattern = Pattern.compile("^[a-z]");
	final Function<String, Boolean> emailChecker = s -> emailPattern.matcher(s).matches();
	
	void testMail(String email) {
		if (emailChecker.apply(email)) {
			// send
		} else {
			// logger.error
		}
	}
	
	
}
