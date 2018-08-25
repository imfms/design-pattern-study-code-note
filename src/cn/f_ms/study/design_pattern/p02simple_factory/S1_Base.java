package cn.f_ms.study.design_pattern.p02simple_factory;

/**
 * 基本结构
 *
 * @author f_ms
 * @date 18-8-25
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

    public static class ProductFactory {
        public static Product createProduct(String productName) {
            switch (productName) {
                case "A":
                    return new ProductA();
                case "B":
                    return new ProductB();
                case "C":
                    return new ProductC();
                default:
                    throw new RuntimeException("unknown product");
            }
        }
    }

    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("B");
        product.someMethod();
    }

}
