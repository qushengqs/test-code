package com.beetest;

import com.beetest.config.MainConfig;
import com.beetest.model.Circle;
import com.beetest.model.Rectangle;
import com.beetest.model.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: senne
 * @Date: 2019/11/6 11:11
 * @Version 1.0
 */
public class ImportApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        Circle circle = context.getBean(Circle.class);
        circle.sayHi();

        Triangle triangle = context.getBean(Triangle.class);
        triangle.sayHi();

        Rectangle rectangle = context.getBean(Rectangle.class);
        rectangle.sayHi();
    }
}
