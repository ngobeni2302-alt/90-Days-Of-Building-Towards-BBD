# Day 03 / 90 — Loops

### Learning how to stir the pot over and over

> **The Journey:** Day 01 we switched on the stove. Day 02 we checked if the food was cooked. Day 03? We learn how to stir the pot 10 times without getting tired.

---

### What Are We Building Today?

Writing repetitive code by hand is the fastest way to burn out. Today we build two automation robots using Java loops:

1. **Multiplication Table Robot:** You give it a number (e.g., `5`), and it automatically counts and prints the full multiplication table up to 10:
```text
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50

```


2. **Sum & Accumulator Robot:** You give it a number (e.g., `5`), and it calculates the cumulative sum from 1 to that number ($1 + 2 + 3 + 4 + 5 = 15$).

---

### How Loops Work — Counting Spoons

Instead of writing `System.out.println` ten times, we use a `for` loop to repeat behavior efficiently:

```java
for (int i = 1; i <= 10; i++) {
    // Repeated block of logic
}

```

* **`int i = 1` (Initialization):** Sets our starting counter (our first spoon).
* **`i <= 10` (Condition):** The loop continues running as long as this condition holds true.
* **`i++` (Iteration/Increment):** Adds 1 to our counter after each loop cycle (`1, 2, 3... 10`).

#### Accumulating Values (The Sum Bowl)

For our sum calculator, we introduce an **accumulator variable** (a bowl initialized at `sum = 0`). On each loop iteration, we add the current counter value to the bowl (`sum += i`), building up the total step-by-step.

---

### Engineering Insight: The Off-By-One Trap (`<=` vs `<`)

A classic software bug is the **off-by-one error**.

* If you write `i < 10`, the loop stops at `9`, completely missing `10`!
* Because we want inclusive boundaries (from 1 up to and including 10), we use the **less-than-or-equal-to** operator (`<= 10`). Interviewers love checking if you catch these subtle boundary details.

---

### Taste Tests (JUnit Suite)

Our verification strategy checks both correct output generation and edge-case error handling:

1. **Multiplication Table:** Verifies that the table for `5` starts correctly at `5 x 1 = 5` and terminates cleanly at `5 x 10 = 50`.
2. **Summation:** Verifies that the sum from 1 to 5 equals `15`, and the sum from 1 to 10 equals `55`.
3. **Defensive Guardrails:** Ensures inputs like `0` or negative numbers (`-5`) throw an `IllegalArgumentException`.

---

### How To Run

Execute the test suite via Maven:

```bash
mvn test

```