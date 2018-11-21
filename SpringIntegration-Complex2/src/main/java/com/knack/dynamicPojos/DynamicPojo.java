package com.knack.dynamicPojos;

import java.util.Map;

import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.core.NamingPolicy;
import org.springframework.cglib.core.Predicate;


/**
 *
 */
public class DynamicPojo
{

	/**
	 * @param className
	 * @param properties
	 * @return
	 */
	public static Class<?> createBeanClass(

			final String className,

			final Map<String, Class<?>> properties)
	{

		final BeanGenerator beanGenerator = new BeanGenerator();


		beanGenerator.setNamingPolicy(new NamingPolicy()
		{
			@Override
			public String getClassName(final String prefix, final String source, final Object key, final Predicate names)
			{
				return className;
			}
		});

		BeanGenerator.addProperties(beanGenerator, properties);
		return (Class<?>) beanGenerator.createClass();
	}


}
