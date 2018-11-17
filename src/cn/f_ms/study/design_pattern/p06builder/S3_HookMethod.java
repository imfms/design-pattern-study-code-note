package cn.f_ms.study.design_pattern.p06builder;

/**
 * 建造者模式 钩子方法
 *
 * @author imf_m
 * @date 2018/11/17
 */
class S3_HookMethod {

    class Product {
        void initA() {}
        void initB() {}
        void initC() {}
    }

    static abstract class Builder {
        abstract void buildA();
        abstract boolean isBuildB();
        abstract void buildB();
        abstract void buildC();

        abstract Product getResult();

        public Product constract() {
            buildA();
            if (isBuildB()) {
                buildB();
            }
            buildC();
            return getResult();
        }
    }

    class ConcreateBuilder extends Builder {

        private Product product = new Product();

        @Override
        void buildA() {
            product.initA();
        }

        @Override
        boolean isBuildB() {
            return false;
        }

        @Override
        void buildB() {
            product.initB();
        }

        @Override
        void buildC() {
            product.initC();
        }

        @Override
        Product getResult() {
            return product;
        }
    }
}
