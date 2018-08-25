package cn.f_ms.study.design_pattern.p02simple_factory;

/**
 * 简单结构
 *
 * @author f_ms
 * @date 18-8-25
 */
public class S2_Simple {

    public interface Product {

        static Product createProduct(String productName) {
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

        void someMethod();
    }

    public static class ProductA implements Product {
        @Override
        public void someMethod() {
            // do something
        }
    }

    public static class ProductB implements Product {
        @Override
        public void someMethod() {
            // do something
        }
    }

    public static class ProductC implements Product {
        @Override
        public void someMethod() {
            // do something
        }
    }

    public static void main(String[] args) {
        Product product = Product.createProduct("B");
        product.someMethod();
    }

}
