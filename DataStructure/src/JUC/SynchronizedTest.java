package JUC;

public class SynchronizedTest {
  private Object obj = new Object();

  void synThis() {
    synchronized (this) {
      System.out.println("synchronized this 锁！");
      System.out.println(Thread.currentThread().getName());
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
//
//  synchronized void synMethod() {
//      System.out.println("synchronized 方法 锁！");
//    System.out.println(Thread.currentThread().getName());
//    try {
//      Thread.sleep(3000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void synOtherObj() {
//    synchronized (obj) {
//      System.out.println("synchronized 对象 锁！");
//      System.out.println(Thread.currentThread().getName());
//    }
//    try {
//      Thread.sleep(3000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//  }


//  static synchronized void synStaticClass() {
//      System.out.println("synchronized 方法 类锁！");
//      System.out.println(Thread.currentThread().getName());
//    try {
//      Thread.sleep(3000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//  }

  void synClass() {
    synchronized (Object.class) {
      for (int q = 0; q < 10; q++) {
        System.out.println("synchronized 类 锁！");
        System.out.println(Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

class Test {
  public static void main(String[] args) {
    SynchronizedTest st = new SynchronizedTest();
    SynchronizedTest st1 = new SynchronizedTest();
//    new Thread(() -> {
//      for (int q = 0; q < 10; q++) {
//        st.synThis();
//      }
//    }, "t1").start();
//
//    new Thread(() -> {
//      for (int q = 0; q < 10; q++) {
//        st1.synThis();
//      }
//    }, "t2").start();
//
//    new Thread(()->{
//      for (int q = 0; q < 10; q++) {
//        st.synOtherObj();
//      }
//    },"t3").start();

//    new Thread(()->{
//      for (int q = 0; q < 10; q++) {
//        SynchronizedTest.synStaticClass();
//      }
//    },"t4").start();
//
    new Thread(() -> {

      st.synClass();

    }, "t5---st").start();

    new Thread(() -> {

      st1.synClass();

    }, "t6").start();
  }
}
