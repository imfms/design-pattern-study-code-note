package cn.f_ms.study.design_pattern.p06builder;

/**
 * 建造者模式 移除指挥者
 *
 * @author imf_m
 * @date 2018/11/17
 */
class S2_RemoveDirector {

    class Product {
        void initA() {}
        void initB() {}
        void initC() {}
    }

    static abstract class Builder {
        abstract void buildA();
        abstract void buildB();
        abstract void buildC();

        abstract Product getResult();

        public Product constract() {
            buildA();
            buildB();
            buildC();
            return getResult();
        }

        public static Product staticConstract(Builder builder) {
            builder.buildA();
            builder.buildB();
            builder.buildC();
            return builder.getResult();
        }
    }

    class ConcreateBuilder extends Builder {

        private Product product = new Product();

        @Override
        void buildA() {
            product.initA();
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
