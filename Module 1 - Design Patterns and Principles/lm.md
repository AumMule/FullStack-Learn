# Java FSE Interview Notes - SOLID Principles & Design Patterns

## SOLID Principles

### 1. SRP - Single Responsibility Principle

### Definition

A class should have only one reason to change.

### Bad Example

```java
class User {
    void saveToDatabase() {}
    void sendEmail() {}
    void generateReport() {}
}
```

The User class has multiple responsibilities.

### Good Example

```java
class User {}

class UserRepository {
    void save(User user) {}
}

class EmailService {
    void sendEmail(User user) {}
}
```

### Interview One-Liner

> One class should have only one responsibility.

---

### 2. OCP - Open/Closed Principle

### Definition

Software entities should be open for extension but closed for modification.

### Bad Example

```java
class Payment {
    void pay(String type) {
        if(type.equals("Card")) {
            // card payment
        } else if(type.equals("UPI")) {
            // upi payment
        }
    }
}
```

Adding a new payment type requires modifying existing code.

### Good Example

```java
interface Payment {
    void pay();
}

class CardPayment implements Payment {
    public void pay() {}
}

class UpiPayment implements Payment {
    public void pay() {}
}
```

### Interview One-Liner

> Open for extension, closed for modification.

---

### 3. LSP - Liskov Substitution Principle

### Definition

A subclass should be replaceable with its parent class without breaking the program.

### Bad Example

```java
class Bird {
    void fly() {}
}

class Ostrich extends Bird {
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

### Good Example

```java
class Bird {
    void move() {}
}

class Sparrow extends Bird {
    void move() {
        System.out.println("Flying");
    }
}
```

### Interview One-Liner

> Child classes should be replaceable for parent classes.

---

### 4. ISP - Interface Segregation Principle

### Definition

Clients should not be forced to implement methods they do not use.

### Bad Example

```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {}

    public void eat() {
        throw new UnsupportedOperationException();
    }
}
```

### Good Example

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Robot implements Workable {
    public void work() {}
}
```

### Interview One-Liner

> Don't force classes to implement unused methods.

---

### 5. DIP - Dependency Inversion Principle

### Definition

Depend on abstractions, not concrete implementations.

### Bad Example

```java
class Computer {
    Keyboard keyboard = new Keyboard();
}
```

### Good Example

```java
interface InputDevice {}

class Keyboard implements InputDevice {}

class Computer {
    private InputDevice device;

    public Computer(InputDevice device) {
        this.device = device;
    }
}
```

### Interview One-Liner

> Depend on interfaces, not implementations.

---

## SOLID Interview Summary

| Principle | One-Liner                                          |
| --------- | -------------------------------------------------- |
| SRP       | One class, one responsibility                      |
| OCP       | Open for extension, closed for modification        |
| LSP       | Child classes should replace parent classes safely |
| ISP       | Don't force classes to implement unused methods    |
| DIP       | Depend on abstractions, not implementations        |

---

# Design Patterns

## 1. Singleton Pattern

### Purpose

Ensure only one instance of a class exists.

### Uses

* Logger
* Runtime
* Configuration Manager
* Database Connection

### Example

```java
class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {

        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
```

### Why Constructor is Private?

To prevent:

```java
Singleton s1 = new Singleton();
Singleton s2 = new Singleton();
```

### Interview Questions

#### What problem does Singleton solve?

Ensures only one object exists.

#### What is wrong with the basic Singleton?

Not thread-safe.

### One-Liner

> Ensures only one object exists and provides a global access point.

---

## 2. Factory Pattern

### Purpose

Create objects without exposing creation logic.

### Without Factory

```java
Circle circle = new Circle();
```

### With Factory

```java
Shape shape = ShapeFactory.getShape("Circle");
```

### Example

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle");
    }
}

class ShapeFactory {

    public static Shape getShape(String type) {

        if(type.equals("Circle"))
            return new Circle();

        return new Rectangle();
    }
}
```

### Benefits

* Hides object creation
* Easier maintenance
* Supports OCP

### OOP Concepts Used

* Abstraction
* Polymorphism

### One-Liner

> Creates objects without exposing creation logic.

---

## 3. Builder Pattern

### Purpose

Construct complex objects step by step.

### Problem Solved

Constructor Explosion

### Bad Example

```java
Student()
Student(String name)
Student(String name, int age)
Student(String name, int age, String city)
Student(String name, int age, String city, double cgpa)
```

### Good Example

```java
Student student = new Student.Builder()
        .setName("Aum")
        .setAge(21)
        .setCGPA(8.67)
        .build();
```

### Advantages

* Readable code
* Optional parameters
* Avoids constructor explosion

### One-Liner

> Constructs complex objects step by step and avoids constructor explosion.

---

# Pattern Recognition Questions

### Which Pattern?

Only one Logger object in application

Answer: Singleton

---

Create UPI, Card, PayPal objects without exposing creation logic

Answer: Factory

---

Create an object with many optional parameters

Answer: Builder

---

# Most Important Interview Answers

### What problem does Singleton solve?

Ensures only one object exists.

### What problem does Factory solve?

Hides object creation logic.

### What problem does Builder solve?

Constructor explosion.

### Why is Singleton constructor private?

To prevent object creation using new.

### When should Builder be used?

When an object has many optional parameters.

### Which pattern does Runtime.getRuntime() use?

Singleton

### Why?

Because it always returns the same instance.

---

# 30-Second Revision

SRP → One responsibility

OCP → Extend, don't modify

LSP → Child should replace parent safely

ISP → Small focused interfaces 

DIP → Depend on interfaces

Singleton → One object

Factory → Hide object creation

Builder → Avoid constructor explosion
