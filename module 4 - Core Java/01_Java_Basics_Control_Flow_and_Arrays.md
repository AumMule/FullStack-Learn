# Java Basics, Control Flow, and Arrays

This revision sheet covers the foundational aspects of Java: setup, compilation/execution mechanics, core syntax, operators, control flow structures, loops, and array manipulation.

---

## 1. Introduction & Environment Setup

### Java Development Kit (JDK) Setup
To run and develop Java programs, you need the JDK.
- **JDK (Java Development Kit):** The full developer toolset (compiler `javac`, packager, debugger, and JRE).
- **JRE (Java Runtime Environment):** Provides the libraries and resources to run a compiled program (includes JVM).
- **JVM (Java Virtual Machine):** The engine that executes Java bytecode on a host machine.

### Your First Java Program
Every Java application must have at least one class and a `main` method as the entry point:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

- `public`: Access modifier making the class/method visible to the system.
- `class`: Keyword used to declare a class.
- `static`: Allows the `main` method to run without instantiating the class.
- `void`: The return type of the method (returns nothing).
- `String[] args`: Command-line arguments.

---

## 2. How Java Works
Java is a **compiled and interpreted** language:

```
[Java Source File (.java)]
         │  (Compiled by 'javac')
         ▼
[Bytecode File (.class)]  <--- Platform Independent
         │  (Interpreted/JIT-compiled by JVM)
         ▼
[Machine Code (Binary)]   <--- Platform Specific
```

1. **Compilation:** `javac HelloWorld.java` compiles source code into intermediate bytecode (`HelloWorld.class`).
2. **Execution:** `java HelloWorld` runs the bytecode using the JVM.
3. **Write Once, Run Anywhere (WORA):** Bytecode can run on any system with a JVM, making Java platform-independent.

---

## 3. Variables & Data Types

### Variables
A variable is a container that holds data. Java is **strongly typed**; every variable must have a declared type.

### Primitive Data Types
Java has 8 primitive data types:

| Type | Size | Default Value | Range / Description |
| :--- | :--- | :--- | :--- |
| `byte` | 1 byte | `0` | `-128` to `127` |
| `short` | 2 bytes | `0` | `-32,768` to `32,767` |
| `int` | 4 bytes | `0` | `-2^31` to `2^31 - 1` (Default integer) |
| `long` | 8 bytes | `0L` | `-2^63` to `2^63 - 1` (Append `L` or `l`) |
| `float` | 4 bytes | `0.0f` | Single-precision fractional (Append `f`) |
| `double` | 8 bytes | `0.0d` | Double-precision fractional (Default decimal) |
| `char` | 2 bytes | `\u0000` | Single 16-bit Unicode character (Use `'a'`) |
| `boolean`| 1 bit | `false` | `true` or `false` |

### Literals
Literals are constant values assigned directly to variables.
```java
int binary = 0b101;     // Binary literal (value = 5)
int octal = 010;        // Octal literal (value = 8)
int hex = 0x1A;         // Hexadecimal literal (value = 26)
double sci = 1.2e3;     // Scientific notation (1200.0)
int underscores = 10_000_000; // Underscores for readability (value = 10000000)
char letter = 'A';      // Character literal
```

### Type Conversion (Casting)
- **Implicit (Widening) Casting:** Converting a smaller type to a larger type. Done automatically.
  `byte` -> `short` -> `char` -> `int` -> `long` -> `float` -> `double`
  ```java
  int num = 10;
  double d = num; // Automatic conversion
  ```
- **Explicit (Narrowing) Casting:** Converting a larger type to a smaller type. Requires manual casting.
  ```java
  double d = 10.5;
  int num = (int) d; // Truncates decimal part; num becomes 10
  ```
- **Type Promotion in Expressions:** Small types (`byte`, `short`, `char`) are promoted to `int` when evaluating expressions.
  ```java
  byte a = 10;
  byte b = 20;
  int c = a * b; // Result is promoted to int
  ```

---

## 4. Operators

### Assignment Operators
Used to assign values to variables: `=`, `+=`, `-=`, `*=`, `/=`, `%=`.
```java
int x = 10;
x += 5; // x = x + 5 (15)
```

### Relational Operators
Evaluate to a `boolean` (`true` or `false`): `==`, `!=`, `<`, `>`, `<=`, `>=`.
```java
int a = 10, b = 20;
boolean result = (a < b); // true
```

### Logical Operators
Used to combine multiple boolean conditions:
- **AND (`&&`):** Returns `true` if both conditions are true. (Short-circuiting: stops if first condition is false).
- **OR (`||`):** Returns `true` if at least one condition is true. (Short-circuiting: stops if first condition is true).
- **NOT (`!`):** Reverses the boolean value.
```java
boolean cond = (5 > 3) && (2 < 4); // true
```

---

## 5. Control Flow

### If-Else and If-Else-If
Executes a block of code based on a condition.
```java
int score = 85;

if (score >= 90) {
    System.out.println("Grade A");
} else if (score >= 80) {
    System.out.println("Grade B"); // Prints Grade B
} else {
    System.out.println("Grade C");
}
```

### Ternary Operator
Shorthand version of `if-else`.
Syntax: `condition ? expression_if_true : expression_if_false`
```java
int n = 10;
String result = (n % 2 == 0) ? "Even" : "Odd"; // "Even"
```

### Switch Statement
Selects one of many code blocks to execute.
```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday"); // Prints Wednesday
        break;
    default:
        System.out.println("Other day");
}
```
*Note: Starting from Java 12+, we have switch expressions:*
```java
String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    default -> "Other day";
};
```

---

## 6. Loops
Loops are used to execute a block of code repeatedly.

### While Loop
Executes as long as the condition is true. Checked at the **beginning**.
```java
int i = 1;
while (i <= 5) {
    System.out.print(i + " "); // Output: 1 2 3 4 5
    i++;
}
```

### Do-While Loop
Executes the block **at least once** because the condition is checked at the **end**.
```java
int i = 6;
do {
    System.out.print(i + " "); // Output: 6
    i++;
} while (i <= 5);
```

### For Loop
Best when the number of iterations is known beforehand.
```java
for (int i = 1; i <= 5; i++) {
    System.out.print(i + " "); // Output: 1 2 3 4 5
}
```

### Which Loop To Use?
- **`for` loop:** When you know exactly how many times to repeat (e.g., iterating through an array size `N`).
- **`while` loop:** When the number of iterations is dependent on a dynamic condition (e.g., reading a file until EOF).
- **`do-while` loop:** When you need the logic to run at least once (e.g., menu-driven programs).

---

## 7. Arrays

An array is a container object that holds a fixed number of values of a single type.

### Creation of Array
```java
// Declaration & Instantiation
int[] nums = new int[5]; // Allocates space for 5 ints (initialized to 0)

// Array Initialization
nums[0] = 10;
nums[1] = 20;

// Direct literal initialization
int[] primes = {2, 3, 5, 7, 11};
```

### Multi-Dimensional Arrays
Represented as arrays of arrays.
```java
int[][] matrix = new int[3][4]; // 3 rows, 4 columns
matrix[0][1] = 5;

// Direct initialization
int[][] table = {
    {1, 2, 3},
    {4, 5, 6}
};
```

### Jagged and 3D Arrays
- **Jagged Array:** Multi-dimensional array where rows have different lengths.
  ```java
  int[][] jagged = new int[3][];
  jagged[0] = new int[2];
  jagged[1] = new int[4];
  jagged[2] = new int[1];
  ```
- **3D Array:** Array of 2D arrays.
  ```java
  int[][][] space = new int[3][4][5];
  ```

### Drawbacks of Arrays
1. **Fixed Size:** Once created, its length cannot be changed.
2. **Homogeneous Data:** Can only store elements of the same type.
3. **No Built-in Methods:** Lacks helper methods for searching, sorting, insertion, or deletion (unlike Collections).

### Array of Objects
Allows storing references to objects instead of primitives.
```java
class Student {
    String name;
    int roll;
}

Student[] students = new Student[3];
students[0] = new Student();
students[0].name = "Alice";
students[0].roll = 101;
```

### Enhanced For Loop (For-Each)
Used exclusively to loop through elements of arrays or collections.
```java
int[] numbers = {10, 20, 30, 40};
for (int num : numbers) {
    System.out.println(num);
}
```
*(Note: You cannot modify array elements or get the current index using a for-each loop)*
