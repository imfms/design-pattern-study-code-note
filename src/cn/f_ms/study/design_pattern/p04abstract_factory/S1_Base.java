package cn.f_ms.study.design_pattern.p04abstract_factory;

/**
 * 抽象工厂基本结构
 *
 * @author imf_m
 * @date 2018/11/4
 */
class S1_Base {

    static abstract class ProductA {}
    static abstract class ProductB {}

    static abstract class AbstractFactory {
        abstract ProductA createProductA();
        abstract ProductB createProductB();
    }

    static class WindowsProductA extends ProductA {}
    static class WindowsProductB extends ProductB {}
    static class LinuxProductA extends ProductA {}
    static class LinuxProductB extends ProductB {}

    static class LinuxFactory extends AbstractFactory {
        @Override ProductA createProductA() {
            return new LinuxProductA();
        }
        @Override ProductB createProductB() {
            return new LinuxProductB();
        }
    }
    static class WindowsFactory extends AbstractFactory {
        @Override ProductA createProductA() {
            return new WindowsProductA();
        }
        @Override ProductB createProductB() {
            return new WindowsProductB();
        }
    }

    public static void main(String[] args) {
        doAction(new WindowsFactory());
        doAction(new LinuxFactory());
    }

    private static void doAction(AbstractFactory factory) {
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();
    }
}
