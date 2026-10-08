# Day 04 / 90 — Arrays

---

### What Are We Building Today?

An **Array Data Processor Robot** capable of running essential aggregations and transformations on fixed-size numeric datasets:

```text
Input:  [10, 20, 5, 30, 15]

Operations:
├── Max Value:      findMax(arr)
├── Min Value:      findMin(arr)
├── Sum:            calculateSum(arr)
├── Average:        calculateAverage(arr)
└── Reversed:       reverseArray(arr)

```

---

### Conceptual Mental Model — The Egg Tray

Think of a Java array like an egg tray with fixed slots:

* Every slot holds one value of the same type (`int[]`).
* Indices always start at **0** and end at **`arr.length - 1`**.
* The size is fixed once declared—you cannot add or remove slots dynamically.

---

### Core Operations to Implement

#### 1. Tracking Extremes (`findMax` & `findMin`)

Iterate through the array while keeping track of the largest or smallest number seen so far.

* *Think about:* What should your initial `max` or `min` variable be set to before starting the loop?

#### 2. Sum & Average (`calculateSum` & `calculateAverage`)

Reuse the accumulator pattern from Day 03 to sum all elements, then calculate the average.

* *Watch out:* Dividing two integers (`int / int`) in Java drops decimal places. Make sure your average method returns a double with proper decimal precision!

#### 3. Array Reversal (`reverseArray`)

Construct a new array of identical length and populate it in reverse order.

* *Index Mapping Challenge:* How do you map the loop counter `i` so that index `0` in the new array gets the last item of the original array?

---

### Engineering Guardrails & Validation

Your methods must be resilient against bad input:

* **Null & Empty Check:** If the array passed in is `null` or empty (`arr.length == 0`), throw an `IllegalArgumentException` before processing.

---

### Tests to Satisfy (JUnit Suite)

Your implementation will be verified against:

* Standard arrays (e.g., `[10, 20, 5, 30, 15]`) evaluating correct max, min, sum, average, and reversed output.
* Single-element arrays (e.g., `[7]`).
* Error handling tests for `null` or empty array inputs.

---

### How To Run

Execute the test suite via Maven:

```bash
mvn test

```