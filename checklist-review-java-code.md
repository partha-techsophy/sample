# Java review checklist

## General

### The Four Principles Of Simple Design

* Runs all tests
* Contains no duplication
* Express intent of programmers
* Small

### Runs all tests
We want to keep running all the tests continuously, because we want the code to work, at all times.

If you can’t prove that your system works and does what it is required to do then it doesn’t really matter if your design is simple or complex. It will also be harder to maintain and bugs tend to creep in undetected.

### Contains no duplication
The second principle stresses on the fact that your code should have as little duplication as possible. The application shouldn’t contain any knowledge duplication, also known as “Don’t Repeat Yourself” (DRY).

A good example is to create common components, whereever possible, in the design of large applications. This helps centralize the logic and allow other applications to reuse them.

### Express intent of programmers
Your code should be easy to read, and your design, simple to understand. This principle is also called Clarity Of Code.

When you look at a piece of code it should immediately tell you what it does and it shouldn’t surprise you. Variable, method, and class names should describe what they do. This is also refered to as the principle of least astonishment or the element of least surprise.

### Small
The application shouldn’t have pieces that you don’t need. Remove any dead code, resist the urge to design for the future things you are not sure of you need. Does the application contain parts that seemed a good idea at the time, but was never fulfilled? Time to revise that.

You should have

* Small methods, just make sure your methods do only one thing.
* Small classes, make sure the class doesn't have too many responsabilities.
* Minimum number classes and methods

Lesser code you have, lesser code you have to maintain. Always aim to keep things simple.

## Architecture
1. Frameworks choice, ask yourself why the framework was choosen, what are the other farmeworks available?
2. Communication with other systems
3. Components, how components are connected, data is exchanged, and how they all work together as a coherent system.
4. Testablity, designing for testability, make sure that your products and services are composed of loosely-coupled, well-encapsulated components or modules.
5. Reuse

## Design
1. Interaction between classes, coupling and cohesion
2. Layer responsibiltiy e.g. web layer, service layer
3. Unit tests, how easy to unit test
4. OOPS principle

## Code
1. Scalability
2. Secuirty
3. Unit tests - Readability, the real problems that complicate unit testing, and introduce expensive complexity, are a result of poorly-designed, untestable code.
4. Basics
    * Formatting
    * Size, the first rule of classes is that they should be small. The second rule of classes is that they should be smaller than that.
    * Complexity
    * New language feature, are you using any 
    * Documentation
5. Performance
    * No premature optimisation
    * Object creation in loop
    * Closing connections and other open items
    * Session usage
    * Caching
    * Database related
6. Language specific
    * Object class & methods
    * String
    * Generics
    * Enums
    * Creating and destroying objects
7. Engineering practices
    * How often is code commited?
    * Release practices
    * Broken builds
    * Deployment practices
    * Continuous integration

## Static code analysis
1. Components & their size and interactions
2. Hotspots
    * Large classes
    * Complex methods
    * Large components
    * Lot of dependencies
    * Uncovered code
3. Sonarlint report