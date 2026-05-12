package Lesson_01;

import java.util.ArrayList;
import java.util.List;

public class Example_01 {
    static void main() {
        //Animal animal=new Animal("HI") ;
        Dog dog = new Dog("Hero");
        dog.makeSound();

        Cat cat = new Cat("Dora");
        cat.makeSound();

        List<Flyable> list = new ArrayList<Flyable>();
        list.add(new Jet("Name1"));
        for (Flyable f : list) {
            f.fly();
        }

    }

    abstract static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        abstract public void makeSound();
    }

    interface Flyable {
        int MAX_SPEED = 100;

        void fly();
    }

    static class Dog extends Animal {
        int numberOfLegs;
        String breed;

        public Dog(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(name + " is sounding bow bow!");
        }
    }

    static class Cat extends Animal {
        String breed;

        public Cat(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(name + " is sounding! Mew");
        }
    }

    abstract static class Breed extends Dog {
        String breed;

        public Breed(String name) {
            super(name);
        }
    }

    static class Jet implements Flyable {
        public Jet(String name) {
        }

        @Override
        public void fly() {
            System.out.println("Jet is flying!");
        }
    }
}
