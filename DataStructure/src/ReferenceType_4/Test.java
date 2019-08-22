package ReferenceType_4;

import java.lang.ref.SoftReference;

public class Test {
	
	public void test1() {
		MyObject obj = new MyObject();
		SoftReference sf = new SoftReference(obj);
		obj = null;
		System.gc();
	}
}

class MyObject {

}
