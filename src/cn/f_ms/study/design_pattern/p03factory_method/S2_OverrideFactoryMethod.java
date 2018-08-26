package cn.f_ms.study.design_pattern.p03factory_method;

/**
 * 重载的工厂方法
 *
 * @author f_ms
 * @date 18-8-26
 */
public class S2_OverrideFactoryMethod {

    public interface Product {
        void someMethod();
    }

    public static class ProductA implements Product {
        @Override public void someMethod() {
            // do something
        }
    }

    public static class ProductB implements Product {
        @Override public void someMethod() {
            // do something
        }
    }

    public static class ProductC implements Product {
        @Override public void someMethod() {
            // do something
        }
    }

    public interface ProductFactory {
        Product createProduct();
        Product createProduct(int type);
        Product createProduct(Object arg);
    }

    public static class ProductAFactory implements ProductFactory {
        @Override public Product createProduct() {
            return new ProductA();
        }

        @Override
        public Product createProduct(int type) {
            return new ProductA();
        }

        @Override
        public Product createProduct(Object arg) {
            return new ProductA();
        }
    }
    public static class ProductBFactory implements ProductFactory {
        @Override public Product createProduct() {
            return new ProductB();
        }

        @Override public Product createProduct(int type) {
            return new ProductB();
        }

        @Override public Product createProduct(Object arg) {
            return new ProductB();
        }
    }
    public static class ProductCFactory implements ProductFactory {
        @Override public Product createProduct() {
            return new ProductC();
        }

        @Override public Product createProduct(int type) {
            return new ProductC();
        }

        @Override public Product createProduct(Object arg) {
            return new ProductC();
        }
    }

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductAFactory();
        productFactory.createProduct().someMethod();
        productFactory.createProduct(1).someMethod();
        productFactory.createProduct(new Object()).someMethod();
    }

}
