# Day 13 / 90 — Sorting & Searching

### Arranging and finding pots all by ourselves

**The Journey:** Yesterday we saved our pots to disk. Today? We are not letting Java do any of the heavy lifting. We are writing the loops ourselves to arrange pots from smallest to biggest and find them instantly.

---

### What Are We Building Today?

Manual sorting and searching are core technical interview tests. Today we are building three algorithms from scratch in `Sorter.java`:

1. **Bubble Sort by Salary:** Compares neighboring employee salaries and swaps them iteratively until the lowest salary bubbles to the front. We are adding a senior-level early-exit optimization (`swapped` flag) to instantly stop if the list is already sorted.
2. **Selection Sort by ID:** Scans through the list, finds the employee with the smallest ID, and shifts them to the front one step at a time.
3. **Binary Search by ID:** Performs lightning-fast lookups on a list that is already sorted by ID, repeatedly cutting the search space in half instead of checking every single item.

---

### How Algorithms Work — The Mechanics

* **Defensive Copying:** We create a new `ArrayList` wrapper from the input list so we never mutate or alter the original data collection.
* **Midpoint Overflow Protection:** When calculating our binary search middle index, we use `left + (right - left) / 2` instead of `(left + right) / 2` to strictly prevent integer overflow—a classic detail interviewers look for.
* **Time Complexity:** Moving from sluggish $O(n^2)$ sorting scans down to efficient $O(\log n)$ logarithmic searches.

---

### Input and Expected Output

#### **Input Data (Unsorted)**

* Sarah (ID: 2, Salary: 40,000)
* John (ID: 3, Salary: 10,000)
* Thabo (ID: 1, Salary: 21,500)

---

### **1. Bubble Sort by Salary (Lowest to Highest)**

* **Expected Output:**
```text
1. John - Salary: 10000.0
2. Thabo - Salary: 21500.0
3. Sarah - Salary: 40000.0

```
---

### **2. Selection Sort by ID (Lowest ID to Highest ID)**

* **Expected Output:**
```text
1. Thabo - ID: 1
2. Sarah - ID: 2
3. John - ID: 3

```
---

### **3. Binary Search for ID 2**

* **Expected Output:**
```text
Found: Sarah (ID: 2, Salary: 40000.0)

```
---

### Taste Tests (JUnit Suite)

Our verification strategy checks sorting order correctness, original list immutability, and binary search accuracy:

1. **Bubble Sort Test:** Verifies that salaries sort ascendingly and that the original input list size and order remain untouched.
2. **Selection Sort Test:** Confirms that employee IDs line up sequentially from lowest to highest.
3. **Binary Search Test:** Validates that target IDs are found instantly and missing IDs safely return `null`.

---

### How To Run

Execute the test suite via Maven:

```bash
mvn test

```