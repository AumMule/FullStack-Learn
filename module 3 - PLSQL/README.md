# 🗂️ PL/SQL Revision Guide & Cheat Sheet

This directory contains a simplified, four-part PL/SQL revision sheet designed to cover all key concepts, structures, syntaxes, and database behaviors required for exam readiness.

---

## 🗺️ Part Index

Click on any part below to view detailed syntaxes, behaviors, and code examples:

### 🧱 [Part 1: Core Declarations & Fetches](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/module%203%20-%20PLSQL/1.md)
*   **PL/SQL Block Structure** (`DECLARE`, `BEGIN`, `EXCEPTION`, `END;`)
*   **Variable Declarations & Assignments** (`:=`)
*   **Anchored Datatypes** (`%TYPE` and `%ROWTYPE`)
*   **Database Retrievals** (`SELECT INTO` and its exceptions: `NO_DATA_FOUND` / `TOO_MANY_ROWS`)

### 🚦 [Part 2: Control Flow & Error Handling](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/module%203%20-%20PLSQL/2.md)
*   **Conditional Structures** (`IF-THEN-ELSIF-ELSE` and `CASE` statements)
*   **Loop Constructs** (Basic `LOOP`, `WHILE` loop, and numeric `FOR` loop)
*   **Exceptions & Errors** (Predefined, Generic `WHEN OTHERS`, and User-Defined exceptions)

### 👁️ [Part 3: Cursors & Basic Subprograms](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/module%203%20-%20PLSQL/3.md)
*   **Multiple Row Processing** (Explicit Cursors vs. Implicit Cursor `FOR` loops)
*   **Procedures & Functions** (Definitions, behaviors, and key differences)
*   **Parameter Passing Modes** (`IN`, `OUT`, and `IN OUT`)

### 📦 [Part 4: Advanced DB Structures & Exam Readiness](file:///c:/Users/ommul/OneDrive/Desktop/cognizant/module%203%20-%20PLSQL/4.md)
*   **Logical Packaging** (Package Specification interfaces vs. Package Body implementations)
*   **Database Event Hooks** (Row-level Triggers, `BEFORE`/`AFTER` triggers, and `:OLD`/`:NEW` variables)
*   **Exam Readiness Summary Matrix** (Quick alignment check with Java equivalents)

---

## ⚡ Quick Start Checklist
1.  **Server Output:** Remember to enable output before executing PL/SQL blocks in CLI query tools:
    ```sql
    SET SERVEROUTPUT ON;
    ```
2.  **Execution:** End anonymous blocks with a `/` on a new line to compile and execute:
    ```sql
    BEGIN
       DBMS_OUTPUT.PUT_LINE('Ready to test!');
    END;
    /
    ```
