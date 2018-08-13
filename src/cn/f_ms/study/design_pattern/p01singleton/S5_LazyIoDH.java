package cn.f_ms.study.design_pattern.p01singleton;

/**
 * 懒汉Initialization on Demand Holder式
 *
 * @author f_ms
 * @date 18-8-13
 */
public class S5_LazyIoDH {

    private static class SingletonHolder {
        private static final S5_LazyIoDH INSTANCE = new S5_LazyIoDH();
    }

    private S5_LazyIoDH() {}

    public static S5_LazyIoDH getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
