package com.lifany.demo.sc;

public class FoobarService {

    @PointcutAnnotation
    public void doSomething(CustomParam param) {
        System.out.println("Do something...");
    }

    @PointcutAnnotation
    public void doSomethingWithException(CustomParam param) {
        System.out.println("Do something with Exception...");
        throw new RuntimeException("For test");
    }
}
