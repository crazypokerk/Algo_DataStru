import java.util.*;

/**
 * @Date 2019/6/16 21:35
 */
public class Test {
	
	public static void main(String[] args) {


//    class person{
//      int age;
//      String name;
//
//      person(int age, String name) {
//        this.age = age;
//        this.name = name;
//      }
//
//      public int getAge() {
//        return age;
//      }
//
//      public void setAge(int age) {
//        this.age = age;
//      }
//
//      public boolean equals(Object obj) {
//        person p = (person) obj;
//        return p.age == ((person) obj).age;
//      }
//
//      public int hashCode() {
//        return name.hashCode() ^ age;
//      }
//    }
//
//    person p1 = new person(11,"x");
//    person p2 = new person(11,"x");
//    System.out.println(p1.hashCode());
//    System.out.println(p2.hashCode());
//    System.out.println(p1.equals(p2));


//    int i = 1;
//    double f = 2.3;
//
//    i = (int) (i + f);
//    System.out.println(i);
//    i += f;
//    System.out.println(i);
//
//    double d = 12.3;
//    double v = ++d;
//    System.out.println(v);
//
//
//    String s = "a";
//
//    switch (s) {
//      case "a":
//        System.out.println("a");
//        break;
//      case "b":
//        System.out.println("b");
//        break;
//      case "c":
//        System.out.println("c");
//        break;
//      default:
//        System.out.println("fuck");
//    }


//		String s = "[(]";
//		String ss = "{{}}[[]]";
//		int valid = isValid(s);
//		int valid1 = isValid(ss);
//
//		System.out.println(valid);
//		System.out.println(valid1);
		
		int[] a = new int[8];
		Arrays.fill(a, 8);
		
		for (int i : a) {
			System.out.print(i);
		}
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String[] strings = list.toArray(new String[list.size()]);
		
		for (String string : strings) {
			System.out.println(string);
		}
		
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = str2.intern();
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		
	}
	
}



