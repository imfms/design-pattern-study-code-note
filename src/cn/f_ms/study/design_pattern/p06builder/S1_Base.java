package cn.f_ms.study.design_pattern.p06builder;

/**
 * 建造者模式 基本实现
 *
 * @author imf_m
 * @date 2018/11/17
 */
class S1_Base {

    class Product {
        void initA() {

        }
        void initB() {

        }
        void initC() {

        }
    }

    abstract class Builder {
        abstract void buildA();
        abstract void buildB();
        abstract void buildC();
        abstract Product getResult();
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

    class Director {

        private final Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product constract() {
            builder.buildA();
            builder.buildB();
            builder.buildC();
            return builder.getResult();
        }
    }

}
