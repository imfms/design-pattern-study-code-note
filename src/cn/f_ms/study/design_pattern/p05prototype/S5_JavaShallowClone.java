package cn.f_ms.study.design_pattern.p05prototype;

/**
 * java语言提供的浅克隆方法
 *
 * @author imf_m
 * @date 2018/11/10
 */
class S5_JavaShallowClone {

    static class ReferenceType {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ReferenceType{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    static class Prototype implements Cloneable {

        private String name;
        private ReferenceType reference;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ReferenceType getReference() {
            return reference;
        }

        public void setReference(ReferenceType reference) {
            this.reference = reference;
        }

        @Override
        public Prototype clone() {
            try {
                return (Prototype) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        @Override
        public String toString() {
            return "Prototype{" +
                    "name='" + name + '\'' +
                    ", reference=" + reference +
                    '}';
        }
    }

    static class Client {
        public  void doSomething() {
            Prototype prototype = new Prototype();
            prototype.setName("prototype");
            ReferenceType reference = new ReferenceType();
            reference.setValue("prototype value");
            prototype.setReference(reference);

            Prototype prototypeclone = prototype.clone();

            System.out.format(
                    "prototype: %s\nprototypeclone: %s\nprototype.getReference() == prototypeclone.getReference(): %s",
                    prototype,
                    prototypeclone,
                    prototype.getReference() == prototypeclone.getReference()
            );
        }
    }

    public static void main(String[] args) {
        new Client().doSomething();
    }
}
