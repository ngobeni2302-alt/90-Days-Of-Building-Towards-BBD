# Day 05 / 90 — Strings

### Reading Labels on Pots

> **The Journey:** Day 04 was about managing trays of numbers (`int[]`). Day 05 is about processing text—reading, parsing, and transforming sequences of characters using **Strings**.

---

### What Are We Building Today?

A **String Data Processor Utility** capable of analyzing text, evaluating character patterns, and performing string transformations:

```text
Input:  "RaceCar"

Operations:
├── Reversed:          reverseString(str)      --> "raCecaR"
├── Is Palindrome:     isPalindrome(str)       --> true (case-insensitive)
├── Vowel Count:       countVowels(str)        --> 3
└── Word Count:        countWords(str)         --> 1

```

---

### Conceptual Mental Model — The Letter Necklace

Think of a Java `String` as a necklace made of ordered letter beads:

* Each character occupies a zero-based position from **`0`** to **`str.length() - 1`**.
* Strings in Java are **immutable**—you don't change the original necklace; you craft a new string or inspect its individual character beads using `.charAt(index)`.

---

### Core Operations to Implement

#### 1. String Reversal (`reverseString`)

Construct a new inverted string by traversing the input sequence from end to start.

* *Loop Control:* How do you set up your loop counter to count downwards from `str.length() - 1` down to `0`?

#### 2. Palindrome Verification (`isPalindrome`)

Determine if a word reads identical forwards and backwards (e.g., `"racecar"` or `"Madam"`).

* *Case Sensitivity Challenge:* Standard equality checks treat `'M'` and `'m'` differently. How can converting your string `.toLowerCase()` simplify comparison logic?

#### 3. Vowel & Word Counting (`countVowels` & `countWords`)

* **Vowels:** Iterate through the string character by character and count occurrences of `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.
* **Words:** Parse words cleanly by evaluating space boundaries or using string splitting patterns.

---

### Engineering Guardrails & Validation

Your methods must gracefully handle edge cases before execution:

* **Null & Empty Guard Clause:** If `str` is `null`, throw an `IllegalArgumentException`.
* **Empty/Whitespace Edge Cases:** Handle empty strings (`""`) predictably without triggering index out-of-bounds errors.

---

### Tests to Satisfy (JUnit Suite)

Your implementation will be verified against:

* Standard words and multi-word sentences.
* Case-insensitivity assertions for palindrome evaluation (e.g., `"Racecar"` $\rightarrow$ `true`).
* Special edge cases (single-character strings, empty strings, strings with trailing/leading spaces).
* Error handling assertions for `null` string parameters.

---

### How To Run

Execute the test suite via Maven:

```bash
mvn test

```