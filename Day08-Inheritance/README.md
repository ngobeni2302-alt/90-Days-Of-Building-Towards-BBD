# Day 08 / 90 — Inheritance & Method Overriding: Savings Account

### Extending the Blueprint for Specialized Objects

> **The Journey:** On Day 07, we built a standard `BankAccount` with mutable state and transaction validation. On Day 08, we unlock one of the foundational pillars of Object-Oriented Programming: **Inheritance**. Rather than duplicating existing logic, we extend our base `BankAccount` to build a specialized `SavingsAccount`.

---

### What Are We Building Today?

A specialized **`SavingsAccount` class** that inherits all state and core behavior from `BankAccount` while adding interest management and strict minimum balance constraints:

```text
BankAccount (Superclass / Parent)
├── State: String accountNumber, protected double balance
└── Behavior: deposit(), withdraw(), getBalance()
        ▲
        │  extends
        │
SavingsAccount (Subclass / Child)
├── Additional State: double interestRate
├── New Behavior: applyInterest()  --> Adds interest to current balance
└── Overridden Behavior: withdraw() --> Enforces minimum balance threshold (R100.0)

```

---

### Key Object-Oriented Principles

#### 1. The `extends` Keyword & Code Reuse

A subclass automatically inherits non-private attributes and methods from its superclass:

#### 2. The `super` Keyword

The `super()` constructor call explicitly passes parameters up to the superclass constructor to handle base initialization. **It must always be the very first statement** in the subclass constructor.

#### 3. Access Modifiers: `protected` vs `private`

To allow child classes direct, safe access to a field while keeping it private from outside code, change its visibility in `BankAccount` from `private` to `protected`:

#### 4. Method Overriding (`@Override`)

Subclasses can redefine how inherited methods behave. In `SavingsAccount`, we override `withdraw()` to require a minimum balance buffer (e.g., R100.0 remaining after withdrawal).

---

### Behavioral Requirements & Validation

1. **Minimum Balance Constraint:** Withdrawals must fail if the remaining balance after withdrawal drops below **R100.0**.
2. **Interest Calculation:** `applyInterest()` calculates accrued interest based on `interestRate` and deposits it into the account:

$$\text{balance} = \text{balance} + (\text{balance} \times \text{interestRate})$$


3. **Atomic Integrity:** If a withdrawal violates the R100.0 minimum balance threshold, throw an `IllegalArgumentException` and ensure the balance remains untouched.

---

### Tests to Satisfy (JUnit Suite)

Your implementation will be verified against:

* Inherited behavior functioning seamlessly (deposits, base getters).
* `applyInterest()` correctly calculating and increasing the account balance.
* Overridden `withdraw()` permitting withdrawals that maintain $\ge \text{R100.0}$.
* Overridden `withdraw()` throwing `IllegalArgumentException` when attempting to drop below R100.0, leaving state unchanged.

### How To Run

Execute the test suite via Maven:

```bash
mvn test

```
