# Day 15: Introduction to JDBC and Databases
---

## Project Structure and File Specifications

### 1. `pom.xml` (Project Configuration)

* **Purpose:** Manages project metadata, Java compiler versions, and external dependencies.
* **Required Contents:**
* Maven compiler source and target set to Java 17.
* H2 database dependency (`com.h2database:h2:2.2.224`) for running the in-memory SQL database.
* JUnit 5 dependency (`org.junit.jupiter:junit-jupiter:5.10.0`) scoped for testing.



---

### 2. `DatabaseConnection.java` (Connection Manager)

* **Purpose:** Centralizes database configuration and provides active SQL connection instances.
* **Required Fields & Constants:**
* `URL`: `jdbc:h2:mem:companydb;DB_CLOSE_DELAY=-1` (Configures an in-memory H2 database that persists for the duration of the JVM execution).
* `USER`: `"sa"` (Default H2 system administrator username).
* `PASS`: `""` (Default empty password).


* **Required Methods:**
* `public static Connection getConnection() throws SQLException`: Opens and returns a new connection using `DriverManager.getConnection()`.



---

### 3. `Employee.java` (Domain Entity / POJO)

* **Purpose:** Acts as the data model representing a single employee record.
* **Required Fields:**
* `private int id;`
* `private String name;`
* `private String role;`
* `private double salary;`


* **Required Constructor:**
* `public Employee(int id, String name, String role, double salary)`: Initializes all private fields upon instantiation.


* **Required Getters:**
* `getId()`
* `getName()`
* `getRole()`
* `getSalary()`


* **Required Overridden Methods:**
* `public String toString()`: Returns a formatted string representation of the employee for console logging and debugging.



---

### 4. `EmployeeDAO.java` (Data Access Object)

* **Purpose:** Encapsulates all SQL execution logic, separating persistence operations from business logic.
* **Required Methods:**
* `public void createTable() throws SQLException`: Executes a `CREATE TABLE IF NOT EXISTS` statement defining columns (`id INT PRIMARY KEY`, `name VARCHAR`, `role VARCHAR`, `salary DOUBLE`).
* `public void addEmployee(Employee e) throws SQLException`: Inserts a record using a parameterized `PreparedStatement` to prevent SQL injection.
* `public Employee findById(int id) throws SQLException`: Queries a single record using a `PreparedStatement`, parses the `ResultSet`, and returns an `Employee` object (or `null` if not found).
* `public List<Employee> getAll() throws SQLException`: Executes a full table query, iterates through the `ResultSet` via `while(rs.next())`, and returns a populated `List<Employee>`.
* `public void delete(int id) throws SQLException`: Removes a record matching the specified primary key using a parameterized `PreparedStatement`.
* `public double totalPayroll() throws SQLException`: Executes an aggregate SQL query (`SELECT SUM(salary)`) and returns the total sum.


* **Architectural Requirements:**
* Must utilize `try-with-resources` for `Connection`, `Statement`, `PreparedStatement`, and `ResultSet` to prevent connection and memory leaks.



---

### 5. `Main.java` (Execution Runner)

* **Purpose:** Provides an executable entry point to test end-to-end database operations in a live environment.
* **Required Implementation (`main` method):**
* Instantiates `EmployeeDAO`.
* Calls `createTable()`.
* Inserts sample `Employee` records.
* Executes search, listing, payroll calculation, and deletion operations, printing output to the console.



---

### 6. `EmployeeTest.java` (Integration Test Suite)

* **Purpose:** Validates DAO functionality automatically using JUnit 5.
* **Required Setup and Test Methods:**
* `@BeforeEach setup()`: Initializes the DAO, creates the table, and clears existing rows before every test to ensure state isolation.
* `@Test testAddAndFind()`: Verifies that inserting an employee allows successful retrieval by ID.
* `@Test testGetAllAndPayroll()`: Verifies that multiple insertions return the correct list size and accurate payroll sum calculations.
* `@Test testDelete()`: Verifies that deleting an employee correctly removes them from the database.



---

## How to Build and Test

Navigate to the project root directory in your terminal and execute:

```bash
mvn clean test

```