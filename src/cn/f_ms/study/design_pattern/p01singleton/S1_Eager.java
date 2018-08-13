package cn.f_ms.study.design_pattern.p01singleton;

/**
 * 饿汉式
 *
 * @author f_ms
 * @date 18-8-13
 */
public class S1_Eager {

    private final static S1_Eager sInstance = new S1_Eager();

    private S1_Eager() {}

    public static S1_Eager getInstance() {
        return sInstance;
    }

}
