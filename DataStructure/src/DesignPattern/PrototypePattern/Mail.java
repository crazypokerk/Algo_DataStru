package DesignPattern.PrototypePattern;

/**
 * @Date 2019/4/8 19:12
 */
public class Mail implements Cloneable {
    //收件人
    private String reciver;
    //邮件名称
    private String subject;
    //称谓
    private String appellation;
    //邮件内容
    private String context;
    //邮件尾部
    private String tail;

    public Mail(AdvTemplate adv) {
        this.context = adv.getAdvContext();
        this.subject = adv.getAdvSubject();
    }

    @Override
    public Mail clone() {
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
