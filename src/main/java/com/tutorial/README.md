// tutorial

# [lambda](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/lambda/README.md)

# Anonymous Classes
<!-- https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html -->

- declare and instantiate a class at the same time
- like local classes except that they do not have a name
- local classes are class declarations, anonymous classes are expressions, meaning that anonymous classes are defined in another expression.

## Example
com.tutorial.anonymous.HelloWorldAnonymousClasses

## Syntax
The syntax of an anonymous class expression is like the invoking of a constructor, 
except that there is a class definition contained in a block of code.

```java
HelloWorld frenchGreeting = new HelloWorld(){
    String name = "tout le monde";
    public void greet(){
        greetSomeone("tout le monde");
        }
    public void greetSomeone(String someone){
        name = someone;
        System.out.println("Salut " + name);
        }
}
```

The anonymous class expression consists of the following:
- The `new` operator
- The name of an interface to implement or class to extend.
- Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression. **Note:** When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in above example.
- A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not.

Anonymous class definition is an expression, it must be part of a statement.
<!-- In this example, the anonymous class expression is part of the statement that instantiates the frenchGreeting object. 
(This explains why there is a semicolon after the closing brace.) -->

## Accessing local variables of the enclosing scope, and declaring and accessing members of the Anonymous class
| **TODO** |
| --- |
| https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html#accessing-members-of-an-enclosing-class |
| https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#shadowing |
| https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html |

> If an interface contains only one method, lambda expression can be used instead of an anonymous class expression

- Anonymous classes are ideal for implementing an interface that contains two or more methods.
 

# Immutable objects in Java
<!-- https://www.baeldung.com/java-immutable-object#benefits-of-immutability -->

- An immutable object is an **object whose internal state remains constant after it has been entirely created**

```java
@Test
    void testImmutableObjects() {
        String name = "Power One";
        String newName = name.replace("One", "----");

        assertEquals("Power One", name); // pass - name doesn't change
        assertEquals("Power ----", newName); // newName is a new instance
    }
```

## The _final_ keyword
- In Java, **variables are mutable by default, meaning we can change the value they hole**

- By using the _final_ keyword when declaring a variable, 
- the Java compiler wouldn't let us change the value of that variable. 
```java
final String name = "Immutable";
        name = "mutable"; // cannot assign value to final variable 'name'
```

**Note:** _final_ only forbids us from changing the reference the variable holds, 
it doesn't protect us from changing the internal state of the object it refers to by using its public API.
```java
@Test
    void testImmutableObjectReference(){
        final List<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("ImmutableTest");
        assertEquals(0, strings.size());  // fails - "ImmutableTest" is added to the 'strings' list and size is now 1
    }
```

## Immutability in Java
Building the API of an immutable object requires us to guarantee that its internal state won't change no matter how we use its API.

A step forward in the right direction is to use final when declaring its attributes:
```java
class Money {
    private final double amount;
    private final Currency currency;

    // ...
}
```

Note that Java guarantees us that the value of amount won't change, 
that's the case with all primitive type variables.

However, in our example we are only guaranteed that the currency won't change, 
so **we must rely on the Currency API to protect itself from changes.**

```java
class Money{
    // ...
    public Money(double amount, Currency currency){
        this.amount = amount;
        this.currency = currency;
    }
    public Currency getCurrency(){
        return currency;
    }
    public double getAmount(){
        return amount;
    }
    
    // No set method to ensure the immutability
}
```

**Note:** to meet the requirements of an immutable API, Money class only has read-only methods.

Using the reflection API, we can break immutability and change immutable objects. 
However, reflection violates immutable object's public API, and usually, we should avoid doing this.

## Benefits
- Since the internal state of an immutable object remains constant in time, **we can share it safely among multiple threads**
- **immutable objects are side-effects free.**

<!-- https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-lang-oop-patterns -->