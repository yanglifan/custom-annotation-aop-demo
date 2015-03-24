package com.lifany.demo.sc;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author Lifan Yang
 */
public class CustomNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("annotation-support",
                new AnnotationDrivenBDP());
    }

}
