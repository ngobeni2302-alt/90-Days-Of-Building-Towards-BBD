# Day 11 / 90 — Mastering the Collections Framework: HashMap + ArrayList Hybrid 🚀

The Scale-Up: Instant lookups meet ordered collections

The Evolution: On Day 10, we built our complete payroll system using an `ArrayList`. Today on Day 11, we upgrade our architecture for enterprise-level performance by combining a `HashMap` with our list!

---

### The Problem & The Solution: $O(n)$ vs $O(1)$

* **The Old Way (`ArrayList` Search):** When searching a list item-by-item (`for` loop), Java checks every element from index 0 to the end. If you have 10,000 employees, a search could take up to 10,000 operations ($O(n)$ linear time).
* **The Upgrade (`HashMap` Lookup):** A `HashMap` acts like a wall of labeled drawers. When you ask for ID `"DEV-001"`, Java goes straight to that specific drawer instantly, taking the exact same amount of time whether you have 10 or 10,000 workers ($O(1)$ constant time).

---

### The Dual-Storage Strategy (Best of Both Worlds)

Real-world enterprise systems rarely rely on just one data structure. In our updated `PayrollSystem`, we keep **both**:

1. **`HashMap<String, Employee>`** — Powers lightning-fast lookups (`findById`) and protects against duplicate ID registrations.
2. **`List<Employee>`** — Preserves insertion order, handles total payroll summation (`getTotalPayroll()`), and makes role-based filtering (`findByRole()`) a breeze.

---

### Core Operations & Mechanics

* **`addEmployee(Employee employee)`**
* Checks for duplicate IDs instantly using `map.containsKey(employee.getId())`.
* If unique, stores the employee in **both** the `HashMap` and the `ArrayList` to keep them synchronized.


* **`findById(String id)`**
* Bypasses loops entirely: returns `map.get(id)` for instant $O(1)$ retrieval.


* **`findByRole(String role)`**
* Iterates through the ordered list to filter and collect all workers matching a specific role (e.g., all `"Developer"` objects).


* **`removeEmployee(String id)`**
* Locates the employee via the map, then safely removes them from **both** data structures so state never drifts out of sync.



---

### How To Run the Tests

Verify your new high-performance collection architecture with Maven:

```bash
mvn test

```