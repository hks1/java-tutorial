package com.tutorial.collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// not allowed to modify collections while iterating through it
    // throws ConcurrentModificationException
public class IteratorExample3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Marco");
        list.add("Dennis");
        list.add("Jane");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            list.remove(list.size() - 1);
        }
    }
}
// OUTPUT
/*
C:\Users\hshukla\.jdks\corretto-15.0.2\bin\java.exe --enable-preview "-javaagent:C:\Users\hshukla\AppData\Local\JetBrains\IntelliJ IDEA Community Edition 2020.3.1\lib\idea_rt.jar=58712:C:\Users\hshukla\AppData\Local\JetBrains\IntelliJ IDEA Community Edition 2020.3.1\bin" -Dfile.encoding=UTF-8 -classpath C:\workspace\java\out\production\java;C:\workspace\java\lib\javax.faces-2.3.0.jar com.tutorial.collections.iterator.IteratorExample3
Marco
Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
	at com.tutorial.collections.iterator.IteratorExample3.main(IteratorExample3.java:17)

Process finished with exit code 1

 */
// Explanation:
/*
first call to next() in the loop works fine and prints Marco
then list.remove() is called and succeeds.
after that call to next() method fails since collection has been modified
 */
