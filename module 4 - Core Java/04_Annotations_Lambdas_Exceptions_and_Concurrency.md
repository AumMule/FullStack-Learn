# Annotations, Lambdas, Exceptions, Concurrency, & Collections

This revision sheet covers annotations, functional interfaces, lambda expressions, exception handling mechanisms, user input, multithreading, collections, and the Stream API.

---

## 1. Annotations & Functional Interfaces

### Annotations
Metadata that provides data about a program. They have no direct effect on the operation of the code they annotate.
- `@Override`: Marks overridden methods.
- `@Deprecated`: Marks obsolete APIs.
- `@SuppressWarnings`: Suppresses compilation warnings.
- `@FunctionalInterface`: Enforces that an interface contains exactly **one abstract method**.

### Functional Interfaces
An interface with exactly **one abstract method**. It can contain any number of static or default methods.
Java divides interfaces into three types:
1. **Normal Interface:** Multiple abstract methods.
2. **Functional Interface (SAM - Single Abstract Method):** Exactly one abstract method.
3. **Marker Interface:** Zero abstract methods (e.g., `Serializable`, `Cloneable`). Used to tag a class.

---

## 2. Lambda Expressions

A concise way to represent anonymous functions. Lambdas can only be used with **Functional Interfaces**.
Syntax: `(parameters) -> { body }`

### Lambda Expression Basic
```java
@FunctionalInterface
interface A {
    void show();
}

public class Main {
    public static void main(String[] args) {
        // Without lambda (Anonymous Inner Class)
        A obj1 = new A() {
            public void show() { System.out.println("Hello"); }
        };

        // With lambda (Shorter syntax)
        A obj2 = () -> System.out.println("Hello");
        obj2.show();
    }
}
```

### Lambda Expression with Return
If the lambda statement is a single expression that returns a value, the `return` keyword is omitted when brackets `{}` are omitted.
```java
@FunctionalInterface
interface Calc {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // Omitting curly braces & return keyword
        Calc obj = (a, b) -> a + b; 
        
        int result = obj.add(5, 4); // 9
    }
}
```

---

## 3. Exceptions

An exception is an unwanted or unexpected event that occurs during execution and disrupts the normal flow of instructions.

### Exception Hierarchy
```
             Throwable
            /         \
       Exception       Error (Out of Memory, StackOverflow, etc.)
       /       \
Checked      Unchecked (RuntimeException)
(IOException,  (NullPointerException, ArithmeticException, 
 SqlException)  ArrayIndexOutOfBoundsException)
```
- **Checked Exceptions:** Evaluated at compile-time. Subclasses of `Exception` (except `RuntimeException`). Must be handled using try-catch or throws.
- **Unchecked Exceptions:** Evaluated at runtime. Subclasses of `RuntimeException`. Usually represent logic errors.

### Exception Handling using `try-catch`
```java
try {
    int result = 10 / 0; // Throws ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero: " + e.getMessage());
}
```

### Try with Multiple Catch Blocks
Catch blocks should be ordered from **most specific to most general**.
```java
try {
    int[] a = new int[5];
    a[5] = 30 / 0;
} catch (ArithmeticException e) {
    System.out.println("Arithmetic error");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index out of bounds");
} catch (Exception e) {
    System.out.println("General error");
}
```

### The `throw` Keyword
Used to explicitly throw an exception.
```java
int age = 15;
if (age < 18) {
    throw new ArithmeticException("Not eligible to vote");
}
```

### Custom Exception
```java
class InvalidAgeException extends Exception { // Checked (extends Exception)
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
// Throw using: throw new InvalidAgeException("Age is invalid");
```

### Ducking Exceptions using `throws`
If a method does not want to handle an exception, it can delegate (duck) the exception to the calling method.
```java
class A {
    public void show() throws ClassNotFoundException {
        Class.forName("InvalidClass"); // Might throw checked exception
    }
}
```

### Try-With-Resources
Introduced in Java 7 to automatically close resources (like files, db connections) that implement `AutoCloseable`. No explicit `finally` block needed.
```java
try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    System.out.println("IO Error: " + e.getMessage());
} // br is automatically closed here
```

---

## 4. User Input Methods

### BufferedReader
Older, thread-safe, fast. Reads text buffer-wise. Requires handling checked exceptions.
```java
import java.io.InputStreamReader;
import java.io.BufferedReader;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line = br.readLine(); // Returns String
int num = Integer.parseInt(br.readLine()); // Parsing needed
```

### Scanner
Newer (Java 5), convenient, not thread-safe. Parses tokens and data types automatically.
```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int num = sc.nextInt();
String str = sc.next();
String line = sc.nextLine();
```

---

## 5. Threads & Concurrency

A thread is a lightweight subprocess; the smallest unit of execution.

### Creating Threads
1. **Extending Thread class:**
   ```java
   class MyThread extends Thread {
       public void run() { System.out.println("Running Thread"); }
   }
   // Execution: MyThread t = new MyThread(); t.start();
   ```
2. **Implementing Runnable interface (Preferred as Java allows multiple interfaces):**
   ```java
   class MyRun implements Runnable {
       public void run() { System.out.println("Running Runnable"); }
   }
   // Execution: Thread t = new Thread(new MyRun()); t.start();
   ```

### Thread Priority and Sleep
- **`Thread.sleep(ms)`:** Pauses thread execution for specified milliseconds.
- **Priority:** Ranges from `1` (MIN_PRIORITY) to `10` (MAX_PRIORITY). Default is `5` (NORM_PRIORITY). Helps thread scheduler decide execution sequence.
  ```java
  t1.setPriority(Thread.MAX_PRIORITY);
  ```

### Race Condition & `synchronized`
Occurs when multiple threads access shared mutable data simultaneously. Use `synchronized` keyword to lock a method or code block so only one thread can access it at a time.
```java
class Counter {
    int count;
    public synchronized void increment() {
        count++; // Thread-safe execution
    }
}
```

### Thread States
```
 NEW ──[start()]──> RUNNABLE ──[scheduler]──> RUNNING
                      ▲                         │
                      │                       [sleep() / wait()]
                      └────[notify() / time]────▼
                                             WAITING / BLOCKED
                                                │
                                              [Done]
                                                ▼
                                            TERMINATED
```
- **New:** Thread created but `start()` not called.
- **Runnable:** `start()` called; waiting for CPU scheduler.
- **Running:** Actively executing.
- **Waiting/Blocked:** Paused (`sleep()`, `wait()`, or waiting for locks).
- **Terminated:** `run()` method has completed execution.

---

## 6. Collection API

```
                     Collection (Interface)
                 /             |            \
          List (Interface)  Set (I)       Queue (I)
         /        \            |             |
     ArrayList  LinkedList  HashSet       Queue Classes
                            (LinkedHashSet)
                            (TreeSet)
                            
*Note: Map is part of java.util but does NOT inherit from Collection.*
```

- **ArrayList:** Re-sizable array. Maintains insertion order. Allows duplicate elements. Index-based fast access.
- **Set (HashSet, TreeSet):** Does not allow duplicates. `TreeSet` stores elements in sorted order.
- **Map (HashMap, TreeMap):** Stores Key-Value pairs. Keys must be unique.
```java
// List
List<Integer> nums = new ArrayList<>();
nums.add(5); nums.add(5); // Duplicates allowed

// Set
Set<Integer> unique = new HashSet<>();
unique.add(5); unique.add(5); // Stores only one '5'

// Map
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 95);
```

### Comparator vs Comparable
Used for sorting custom objects:
- **`Comparable`:** Used for natural ordering. The class must implement `Comparable` and override `compareTo()`. Only one sorting sequence possible.
- **`Comparator`:** Used for custom/multiple sorting sequences. Passed externally to sorting methods. Override `compare()`.

```java
// Comparable (Sorting students by Roll No)
class Student implements Comparable<Student> {
    int roll;
    public int compareTo(Student other) { return this.roll - other.roll; }
}

// Comparator (Sorting students by name length on the fly)
Comparator<Student> comp = (s1, s2) -> s1.name.length() - s2.name.length();
Collections.sort(studentList, comp);
```

---

## 7. Stream API

Introduced in Java 8 to process collections of objects in a functional style. Streams do **not** modify the original collections.

### Need of Stream API
Makes code concise, readable, and supports parallel processing easily without write-blocking boilerplate code.

### Stream Operations
- **`forEach()`:** Terminal operation to iterate through stream elements.
- **`filter()`:** Intermediate operation to filter elements matching a condition.
- **`map()`:** Intermediate operation to transform each element.
- **`reduce()`:** Terminal operation to combine stream elements into a single value.
- **`sorted()`:** Intermediate operation to sort stream.

```java
import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 8, 2, 7);

        // Filter even numbers, double them, sort them, and print
        nums.stream()
            .filter(n -> n % 2 == 0) // filter even: 4, 8, 2
            .map(n -> n * 2)         // double: 8, 16, 4
            .sorted()                // sort: 4, 8, 16
            .forEach(n -> System.out.println(n)); 
            
        // Reduce: Sum of all elements
        int sum = nums.stream()
                      .reduce(0, (c, e) -> c + e);
        System.out.println("Sum: " + sum);
    }
}
```
*(Intermediate operations return a new stream and are lazy. Terminal operations execute the pipeline and return a final result)*
