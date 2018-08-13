package cn.f_ms.study.design_pattern.p01singleton;

/**
 * 懒汉式
 *
 * @author f_ms
 * @date 18-8-13
 */
public class S2_Lazy {

    private static S2_Lazy sInstance;

    private S2_Lazy() {}

    public static S2_Lazy getInstance() {
        if (sInstance == null) {
            sInstance = new S2_Lazy();
        }
        return sInstance;
    }

}
