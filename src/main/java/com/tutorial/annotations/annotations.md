# Java Annotations
<!-- https://www.digitalocean.com/community/tutorials/java-annotations -->
provides information about the code.

1. Built-in Java annotations
2. Write Custom Annotation
3. Annotations usage and parsing them using [Reflection API](https://www.digitalocean.com/community/tutorials/java-reflection-example-tutorial)

used in
- Hibernate
- [Jersey](https://www.digitalocean.com/community/tutorials/jersey-java-tutorial)
- [Spring](https://www.digitalocean.com/community/tutorials/spring-tutorial-spring-core-tutorial)

Java Annotation is metadata about the program, embedded in the program itself.

- can be parsed
- specify annotation availability to either compile time only or till runtime

<!--
Before java annotations, program metadata was available through java comments or by Javadoc but annotation offers more than that. Annotations metadata can be available at runtime too and annotation parsers can use it to determine the process flow. For example, in [Jersey webservice](https://www.digitalocean.com/community/tutorials/jersey-java-tutorial) we add PATH annotation with URI string to a method and at runtime, jersey parses it to determine the method to invoke for given URI pattern.
-->

## Java Custom Annotation

```java
package com.tutorial.annotations.example;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "hks";
    String date();
    int revision() default 1;
    String comments();
}

```
1. Annotation methods can not have parameters.
2. Annotation methods return types are limited to primitives, String, Enums, Annotation or array of these.
3. Java Annotation methods can have default values.
4. Annotations can have meta annotations attached to them. Meta annotations are used to provide information about the annotation.

## Meta Annotations in Java
1. @Documented - 
2. @Target - TYPE, METHOD, CONSTRUCTOR, FIELD etc.
3. @Inherited - 
4. @Retention - SOURCE, CLASS and RUNTIME
5. @Repeatable - 

## Built-in Annotations in Java
1. @Override
2. @Deprecated
3. @SupressWarnings
4. @FunctionalInterface - introduced in [java8](https://www.digitalocean.com/community/tutorials/java-8-features-with-examples) to indicate that the interface is intended to be [functional interface](https://www.digitalocean.com/community/tutorials/java-8-functional-interfaces)
5. @SafeVarargs

## Java Annotations Example

```java
package com.tutorial.annotations.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {
    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "hks1", comments = "main method", date = "Feb 9, 2023")
    public String toString(){
        return "Overriden toString()";
    }
    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Feb 10, 2023")
    public static void oldMethod(){
        System.out.println("old method, don't use it.");
    }
    @SuppressWarnings({"unchecked", "deprecation"})
    @MethodInfo(author = "hks1", comments = "main method", date = "Feb 11, 2023", revision = 2)
    public static void genericTest() throws FileNotFoundException{
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}

```

## Java Annotations Parsing
- will use Reflection to parse java annotations from a class.
- Annotation Retention Policy should be RUNTIME otherwise its information will not be available at runtime and we won't be able to fetch any data from it.

```java
package com.tutorial.annotations.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParsing {
    public static void main(String[] args) {
        try{
            for (Method method : AnnotationParsing.class.getClassLoader()
                    .loadClass(("com.tutorial.annotations.example.AnnotationExample"))
                    .getMethods()){
                if(method.isAnnotationPresent(com.tutorial.annotations.example.MethodInfo.class)){
                    // iterated all the annotations available in the method
                    for (Annotation anno: method.getDeclaredAnnotations()
                    ) {
                        System.out.println("Annotation in method '" + method + "' : " + anno);
                    }
                    MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                    if(methodAnno.revision() == 1){
                        System.out.println("Method with revision no. 1 = " + method);
                    }
                }

            }
        } catch (SecurityException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

```

__Java Annotations Update__
1. Servlet Specs 3.0 introduced use of annotations for Servlet Configuration and init parameters. [Java Servlet Tutorial](https://www.digitalocean.com/community/tutorials/servlet-jsp-tutorial)
2. We can use annotations in Struts 2 to configure it's action classes and result pages. [Struts 2 Hello World Annotation Example](https://www.digitalocean.com/community/tutorials/struts-2-hello-world-example-with-annotations-and-without-struts-xml-file)

Reference: https://docs.oracle.com/javase/tutorial/java/annotations/