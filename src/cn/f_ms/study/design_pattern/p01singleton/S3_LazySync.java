package cn.f_ms.study.design_pattern.p01singleton;

/**
 * 懒汉同步式
 *
 * @author f_ms
 * @date 18-8-13
 */
public class S3_LazySync {

    private static S3_LazySync sInstance;

    private S3_LazySync() {}

    public synchronized static S3_LazySync getInstance() {
        if (sInstance == null) {
            sInstance = new S3_LazySync();
        }
        return sInstance;
    }

}
