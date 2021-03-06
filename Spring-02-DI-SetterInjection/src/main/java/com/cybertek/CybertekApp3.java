package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp3 {


    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course1 = container.getBean("java", Course.class);
        Course couse2 = container.getBean("selenium", Course.class);

        course1.getTeachingHours();
        couse2.getTeachingHours();
    }
}
