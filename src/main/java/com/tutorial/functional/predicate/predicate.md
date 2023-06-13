# Predicate methods
predefined functional interface in `java.util.function` package.

test(T t)
> evaluates the predicate on the value passed to this function as the argument and then returns a boolean value
```java
import java.util.function.Predicate; 

class testDemo { 
    public static void main(String[] args) 
    {  
        Predicate<Integer> greater_than = x -> (x > 10);  
  
        // calling test method of the predicate
        System.out.println(greater_than.test(11));  
    } 
} 
```

isEqual(Object t)
> returns a predicate that tests if two objects are equal
```java
import java.util.function.Predicate;

class isEqualDemo {
    public static void main( String args[] ) {
        Predicate<String> pred  = Predicate.isEqual("Educative");
        System.out.println(pred.test("educative "));
    }
}
```

and(Predicate p)
> returns a composed predicate that represents a logical AND of the outputs coming from both predicates
```java
import java.util.function.Predicate; 

class andDemo { 
    public static void main(String[] args) 
    {  
        Predicate<Integer> grt_10 = x -> (x > 10);
        Predicate<Integer> less_100 = x -> (x < 100); 
  
        // composing two predicates using and
        System.out.println(grt_10.and(less_100).test(60));  
    } 
} 
```

or(Predicate p)
> returns a composed predicate that represents a logical OR of the outputs coming from both predicates
```java
import java.util.function.Predicate; 

class orDemo { 
    public static void main(String[] args) 
    {  
        Predicate<Integer> eq_10 = x -> (x == 10);
        Predicate<Integer> grt_20 = x -> (x > 20); 
  
        // composing two predicates using and
        System.out.println(eq_10.or(grt_20).test(21));  
    } 
} 
```

negate()
> returns a predicate that represents the logical negation of the respective predicate
```java
import java.util.function.Predicate; 

class testDemo { 
    public static void main(String[] args) 
    {  
        Predicate<Integer> greater_than = x -> (x > 10);  
  
        // calling negate method of the predicate
        System.out.println(greater_than.negate().test(11));  
    } 
} 
```

<!-- https://www.educative.io/answers/what-is-a-java-predicate -->