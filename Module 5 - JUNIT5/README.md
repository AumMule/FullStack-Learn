# Module 5 - JUnit Testing Guide

Welcome to the **JUnit Testing Guide**! This module is designed to take you on a step-by-step journey through the evolution of Java unit testing, from legacy JUnit 3/4 paradigms to modern, advanced testing features in JUnit 5 (Jupiter). 

Each project in this directory is a self-contained demonstration of a specific testing concept, tool, or lifecycle configuration.

---

## 📚 Table of Contents

1. [demo - Legacy JUnit 3 Setup](#1-demo---legacy-junit-3-setup)
2. [JUNITL-01 - Annotation-Based JUnit 4](#2-junitl-01---annotation-based-junit-4)
3. [JUNIT-02nomaven - Basic JUnit 5 (No Build Tool)](#3-junit-02nomaven---basic-junit-5-no-build-tool)
4. [jUNIT5-03maven - JUnit 5 & Lazy Messages (Maven)](#4-junit5-03maven---junit-5--lazy-messages-maven)
5. [JUNIT5-04-Exception - Pre-Assertion Exception Handling](#5-junit5-04-exception---pre-assertion-exception-handling)
6. [JUNIT5-05-timeout - Performance & Timeout Assertions](#6-junit5-05-timeout---performance--timeout-assertions)
7. [JUNIT5-06-BeforeAfterEach - Method-Level Lifecycle Hooks](#7-junit5-06-beforeaftereach---method-level-lifecycle-hooks)
8. [JUNIT5-06-BeforeAfterAll - Class-Level Lifecycle Hooks](#8-junit5-06-beforeafterall---class-level-lifecycle-hooks)
9. [JUNIT5-07-Instance - Custom Test Instance Lifecycles](#9-junit5-07-instance---custom-test-instance-lifecycles)
10. [JUNIT5TEST - Boilerplate Sandbox](#10-junit5test---boilerplate-sandbox)

---

## Project Walkthroughs

### 1. [demo](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/demo) - Legacy JUnit 3 Setup
*A demonstration of the historical JUnit 3 structure using standard Maven archetypes.*
* **Concepts Covered**: Legacy testing syntax, inheritance-based tests, strict naming conventions.
* **Key Details**:
  - Test classes must extend `TestCase` (`junit.framework.TestCase`).
  - Test methods must follow the naming pattern starting with the lowercase prefix `test` (e.g., `testApp`).
  - Test suites are configured manually via static `suite()` methods returning a `TestSuite`.
* **Important Files**:
  - Main Class: [App.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/demo/src/main/java/com/aum/App.java)
  - Test Class: [AppTest.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/demo/src/test/java/com/aum/AppTest.java)
  - Project Config: [pom.xml](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/demo/pom.xml)

---

### 2. [JUNITL-01](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNITL-01) - Annotation-Based JUnit 4
*A transition project showing the clean-up of boilerplate code using JUnit 4 annotations.*
* **Concepts Covered**: Annotation-driven testing, basic mathematical assertions.
* **Key Details**:
  - Eliminates the need to extend `TestCase`.
  - Introduces the `@Test` annotation (`org.junit.Test`) to mark methods for execution.
  - Leverages basic assertions like `assertEquals` from `org.junit.Assert`.
* **Important Files**:
  - Main Class: [Calc.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNITL-01/src/main/java/com/aum/Calc.java) (calculates division)
  - Test Class: [CalcTest.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNITL-01/src/test/java/com/aum/CalcTest.java)

---

### 3. [JUNIT-02nomaven](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT-02nomaven) - Basic JUnit 5 (No Build Tool)
*Using JUnit 5 Jupiter engine manually by linking external JARs in the IDE classpath without Maven.*
* **Concepts Covered**: Modern JUnit 5 API, package-private test methods.
* **Key Details**:
  - Relies on the modern Jupiter Engine (`org.junit.jupiter.api.Test` and `org.junit.jupiter.api.Assertions`).
  - Test classes and methods no longer need to be public; package-private access is default.
  - Tests basic shape calculations for square and circle areas.
* **Important Files**:
  - Main Class: [Shapes.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT-02nomaven/src/com/Shapes/Shapes.java)
  - Test Class: [ShapesTest.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT-02nomaven/test/com/Shapes/ShapesTest.java)

---

### 4. [jUNIT5-03maven](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/jUNIT5-03maven) - JUnit 5 & Lazy Messages (Maven)
*Implementing JUnit 5 within a standard Maven lifecycle, exploring functional paradigms.*
* **Concepts Covered**: Dependency management via Maven, Java 8 Lambdas in assertions.
* **Key Details**:
  - Uses `pom.xml` to fetch JUnit 5 Jupiter engine dependencies dynamically.
  - Demonstrates **Lazy Assertion Messages** using Java 8 functional interface/lambdas (`Supplier<String>`).
  - > [!TIP]
    > Standard error messages are concatenated eagerly, consuming CPU cycles and memory. By passing a lambda (`() -> "Message"`), the message is only evaluated/generated if the assertion actually fails.
* **Important Files**:
  - Main Class: [Shapes.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/jUNIT5-03maven/java/com/test/trial/Shapes.java)
  - Test Class: [TestTrail.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/jUNIT5-03maven/src/test/java/com/test/trial/TestTrail.java)

---

### 5. [JUNIT5-04-Exception](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-04-Exception) - Pre-Assertion Exception Handling
*A project illustrating how exception verification was traditionally done inside unit tests.*
* **Concepts Covered**: Exception testing, try-catch in test suites.
* **Key Details**:
  - Uses typical try-catch patterns within test blocks to intercept and check exceptions (e.g. catches a `NullPointerException` thrown when a sorting utility attempts to process a null array).
  - Prepares learners for the modern declarative alternative `assertThrows()` in JUnit 5.
* **Important Files**:
  - Main Class: [SortingArray.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-04-Exception/src/main/java/com/learning/SortingArray.java)
  - Test Class: [TestSortingArray.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-04-Exception/src/test/java/com/learning/TestSortingArray.java)

---

### 6. [JUNIT5-05-timeout](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-05-timeout) - Performance & Timeout Assertions
*Verifying service-level agreements (SLAs) and method efficiency limits.*
* **Concepts Covered**: Performance verification, JUnit 5 Timeout APIs.
* **Key Details**:
  - Uses `assertTimeout(Duration, Executable)` to enforce time limits on operations.
  - Simulates a performance-heavy process (sorting an array 100,000,000 times inside a loop) and fails the test if execution exceeds `100` milliseconds.
* **Important Files**:
  - Main Class: [SortingArray.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-05-timeout/src/main/java/com/learning/SortingArray.java)
  - Test Class: [TestSortingArray.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-05-timeout/src/test/java/com/learning/TestSortingArray.java)

---

### 7. [JUNIT5-06-BeforeAfterEach](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-06-BeforeAfterEach) - Method-Level Lifecycle Hooks
*Managing fresh states between independent test runs.*
* **Concepts Covered**: Method-level lifecycle, initialization setups.
* **Key Details**:
  - Introduces `@BeforeEach` and `@AfterEach` lifecycle annotations.
  - `@BeforeEach` runs a setup block (`init()`) prior to every individual test method, ensuring objects are fresh.
  - `@AfterEach` runs a teardown block (`destroy()`) immediately after every test completes, ideal for state reset.
* **Important Files**:
  - Main Class: [Shapes.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-06-BeforeAfterEach/src/main/java/com/learning/Shapes.java)
  - Test Class: [TestSortingArray.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-06-BeforeAfterEach/src/test/java/com/learning/TestSortingArray.java)

---

### 8. [JUNIT5-06-BeforeAfterAll](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-06-BeforeAfterAll) - Class-Level Lifecycle Hooks
*Initializing heavy resources once for the entire test suite.*
* **Concepts Covered**: Class-level lifecycle hooks, static setups.
* **Key Details**:
  - Introduces `@BeforeAll` and `@AfterAll` lifecycle annotations.
  - Under JUnit's standard model, these methods must be marked `static` because they execute before any test objects are created and after all runs complete.
  - > [!NOTE]
    > Essential for database connection establishment, spinning up container mocks, or opening shared reading streams.
* **Important Files**:
  - Main Class: [Shapes.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-06-BeforeAfterAll/src/main/java/com/learning/Shapes.java)
  - Test Class: [TestSortingArray.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-06-BeforeAfterAll/src/test/java/com/learning/TestSortingArray.java)

---

### 9. [JUNIT5-07-Instance](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-07-Instance) - Custom Test Instance Lifecycles
*Modifying how JUnit constructs test classes to optimize state management.*
* **Concepts Covered**: TestInstance lifecycle optimization (`PER_CLASS` vs `PER_METHOD`).
* **Key Details**:
  - By default, JUnit constructs a new instance of the test class for each test method (`PER_METHOD`) to ensure isolated states.
  - Reconfiguring this using `@TestInstance(TestInstance.Lifecycle.PER_CLASS)` instructs JUnit to reuse a single instance for the entire class.
  - With `PER_CLASS`, `@BeforeAll` and `@AfterAll` methods **do not** need to be static.
  - The class constructor runs exactly once, optimizing performance when initializing test classes.
* **Important Files**:
  - Main Class: [Shapes.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-07-Instance/src/main/java/com/learning/Shapes.java)
  - Test Class: [TestSortingArray.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5-07-Instance/src/test/java/com/learning/TestSortingArray.java)

---

### 10. [JUNIT5TEST](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5TEST) - Boilerplate Sandbox
*A clean workspace setup to practice and implement JUnit 5 tests from scratch.*
* **Concepts Covered**: Hands-on sandbox play.
* **Important Files**:
  - Main Class: [Shape.java](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/Module%205%20-%20JUNIT5/JUNIT5TEST/src/Shape.java) (blank container class)

---

## 💡 Quick Tips for JUnit Testing

1. **Assertion Message Optimization**: Eager string concatenation (`"Expected " + expected + " but got " + actual`) consumes resources even if the test passes. Always prefer Java 8 Supplier lambdas (`() -> "Message..."`) for performance-sensitive tests.
2. **Lifecycle Selection**: Use `@TestInstance(Lifecycle.PER_CLASS)` when you want to avoid `static` lifecycle methods or need to carry states across sequential tests (though writing stateless tests is always recommended!).
3. **Execution Timeout**: Always apply `assertTimeout` to integration tests or heavy computation methods to detect potential deadlocks or memory leaks early.
