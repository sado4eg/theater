package ua.epam.spring.hometask.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        Theater theater = ctx.getBean(Theater.class);
        theater.entryPoint();
    }

}
