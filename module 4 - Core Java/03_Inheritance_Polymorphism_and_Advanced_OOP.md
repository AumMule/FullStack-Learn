# Inheritance, Polymorphism, & Advanced OOP Concepts

This revision sheet covers inheritance structures, method overriding, packages, access modifiers, polymorphism, casting, abstract classes, inner classes, interfaces, and enums.

---

## 1. Inheritance

Inheritance is a mechanism where one class acquires the properties (variables) and behaviors (methods) of another class. It promotes **code reusability** (IS-A relationship).
- **Parent Class (Superclass / Base Class):** Class whose properties are inherited.
- **Child Class (Subclass / Derived Class):** Class that inherits properties. Uses the `extends` keyword.

```java
class Calculator { // Superclass
    public int add(int n1, int n2) { return n1 + n2; }
}

class AdvCalc extends Calculator { // Subclass
    public int sub(int n1, int n2) { return n1 - n2; }
}
```

### Inheritance Types
1. **Single Inheritance:** A child class extends a single parent class.
2. **Multilevel Inheritance:** A child class extends a parent class which itself extends another class (e.g., `C extends B`, `B extends A`).
3. **Multiple Inheritance:** A class inherits from multiple classes. **Java does not support Multiple Inheritance with classes** to avoid the **Diamond Problem** (ambiguity when two parent classes have methods with the same signature). However, multiple inheritance is supported via **Interfaces**.

---

## 2. Method Overriding

When a subclass provides a specific implementation for a method that is already defined in its superclass.
- Same method name, same parameters, same return type.
- Used for runtime polymorphism.
- `@Override` annotation is recommended.
- Overriding cannot occur for methods declared as `static`, `final`, or `private`.

```java
class Parent {
    public void show() { System.out.println("In Parent"); }
}

class Child extends Parent {
    @Override
    public void show() { System.out.println("In Child"); }
}
```

---

## 3. Packages & Access Modifiers

### Packages
A namespace that groups related classes, interfaces, and sub-packages.
- Prevents naming conflicts.
- Controlled access using access modifiers.
- Use `package com.example;` at the top of files and `import com.example.MyClass;` to use it elsewhere.

### Access Modifiers
Define the scope/visibility of classes, methods, variables, and constructors.

| Modifier | Class | Package | Subclass (Same pkg) | Subclass (Diff pkg) | World |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **`public`** | Yes | Yes | Yes | Yes | Yes |
| **`protected`**| Yes | Yes | Yes | Yes (via inheritance) | No |
| **`default` (no keyword)** | Yes | Yes | Yes | No | No |
| **`private`** | Yes | No | No | No | No |

---

## 4. Polymorphism & Dynamic Method Dispatch

Polymorphism means "many forms".
1. **Compile-time Polymorphism:** Checked by the compiler. Achieved via **Method Overloading**.
2. **Runtime Polymorphism:** Resolved at execution time. Achieved via **Method Overriding** and **Dynamic Method Dispatch**.

### Dynamic Method Dispatch
A mechanism where a call to an overridden method is resolved at runtime through a parent reference pointing to a child object.

```java
class Computer {
    public void show() { System.out.println("Computer running..."); }
}
class Laptop extends Computer {
    public void show() { System.out.println("Laptop running..."); }
}

public class Main {
    public static void main(String[] args) {
        Computer obj = new Laptop(); // Parent reference pointing to Child object (Upcasting)
        obj.show(); // Output: "Laptop running..." (decided at runtime)
    }
}
```

---

## 5. The `final` Keyword

Used to apply restrictions:
- **`final` Variable:** Creates a constant value. Cannot be reassigned.
- **`final` Method:** Cannot be overridden by subclasses.
- **`final` Class:** Cannot be extended (inherited) by any other class.

```java
final int LIMIT = 100; // Constant

class Parent {
    public final void show() {} // Cannot be overridden
}

final class A {} // Cannot be subclassed
```

---

## 6. The `Object` Class

Every class in Java implicitly extends the `java.lang.Object` class. Three crucial methods commonly overridden:
1. **`toString()`:** Returns a string representation of the object. Default is `ClassName@HashCode`.
2. **`hashCode()`:** Returns a unique integer representation of the memory address of the object.
3. **`equals(Object obj)`:** Compares equality. Default checks reference (`==`). You override it to check content.

```java
class Student {
    String name;
    int roll;

    @Override
    public String toString() {
        return "Student[Name=" + name + ", Roll=" + roll + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return roll == s.roll && name.equals(s.name);
    }
}
```

---

## 7. Upcasting and Downcasting

- **Upcasting:** Assigning a subclass object to a superclass reference variable. Done automatically.
  ```java
  Animal a = new Dog(); // Dog is upcast to Animal
  ```
- **Downcasting:** Assigning a superclass reference back to a subclass reference. Must be done explicitly.
  ```java
  Dog d = (Dog) a; // Explicit downcasting. Throws ClassCastException if 'a' is not a Dog.
  ```

---

## 8. The `abstract` Keyword

Used to achieve abstraction.
- **Abstract Class:** Cannot be instantiated. Can contain both abstract (without body) and concrete methods.
- **Abstract Method:** Declared without implementation; subclasses **must** override and provide the implementation.

```java
abstract class Car {
    public abstract void drive(); // Abstract method (no body)
    
    public void playMusic() { // Concrete method
        System.out.println("Playing music");
    }
}

class WagonR extends Car {
    public void drive() { // Must implement abstract method
        System.out.println("Driving WagonR...");
    }
}
```

---

## 9. Inner Classes

A class declared inside another class.
- **Member Inner Class:** Non-static class defined inside an outer class. Requires outer class object to instantiate.
- **Static Inner Class:** Class defined inside outer class using `static`. Does not require outer class object.
- **Anonymous Inner Class:** An inner class declared without a name. Used to override methods of a class/interface on the fly.

```java
class Outer {
    int x = 10;
    
    class Inner { // Member Inner Class
        void show() { System.out.println("Value of x: " + x); }
    }
}
// Instantiation: Outer.Inner in = new Outer().new Inner();
```

### Anonymous Inner Class Examples
```java
// Overriding on the fly
class A {
    public void show() { System.out.println("In A show"); }
}

public class Main {
    public static void main(String[] args) {
        A obj = new A() { // Anonymous Inner Class
            @Override
            public void show() {
                System.out.println("In Anonymous show");
            }
        };
        obj.show(); // Prints: "In Anonymous show"
    }
}
```

---

## 10. Interfaces

An interface is a blueprint of a class. It contains only abstract methods (prior to Java 8) and constant variables. Used to achieve **total abstraction** and **multiple inheritance**.

- Variables are implicitly `public static final`.
- Methods are implicitly `public abstract`.
- Implemented using the `implements` keyword.

```java
interface Animal {
    void eat(); // public abstract void eat();
}

interface Pet {
    void play();
}

// Subclass implementing multiple interfaces
class Dog implements Animal, Pet {
    public void eat() { System.out.println("Dog eats bone"); }
    public void play() { System.out.println("Dog plays fetch"); }
}
```

*Note: Since Java 8, interfaces can also have `default` and `static` methods (with implementations). Since Java 9, they can contain `private` methods.*

### Need of Interface
Interfaces decouple client code from the actual implementation. It allows you to design applications around contracts, promoting flexibility and modularity.

---

## 11. Enums

An `Enum` (Enumeration) is a special data type used to define a collection of constants.

### Enum Basics
```java
enum Status {
    RUNNING, FAILED, PENDING, SUCCESS;
}

public class Main {
    public static void main(String[] args) {
        Status s = Status.RUNNING;
        System.out.println(s); // RUNNING
    }
}
```

### Enum with If and Switch
Enums are commonly used with control statements:
```java
Status s = Status.SUCCESS;

switch (s) {
    case RUNNING -> System.out.println("In Progress");
    case FAILED -> System.out.println("Something went wrong");
    case SUCCESS -> System.out.println("Done!");
}
```

### Enum Class (Custom Constructors and Methods)
In Java, enums behave like classes. They can contain variables, constructors, and methods.
- Enum constructors are executed for each enum constant.
- Enum constructors are implicitly `private` or `package-private`.

```java
enum Laptop {
    MACBOOK(2000), XPS(1500), THINKPAD(1200);
    
    private int price; // Instance variable
    
    Laptop(int price) { // Constructor
        this.price = price;
    }
    
    public int getPrice() { return price; }
}
```
*(To iterate over an enum, use `Laptop.values()`)*
