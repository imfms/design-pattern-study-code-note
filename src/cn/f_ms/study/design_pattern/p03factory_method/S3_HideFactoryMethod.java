package cn.f_ms.study.design_pattern.p03factory_method;

/**
 * 隐藏工厂方法
 *
 * @author f_ms
 * @date 18-8-26
 */
public class S3_HideFactoryMethod {

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

    public static abstract class ProductFactory {

        private Product product;

        protected abstract Product createProduct();

        public void someMethod() {
            if (product == null) {
                product = createProduct();
            }
            product.someMethod();
        }
    }

    public static class ProductAFactory extends ProductFactory {
        @Override public Product createProduct() {
            return new ProductA();
        }
    }
    public static class ProductBFactory extends ProductFactory {
        @Override public Product createProduct() {
            return new ProductB();
        }
    }
    public static class ProductCFactory extends ProductFactory {
        @Override public Product createProduct() {
            return new ProductC();
        }
    }

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductAFactory();
        productFactory.someMethod();
    }

}
