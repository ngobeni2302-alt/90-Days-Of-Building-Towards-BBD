# Day 06 / 90 — OOP & Encapsulation: The Student Class

### Building Our Own Custom Pots

> **The Journey:** Days 01 through 05 used built-in Java types like `int[]` and `String`. Day 06 marks a massive shift: **Object-Oriented Programming (OOP)**. Instead of relying on what Java gives us, we are forging our *own* custom data type: the `Student` class.

---

### What Are We Building Today?

A custom **`Student` blueprint** that bundles state (data) and behavior (methods) into a single encapsulated unit:

```
Student Object
├── State (Private Fields)
│   ├── String name
│   ├── int age
│   └── double marks
│
└── Behavior (Public Methods)
    ├── Getters (getName(), getAge(), getMarks())
    ├── getGrade()  --> Calculates letter grade based on marks
    └── isPass()    --> Returns true if marks >= 50

```

---

### Conceptual Mental Model — The Custom Pot Blueprint

Think of a Java `class` as a factory blueprint for a pot:

* **Fields (`name`, `age`, `marks`)** are the raw materials inside the pot.
* **Encapsulation (`private`)** locks those materials away so outside code cannot tamper with them directly. If someone wants to inspect the data, they have to ask politely using **getters** (`getName()`, etc.).
* **The Constructor** is the quality-control inspector on the factory line. It ensures that every `Student` born into the system is valid before creation is allowed.

---

### Core Concepts to Implement

#### 1. Private Fields & Encapsulation

Declare instance variables as `private` to protect object integrity:

```java
private String name;
private int age;
private double marks;

```

#### 2. The Constructor & Defensive Validation

When instantiating a `Student`, the constructor must guard against invalid inputs:

* **Name:** Cannot be null or blank.
* **Age:** Must be between 16 and 100 inclusive.
* **Marks:** Must be between 0 and 100 inclusive.
* *Guard Clause:* If any validation fails, throw an `IllegalArgumentException`.

#### 3. Behavioral Methods

Give your objects actions they can perform on themselves:

* **`getGrade()`**: Returns a letter grade (`'A'`, `'B'`, `'C'`, `'D'`, or `'F'`) based on the student's marks.
* **`isPass()`**: Returns a `boolean` indicating whether the student passed (e.g., marks $\ge 50$).

---

### Engineering Guardrails & Validation

Just like our array and string utilities, object instantiation must fail fast and loud when given bad data:

* Passing an age of `-5` or marks of `150` should immediately trigger an exception, preventing corrupt objects from existing in memory.

---

### Tests to Satisfy (JUnit Suite)

Your implementation will be verified against:

* Successful object creation with valid parameters.
* Encapsulation rules (fields are inaccessible from outside without getters).
* Boundary validation checks (throws `IllegalArgumentException` for out-of-range ages or marks).
* Correct grade calculation and pass/fail evaluation logic.

---

### How To Run

Execute the test suite via Maven:

```bash
mvn test

```