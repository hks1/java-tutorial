
# Generics

## Generic Methods

properties of generic methods:

- Generic methods have a type parameter (the diamond operator enclosing the type) before the return type of the method declaration.
- Type parameters can be bounded.
- Generic methods can have different type parameters separated by commas in the method signature.
- Method body for a generic method is just like a normal method.

```java
public <T> List<T> fromArrayToList(T[] a) {   
    return Arrays.stream(a).collect(Collectors.toList());
}
```

The <T> in the method signature implies that the method will be dealing with generic type T. This is needed even if the method is returning void.

The method can deal with more than one generic type. Where this is the case, we must add all generic types to the method signature.

```java
public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
    return Arrays.stream(a)
      .map(mapperFunction)
      .collect(Collectors.toList());
}
```

We're passing a function that converts an array with the elements of type T to list with elements of type G.

Example: convert Integer to its String representation:

```java
@Test
public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
    Integer[] intArray = {1, 2, 3, 4, 5};
    List<String> stringList
      = Generics.fromArrayToList(intArray, Object::toString);
 
    assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
}
```

## Bounded Generics

we can specify that a method accepts 
- a type and all its subclasses (upper bound) or 
- a type and all its superclasses (lower bound).

To declare an upper-bounded type, we use the keyword `extends` after the type, followed by the upper bound that we want to use:
```java
public <T extends Number> List<T> fromArrayToList(T[] a) {
    ...
}
```

### Multiple Bounds

```java
<T extends Number & Comparable>
```

If one of the types that are extended by T is a class (e.g. Number), we have to put it first in the list of bounds. Otherwise, it will cause a compile-time error.

## Using Wildcards with Generics

Wildcards are represented by the question mark ? in Java, and we use them to refer to an unknown type. 

**Note:** Object is the supertype of all Java classes. However, a collection of Object is not the supertype of any collection.

**Example**

```java
public static void paintAllBuildings(List<Building> buildings) {
    buildings.forEach(Building::paint);
}
```

If we imagine a subtype of Building, such as a House, we can't use this method with a list of House, even though House is a subtype of Building.

If we need to use this method with type Building and all its subtypes, the bounded wildcard can do the magic:

```java
public static void paintAllBuildings(List<? extends Building> buildings) {
    ...
}
```

Now this method will work with type Building and all its subtypes. 
This is called an upper-bounded wildcard, where type Building is the upper bound.

We can also specify wildcards with a lower bound, where the unknown type has to be a supertype of the specified type. 
</br> Lower bounds can be specified using the `super` keyword followed by the specific type. 
</br> For example, `<? super T>` means unknown type that is a superclass of T (= T and all its parents).

## Type Erasure

to ensure that generics won't cause overhead at runtime, the compiler applies a process called type erasure on generics at compile time.

Type erasure removes all type parameters and replaces them with their bounds or with Object if the type parameter is unbounded. This way, the bytecode after compilation contains only normal classes, interfaces and methods, ensuring that no new types are produced. Proper casting is applied as well to the Object type at compile time.

Example:

```java
public <T> List<T> genericMethod(List<T> list) {
    return list.stream().collect(Collectors.toList());
}
```
with type erasure, the unbounded type _T_ is replaced with _Object_:
```java
// for illustration
public List<Object> withErasure(List<Object> list) {
    return list.stream().collect(Collectors.toList());
}

// which in practice results in
public List withErasure(List list) {
    return list.stream().collect(Collectors.toList());
}
```

If the type is bounded, the type will be replaced by the bound at compile time:
```java
public <T extends Building> void genericMethod(T t) {
    ...
}
```
and would change after compilation:
```java
public void genericMethod(Building t) {
    ...
}
```

##
**One restriction of generics in Java is that the type parameter cannot be a primitive type.**

To understand why primitive data types don't work, let's remember that **generics are a compile-time feature, meaning the type parameter is erased and all generic types are implemented as type Object**.

Example: _add_ method of a list
```java
List<Integer> list = new ArrayList<>();
list.add(17);
```

signature of add method:
```java
boolean add(E e);
```
and will be compiled to:
```java
boolean add(Object e);
```
Therefore, type parameters must be convertible to _Object_. **Since primitive types don't extend Object, we can't use them as type parameters**.

However, Java provides boxed types for primitives, along with autoboxing and unboxing to unwrap them:
```java
Integer a = 17;
int b = a;

```

<!-- https://www.baeldung.com/java-generics -->