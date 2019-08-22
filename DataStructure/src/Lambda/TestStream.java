package Lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @Date 2019/7/18 16:01
 */
/*
 * 	一、Stream 的三个操作步骤
 * 		1.创建 Stream
 * 		2.中间操作
 * 		3.终止操作（终端操作）
 */
public class TestStream {
	//创建 Stream
	@Test
	public void test() {
		// 1.可以通过 Collection 系列集合提供的 stream() 或 parallelStream() 创建
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		Stream<String> para = list.parallelStream();
		
		// 2.通过 Arrays 中的静态方法 stream() 获取数组流
		Date[] dates = new Date[10];
		Stream<Date> dateStream = Arrays.stream(dates);
		
		// 3.通过 Stream 类中的静态方法 of()
		Stream<String> stringStream = Stream.of("aa", "bb", "cc");
		
		// 4.创建无限流
		// 迭代
		Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
		iterate.limit(10);
		iterate.forEach(System.out::println);
		
		// 生成
		Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
		
		
	}
	
	@Test
	public void test1() {
		Optional<String> a = Optional.of("a");
		assertEquals("a", a.get());
		
		Optional emptyOptional = Optional.empty();
		Optional alsoEmpty = Optional.ofNullable(null);
		
		assertFalse(emptyOptional.isPresent());
		
		assertTrue(a.isPresent());
		
		int[] bb = {123, 3213, 5, 67, 94};
		
		
	}
	
	@Test
	public void test2() {
	
	}
}
