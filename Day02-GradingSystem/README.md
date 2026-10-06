# Day 02 / 90 — Grading System
### Learning how to know if food is ready or burnt

> Day 01 we learned how to switch on the stove.
> Day 02 we learn how to check if the food is ready, okay, or burnt.

---

### What Are We Building Today?

Imagine you are a teacher.

A student comes to you and says: "Teacher, I got 85 marks."

You have to think and say:
- 85 is high! That's an A! Excellent!

Another student says: "I got 45 marks."
You think and say:
- 45 is low. That's an F. Fail.

That is what our program does. It's a Grading Robot.

### The Rules — Like Cooking Temperature

We have rules, like when you cook meat:

- If temperature is 80 to 100 degrees = PERFECT (Grade A)
- If temperature is 60 to 79 degrees = GOOD (Grade B)
- If temperature is 50 to 59 degrees = OKAY, JUST COOKED (Grade C)
- If temperature is 0 to 49 degrees = BURNT / RAW (Grade F - Fail)
- If someone says temperature is 105 or -5 = That's impossible! Error!

We must teach the robot these rules.

### Ingredients

1.  **mark** - The number student got. Like 85. This is an `int` (whole number, no dot).
2.  **if / else if / else** - This is how robot makes decisions. Like: IF mark is big, THEN do this, ELSE IF mark is medium, THEN do that, ELSE do something else.
3.  **||** - Means OR. We use it to say: If mark is less than 0 OR more than 100, it's invalid.
4.  **getGrade()** - A little box that takes mark and returns A, B, C, or F. This is a method.
5.  **getMessage()** - Another box that takes A, B, C, F and returns a nice message.

### Step By Step — How Robot Thinks

**Step 1: Ask for mark**
Robot says: "Enter your mark (0-100): "
You type 85. Robot remembers 85 inside `mark`.

**Step 2: Check if it's impossible**
Robot asks: Is mark less than 0? Or more than 100?
If YES -> Shout "Error: Invalid mark! Must be 0-100" and stop.
If NO -> Continue.

**Step 3: Check grades — HIGHEST FIRST!**
This is super important. You must check biggest number first.

Robot does:
- Is mark >= 80? (Is 85 >= 80? YES!) -> Return "A" -> Stop checking.
- If first was NO, is mark >= 60? -> Return "B"
- If NO, is mark >= 50? -> Return "C"
- If still NO, then it must be 0-49 -> Return "F"

Why highest first? Imagine you check >=50 first. 85 is also >=50, so robot would wrongly give C to 85! So we check 80, then 60, then 50.

**Step 4: Give nice message**
If grade is A, robot says "Excellent! - BBD level"
If B, "Good job!"
If C, "Pass - keep cooking"
If F, "Fail - try again"

**Step 5: Show answer**
Robot says: "Mark: 85 -> Grade: A - Excellent! - BBD level"

### Why We Split Code Into Methods?

We made two little boxes: `getGrade()` and `getMessage()`.

Why? So we can TEST them. If all code is inside `main()`, we cannot test it easily.

`main()` only talks to human. The brain work is in `getGrade()`.

### Our Taste Tests (Tests)

We taste 7 times:

1.  80, 100, 85 should give A
2.  60, 79, 65 should give B
3.  50, 59 should give C
4.  0, 49 should give F
5.  101, 105 should shout Error
6.  -1 should shout Error
7.  Boundary test: 79 is B but 80 is A — one mark changes everything!

If all 7 pass, our food is perfect.

### How To Run

Test first:

mvn test

Talk to robot:

mvn exec:java -Dexec.mainClass="Main"