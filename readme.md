## Lambda Expressions
A lambda is a no-name implementation of a method in an interface.

For example the **Runnable Interface** has one method `run`:

```java 
public interface Runnable {
    void run();
}
```

In order to use this interface, like in the constructor of 
a **Thread**, we create an anonymous inner class:

```java
new Thread(new Runnable() {
    public void run() {
        System.out.println("Too verbose");
    }
})
```
Using lambdas, the following piece of code will do 
the same thing as the one above

```java
new Thread(() -> {System.out.println("Too verbose");})
```

`() -> System.out.println("Too verbose");}` is a lambda

A lambda consists of 3 parts:
- parameters
- arrow or lambda symbol (->)
- body (implementation of the method)

Accordingly,
`() -> {//statements}`

### What qualifies for lambda
For an interface and it's method to be used like we
did for the Runnable example above, the interface 
must have **exactly one abstract method**.
Such an interface is called a **Functional Interface**.

### Other notes
A lambda is not bound to any method or interface.

Imagine
```java
interface A {
    void print(String s);
    default sayHi() {
        System.out.println("Soy A");
    }
}

interface B {
    void print(String s);
    default sayHi() {
        System.out.println("Soy B");
    }
}
```
```java
(String s) -> {System.out.println("Test")}
``` 

is a valid
lambda that really is neither tied to interface A nor B

However, we can assign a lambda to an interface type
that matches its definition.

Hence we could do:
```java
A = (String s) -> {System.out.println("Test A")};
B = (String s) -> {System.out.println("Test B")};
```

## Interface Static Methods
Starting in Java 8, static methods can be added to interfaces.
```java
public interface StaticDemo {
    static String normalize(String s) {
        System.out.println("Invoked Static Interface Method");
        return s == null ? "Empty String" : s;
    }

    void print(String s);
}
```
### Notes:
- static methods must have a body
- to use a static method, use the name of the Interface dot static-method-name

### Why Static Methods
- think of them like utility or helper methods related to the interface functionality
  - for example `Stream.concat` in the Stream interface to concatenate 2 streams
  
- static methods are used to create instances of the interface type
  - for example `List.of`, `Stream.of`