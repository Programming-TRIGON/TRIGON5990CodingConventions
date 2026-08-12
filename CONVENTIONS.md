# Coding Conventions Guide

This document outlines the specific coding standards for our FRC robot codebase. Strict adherence to these rules keeps our code clean, predictable, and easy to navigate.

## 1. Naming Conventions
Names should always be clear and meaningful, prioritizing descriptiveness over brevity. Even if a variable or method name becomes long, it is better to be explicit than ambiguous.

| Element | Case Rule | Example |
| :--- | :--- |:---|
| **Packages** | entirely lowercase | `examplepackage`, `subsystems` |
| **Classes / Interfaces** | UpperCamelCase | `GeneralConventions`, `SwerveDrive` |
| **Methods** | lowerCamelCase | `calculateTargetVelocity()`, `stop()` |
| **Booleans (Variables & Methods)** | Prefix with `is`, `should`, `has`, etc. | `isOpen()`, `SHOULD_USE_FOC` |
| **Static Variables** | UPPER_SNAKE_CASE | `MAXIMUM_SPEED`, `TARGET_STATE` |
| **Non-Static Variables** | lowerCamelCase | `currentVelocity`, `targetAngle` |
| **Constants (Static Final)** | UPPER_SNAKE_CASE | `WHEEL_RADIUS_METERS` |
| **Enums (Name)** | UpperCamelCase | `IntakeState`, `ElevatorState` |
| **Enums (States)** | UPPER_SNAKE_CASE (Future Tense) | `PREPARE_FOR_SCORING`, `SCORE`, `STOP` |

## 2. Variable Ordering
Variables within a class must be ordered strictly by the following hierarchy.
*Note: Constants are just `static final` variables.*

1. **Static vs Non-Static:** All `static` variables go above all non-static variables.
2. **Final vs Non-Final:** Within the static/non-static groups, `final` variables go above non-final variables.
3. **Access Modifier:** Within the final/non-final groups, order by access level: `public`, then `protected`, then default (package-private), then `private`.
4. **Importance:** Finally, group by logical importance to the class.

### SubsystemConstants Specific Ordering
For `SubsystemConstants` files, follow this specific logical order. **Similar constants must be grouped together, with a single blank line separating each distinct group** to maintain readability (e.g., separating hardware IDs from tuning values).

1. Motor Initialization
2. Motor Configuration
3. Simulation Configuration
4. SysID Configuration
5. Visualization Initialization & Configuration
6. Miscellaneous
7. `static {}` block (where configure methods are called)
8. Configuration methods
9. Enums

## 3. Method Ordering
Methods follow a similar hierarchical structure to keep class flow predictable:

1. **Static Methods:** Placed at the very top of the method section.
2. **Constructors:** Placed immediately after static methods.
3. **Other Methods:** Sorted primarily by access modifier (`public`, `protected`, default, `private`).
4. **Caller over Callee:** A method should be placed directly above the method it calls (usage-based ordering).
    - *Exception:* If a `private` method calls a `public` method, the `public` method remains above the `private` method due to the access modifier rule.
5. **Importance:** Group by logical importance if the above rules result in a tie.

## 4. Modifiers and Variables
- **Constants:** Use `static final` for values universally fixed throughout the program's lifecycle (e.g., physical dimensions, tuning values).
- **Local Finals:** Any local variable inside a method that *can* be final *must* be marked as `final`.
- **Method Parameters:** Method parameters should **never** be marked as `final`.

## 5. Formatting and Spacing
- **Variable Grouping:** When declaring similar variables or constants of the same type, write the access modifier and type once, and separate each variable with a comma and a new line.
- **Method Spacing:** There must be exactly **one** blank line before and after each method. Never use more than one consecutive blank line anywhere in a file.
- **Logical Grouping:** Separate large blocks of code within a method by a single blank line where it logically makes sense (e.g., separating a calculation block from a validation block).
- **Curly Braces:** If an `if` statement or a `for` loop contains only a single short statement, **omit** the curly brackets.

## 6. Documentation
- Complex methods must have Javadocs explaining their logic and purpose.
- Extract similar logic used in multiple places into a single helper method to avoid code duplication.