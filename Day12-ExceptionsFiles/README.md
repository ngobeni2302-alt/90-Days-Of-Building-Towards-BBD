# Day 12: Advanced Error Handling & File Persistence (`Day12-ExceptionsFiles`)

Building upon the Object-Oriented payroll management system, **Day 12** focuses on enterprise-grade reliability: enforcing robust business rules via custom exceptions and ensuring data durability through file I/O serialization.

---

## Key Features Implemented

* **Custom Exception Hierarchy:**
* `DuplicateIdException` (Checked Exception, extending `Exception`): Enforces unique employee IDs at compile time.


* `EmployeeNotFoundException` (Unchecked Exception, extending `RuntimeException`): Handles lookup failures gracefully during runtime logic.

* **Data Persistence & File I/O (`FileStorage.java`):**
* Implemented CSV serialization to save and load company registry state (`Company`) across sessions.


* Leveraged `try-with-resources` (`BufferedWriter` / `BufferedReader`) to ensure automatic, safe file stream closure and prevent memory leaks.


* Forced `Locale.US` during string formatting to ensure standard decimal points (`.`) are used globally, preventing regional comma parsing errors.


* **Comprehensive Testing (`MainTest.java`):**
* Verified exception throwing behavior using JUnit 5's `assertThrows`.
* Validated end-to-end file save/load round-trips and payroll calculations.



---

## Project Structure

```text
src/
├── main/java/
│   ├── Company.java                  # Registry management with exception guards[cite: 8]
│   ├── Developer.java                # Developer subclass[cite: 7]
│   ├── DuplicateIdException.java     # Checked custom exception[cite: 6]
│   ├── Employee.java                 # Abstract base employee class[cite: 5]
│   ├── EmployeeNotFoundException.java# Unchecked custom exception[cite: 4]
│   ├── FileStorage.java              # CSV serialization & file persistence[cite: 3]
│   ├── Intern.java                   # Intern subclass[cite: 2]
│   └── Manager.java                  # Manager subclass[cite: 1]
└── test/java/
    └── MainTest.java                 # JUnit 5 test suite[cite: 9]

```

---

## Running the Tests

To compile and run the test suite via Maven, execute:

```bash
mvn test

```
