# Java

## Access Modifiers
<!-- https://howtodoinjava.com/java/oops/java-access-modifiers/ -->

Java provides four access modifiers to set access levels for classes, variables, methods and [constructors](https://howtodoinjava.com/java/oops/java-constructors/) i.e. public, private, protected and default.

- public – accessible everywhere
- protected – accessible in the same package and subclasses outside the package
- default – accessible only in the same package
- private – accessible only in the same class

> public > protected > package-private (or default) > private

> to access a public class in the different package, class needs to needs to be imported first

> the fields in an interface are implicitly public static final and the methods in an interface are, by default, public.

> The topmost classes and interfaces cannot be private.

> Local variables and formal parameters cannot take access specifiers. Since they are inherently inaccessible to the outside according to scoping rules, they are effectively private.

> Both private and protected can be (and frequently are) applied to nested classes and interfaces, just never top-level classes and interfaces.



**Levels of access control**

- Class level access – allows modifiers to be public, or package-private (default).
- Method level access – allows modifiers to be public, private, protected, or package-private (default).


## Design Patterns

[Abstract Factory](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/abstractfactory/abstract-factory-pattern.md#abstract-factory)

[Adaptor](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/adapter/adapter-pattern.md#adapter-pattern)

[Builder](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/builder/builder-pattern.md#builder)

[Factory](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/factory/factory-pattern.md#factory-)

[Factory Method](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/factorymethod/factory-method-pattern.md#factory-method-)

[Observer](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/observer/observer-pattern.md#observer-pattern)

[Chain of Responsibility](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/chainofresponsibility/chain-of-responsibility.md#chain-of-responsibility-design-pattern)

[Singleton](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/hks/design/patterns/singleton/singleton.md#singleton-design-pattern)

## [Java Reflection](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/reflection/reflection.md#java-reflection)

## [Java Annotations](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/annotations/annotations.md#java-annotations)
