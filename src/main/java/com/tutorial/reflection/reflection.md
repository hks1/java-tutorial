# Java Reflection
<!-- https://www.digitalocean.com/community/tutorials/java-reflection-example-tutorial -->
- provides ability to inspect and modify the runtime behavior of the application.
- can inspect a class, [interface](https://www.digitalocean.com/community/tutorials/interface-in-java), [enum](https://www.digitalocean.com/community/tutorials/java-enum), get their structure, methods and fields information at runtime even though class is not accessbile at compile time.
- can be used to instantiate an object, invoke it's methods, change field values.

Some examples of frameworks that use java reflection:
1. __JUnit__ - Uses reflection to parse @Test annotation to get the test methods and then invoke them.
2. __Spring__ - dependency injection,  [Spring Dependency Injection](https://www.digitalocean.com/community/tutorials/spring-dependency-injection)
3. __Tomcat__ web container to forward the request to correct module by parsing their web.xml and request URI.
4. __Eclipse__ auto completion of method names
5. __Struts__
6. __Hibernate__

<!-- The list is endless and they all use java reflection because all these frameworks have no knowledge and access of user defined classes, interfaces, their methods etc. -->

We should not use reflection in normal programming where we already have access to the classes and interfaces because of following drawbacks.
- __Poor Performance__ 
- __Security Restrictions__
- __Security Issues__
- __High Maintenance__

## Java Reflection for Classes
object
- primitive type - boolean, byte, short, int, long, char, float, double
- reference - e.g., classes, enums, arrays, inherit from `java.lang.Object`

__java.lang.Class__ is the entry point for all reflection operations.

For every type of object, [JVM](https://www.digitalocean.com/community/tutorials/difference-jdk-vs-jre-vs-jvm) instantiate an [immutable](https://www.digitalocean.com/community/tutorials/how-to-create-immutable-class-in-java) instance of `java.lang.Class` that provides methods to examine the runtime properties of the object and create new objects, invoke it's method and get/set object fields.
[inheritence](https://www.digitalocean.com/community/tutorials/inheritance-java-example)

public interface BaseInterface

public class BaseClass

public class extends BaseClass implements BaseInterface

### Get Class Object
get Class of an object
- through static variable `class`
- using `getClass()` method of object
- `java.lang.Class.forName(String fullyClassifiedClassName)`

for primitive types and arrays
- use static variable `class`

Wrapper classes provide another static variable `TYPE` to get the class

