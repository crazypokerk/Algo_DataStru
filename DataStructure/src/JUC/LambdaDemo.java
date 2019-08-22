package JUC;

/**
 * @Date 2019/5/9 10:13
 * 1.拷贝中括号+写死右箭头+落地大括号
 * 2.函数式接口：一个接口里面有且仅有一个方法的接口，才可以使用Lambda
 * 3.@FunctionalInterface
 * 4.default默认方法实现，JDK1.8
 * 5.静态方法实现，接口中
 */
public class LambdaDemo {
	public static void main(String[] args) {
//    Foo foo = new Foo() {
//      @Override
//      public void sayHello() {
//        System.out.println("fuck me bitch!");
//      }
//    };

//    Foo foo = () -> {System.out.println("fuck me bitch!");};
//    foo.sayHello();
		Foo foo = (x, y) -> {
			return x + y;
		};
		int res = foo.add(3, 4);
		System.out.println(res);
	}
}

interface Foo {
	//void sayHello();
	
	int add(int x, int y);
	
	default int div(int x, int y) {
		return x / y;
	}
	
	public static int sub(int x, int y) {
		return x - y;
	}
	
	//void sayFuck();
}
