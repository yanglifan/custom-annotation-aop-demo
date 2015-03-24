# Introduction
The project shows that how to enable the annotation style AOP function based on Spring Framework.

# Details

1. Define Spring `NamespaceHandler` to parse your own Spring XML configuration namespace.
1. Register your own `BeanDefinitionParser` with your own namespace and combine your `Advisor` and `MethodInterceptor`.
1. Define your own `Advisor` which define the AOP pointcut.
1. Define your own `MethodInterceptor` to implement the real logic.