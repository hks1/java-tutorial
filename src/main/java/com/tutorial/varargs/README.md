# varargs

handle an arbitrary number of parameters automatically – using an array under the hood.

define them using a standard type declaration, followed by an ellipsis:

```java
public String formatWithVarArgs(String... values) {
    // ...
}
```

And now, we can call our method with an arbitrary number of arguments, like:
```java
formatWithVarArgs();

formatWithVarArgs("a", "b", "c", "d");
```

**varargs are arrays so we need to work with them just like we'd work with a normal array.**

## Rules

- Each method can only have one varargs parameter
- The varargs argument must be the last parameter

## Heap Pollution

Using varargs can lead to so-called [Heap Pollution](https://en.wikipedia.org/wiki/Heap_pollution).

https://en.wikipedia.org/wiki/Heap_pollution

```java
static String firstOfFirst(List<String>... strings) {
    List<Integer> ints = Collections.singletonList(42);
    Object[] objects = strings;
    objects[0] = ints; // Heap pollution

    return strings[0].get(0); // ClassCastException
}
```

```java
String one = firstOfFirst(Arrays.asList("one", "two"), Collections.emptyList());

assertEquals("one", one);
```

**We would get a ClassCastException even though we didn't even use any explicit type casts here:**
`java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String`

## Safe Usage

**Every time we use varargs, the Java compiler creates an array to hold the given parameters.** In this case, the compiler creates an array with generic type components to hold the arguments.

When we use varargs with generic types, as there's a potential risk of a fatal runtime exception, the Java compiler warns us about a possible unsafe varargs usage:

> warning: [varargs] Possible heap pollution from parameterized vararg type T

**The varargs usage is safe if and only if:**

- We don't store anything in the implicitly created array. In this example, we did store a List<Integer> in that array
- We don't let a reference to the generated array escape the method (more on this later)
****If we are sure that the method itself does safely use the varargs, we can use `@SafeVarargs` to suppress the warning.

Put simply, the varargs usage is safe if we use them to transfer a variable number of arguments from the caller to the method and nothing more!

## Escaping Varargs Reference

Consider another unsafe usage of varargs
```java
static <T> T[] toArray(T... arguments) {
        return arguments;
        }
```

**because it let the varargs array escape to the caller, it violates the second rule of safe varargs.**

To see how this method can be dangerous, let's use it in another method:
```java
static <T> T[] returnAsIs(T a, T b) {
    return toArray(a, b);
}
```

Then if we call this method:
```java
String[] args = returnAsIs("One", "Two");
```

We would, again, get a _ClassCastException_. Here's what happens when we call the _returnAsIs_ method:

- To pass a and b to the toArray method, Java needs to create an array
- Since the Object[] can hold items of any type, the compiler creates one
- The toArray method returns the given Object[] to the caller
- Since the call site expects a String[], the compiler tries to cast the Object[] to the expected String[], hence the ClassCastException

- For a more detailed discussion on heap pollution, it's highly recommended to read item 32 of Effective Java by Joshua Bloch.
