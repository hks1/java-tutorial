<!-- https://www.educative.io/answers/what-is-the-supplier-functional-interface-in-java -->

> `Supplier` is a functional interface that produces output without accepting any input

> The interface contains one method `get()`


**Syntax:**

T get()

```java
import java.util.Random;
import java.util.function.*;

public class Main{
    public static void main(String[] args) {
        // Supplier interface implementation that generates random integer value
        Supplier<Integer> randomSupplier = () -> new Random().nextInt();
        int count = 5;

        // Calling get method to get the random value
        while(count-- > 0) System.out.println(randomSupplier.get());

    }
}
```