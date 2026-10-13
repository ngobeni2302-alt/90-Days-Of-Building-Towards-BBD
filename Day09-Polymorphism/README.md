# Day 09 / 90 — Polymorphism & Bank Manager

### One hand manages 100 pots

> **The Evolution:** On Day 08, we learned how to make special pots (`SavingsAccount`) from normal pots (`BankAccount`). Today on Day 09, we build a **Bank**—a secure shelf that can hold all of them at once!

---

### What Is Polymorphism?

Instead of creating separate lists for normal accounts and savings accounts, our Bank uses a single `List<BankAccount>`.

Because a `SavingsAccount` *is* a `BankAccount`, one list can hold multiple types of accounts side by side. That is **polymorphism**: *one collection type, many forms of objects*. When we ask them to do something, Java automatically figures out whether it's a normal account or a savings account and runs the correct behavior!

---

### Core Operations on the Shelf

* **`addAccount(BankAccount account)`** — Places a new pot securely onto our shelf.
* **`totalBalance()`** — Goes down the line, asks every pot for its money, and adds it all up.
* **`applyInterestToAll()`** — Walks the shelf, checks each pot, and if it's a savings account, rewards it with interest!
* **`findAccount(String accountNumber)`** — Searches the shelf by number to fetch the exact pot we are looking for.

---

### The Trickier Mechanics

#### 1. Checking Types & Casting (`instanceof`)

When `applyInterestToAll()` looks at our generic list of `BankAccount` objects, it sees them all as standard bank accounts. To figure out which ones are actually savings accounts so we can apply interest, we use a two-step check:

* **The Check (`instanceof`):** *"Are you a SavingsAccount?"*
* **The Cast `(SavingsAccount)`:** If yes, we temporarily put on special glasses to treat it as a savings account so we can call `.applyInterest()`.

#### 2. Protecting Our Shelf (Defensive Copying)

When outsiders ask to see our list of accounts, we don't hand them the actual shelf—otherwise, someone could break or rearrange our accounts behind our backs!
Instead, we hand them a brand-new photocopy of the list using `new ArrayList<>(accounts)`, keeping our internal records completely safe and secure.

---

### How To Run the Tests

Verify your implementation with Maven:

```bash
mvn test

```