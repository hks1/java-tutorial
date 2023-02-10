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
