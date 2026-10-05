# Day 01 / 90 — Simple Calculator
### Learning how to switch on the stove

> Lucky from BBD said: "If you want to work at BBD, you need to know how to cook."
> Today I learned how to switch on the stove.

---

### What Are We Building Today?

Imagine you have a little robot friend.

You tell the robot: "Hey robot, I have 10 apples. I add 2 more apples. How many do I have?"

And the robot says: "You have 12.5 apples!"

That robot is our Calculator. It's a very small, very simple program.

We are building it in Java.

### Why Are We Building This?

Before you can cook a big meal, you must learn how to switch on the stove.

Before you can be a big software engineer at BBD, you must learn the very basics:

1.  How to ASK someone for something (this is `Scanner` in Java)
2.  How to REMEMBER something (this is a `variable` like `num1`)
3.  How to CHOOSE what to do (this is `switch` and `if`)

If you don't know these 3 things, you can't cook anything.

### Our Ingredients (What We Need)

Think of coding like cooking. We need ingredients:

1.  **num1** - The first number. Like 10.5. This is a `double`. A double means it can have a little dot, like 10.5, not just 10.
2.  **operator** - What do you want to do? `+` means add, `-` means minus, `*` means times, `/` means divide. This is a `char`. A char is just one single letter or symbol.
3.  **num2** - The second number. Like 2.
4.  **Scanner** - This is our ears. It listens to what the human types on the keyboard.

### Step By Step — How The Robot Thinks

This is exactly what our code does, in baby steps:

**Step 1: Say Hello**
The program says: "=== Day 01 - Simple Calculator ==="

**Step 2: Ask for First Number**
It says: "Enter first number: "
Then it WAITS. You type 10.5 and press Enter.
It REMEMBERS 10.5 inside a little box called `num1`.

**Step 3: Ask What To Do**
It says: "Enter operator (+, -, *, /): "
You type `+`
It REMEMBERS `+` inside a box called `operator`.

**Step 4: Ask for Second Number**
It says: "Enter second number: "
You type 2. It REMEMBERS 2 inside `num2`.

**Step 5: Decide What To Do**
It looks at the `operator` box.

- If box says `+`, it does `num1 + num2` = 10.5 + 2 = 12.5
- If box says `-`, it does `num1 - num2` = 10.5 - 2 = 8.5
- If box says `*`, it does `num1 * num2` = 10.5 * 2 = 21
- If box says `/`, it does `num1 / num2` = 10.5 / 2 = 5.25

This choosing part is called a `switch`. Like a train switch that changes tracks.

**Step 6: Be Careful!**
Two dangerous things can happen:

1.  You try to divide by 0. Like 10 / 0. You can't divide pizza into 0 pieces. It's impossible. So robot says "Error: Cannot divide by zero" and does NOT crash.
2.  You type `%` which we didn't teach it. Robot says "Error: Invalid operator".

Being careful is what BBD loves. Good engineers don't just make it work when everything is perfect. They make it NOT break when things are wrong.

**Step 7: Say The Answer**
It says: "Result: 10.5 + 2.0 = 12.5"

Done!

### Why We Use `double` and Not `int`?

This is super important.

- `int` means integer. Like 1, 2, 3, 10. No dot. If you do 5 / 2 with `int`, Java says 2. It throws away the .5. It chops it.
- `double` means it can have a dot. Like 10.5, 2.5. If you do 5 / 2 with `double`, Java says 2.5. It keeps the truth.

We want the truth, so we use `double`.

### Our Little Test — Did We Cook It Right?

How do we know our food tastes good? We taste it.

In coding, tasting is called Testing.

We wrote a little helper called `MainTest.java`. It tastes our calculator 7 times:

1.  Taste 10.5 + 2 — should be 12.5? YES
2.  Taste 10 - 2 — should be 8? YES
3.  Taste 5 * 3 — should be 15? YES
4.  Taste 5 / 2 — should be 2.5? YES (this proves we used double)
5.  Taste 10 / 0 — should shout Error? YES
6.  Taste 10 % 2 — should shout Invalid operator? YES
7.  Taste 5 / 2 again — did we remember double? YES

If all 7 tastes pass, our food is good!

### How To Run It On Your Computer

If you have Maven (the easy way):

mvn test

If you don't have Maven:

javac src/main/java/Main.java

java -cp src/main/java Main