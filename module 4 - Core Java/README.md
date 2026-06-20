# Module 4 - Core Java Revision Sheets

Welcome to the Core Java Revision Sheets! This repository contains a curated, clean, and comprehensive guide to revising the entirety of Core Java, structured logically to help you quickly review core syntax, object-oriented concepts, exception handling, multithreading, collections, and streams.

---

## 📚 Table of Contents

### 1. [01. Java Basics, Control Flow, and Arrays](file:///C:/Users/ommul/OneDrive/Desktop/cognizant/module%204%20-%20Core%20Java/01_Java_Basics_Control_Flow_and_Arrays.md)
*Quick guide on Java syntax foundations and basic flow structures.*
- **Intro & Environment Setup:** JDK vs JRE vs JVM, setting up environment, first Java program.
- **Java Execution Mechanics:** Compilation (`javac`), Bytecode, JVM execution.
- **Variables & Data Types:** 8 Primitives, Literals, Type Promotion, and Implicit/Explicit Type Casting.
- **Operators:** Assignment, Relational, and Short-Circuit Logical operators.
- **Control Flow:** `if-else`, Ternary operator, Switch Statement, and Modern Switch Expressions.
- **Loops:** `while`, `do-while`, `for`, loop selection, and enhanced `for-each` loop.
- **Arrays:** 1D/2D arrays, Jagged arrays, 3D arrays, limitations, and arrays of objects.

---

### 2. [02. OOP Concepts and Core Keywords](file:///C:/Users/ommul/OneDrive/Desktop/cognizant/module%204%20-%20Core%20Java/02_OOP_Concepts_and_Core_Keywords.md)
*Core elements of Object-Oriented programming and structural keywords.*
- **Classes & Objects:** Structure, instance fields, state, and behaviors.
- **Memory Management:** Stack vs Heap memory layout, garbage collection.
- **Methods:** Declaration, execution, and Compile-time Polymorphism via Method Overloading.
- **Strings:** Immutability, String Constant Pool (SCP), `StringBuffer` vs `StringBuilder`.
- **Static Keyword:** Static variables, static blocks (class loading execution), and static methods.
- **Encapsulation:** Visibility, getters/setters, and the `this` keyword.
- **Constructors:** Default vs Parameterized, constructor chaining (`this()`), and `super()`.
- **Naming Conventions & Anonymous Objects:** Standard naming guides and inline instantiation.

---

### 3. [03. Inheritance, Polymorphism, and Advanced OOP](file:///C:/Users/ommul/OneDrive/Desktop/cognizant/module%204%20-%20Core%20Java/03_Inheritance_Polymorphism_and_Advanced_OOP.md)
*Extending structures, typecasting, dynamic resolution, contracts, and enums.*
- **Inheritance:** Code reuse, Single vs Multilevel, why Java doesn't support Multiple Inheritance with classes.
- **Overriding:** Runtime behavior customization, annotations, overriding restrictions.
- **Packages & Modifiers:** Namespace management and Access Modifier scopes (`public`, `protected`, `default`, `private`).
- **Polymorphism:** Runtime polymorphism and Dynamic Method Dispatch.
- **Final Keyword:** Creating constants, preventing method overriding and class inheritance.
- **Object Class:** Custom overriding of `toString()`, `equals()`, and `hashCode()`.
- **Casting:** Upcasting and Downcasting safety.
- **Abstraction:** Abstract classes, abstract methods, and contracts.
- **Inner Classes:** Member, static, and Anonymous Inner classes.
- **Interfaces:** Standard contracts, multi-inheritance, and Java 8/9 default and private additions.
- **Enums:** Class-like enums, switch-case support, variables, and constructors.

---

### 4. [04. Annotations, Lambdas, Exceptions, and Concurrency](file:///C:/Users/ommul/OneDrive/Desktop/cognizant/module%204%20-%20Core%20Java/04_Annotations_Lambdas_Exceptions_and_Concurrency.md)
*Functional programming features, errors, concurrency, collections, and modern streams.*
- **Annotations:** Built-in metadata modifiers.
- **Functional Interfaces & Lambdas:** Single Abstract Method (SAM) contracts, lambda expressions, and shorthand returns.
- **Exceptions:** Checked vs Unchecked, hierarchy, `try-catch-finally`, multiple catches, `throw`, custom exceptions, ducking via `throws`, and automatic resource management via Try-with-resources.
- **User Input:** `BufferedReader` (fast/synchronized) vs `Scanner` (token parsing).
- **Concurrency & Threads:** Creating threads (Thread vs Runnable), priority, sleep, race conditions, synchronization locks, and lifecycle states.
- **Collection API:** `List`, `Set`, `Map` structures, sorting via `Comparable` vs custom `Comparator`.
- **Stream API:** Pipeline flow, intermediate vs terminal operations (`forEach`, `filter`, `map`, `reduce`, `sorted`).

---

## 💡 Quick Tips for Revision
1. **Memory Allocation:** Always draw a Stack and Heap diagram when tracking object reference problems.
2. **Comparable vs Comparator:** Remember, **Comparable** is *natural* ordering written inside the class (single logic), while **Comparator** is *custom* ordering defined externally (multiple logics, often using lambdas).
3. **Strings:** Check whether you are matching with `==` (compares references) or `.equals()` (compares contents). Always use `StringBuilder` inside loops for concatenations.
