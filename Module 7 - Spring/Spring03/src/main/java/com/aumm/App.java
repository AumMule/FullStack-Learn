package com.aumm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));


        ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");

        Alien obj = (Alien)factory.getBean("alien");

        obj.code();
    }
}
