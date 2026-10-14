# Day 10 / 90 — Abstraction + Inheritance + Polymorphism COMBINED 

The Trinity: One abstract blueprint, multiple specialized workers, endless scalability

The Evolution: On Day 09, we built a `Bank` holding mixed accounts using polymorphism. 
Today on Day 10, we combine all three pillars of OOP—**Abstraction**, **Inheritance**, and **Polymorphism**—into a complete enterprise payroll system!

---

### Class Architecture & Specifications

Here is the exact blueprint of the classes, fields, and methods you need to build:

#### 1. `Employee` (Abstract Parent Class)

*Serves as the abstract blueprint for all company workers.*

* **Fields:**
* `protected String name`
* `protected String id`
* `protected double baseSalary`


* **Constructors:**
* `Employee(String name, String id, double baseSalary)`


* **Abstract Methods (Must be implemented by children):**
* `public abstract double calculateSalary()` — Returns `double`
* `public abstract String getRole()` — Returns `String`


* **Concrete Methods:**
* `public String getName()` — Returns `String`
* `public String getId()` — Returns `String`
* `public double getBaseSalary()` — Returns `double`



#### 2. `Developer` (Concrete Subclass)

*Extends `Employee` with a specific coding bonus structure.*

* **Fields:**
* `private double codingBonus`


* **Methods:**
* `Developer(String name, String id, double baseSalary, double codingBonus)`
* `public double calculateSalary()` — Returns `double` (`baseSalary + codingBonus`)
* `public String getRole()` — Returns `String` (`"Developer"`)



#### 3. `Manager` (Concrete Subclass)

*Extends `Employee` with a management performance bonus.*

* **Fields:**
* `private double managementBonus`


* **Methods:**
* `Manager(String name, String id, double baseSalary, double managementBonus)`
* `public double calculateSalary()` — Returns `double` (`baseSalary + managementBonus`)
* `public String getRole()` — Returns `String` (`"Manager"`)



#### 4. `Intern` (Concrete Subclass)

*Extends `Employee` working on a fixed stipend model.*

* **Methods:**
* `Intern(String name, String id, double baseSalary)`
* `public double calculateSalary()` — Returns `double` (`baseSalary`)
* `public String getRole()` — Returns `String` (`"Intern"`)



#### 5. `PayrollSystem` (The Container Class)

*Manages a collection of mixed employee records securely.*

* **Fields:**
* `private List<Employee> employees`


* **Methods:**
* `PayrollSystem()` — Initializes an empty `ArrayList<>`
* `public void addEmployee(Employee employee)` — Adds worker to list (throws `IllegalArgumentException` if `null`)
* `public double getTotalPayroll()` — Loops through list, calls `calculateSalary()` polymorphically, and returns `double` total sum
* `public Employee findEmployee(String id)` — Searches list by ID using `.equals()`, returns matching `Employee` object or `null`
* `public List<Employee> getEmployees()` — Returns a defensive copy `new ArrayList<>(employees)` to protect internal state

---

### How This Project Uses All 3 Pillars Together

1. **Abstraction (`Employee`):**
* You cannot do `new Employee(...)` directly.
* Abstract methods force every subclass to provide its own calculation rules, hiding complexity from the main system.

2. **Inheritance (`extends`):**
* Subclasses inherit `name`, `id`, and `baseSalary` instantly via `super()`, upholding the DRY principle. A `Developer` *IS-A* `Employee`.

3. **Polymorphism (`List<Employee>`):**
* A single list holds Developers, Managers, and Interns together.
* Calling `e.calculateSalary()` or `e.getRole()` inside a loop dynamically triggers the correct subclass logic at runtime without messy `instanceof` checks.

---

### How To Run the Tests

Verify your implementation and watch your test suite pass with Maven:

```bash
mvn test

```