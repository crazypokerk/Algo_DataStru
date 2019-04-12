package DesignPattern.ObserverPattren;

/**
 * @Date 2019/4/12 9:04
 */
public class WangSiTu implements Observer {
    //王司徒视诸葛亮为不共戴天之敌
    @Override
    public void update(String context) {
        System.out.println("王司徒：观察到诸葛亮有动作，要准备报告曹丞相...");
        this.reportToCaoCao(context);
        System.out.println("王司徒：汇报完毕...\n");
    }

    //汇报给曹操
    public void reportToCaoCao(String reportContext) {
        System.out.println(reportContext + "！" + "王司徒：报告，丞相！诸葛村夫有动作了！！！");
    }
}
