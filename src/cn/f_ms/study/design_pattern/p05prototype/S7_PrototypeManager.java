package cn.f_ms.study.design_pattern.p05prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型管理器
 *
 * @author imf_m
 * @date 2018/11/10
 */
class S7_PrototypeManager {

    interface Prototype {
        Prototype clone();
    }

    static class PrototypeManager {
        private static Map<String, Prototype> prototypes = new HashMap<>();

        static {
            prototypes.put("a", new PrototypeA("i'm A"));
            prototypes.put("b", new PrototypeB("i'm B"));
        }

        public static void put(String key, Prototype prototype) {
            prototypes.put(key, prototype);
        }

        public static Prototype get(String key) {
            return prototypes.get(key);
        }
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
            Prototype prototypeA = PrototypeManager.get("a");
            Prototype prototypeAclone = prototypeA.clone();
            Prototype prototypeB = PrototypeManager.get("b");
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
