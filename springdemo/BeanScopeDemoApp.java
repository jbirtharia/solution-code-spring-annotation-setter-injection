package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach firstTennisCoach = context.getBean("tennisCoach",Coach.class);

        Coach secondTennisCoach = context.getBean("tennisCoach",Coach.class);

        boolean result = (firstTennisCoach == secondTennisCoach);
        System.out.println("Beans are equal : "+result);
        System.out.println("Address of first bean : "+firstTennisCoach);
        System.out.println("Address of second bean : "+secondTennisCoach);

        context.close();
    }
}
