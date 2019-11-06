package com.beetest;

import com.beetest.bean.ConditionBean;
import com.beetest.config.ConditionConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConditionContext;

/**
 * @Author: senne
 * @Date: 2019/11/6 11:33
 * @Version 1.0
 */
public class ConditionalApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ConditionBean conditionBean = context.getBean(ConditionBean.class);
        conditionBean.sayHi();
    }
}
