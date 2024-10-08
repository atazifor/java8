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

## Default Methods
Starting in Java 8, interfaces could have method implementations preceded with the `default` keyword.
And only interfaces can have default methods, not classes.

Default methods provide a way for new methods to 
be added to an interface in the future, 
without breaking the contract of implementation 
classes that clearly don't have this new method implemented.

Imagine we have the following interface.
```java
public interface IPhone {
   // abstract method
   public String getColor();
   // default method
   public default String printBrand() {
      System.out.print("Apple");
   }
}
```
And the following implementation:

```java
public class IPhone8Plus implements IPhone{
    @Override
    public String getColor() {
        return "Gray";
    }
}
```

If in the future we decide to add another method to the interface `IPhone`
we shall add it as a `default` method so that `IPhone8Plus` will continue to compile
```java
public interface IPhone {
   // abstract method
   public String getColor();
   // default method
   public default String printBrand() {
      System.out.print("Apple");
   }
  // default method
  public default String model() {
    System.out.print("Mini");
  }
}
```

## Streams
A streams is a sequence of elements usually from a collection. Streams perform a series of operations on this
sequence of elements.

Collection may be list, array, set, file or any sequence of elements.

Operations could be:
- Non-terminal: 
  - perform some action on the streams and return another streams with modified elements
  - leaves the streams "open"
- Terminal: 
  - closes the streams
  - returns a single result
  - no further action can be performed on the streams (since it's closed)
  - an IllegalStateException is thrown if you try to perform other non-terminal operations on a closed streams.
