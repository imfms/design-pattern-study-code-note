package cn.f_ms.study.design_pattern.p01singleton;

/**
 * 懒汉双重检查锁式
 *
 * @author f_ms
 * @date 18-8-13
 */
public class S4_LazyDoubleCheckLocking {

    private static S4_LazyDoubleCheckLocking sInstance;

    private S4_LazyDoubleCheckLocking() {}

    public static S4_LazyDoubleCheckLocking getInstance() {

        if (sInstance == null) {
            synchronized (S4_LazyDoubleCheckLocking.class) {
                if (sInstance == null) {
                    sInstance = new S4_LazyDoubleCheckLocking();
                }
            }
        }

        return sInstance;
    }

}
