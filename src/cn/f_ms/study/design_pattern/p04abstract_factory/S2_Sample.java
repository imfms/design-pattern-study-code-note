package cn.f_ms.study.design_pattern.p04abstract_factory;

import java.util.Random;

/**
 * Sunny软件公司欲推出一款新的手机游戏软件，该软件能够支持Symbian,Android和WindowsMobile等多个智能手机操作系统平台
 * 针对不用的手机操作系统该游戏软件提供了不同的游戏操作控制类(OperationController)和游戏界面控制类(InterfaceController)
 * 并提供相应的工厂类来封装这些类的初始化过程。软件要求具有良好的扩展性以支持新的操作系统平台，
 * 为了满足上述要求，试采用抽象工厂模式对其进行设计。
 *
 * @author imf_m
 * @date 2018/11/4
 */
class S2_Sample {

    interface OperationController {
        void onKeyDown();
    }

    interface InterfaceController {
        void display();
    }

    interface PlatformControllerAbstractFactory {
        OperationController initOperationController();

        InterfaceController initInterfaceController();
    }

    static class SymbianOperationController implements OperationController {
        @Override
        public void onKeyDown() {
            System.out.println("Symbian onKeyDown");
        }
    }

    static class SymbianInterfaceController implements InterfaceController {
        @Override
        public void display() {
            System.out.println("Symbian display");
        }
    }

    static class SymbianPlatformAbstractFactory implements PlatformControllerAbstractFactory {
        @Override
        public OperationController initOperationController() {
            return new SymbianOperationController();
        }

        @Override
        public InterfaceController initInterfaceController() {
            return new SymbianInterfaceController();
        }
    }

    static class AndroidOperationController implements OperationController {
        @Override
        public void onKeyDown() {
            System.out.println("Android onKeyDown");
        }
    }

    static class AndroidInterfaceController implements InterfaceController {
        @Override
        public void display() {
            System.out.println("Android display");
        }
    }

    static class AndroidPlatformAbstractFactory implements PlatformControllerAbstractFactory {
        @Override
        public OperationController initOperationController() {
            return new AndroidOperationController();
        }

        @Override
        public InterfaceController initInterfaceController() {
            return new AndroidInterfaceController();
        }
    }

    static class WindowsPhoneOperationController implements OperationController {
        @Override
        public void onKeyDown() {
            System.out.println("WindowsPhone onKeyDown");
        }
    }

    static class WindowsPhoneInterfaceController implements InterfaceController {
        @Override
        public void display() {
            System.out.println("WindowsPhone display");
        }
    }

    static class WindowsPhonePlatformAbstractFactory implements PlatformControllerAbstractFactory {
        @Override
        public OperationController initOperationController() {
            return new WindowsPhoneOperationController();
        }

        @Override
        public InterfaceController initInterfaceController() {
            return new WindowsPhoneInterfaceController();
        }
    }

    public static void main(String[] args) {

        PlatformControllerAbstractFactory[] factorys = {
                new SymbianPlatformAbstractFactory(),
                new AndroidPlatformAbstractFactory(),
                new WindowsPhonePlatformAbstractFactory()
        };

        PlatformControllerAbstractFactory factory = factorys[new Random().nextInt(factorys.length)];
        factory.initInterfaceController().display();
        factory.initOperationController().onKeyDown();
    }
}
