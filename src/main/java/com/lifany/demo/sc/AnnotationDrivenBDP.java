package com.lifany.demo.sc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.config.AopNamespaceUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author Bruno Yang
 */
public class AnnotationDrivenBDP implements BeanDefinitionParser {

	public BeanDefinition parse(Element element, ParserContext parserContext) {
		AopNamespaceUtils.registerAutoProxyCreatorIfNecessary(parserContext, element);

		Object eleSource = parserContext.extractSource(element);

		// Create CustomInterceptor Bean Definition.
		Map<String, Object> properties = new HashMap<String, Object>();

		RootBeanDefinition interceptorDef = new RootBeanDefinition(CustomInterceptor.class,
				new MutablePropertyValues(properties));
		interceptorDef.setSource(eleSource);
		interceptorDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		String interceptorName = parserContext.getReaderContext().registerWithGeneratedName(
				interceptorDef);

		// Create the CustomAdvisor definition.
		RootBeanDefinition advisorDef = new RootBeanDefinition(CustomAdvisor.class);
		advisorDef.setSource(eleSource);
		advisorDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		advisorDef.getPropertyValues().addPropertyValue("adviceBeanName", interceptorName);
		parserContext.getReaderContext().registerWithGeneratedName(advisorDef);

		return null;
	}
}
