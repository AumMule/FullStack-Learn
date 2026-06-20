# Object-Oriented Programming (OOP) Concepts & Core Keywords

This revision sheet covers classes, objects, JVM memory layout (Stack & Heap), method structures, string manipulation, encapsulation, and constructors.

---

## 1. Class & Object

- **Class:** A template or blueprint that defines the structure and behavior (variables and methods) of objects. It is a logical entity.
- **Object:** An instance of a class. It is a physical entity that has state (variables) and behavior (methods).

### Class and Object Practical
```java
// Class declaration
class Calculator {
    // Variable (State)
    int num;

    // Method (Behavior)
    public int add(int n1, int n2) {
        return n1 + n2;
    }
}

public class Main {
    public static void main(String[] args) {
        // Object creation (Instantiating Calculator)
        Calculator calc = new Calculator(); 
        
        int result = calc.add(5, 7);
        System.out.println(result); // 12
    }
}
```

---

## 2. Stack and Heap Memory

Java manages memory in two primary areas:

```
┌─────────────────────────────────┐      ┌───────────────────────────────┐
│              STACK              │      │             HEAP              │
├─────────────────────────────────┤      ├───────────────────────────────┤
│ • Local variables (primitives)  │      │ • All objects created with    │
│ • Reference variables           │ ───> │   the 'new' keyword.          │
│ • Method execution frames       │      │ • Instance variables.         │
│ • Fast, LIFO structure          │      │ • Garbage collected when      │
│ • Automatically cleaned up      │      │   unreferenced.               │
└─────────────────────────────────┘      └───────────────────────────────┘
```

- **Stack:** Stores method execution frames, primitive local variables, and reference variables (holding addresses of objects in Heap). Allocation is LIFO (Last-In-First-Out).
- **Heap:** Stores actual objects and their instance variables. Objects in the Heap stay there as long as there is a reference pointing to them. The **Garbage Collector (GC)** runs in the background to free memory of unreferenced objects.

---

## 3. Methods & Method Overloading

### Methods
A block of code that runs only when called. It can accept parameters and return values.

### Method Overloading
A compile-time polymorphism feature where a class can have multiple methods with the **same name** but **different parameters** (different signature).
*Different parameters can mean:*
1. Different number of parameters.
2. Different types of parameters.
3. Different order of parameter types.

*(Note: Overloading **cannot** be done solely by changing the return type or access modifiers).*

```java
class MathUtils {
    public int multiply(int a, int b) {
        return a * b;
    }

    // Overloaded by parameter type
    public double multiply(double a, double b) {
        return a * b;
    }

    // Overloaded by number of parameters
    public int multiply(int a, int b, int c) {
        return a * b * c;
    }
}
```

---

## 4. Strings in Java

A `String` in Java is an object that represents a sequence of char values.

### Immutable Strings
Strings are **immutable**; once a String object is created, its value cannot be changed. Any operation that modifies a String will result in a new String object.

### String Constant Pool (SCP)
To save memory, JVM stores String literals in a special memory area in the Heap called the **String Constant Pool (SCP)**.
```java
String s1 = "Hello"; // Created in SCP
String s2 = "Hello"; // References the existing s1 in SCP
String s3 = new String("Hello"); // Created in normal Heap memory (outside SCP)

System.out.println(s1 == s2); // true (same reference)
System.out.println(s1 == s3); // false (different locations)
System.out.println(s1.equals(s3)); // true (checks actual content)
```

### StringBuffer & StringBuilder (Mutable Strings)
When you need to make frequent modifications to strings, use mutable representations:
- **`StringBuffer`:** Thread-safe (synchronized), slower.
- **`StringBuilder`:** Not thread-safe (not synchronized), faster. Introduced in Java 5.

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Modifies the original object in-place
System.out.println(sb.toString()); // "Hello World"
```

---

## 5. The `static` Keyword

Used for memory management. It belongs to the class rather than instances of the class.

### Static Variables
Shared among all objects of that class. Created in a separate Class Area when the class is loaded.
```java
class Mobile {
    String brand;
    int price;
    static String name; // Shared value
}
```

### Static Block
Used to initialize static variables. Runs **once** when the class is first loaded into JVM memory (even before the `main` method or constructor runs).
```java
class Mobile {
    static String name;
    static {
        name = "SmartPhone";
        System.out.println("Static block executed");
    }
}
```

### Static Methods
Methods that can be called directly without creating an object.
- Static methods can access **only static data** directly.
- They **cannot** access instance variables or instance methods without an object reference.
- They cannot use `this` or `super` keywords.
```java
class Calc {
    public static int add(int a, int b) {
        return a + b;
    }
}
// Called using Calc.add(2, 3);
```

---

## 6. Encapsulation

Encapsulation is the practice of wrapping data (variables) and code (methods) together as a single unit, and restricting direct access to some of the object's components.
- Make variables `private`.
- Provide public `getter` and `setter` methods to read/write them.

```java
class Account {
    private int balance; // Restricted direct access

    // Getter
    public int getBalance() {
        return balance;
    }

    // Setter with validation
    public void setBalance(int balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
}
```

### The `this` Keyword
A reference variable in Java that refers to the **current object** inside a method or constructor. Used to avoid ambiguity between instance variables and local variables/parameters.
```java
class Human {
    private String name;
    
    public void setName(String name) {
        this.name = name; // 'this.name' refers to instance variable; 'name' is parameter
    }
}
```

---

## 7. Constructors

A block of code similar to a method that is called when an instance of an object is created.
- Must have the **same name** as the class.
- Must **not** have an explicit return type (not even `void`).

### Default vs Parameterized Constructor
- **Default Constructor:** Inserted automatically by the compiler if no constructor is defined. Initializes fields with default values.
- **Parameterized Constructor:** User-defined constructor that accepts arguments to initialize variables.

```java
class Laptop {
    String brand;
    int ram;

    // Default Constructor (explicitly defined)
    public Laptop() {
        this.brand = "Unknown";
        this.ram = 8;
    }

    // Parameterized Constructor
    public Laptop(String brand, int ram) {
        this.brand = brand;
        this.ram = ram;
    }
}
```

### `this()` and `super()` Methods
- **`this()`:** Calls another constructor in the **same class** (constructor chaining). Must be the first statement.
- **`super()`:** Calls the constructor of the **immediate parent class**. Automatically placed by the compiler as the first statement in any constructor if not specified.

```java
class A {
    public A() {
        System.out.println("In A");
    }
}

class B extends A {
    public B() {
        super(); // Calls A constructor
        System.out.println("In B");
    }
    
    public B(int x) {
        this(); // Calls default constructor B()
        System.out.println("In B Parameterized");
    }
}
```

---

## 8. Miscellaneous Core Concepts

### Naming Conventions
- **Classes:** PascalCase (e.g., `MyFirstClass`)
- **Variables & Methods:** camelCase (e.g., `myVariable`, `myMethod()`)
- **Packages:** lowercase (e.g., `com.company.project`)
- **Constants:** UPPER_CASE with underscores (e.g., `MAX_VALUE`)

### Anonymous Objects
An object that is created but not assigned to a reference variable. Useful when you need to call a method only once.
```java
new Calculator().add(5, 10); // Anonymous object created and used
```
- It is created in the Heap, executed, and immediately becomes eligible for garbage collection since it has no reference.
