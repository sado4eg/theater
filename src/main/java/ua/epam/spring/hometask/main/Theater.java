package ua.epam.spring.hometask.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alex on 18.03.2018.
 */
public class Theater {

    private static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
    }

}
