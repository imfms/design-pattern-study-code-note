package cn.f_ms.study.design_pattern.p05prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * java语言序列化功能提供的深克隆方法深克隆
 *
 * @author imf_m
 * @date 2018/11/10
 */
class S6_JavaSerializeDeepClone {

    static class ReferenceType implements Serializable {

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

    static class Prototype implements Serializable {

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
                ByteArrayOutputStream memery = new ByteArrayOutputStream();
                ObjectOutputStream output = new ObjectOutputStream(memery);
                output.writeObject(this);
                output.close();
                return (Prototype) new ObjectInputStream(new ByteArrayInputStream(memery.toByteArray())).readObject();
            } catch (Exception e) {
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
