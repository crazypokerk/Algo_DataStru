package Threaddddd;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Date 2019/4/1 12:56
 */
public class MutilThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfo = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo t :
                threadInfo) {
            System.out.println("[" + t.getThreadId() + "]" + t.getThreadName());
        }
    }
}
