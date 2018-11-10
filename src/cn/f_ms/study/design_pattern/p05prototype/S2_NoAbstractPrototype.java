package cn.f_ms.study.design_pattern.p05prototype;

/**
 * 抽象原型本身为具体实现
 *
 * @author imf_m
 * @date 2018/11/10
 */
class S2_NoAbstractPrototype {

    static class Prototype {

        private String name;

        public Prototype(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public Prototype clone() {
            return new Prototype(name);
        }

        @Override
        public String toString() {
            return "Prototype{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Client {
        public  void doSomething() {
            Prototype prototype = new Prototype("prototype");
            Prototype prototypeclone = prototype.clone();

            System.out.format(
                    "prototype: %s\nprototypeClone: %s",
                    prototype, prototypeclone
            );
        }
    }

    public static void main(String[] args) {
        new Client().doSomething();
    }
}
