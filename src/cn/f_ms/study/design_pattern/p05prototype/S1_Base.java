package cn.f_ms.study.design_pattern.p05prototype;

/**
 * 基本结构
 *
 * @author imf_m
 * @date 2018/11/10
 */
class S1_Base {

    interface Prototype {
        Prototype clone();
    }

    static class PrototypeA implements Prototype {

        private String name;

        public PrototypeA(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public PrototypeA clone() {
            return new PrototypeA(name);
        }

        @Override
        public String toString() {
            return "PrototypeA{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    static class PrototypeB implements Prototype {

        private String value;

        public PrototypeB(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public PrototypeB clone() {
            return new PrototypeB(value);
        }

        @Override
        public String toString() {
            return "PrototypeB{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    static class Client {
        public  void doSomething() {
            Prototype prototypeA = new PrototypeA("a");
            Prototype prototypeAclone = prototypeA.clone();
            Prototype prototypeB = new PrototypeA("b");
            Prototype prototypeBclone = prototypeB.clone();

            System.out.format(
                    "prototypeA: %s\nprototypeAclone: %s\nprototypeB: %s\nprototypeBclone: %s",
                    prototypeA, prototypeAclone, prototypeB, prototypeBclone
            );
        }
    }

    public static void main(String[] args) {
        new Client().doSomething();
    }
}
