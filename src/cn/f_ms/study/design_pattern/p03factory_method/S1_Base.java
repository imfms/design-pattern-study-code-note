package cn.f_ms.study.design_pattern.p03factory_method;

/**
 * 基本结构
 *
 * @author f_ms
 * @date 18-8-26
 */
public class S1_Base {

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
    }

    public static class ProductAFactory implements ProductFactory {
        @Override public Product createProduct() {
            return new ProductA();
        }
    }
    public static class ProductBFactory implements ProductFactory {
        @Override public Product createProduct() {
            return new ProductB();
        }
    }
    public static class ProductCFactory implements ProductFactory {
        @Override public Product createProduct() {
            return new ProductC();
        }
    }

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductAFactory();
        productFactory.createProduct().someMethod();
    }

}
