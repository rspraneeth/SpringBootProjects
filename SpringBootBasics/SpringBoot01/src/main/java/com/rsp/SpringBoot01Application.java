package com.rsp;

import com.rsp.beans.CourseSelection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class  SpringBoot01Application {

    static {
        System.out.println("SpringBoot01 application loaded...");
    }

    public SpringBoot01Application(){
        System.out.println("SpringBoot01 app has been created.");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBoot01Application.class, args);
//        System.out.println("Spring container used here is "+context.getClass().getName());
//        System.out.println("Beans getting created behind the scene are "+context.getBeanDefinitionCount()+ " " + Arrays.toString(context.getBeanDefinitionNames()));

        CourseSelection cs = context.getBean(CourseSelection.class);
        boolean status = cs.chooseCourse(432.45);

        if (status) System.out.println("Success");
        else System.out.println("Failed");

        context.close();
    }

}
