# Day 07 / 90 — State Management & Encapsulation: The Bank Account

### A Stateful Object That Remembers

> **The Journey:** On Day 06, we built the `Student` class—a static blueprint whose attributes are set at birth. On Day 07, we level up to **stateful objects**. Unlike a student whose grades are fixed at creation, a `BankAccount` evolves over time: it accepts deposits, processes withdrawals, and remembers its balance across operations.

---

### What Are We Building Today?

A custom **`BankAccount` class** that manages dynamic financial state safely:

```text
BankAccount Object
├── State (Private Fields)
│   ├── String accountNumber
│   └── double balance (starts at 0.0 or initial deposit)
│
└── Behavior (Public Methods)
    ├── deposit(double amount)   --> Adds funds if valid
    ├── withdraw(double amount)  --> Removes funds if valid & sufficient
    └── getBalance()             --> Safe read-only access to state

```

---

### Conceptual Mental Model — The Stateful Pot

Think of a `BankAccount` as a secure vault pot:

* **The State (`balance`)** lives securely inside the pot. Outside code cannot reach in and rewrite the numbers directly (`private double balance`).
* **Deposits** are like adding coins through the slot. The system checks that you aren't trying to deposit negative money or zero.
* **Withdrawals** require two strict checks:
1. Is the requested amount positive?
2. Do you actually have enough money in the pot to cover it?


* **Atomic Integrity (The Hard Part):** If a withdrawal fails because funds are insufficient, the transaction must abort completely. **The balance must remain untouched.** A failed operation should never leave your object in a half-broken state.

---

### Core Concepts to Implement

#### 1. Encapsulated State

Keep the balance strictly private to prevent external tampering:

#### 2. Defensive Deposits

Ensure deposits are valid before updating state:

#### 3. Secure Withdrawals with Guard Clauses

Guard against negative inputs *and* overdraft attempts:

---

### Tests to Satisfy (JUnit Suite)

Your implementation will be verified against:

* Initial balance setup.
* Successful deposits increasing the balance correctly.
* Successful withdrawals decreasing the balance correctly.
* Defensive validation throwing exceptions for negative or zero amounts.
* Overdraft protection throwing exceptions and **leaving the original balance completely unchanged** when withdrawals fail.

---

### How To Run

Execute your test suite via Maven:

```bash
mvn test

```