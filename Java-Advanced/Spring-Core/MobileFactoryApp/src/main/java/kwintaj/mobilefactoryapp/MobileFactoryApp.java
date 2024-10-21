package kwintaj.mobilefactoryapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobileFactoryApp
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
        Samsung s24 = (Samsung) context.getBean("mobile1");
        Iphone i16 = (Iphone) context.getBean("mobile2");

        s24.call();
        i16.call();
   }
}